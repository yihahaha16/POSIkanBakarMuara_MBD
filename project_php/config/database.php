<?php
$host = "localhost";
$dbname = "ikanbakarmuara"; //sesuaikan nama db kalian
$username = "root";
$password = ""; //sesuaikan pass db kalian
try {
$conn = new PDO(
"mysql:host=$host;dbname=$dbname;charset=utf8",
$username,
$password
);
$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
echo "Koneksi database berhasil";
} catch (PDOException $e) {
die("Koneksi database gagal: " . $e->getMessage());
}