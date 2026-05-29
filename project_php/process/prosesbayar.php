<?php
session_start();
require_once "..\config\database.php";

try {
    $pesanan_id = $_SESSION['pesanan_id'];
    $metode = $_POST['transaksi_metode'];
    if ($metode == "Non Tunai") {
        $metode_db = "Non-Tunai";
    } else {
        $metode_db = "Tunai";
    }
    $stmt = $conn->prepare("INSERT INTO transaksi (pesanan_id, transaksi_status, transaksi_tanggal, transaksi_metode)VALUES (:pesanan_id, 'Berhasil', now(), :transaksi_metode)");
    $stmt->execute([
        ':pesanan_id' => $pesanan_id,
        ':transaksi_metode' => $metode_db
    ]);

    header("Location: ../public/selesai.php");
    exit;

} catch (PDOException $e) {
    echo "Gagal menambah transaksi: " . $e->getMessage();
}