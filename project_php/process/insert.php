<?php
require_once 'D:\Kul\Semester_4\PBO_Praktikum\PBO_POSIkanBakarMuara\project_php\config\database.php';
try{
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
    $stmt->execute([
        ':pesanan_id' => '$pesanan_id',
        ':dp_kuantitas' => $_POST['dp_kuantitas']
    ]);

header("Location: /public/tambah.php?status=sukses");
}catch (PDOException $e){
    echo "Gagal menambah pesanan: " . $e->getMessage();
}