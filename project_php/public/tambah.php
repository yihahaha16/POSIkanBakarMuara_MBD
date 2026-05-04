<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tambah Menu</title>
</head>
<body>
    <?php
    require_once "..\config\database.php";
    $pesanan_id = $_GET['pesanan_id'];
    $stmt = $conn->prepare(
        'Select dp.pesanan_id, m.menu_id, m.menu_nama, m.menu_kategori, m.menu_harga, dp.dp_kuantitas from detail_pesanan dp join menu m on dp.menu_id = m.menu_id where dp.pesanan_id = :pesanan_id'
    );
    $stmt->execute([':pesanan_id' => $pesanan_id]);
    $dp = $stmt->fetchAll(PDO::FETCH_ASSOC);
    ?>
        <h3>Menu yang telah Anda pilih: <br></h3>
    <table border="1">
        <tr>
            <th>Nama</th>
            <th>Kategori</th>
            <th>Harga</th>
            <th>Jumlah</th>
            <th>Aksi</th>
        </tr>
        <?php foreach ($dp as $row): ?>
            <tr>
            <td><?=$row['menu_nama']?></td>
            <td><?=$row['menu_kategori']?></td>
            <td><?=$row['menu_harga']?></td>
            <td><?=$row['dp_kuantitas']?></td>
            <td>
            <button><a href="edit.php?pesanan_id=<?= $row['pesanan_id']?>&menu_id=<?= $row['menu_id'] ?>">Edit</a></button>
            <button><a href="hapus.php?pesanan_id=<?= $row['pesanan_id']?>&menu_id=<?= $row['menu_id']?> ">Hapus</a></button>
            </td>
            </tr>
        <?php endforeach;?>
    </table>
</body>
</html>