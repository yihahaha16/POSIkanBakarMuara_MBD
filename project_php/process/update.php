<?php
require_once "..\config\database.php";
try{
    // $stmt = $conn->prepare("
    //     update pesanan
    //     set pelanggan_noHP = :pelanggan_noHP, pesanan_noMeja = :pesanan_noMeja, pesanan_jenis = :pesanan_jenis
    //     where pesanan_id = :pesanan_id
    // ");
    // $stmt->execute([
    //     ':pesanan_id' => $_POST['pesanan_id'],
    //     ':pelanggan_noHP' => $_POST['pelanggan_noHP'],
    //     ':pesanan_noMeja' => $_POST['pesanan_noMeja'],
    //     ':pesanan_jenis' => $_POST['pesanan_jenis'],
    // ]);

    $stmt = $conn->prepare("
        update detail_pesanan
        set dp_kuantitas = :qty
        where pesanan_id = :pesanan_id and menu_id = :menu_id
    ");
    foreach($_POST['dp_kuantitas'] as $menu_id => $kuantitas){
        if (empty($pesanan_id) || empty($menu_id) || empty($kuantitas)) {
            $errorMessage = "Semua kolom harus terisi";
            break;
        }
        $stmt->execute([
            ':pesanan_id' => $pesanan_id,
            ':menu_id' => $menu_id,
            ':dp_kuantitas' => $kuantitas
        ]);
    }

    header("Location: /public/tambah.php?pesanan_id=" . $pesanan_id);
    exit;
} catch (PDOException $e) {
    echo "Gagal mengubah pesanan: " . $e->getMessage();
}
