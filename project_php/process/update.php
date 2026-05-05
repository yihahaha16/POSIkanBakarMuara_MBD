<?php
require_once "..\config\database.php";
try{
    $pesanan_id = $_POST['pesanan_id'];
    $menu_id = $_POST['menu_id'];
    $kuantitas = $_POST['kuantitas'];

    $stmt = $conn->prepare("
        update detail_pesanan
        set dp_kuantitas = :kuantitas
        where pesanan_id = :pesanan_id and menu_id = :menu_id
    ");

    $stmt->execute([
        ':pesanan_id' => $pesanan_id,
        ':menu_id' => $menu_id,
        ':kuantitas' => $kuantitas
    ]);

    header("Location: ../public/tambah.php?pesanan_id=" . $pesanan_id);
    exit;
} catch (PDOException $e) {
    echo "Gagal mengubah pesanan: " . $e->getMessage();
}
