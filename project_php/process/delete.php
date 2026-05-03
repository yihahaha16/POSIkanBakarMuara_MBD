<?php 
require_once "../config/database.php";
try{
$pesanan_id=$_POST['pesanan_id'];
$menu_id=$_POST['menu_id'];
$stmt= $conn->prepare("DELETE FROM detail_pesanan WHERE pesanan_id=:pesanan_id AND menu_id=:menu_id");
$stmt->execute([
':pesanan_id'=>$pesanan_id,
':menu_id'=>$menu_id
]);
header("Location: ../public/tambah.php?status=sukses&pesanan_id=".$pesanan_id);
} catch (PDOException $e) {
echo "Gagal menghapus data: " . $e->getMessage();
}
?>