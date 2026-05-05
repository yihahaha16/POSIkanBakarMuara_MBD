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
     <div style="background:#f9f9f9;width:470px;height:360px;border-radius:0px 0px 20px 20px;padding:30px">
        <form action="../process/insert.php" method="post">
           Nama: <input type="text" name=pelanggan_nama><br>
            Nomor Telepon: <input type="text" name=pelanggan_noHp><br>
            Tanggal pesan: <input type="date" name=pesanan_tanggal><br>
            Nomor Meja: <input type="text" name=pesanan_noMeja><br>
            Jenis: <select style="padding: 4px" name="pesanan_jenis">
            <option value="Dine in">Dine in</option>
            <option value="Take away">Take away</option></select>
            <br><p style="margin-top:7px;margin-bottom:7px;text-align:center"><strong>Daftar Menu</strong></p>
            <table style="width:470px">
                <?php require_once '../config/database.php';
                $stmt = $conn->query("SELECT menu_id,menu_nama,menu_kategori,menu_harga FROM menu");
                $data = $stmt->fetchAll(PDO::FETCH_ASSOC); ?>
                <tr><th>Nama</th><th>Kategori</th><th>Harga</th><th>Jumlah</th></tr>
                <?php foreach ($data as $row): ?>
                <tr>
                <td><?= $row['menu_nama']; ?></td>
                <td style="text-align:center"><?= $row['menu_kategori']; ?></td>
                <td style="text-align:center"><?= $row['menu_harga']; ?></td>
                <td>
                <input type="number" name="dp_kuantitas[<?= $row['menu_id']; ?>]" min="0" max="10" value="0"></td></tr>
                <?php endforeach; ?> </table>
            <div style="margin-top:15px;justify-content:center;display:flex ">
            <a href = "tambah.php">
            <button style="background-color:#f44236;border:none;border-radius:5px;padding:7px;width:80px;color:white;cursor: pointer;" type="submit"><strong>Pesan</strong></button></a></div>
        </form></div>
    </body>
</html>