<?php require_once "../config/database.php";

if(isset($_SESSION['pesanan_id'])) {
    $pesanan_id = $_SESSION['pesanan_id'];

    $stmt = $conn->prepare("DELETE FROM detail_pesanan WHERE pesanan_id = :pesanan_id");
    $stmt->execute([':pesanan_id' => $pesanan_id]);

    $stmt = $conn->prepare("DELETE FROM pesanan WHERE pesanan_id = :pesanan_id");
    $stmt->execute([':pesanan_id' => $pesanan_id]);

    unset($_SESSION['pesanan_id']);
    unset($_SESSION['dp_kuantitas']);
    session_destroy();
}

header("Location: /public/index.php");
exit;