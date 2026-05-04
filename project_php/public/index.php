<!DOCTYPE html>
<html>
    <head>
        <title>Beranda</title>
    </head>
    <body>
        <form action="../process/insert.php" method="post">
           Nama: <input type="text" name=pelanggan_nama><br>
            Nomor Telepon: <input type="text" name=pelanggan_noHp><br>
            Tanggal pesan: <input type="date" name=pesanan_tanggal><br>
            Nomor Meja: <input type="text" name=pesanan_noMeja><br>
            <select name="pesanan_jenis">
                <option value="Dine in">Dine in</option>
                <option value="Take away">Take away</option>
            </select>
       

<table border="1">
<?php
require_once '../config/database.php';
$stmt = $conn->query("SELECT menu_id,menu_nama,menu_kategori,menu_harga FROM menu");
$data = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>

<tr>
<th>Nama</th>
<th>Kategori</th>
<th>Harga</th>
<th>Jumlah</th>
</tr>
<?php foreach ($data as $row): ?>
<tr>
<td><?= $row['menu_nama']; ?></td>
<td><?= $row['menu_kategori']; ?></td>
<td><?= $row['menu_harga']; ?></td>
<td>
    <input type="number" name="dp_kuantitas[<?= $row['menu_id']; ?>]" min="0" max="10" value="0">
</td>
</tr>
<?php endforeach;

?>
</table>
<a href = "tambah.php">
    <button type="submit">Pesan</button>
</a>
 </form>
    </body>
</html>