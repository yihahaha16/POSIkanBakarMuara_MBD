<?php 
require_once '../config/database.php';
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Hapus Pesanan</title>
    </head>
    <body>
        <?php 
        $pesanan_id=$_GET['pesanan_id'];
        $menu_id=$_GET['menu_id'];   
        $stmt=$conn->query("SELECT menu_nama FROM menu WHERE menu_id='$menu_id'");
        $data=$stmt->fetch(PDO::FETCH_ASSOC);
        ?>
        <p>Apakah anda yakin ingin menghapus pesanan <?= $data['menu_nama']?></p>
        <form action="../process/delete.php" method="post">
             <input type="hidden" name="pesanan_id" value="<?= $pesanan_id ?>">
    <input type="hidden" name="menu_id" value="<?= $menu_id ?>">
        <button type="submit">Ya</button>
        </form>
        <a href="tambah.php&pesanan_id=<?=  $pesanan_id?>">
            <button type="button">Tidak</button>
        </a>
    </body>
</html>