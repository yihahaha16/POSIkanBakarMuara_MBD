Anggota Kelompok 1:
Faliha Imtinan (D1041241004)
Violaine Gunawan (D1041241036)
Zalikhah Khairunnisa (D1041241018)

Deskripsi sistem:
Studi kasus ini adalah Sistem POS Restoran Ikan Bakar Muara Sistem ini dibuat agar kasir dapat melakukan input pesanan sehingga proses pencatatan pesanan dapat dilakukan secara lebih akurat, efisien, dan terstruktur.
Pada halaman index, kasir akan diminta untuk mengisi informasi data pelanggan, seperti nama dan nomor telepon. Lalu dilanjutkan untuk mengisi data pesanan, seperti tanggal pesan, nomor meja, ID kasir, jenis pesanan, dan menyesuaikan kuantitas/jumlah menu yang diinginkan. Data ini akan disimpan pada database menggunakan PDO dan PHP. 
Selanjutnya,  kasir akan dialihkan ke halaman tambah. Halaman ini akan menampilkan menu yang telah dipilih beserta detail pesanan, seperti kuantitas yang dipesan, subtotal per menu, dan grand total pesanan. Kasir dapat melakukan aksi, seperti mengubah kuantitas dengan tombol edit dan menghapus pesanan dengan tombol hapus. Pada aksi edit, kasir dapat mengubah kuantitas menu yang telah dipesan dengan syarat kuantitas tidak boleh <= 0. Sedangkan pada aksi hapus, kasir dapat menghapus menu yang dipesan dengan syarat melakukan konfirmasi terlebih dahulu (ya/tidak). 
Selanjutnya, kasir akan dialihkan pada halaman savepesanan, kasir akan memilih metode pembayaran tunai/nontunai sesuai dengan pilihan pelanggan. Setelah memilih metode pembayaran dan menekan tombol bayar kasir akan dialihkan ke halaman selesai dimana halaman tersebut meenampilkan apakah transaksi berhasil/tidak. Kemudian ada tombol kembali ke beranda untuk membuat pesanan baru lagi.
Dengan adanya sistem ini, proses pencatatan dapat berjalan lebih efisien dan terstruktur.

Instalasi (Menggunakan Visual Studio Code, MySQL Command Line Client dan Chrome):
1. Download file ikanbakarmuara_fullbackup.sql
2. Buka MySQL Command Line Client, kemudian login, dan jalankan sintaks berikut "CREATE DATABASE ikanbakarmuara" 
3. Buka Command Prompt, ubah ke directory (cd) tempat penyimpanan file sql tersebut
4. Jalankan sintaks berikut "mysql -u root -p ikanbakarmuara <  ikanbakarmuara_fullbackup.sql"
5. Buka Visual Studio Code, pada navigation bar di kiri atas, disamping menu run, klik titik 3 > Terminal > New Terminal
6. Jalankan sintaks berikut "cd project_php" kemudian enter
7. Jalankan sintaks berikut "php -S localhost:8000" kemudian enter
8. Buka Chrome, ketik "http://localhost:8000/public"
9. Project berhasil dijalankan