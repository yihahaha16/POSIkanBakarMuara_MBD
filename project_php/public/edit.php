<?php
require_once "../config/database.php";

$pesanan_id = $_GET['pesanan_id'];
$stmt = $conn->prepare("
    select dp.menu_id, m.menu_nama, dp.dp_kuantitas
    from detail_pesanan dp
    join menu m on dp.menu_id = m.menu_id
    where dp.pesanan_id = :pesanan_id
");
$stmt->execute([':pesanan_id' => $pesanan_id]);
$data = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Jumlah</title>
</head>

<body style="font-family:Arial; display:flex; flex-direction:column; justify-content:center; align-items:center; margin-top:30px">
    <div style="text-align:center; background:#f44236; width:530px; height:100px; border-radius:20px 20px 0 0; color:white">    
    <h1 style="margin-top:15px; margin-bottom:0px">Sistem Pemesanan </h1><h1 style="margin-top: 0px"> Ikan Bakar Muara</h1>
    </div>
</body>

<body style="font-family:Arial; background:#f5f5f5;">
<div style="width:400px; margin:0px auto; background:white; padding:20px; border-radius:20px;">

<h2 style="text-align:center;">Edit Kuantitas</h2>
    <form action="../process/update.php" method="POST">
        <input type="hidden" name="pesanan_id" value="<?= $pesanan_id ?>">

        <?php foreach ($data as $row): ?>
            <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:15px;">
                <span><?= $row['menu_nama'] ?></span>

                <div style="display:flex; align-items:center; gap:5px;">
                    <input type="number" name="dp_kuantitas[<?= $row['menu_id'] ?>]" id="kuantitas-<?= $row['menu_id'] ?>" 
                    value="<?= $row['dp_kuantitas'] ?>" class="kuantitas_input" min="1" 
                    style="width:150px; text-align:left; border:1px solid #ccc; border-radius:5px; padding:3px;">
                </div>
            </div>
        <?php endforeach; ?>

        <div style="display:flex; justify-content:center; gap:15px; margin-top:20px;">
        <button style="background-color:#f44236; border:none; border-radius:5px; padding:5px; 
            width:70px; color:white; font-size:14px; font-family:Arial; cursor: pointer;" type="submit">Update</button>
        <a href="tambah.php?pesanan_id=<?= $pesanan_id ?>"
            style="display:inline-block; border:2px solid #f44236; border-radius:5px; padding:5px;
            width:70px; text-align:center; color:black; font-size:14px; font-family:Arial; text-decoration:none; cursor:pointer;">Kembali</a>
        </div>
    </form>
</div>

<script>
function plus(id) {
    let input = document.getElementById('kuantitas-' + id);
    input.value = parseInt(input.value) + 1;
}

function minus(id) {
    let input = document.getElementById('kuantitas-' + id);
    if (input.value > 1) {
        input.value = parseInt(input.value) - 1;
    }
}
</script>

</body>
</html>
