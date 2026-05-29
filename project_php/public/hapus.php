<?php require_once '../config/database.php'; ?>
<!DOCTYPE html>
<html>
    <head>
        <title>Hapus Pesanan</title>
    </head>
   <body style="font-family:Arial; display:flex; flex-direction: column;justify-content:center; align-items:center;margin-top:30px">    
    <div style="text-align:center;background:#f44236;width:530px;height:100px;border-radius:20px 20px 0 0;color:white">    
    <h1 style="margin-top:15px;margin-bottom: 0px">Sistem Pemesanan </h1><h1 style="margin-top: 0px"> Ikan Bakar Muara</h1> </div> 
    <div style="background:#f9f9f9;width:470px;border-radius:0px 0px 20px 20px;padding:30px"> <?php $pesanan_id=$_GET['pesanan_id'];
        $menu_id=$_GET['menu_id'];   
        $stmt=$conn->query("SELECT menu_nama FROM menu WHERE menu_id='$menu_id'");
        $data=$stmt->fetch(PDO::FETCH_ASSOC); ?>
       <p style="margin-top:10px; margin-bottom:0px;">Apakah anda yakin ingin menghapus pesanan <strong><?= $data['menu_nama']?> </strong>?</p></div>
        <div style="background:#f9f9f9;width:510px;height:30px;border-radius:0px 0px 20px 20px;padding:10px;display:flex; gap: 40px; justify-content:center;">
        <form action="../process/delete.php" method="post">
            <input type="hidden" name="pesanan_id" value="<?= $pesanan_id ?>">
            <input type="hidden" name="menu_id" value="<?= $menu_id ?>">
            <button style="background-color:#f44236;border:none;border-radius:5px;padding:7px;width:80px;color:white;cursor: pointer;" type="submit">Ya</button>
        </form>
        <a href="tambah.php?pesanan_id=<?=  $pesanan_id?>">
            <button style="border:2px solid #f44236;border-radius:5px;padding:5.5px;width:75px;color:black;cursor: pointer;" type="button">Tidak</button>
        </a></div>
    </body>
</html>