<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tambah Menu</title>
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
    require_once "..\config\database.php";
    $pesanan_id = $_GET['pesanan_id'];
    $stmt = $conn->prepare(
        'Select dp.pesanan_id, m.menu_id, m.menu_nama, m.menu_kategori, m.menu_harga, dp.dp_kuantitas, 
        dp.dp_total from detail_pesanan dp join menu m on dp.menu_id = m.menu_id where dp.pesanan_id = :pesanan_id'
        );
        $stmt->execute([':pesanan_id' => $pesanan_id]);
        $dp = $stmt->fetchAll(PDO::FETCH_ASSOC);
        
    $pelanggan = $conn->prepare('select p.pelanggan_nama, ps.pelanggan_noHP from pesanan ps join pelanggan p on 
    ps.pelanggan_noHP = p.pelanggan_noHP where ps.pesanan_id = :pesanan_id');
    $pelanggan->execute([':pesanan_id' => $pesanan_id]);
    $pelanggan_nama = $pelanggan->fetch(PDO::FETCH_ASSOC);

    $grandtotal = $conn->prepare('select pesanan_grandtotal from pesanan where pesanan_id = :pesanan_id');
    $grandtotal->execute([':pesanan_id'=>$pesanan_id]);
    $pesanan_grandtotal = $grandtotal->fetch(PDO::FETCH_ASSOC);
    ?>
    <div style="margin-top:7px;margin-bottom:0px;text-align:center">
        <h2>Halo <?=$pelanggan_nama['pelanggan_nama']?>,</h2><h2> silahkan periksa kembali pesanan Anda.</h2>
    </div>
        <h3>Menu yang telah Anda pilih:</h3>
    <table border="1">
        <tr>
            <th>Nama</th>
            <th>Kategori</th>
            <th>Harga</th>
            <th>Jumlah</th>
            <th>Subtotal</th>
            <th>Aksi</th>
        </tr>
        <?php foreach ($dp as $row): ?>
            <tr>
            <td><?=$row['menu_nama']?></td>
            <td><?=$row['menu_kategori']?></td>
            <td><?=$row['menu_harga']?></td>
            <td><?=$row['dp_kuantitas']?></td>
            <td><?=$row['dp_total']?></td>
            <td>
            <a href="edit.php?pesanan_id=<?= $row['pesanan_id']?>&menu_id=<?= $row['menu_id'] ?>"><button style="display:inline-block; border:2px solid #f44236; border-radius:5px; padding:3px;
            width:50px; text-align:center; color:black; text-decoration:none; cursor:pointer;">Edit</button></a>
            <a href="hapus.php?pesanan_id=<?= $row['pesanan_id']?>&menu_id=<?= $row['menu_id']?> "><button style="background-color:#f44236;border:2px solid #f44236;border-radius:5px;padding:3px;width:50px;color:white;cursor: pointer">Hapus</button></a>
            </td>
            </tr>
        <?php endforeach;?>
    </table>
    <br>
</table>
    <h3 style="margin-top:7px;margin-bottom:7px;text-align:center">Grandtotal: Rp <?= $pesanan_grandtotal['pesanan_grandtotal'] ?></h3>
</body>
</html>