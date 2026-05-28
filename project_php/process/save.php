<?php
session_start();
require_once "..\config\database.php";
try{
    unset($_SESSION['pesanan_id']);
    unset($_SESSION['pelanggan_noHp']);
} catch (PDOException){
    echo "Gagal menyimpan pesanan: ". $e->getMessage();
}