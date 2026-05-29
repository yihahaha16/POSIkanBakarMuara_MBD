<?php
session_start();
require_once "..\config\database.php";
try{
    $pelanggan_id = $conn->prepare("insert ignore into pelanggan (pelanggan_noHP, pelanggan_nama) values (:pelanggan_noHP, :pelanggan_nama)");
    $pelanggan_id->execute(
        [':pelanggan_noHP' => $_POST['pelanggan_noHp'],
        ':pelanggan_nama' => $_POST['pelanggan_nama']]
    );
    if (!isset($_SESSION['pesanan_id'])){
        $stmt = $conn->prepare(
            "insert into pesanan (pelanggan_noHP, pesanan_tanggal, pesanan_noMeja, pesanan_jenis, kasir_id) values (:pelanggan_noHP, now(), :pesanan_noMeja, :pesanan_jenis, :kasir_id)"
        );
        $stmt->execute([
            ':pelanggan_noHP' => $_POST['pelanggan_noHp'],
            ':pesanan_noMeja' => $_POST['pesanan_noMeja'],
            ':pesanan_jenis' => $_POST['pesanan_jenis'],
            ':kasir_id'=> $_POST['kasir_id']
        ]);
        $_SESSION['pesanan_id'] = $conn->lastInsertId();
        }
        $pesanan_id = $_SESSION['pesanan_id'];
        $_SESSION['dp_kuantitas'] = $_POST['dp_kuantitas'];
   foreach($_POST['dp_kuantitas'] as $menu_id => $kuantitas){
    if ($kuantitas <= 0) continue;
    $cek = $conn->prepare("SELECT dp_kuantitas FROM detail_pesanan WHERE pesanan_id = :pesanan_id AND menu_id = :menu_id");
    $cek->execute([ ':pesanan_id' => $pesanan_id,':menu_id' => $menu_id]);
    $data = $cek->fetch(PDO::FETCH_ASSOC);
    if ($data){
        $update = $conn->prepare("UPDATE detail_pesanan SET dp_kuantitas = :kuantitas WHERE pesanan_id = :pesanan_id AND menu_id = :menu_id");
        $update->execute([':kuantitas' => $kuantitas,':pesanan_id' => $pesanan_id,':menu_id' => $menu_id]);
    }
    else {
        $insert = $conn->prepare("INSERT INTO detail_pesanan (pesanan_id, menu_id, dp_kuantitas) VALUES (:pesanan_id, :menu_id, :dp_kuantitas)");
        $insert->execute([
            ':pesanan_id' => $pesanan_id,
            ':menu_id' => $menu_id,
            ':dp_kuantitas' => $kuantitas
        ]);
    }
}
header("Location: /public/tambah.php?pesanan_id=" . $pesanan_id);
}catch (PDOException $e){
    echo "Gagal menambah pesanan: " . $e->getMessage();
}