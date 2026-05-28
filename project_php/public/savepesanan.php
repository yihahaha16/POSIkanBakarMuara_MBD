<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simpan Pesanan</title>
</head>
<body>
    <style>
table, td, th {
  border: 1px solid;
}
td, th {
  padding: 5px;
}
table {
  border-collapse: collapse;
}
</style>
    <body style="font-family:Arial; display:flex; flex-direction: column;justify-content:center; align-items:center;margin-top:30px">
    <div style="text-align:center;background:#f44236;width:530px;height:100px;border-radius:20px 20px 0 0;color:white">    
    <h1 style="margin-top:15px;margin-bottom: 0px">Sistem Pemesanan </h1><h1 style="margin-top: 0px"> Ikan Bakar Muara</h1>
    </div> 
<table style="width:470px">
    <?php 
    session_start();
    require_once "..\config\database.php";
    $pesanan_id = $_SESSION['pesanan_id'];
    $stmt = $conn->prepare("Select pesanan_grandtotal FROM pesanan where pesanan_id = :pesanan_id");
    $stmt->execute([':pesanan_id' => $pesanan_id]);
    $dp = $stmt->fetch(PDO::FETCH_ASSOC);
    ?>
    <h3 style="margin-top:7px;margin-bottom:7px;text-align:center"> Grandtotal Anda: Rp <?= $dp['pesanan_grandtotal'] ?></h3>
    Mohon tunggu hidangan Anda, Silahkan proses pembayaran di Kasir <br><br>
    <?php unset($_SESSION[':pesanan_id'])?>
    <a href="index.php"><button style="background-color:#f44236;border:2px solid #f44236;border-radius:5px;padding:3px;width: 100px;color:white;cursor: pointer">Kembali ke Beranda</button></a>
</table>
</html>