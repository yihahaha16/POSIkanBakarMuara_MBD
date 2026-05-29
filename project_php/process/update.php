<?php
require_once "../config/database.php";
 
$pesanan_id = $_POST['pesanan_id'];
$jenis = $_POST['jenis'] ?? '';
 
try {
    if (empty($pesanan_id)) {
        die("Data tidak lengkap");
    }
 
    if ($jenis === 'update_kuantitas') {
        $menu_id   = $_POST['menu_id'];
        $kuantitas = $_POST['kuantitas'];
        if (empty($menu_id) || empty($kuantitas)) {
            die("Semua kolom harus terisi");
        }
        $stmt = $conn->prepare("
            UPDATE detail_pesanan
            SET dp_kuantitas = :qty
            WHERE pesanan_id = :pesanan_id AND menu_id = :menu_id
        ");
        $stmt->execute([
            ':qty'        => $kuantitas,
            ':pesanan_id' => $pesanan_id,
            ':menu_id'    => $menu_id
        ]);
 
    } elseif ($jenis === 'update_kasir') {
        $kasir_id = $_POST['kasir_id'];
        if (empty($kasir_id)) {
            die("Kasir harus dipilih");
        }
        $stmt = $conn->prepare("
            UPDATE pesanan
            SET kasir_id = :kasir_id
            WHERE pesanan_id = :pesanan_id
        ");
        $stmt->execute([
            ':kasir_id'   => $kasir_id,
            ':pesanan_id' => $pesanan_id
        ]);
 
    } else {
        die("Salah memasukkan data.");
    }
 
    header("Location: ../public/tambah.php?pesanan_id=" . $pesanan_id);
    exit;
} catch (PDOException $e) {
    echo "Gagal mengubah pesanan: " . $e->getMessage();
}

/* <?php
require_once "..\config\database.php";
try{
    $stmt = $conn->prepare("
        update detail_pesanan
        set dp_kuantitas = :qty
        where pesanan_id = :pesanan_id and menu_id = :menu_id
    ");
    foreach($_POST['dp_kuantitas'] as $menu_id => $kuantitas){
        if (empty($pesanan_id) || empty($menu_id) || empty($kuantitas)) {
            $errorMessage = "Semua kolom harus terisi";
            break;
        }
        $stmt->execute([
            ':pesanan_id' => $pesanan_id,
            ':menu_id' => $menu_id,
            ':dp_kuantitas' => $kuantitas
        ]);
    }

    header("Location: /public/tambah.php?pesanan_id=" . $pesanan_id);
    exit;
} catch (PDOException $e) {
    echo "Gagal mengubah pesanan: " . $e->getMessage();
}
*/
