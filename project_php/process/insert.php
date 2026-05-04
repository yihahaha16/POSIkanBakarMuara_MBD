<?php
require_once "..\config\database.php";
try{
    $pelanggan_id = $conn->prepare("insert ignore into pelanggan (pelanggan_noHP, pelanggan_nama) values (:pelanggan_noHP, :pelanggan_nama)");
    $pelanggan_id->execute(
        [':pelanggan_noHP' => $_POST['pelanggan_noHp']],
        [':pelanggan_nama' => $_POST['pelanggan_nama']]
    );
    $stmt = $conn->prepare(
        "insert into pesanan (pelanggan_noHP, pesanan_tanggal, pesanan_noMeja, pesanan_jenis) values (:pelanggan_noHP, now(), :pesanan_noMeja, :pesanan_jenis)"
    );
    $stmt->execute([
        ':pelanggan_noHP' => $_POST['pelanggan_noHp'],
        ':pesanan_noMeja' => $_POST['pesanan_noMeja'],
        ':pesanan_jenis' => $_POST['pesanan_jenis']
    ]);
    $pesanan_id = $conn->lastInsertId();
    $stmt = $conn->prepare(
        "insert into detail_pesanan (pesanan_id, menu_id, dp_kuantitas) values (:pesanan_id, :menu_id, :dp_kuantitas)"
    );
    foreach($_POST['dp_kuantitas'] as $menu_id => $kuantitas){
        if ($kuantitas <=0) continue;
        $stmt->execute([
            ':pesanan_id' => $pesanan_id,
            ':menu_id' => $menu_id,
            ':dp_kuantitas' => $kuantitas
        ]);
    }

header("Location: /public/tambah.php?pesanan_id=" . $pesanan_id);
}catch (PDOException $e){
    echo "Gagal menambah pesanan: " . $e->getMessage();
}