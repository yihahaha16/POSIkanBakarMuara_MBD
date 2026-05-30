<?php
require_once "..\config\database.php";
unset($_SESSION['pesanan_id']);
unset($_SESSION['dp_kuantitas']);
session_destroy();
?>
<!DOCTYPE html>
<html>
<head>
    <title>Selesai</title>
</head>
<body style="font-family:Arial; display:flex; flex-direction: column;justify-content:center; align-items:center;margin-top:30px">
<div style="text-align:center;background:#f44236;width:530px;height:100px;border-radius:20px 20px 0 0;color:white">    
    <h1 style="margin-top:15px;margin-bottom: 0px">Sistem Pemesanan</h1>
    <h1 style="margin-top: 0px">Ikan Bakar Muara</h1>
</div>
<div style="background:#f9f9f9;width:470px;border-radius:0px 0px 20px 20px;padding:30px;text-align:center;">
    <h2 style="margin-bottom:10px;">Transaksi Berhasil!</h2>
    <a href="index.php"><button style="background-color:#f44236;border:none;border-radius:5px;padding:10px;width:180px;color:white;cursor:pointer;">Kembali ke Beranda</button></a>
</div>

</body>
</html>