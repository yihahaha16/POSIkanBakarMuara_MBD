<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert Menu</title>
</head>
<body>
    <p>Pilih Menu</p>
    <?php
    require_once'D:\Kul\Semester_4\PBO_Praktikum\PBO_POSIkanBakarMuara\project_php\config\database.php';

    try{
        $stmt = $conn->prepare(
        "insert into detail_pesanan menu_id, dp_kuantitas values (:menu_id, :dp_kuantitas)"
        );

        $stmt->execute([
            ':menu_id' => $_POST['menu_id']，
            ':dp_kuantitas' => $_POST['dp_kuantitas']，
        ]);

        header("Location: D:\Kul\Semester_4\PBO_Praktikum\PBO_POSIkanBakarMuara\project_php\public\index.php?status=sukses")
    }catch (PDOException $e){
        echo "Gagal menambah pesanan: " . $e->getMessage();
    }
</body>
</html>