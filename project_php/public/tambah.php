<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tambah Menu</title>
</head>
<body>
    <?php
    $stmt = $conn->query(
        'Select dp.pesanan_id, m.menu_nama, m.menu_harga, dp.dp_kuantitas from detail_pesanan dp join menu m on dp.menu_id = m.menu_id'
    );
    $dp = $stmt->fetchAll(PDO::FETCH_ASSOC);
    ?>
    <form method = "post" action = "/process/insert.php">
        <h3>Menu yang telah Anda pilih: <br></h3>
    <table border="1">
        <tr>
            <th>Nama</th>
            <th>Kategori</th>
            <th>Harga</th>
            <th>Jumlah</th>
            <th>Aksi</th>
        </tr>
        <tr>
            <?php foreach ($dp as $row): ?>
                <td><?=$row['menu_nama']?></td>
                <td><?=$row['menu_kategori']?></td>
                <td><?=$row['menu_harga']?></td>
                <td><?=$row['dp_kuantitas']?></td>
                <td>
                    <a href="edit.php"?>Edit</a>
                    <a href="delete.php"?>Hapus</a>
                </td>
            <?endforeach;?>
        </tr>
    </table>
    </form>
</body>
</html>