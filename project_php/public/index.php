<?php
session_start();
require_once '../config/database.php';
$kategori = $_GET['kategori'] ?? '';
if ($kategori != '') {
    $stmt = $conn->prepare("SELECT menu_id,menu_nama,menu_kategori,menu_harga FROM menu WHERE menu_kategori = :kategori");
    $stmt->execute([':kategori' => $kategori]);
}
else {
    $stmt = $conn->query("SELECT menu_id,menu_nama,menu_kategori,menu_harga FROM menu");
}
$data = $stmt->fetchAll(PDO::FETCH_ASSOC); 

if (isset($_SESSION['pesanan_id'])) {
    $pesanan_id = $_SESSION['pesanan_id'];
    $pesanan = $conn->prepare("SELECT p.pelanggan_nama,ps.pelanggan_noHP,ps.pesanan_tanggal,ps.pesanan_noMeja,ps.pesanan_jenis,ps.kasir_id FROM pesanan ps JOIN pelanggan p ON ps.pelanggan_noHP = p.pelanggan_noHP WHERE ps.pesanan_id = :pesanan_id");
    $pesanan->execute([':pesanan_id' => $pesanan_id]);
    $data2 = $pesanan->fetch(PDO::FETCH_ASSOC);
}

?>
<!DOCTYPE html>
<html>
    <head>
        <title>Beranda</title>
    </head>
<style> 
table, td, th {border: 1px solid; }
td, th { padding: 5px; }
table { border-collapse: collapse; } </style>
<body style="font-family:Arial; display:flex; flex-direction: column;justify-content:center; align-items:center;margin-top:30px">    
    <div style="text-align:center;background:#f44236;width:530px;height:100px;border-radius:20px 20px 0 0;color:white">    
    <h1 style="margin-top:15px;margin-bottom: 0px">Sistem Pemesanan </h1><h1 style="margin-top: 0px"> Ikan Bakar Muara</h1> </div> 
    <div style="background:#f9f9f9;width:470px;border-radius:0px 0px 20px 20px;padding:30px">
        <form action="../process/insert.php" method="post">
           Nama: <input type="text" name=pelanggan_nama required value="<?= $data2['pelanggan_nama'] ?? '' ?>"><br>
            Nomor Telepon: <input type="text" name=pelanggan_noHp required  value="<?= $data2['pelanggan_noHP'] ?? '' ?>"><br>
       Tanggal: <input type="date" name="pesanan_tanggal" value="<?= $data2['pesanan_tanggal'] ?? date('Y-m-d') ?>" readonly>
<br>            Nomor Meja: <input type="text" name=pesanan_noMeja required value="<?= $data2['pesanan_noMeja'] ?? '' ?>"><br>
                Kasir:  <input type="text" name=kasir_id required value="<?= $data2['kasir_id'] ?? '' ?>"><br>
            Jenis: <select style="padding: 4px" name="pesanan_jenis">
            <option value="Dine in" <?= ($data2['pesanan_jenis'] ?? '') == 'Dine in' ? 'selected' : '' ?>>Dine in</option>
    <option value="Take away"<?= ($data2['pesanan_jenis'] ?? '') == 'Take away' ? 'selected' : '' ?>>Take away</option></select>
        <br>
        <p style="margin-top:7px;margin-bottom:7px;text-align:center"><strong>Daftar Menu</strong></p>
       <div style="margin-bottom:10px">
<a href="public" style="text-decoration:none;"><button style="color:black;background-color:#e0e0e0;border:none;border-radius:5px;padding:7px;width:80px;cursor:pointer;" type="button">Semua</button></a>
<a href="?kategori=Makanan" style="text-decoration:none;"><button style="color:black;background-color:#e0e0e0;border:none;border-radius:5px;padding:7px;width:80px;cursor:pointer;" type="button">Makanan</button></a>
<a href="?kategori=Minuman" style="text-decoration:none;">
<button
style="color:black;background-color:#e0e0e0;border:none;border-radius:5px;padding:7px;width:80px;cursor:pointer;"
type="button">
Minuman
</button>
</a>

</div>
            <table>
                <tr><th>Nama</th><th>Kategori</th><th>Harga</th><th>Jumlah</th></tr>
                <?php foreach ($data as $row): ?>
                <tr>
                <td><?= $row['menu_nama']; ?></td>
                <td style="text-align:center"><?= $row['menu_kategori']; ?></td>
                <td style="text-align:center">Rp <?= $row['menu_harga']; ?></td>
                <td>
                <input type="number" name="dp_kuantitas[<?= $row['menu_id']; ?>]" min="0" max="10" value="<?= $_SESSION['dp_kuantitas'][$row['menu_id']] ?? 0 ?>"></td></tr>
                <?php endforeach; ?> </table>
            <div style="margin-top:15px;justify-content:center;display:flex ">
            <a href = "tambah.php">
            <button style="background-color:#f44236;border:none;border-radius:5px;padding:7px;width:80px;color:white;cursor: pointer;" type="submit"><strong>Pesan</strong></button></a></div>
        </form></div>
    </body>
</html>