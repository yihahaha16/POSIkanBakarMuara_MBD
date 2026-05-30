<?php

$host = "localhost";
$dbname = "ikanbakarmuara_full"; //sesuaikan nama db kalian
$username = "root";
$password = ""; //sesuaikan pass db kalian

session_start();
   
try {
$conn = new PDO(
"mysql:host=$host;dbname=$dbname;charset=utf8",
$username,
$password
);
$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
die("Koneksi database gagal: " . $e->getMessage());
}