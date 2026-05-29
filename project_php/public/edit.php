<?php
require_once "../config/database.php";

$pesanan_id = $_GET['pesanan_id'];
$menu_id    = $_GET['menu_id'];

// Ambil data detail pesanan untuk edit kuantitas
$stmt = $conn->prepare("
    SELECT dp.menu_id, m.menu_nama, dp.dp_kuantitas
    FROM detail_pesanan dp
    JOIN menu m ON dp.menu_id = m.menu_id
    WHERE dp.pesanan_id = :pesanan_id AND dp.menu_id = :menu_id
");
$stmt->execute([':pesanan_id' => $pesanan_id, ':menu_id' => $menu_id]);
$data = $stmt->fetch(PDO::FETCH_ASSOC);

// Ambil kasir_id yang sedang dipakai di pesanan ini
$stmtPesanan = $conn->prepare("SELECT kasir_id FROM pesanan WHERE pesanan_id = :pesanan_id");
$stmtPesanan->execute([':pesanan_id' => $pesanan_id]);
$pesanan = $stmtPesanan->fetch(PDO::FETCH_ASSOC);

// Ambil semua kasir untuk dropdown
$stmtKasir = $conn->query("SELECT kasir_id, kasir_nama FROM kasir ORDER BY kasir_id");
$listKasir = $stmtKasir->fetchAll(PDO::FETCH_ASSOC);

// Ambil semua pelanggan untuk dropdown buat pesanan manual
$stmtPelanggan = $conn->query("SELECT pelanggan_noHP, pelanggan_nama FROM pelanggan ORDER BY pelanggan_nama");
$listPelanggan = $stmtPelanggan->fetchAll(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Pesanan</title>
</head>
<body style="font-family:Arial; display:flex; flex-direction:column; justify-content:center; align-items:center; margin-top:30px">

    <!-- Header -->
    <div style="text-align:center; background:#f44236; width:530px; height:100px; border-radius:20px 20px 0 0; color:white">
        <h1 style="margin-top:15px; margin-bottom:0px">Sistem Pemesanan</h1>
        <h1 style="margin-top:0px">Ikan Bakar Muara</h1>
    </div>

    <div style="background:#f9f9f9; width:470px; border-radius:0px 0px 20px 20px; padding:30px">

        <!-- ===== SECTION 1: Edit Kuantitas (Pelanggan) ===== -->
        <h2 style="text-align:center; margin-top:5px;">Edit Kuantitas</h2>
        <form action="../process/update.php" method="POST">
            <input type="hidden" name="aksi" value="update_kuantitas">
            <input type="hidden" name="pesanan_id" value="<?= $pesanan_id ?>">
            <input type="hidden" name="menu_id" value="<?= $menu_id ?>">
            <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:15px;">
                <p style="margin:0"><?= $data['menu_nama'] ?></p>
                <input type="number" name="kuantitas" value="<?= $data['dp_kuantitas'] ?>" min="1"
                    style="width:150px; text-align:left; border:1px solid #ccc; border-radius:5px; padding:3px;">
            </div>
            <div style="display:flex; justify-content:center; gap:15px; margin-top:20px;">
                <button type="submit" style="background-color:#f44236; border:none; border-radius:5px; padding:7px; width:80px; color:white; cursor:pointer;">Update</button>
                <a href="tambah.php?pesanan_id=<?= $pesanan_id ?>">
                    <button type="button" style="border:2px solid #f44236; border-radius:5px; padding:5.5px; width:75px; color:black; cursor:pointer;">Kembali</button>
                </a>
            </div>
        </form>

        <hr style="margin:25px 0; border:none; border-top:1px solid #ddd;">

        <!-- ===== SECTION 2: Ganti Kasir ===== -->
        <h2 style="text-align:center;">Ganti Kasir</h2>
        <form action="../process/update.php" method="POST">
            <input type="hidden" name="aksi" value="update_kasir">
            <input type="hidden" name="pesanan_id" value="<?= $pesanan_id ?>">
            <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:15px;">
                <p style="margin:0">Kasir Bertugas</p>
                <select name="kasir_id" style="width:200px; padding:4px; border:1px solid #ccc; border-radius:5px;">
                    <?php foreach ($listKasir as $kasir): ?>
                        <option value="<?= $kasir['kasir_id'] ?>"
                            <?= $kasir['kasir_id'] === $pesanan['kasir_id'] ? 'selected' : '' ?>>
                            <?= $kasir['kasir_id'] ?> - <?= $kasir['kasir_nama'] ?>
                        </option>
                    <?php endforeach; ?>
                </select>
            </div>
            <div style="display:flex; justify-content:center; margin-top:20px;">
                <button type="submit" style="background-color:#f44236; border:none; border-radius:5px; padding:7px; width:80px; color:white; cursor:pointer;">Simpan</button>
            </div>
        </form>

        <hr style="margin:25px 0; border:none; border-top:1px solid #ddd;">

        <!-- ===== SECTION 3: Buat Pesanan Manual (Kasir) ===== -->
        <h2 style="text-align:center;">Buat Pesanan Manual</h2>
        <form action="../process/insert_manual.php" method="POST">
            <table style="width:100%; border-collapse:collapse;">
                <tr>
                    <td style="padding:5px 0;">Pelanggan</td>
                    <td style="padding:5px 0;">
                        <select name="pelanggan_noHP" style="width:200px; padding:4px; border:1px solid #ccc; border-radius:5px;">
                            <?php foreach ($listPelanggan as $p): ?>
                                <option value="<?= $p['pelanggan_noHP'] ?>"><?= $p['pelanggan_nama'] ?> (<?= $p['pelanggan_noHP'] ?>)</option>
                            <?php endforeach; ?>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="padding:5px 0;">Kasir</td>
                    <td style="padding:5px 0;">
                        <select name="kasir_id" style="width:200px; padding:4px; border:1px solid #ccc; border-radius:5px;">
                            <?php foreach ($listKasir as $kasir): ?>
                                <option value="<?= $kasir['kasir_id'] ?>"><?= $kasir['kasir_id'] ?> - <?= $kasir['kasir_nama'] ?></option>
                            <?php endforeach; ?>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="padding:5px 0;">Tanggal</td>
                    <td style="padding:5px 0;">
                        <input type="date" name="pesanan_tanggal" value="<?= date('Y-m-d') ?>"
                            style="width:196px; padding:3px; border:1px solid #ccc; border-radius:5px;">
                    </td>
                </tr>
                <tr>
                    <td style="padding:5px 0;">No. Meja</td>
                    <td style="padding:5px 0;">
                        <input type="text" name="pesanan_noMeja" required
                            style="width:196px; padding:3px; border:1px solid #ccc; border-radius:5px;">
                    </td>
                </tr>
                <tr>
                    <td style="padding:5px 0;">Jenis</td>
                    <td style="padding:5px 0;">
                        <select name="pesanan_jenis" style="width:200px; padding:4px; border:1px solid #ccc; border-radius:5px;">
                            <option value="Dine in">Dine in</option>
                            <option value="Take away">Take away</option>
                        </select>
                    </td>
                </tr>
            </table>
            <div style="display:flex; justify-content:center; margin-top:20px;">
                <button type="submit" style="background-color:#f44236; border:none; border-radius:5px; padding:7px; width:120px; color:white; cursor:pointer;">Buat Pesanan</button>
            </div>
        </form>

    </div>
</body>
</html>
