package Tugas1;

//INTERFACE: digunakan untuk class yang mempunyai method sama namun logika cetak struk yang berbeda (PembayaranQRIS dan PembayaranCash)
interface CetakStruk {
    public void cetakStruk();
}

class Menu{
    String menuId;
    String menuNama;
    String menuStatus;
    // bool isAvailable;

    //Constructor untuk menginisialisasi data Menu
    public Menu(String menuId, String menuNama, String menuStatus){
        this.menuId = menuId;
        this.menuNama = menuNama;
        this.menuStatus = menuStatus;
    }

    //Method untuk menampilkan Menu
    public void tampilMenu(){
        System.out.println(menuId + " - " + menuNama + " - " + menuStatus);
    }
}

class MenuReguler extends Menu{
    private int hargaMenuReguler;

    public MenuReguler(String menuId, String menuNama, String menuStatus, int hargaMenuReguler){
        super(menuId, menuNama, menuStatus);
        this.hargaMenuReguler = hargaMenuReguler;
    }
}

class MenuPoin extends Menu{
    private int hargaMenuPoin;

    public MenuPoin(String menuId, String menuNama, String menuStatus, int hargaMenuPoin){
        super(menuId, menuNama, menuStatus);
        this.hargaMenuPoin = hargaMenuPoin;
    }
}

// POLYMORPHISM: memungkinkan method yang sama digunakan untuk perilaku yang berbeda (pada class DineIn dan TakeAway)
class Pesanan {
    String pesananId;
    int pesananTotal;
    int pesananPajak;

    public Pesanan(String pesananId, int pesananTotal){ 
        this.pesananId = pesananId;
        this.pesananTotal = pesananTotal;   
    }

    void pesan() {
        pesananPajak = (int)(pesananTotal * 0.1);
        int totalBayar = pesananTotal + pesananPajak;

        System.out.println("Pesanan telah dibuat");
        System.out.println("Total\t\t: Rp" + pesananTotal);
        System.out.println("Pajak (10%)\t: Rp" + pesananPajak);
        System.out.println("Total bayar\t: Rp" + totalBayar);
        System.out.println();
    }

    void proses() {
        System.out.println("Pesanan sedang diproses");
    }
}

class DineIn extends Pesanan{
    String noMeja;

    DineIn(String pesananId, int pesananTotal, String noMeja) {
        super(pesananId, pesananTotal);
        this.noMeja = noMeja;
    }

    @Override
    void proses() {
        System.out.println("Pesanan dine-in di meja " + noMeja + " sedang diproses!");
    }
}

class TakeAway extends Pesanan{
    TakeAway(String pesananId, int pesananTotal) {
        super(pesananId, pesananTotal);
    }

    @Override
    void proses() {
        System.out.println("Pesanan take away sedang diproses!");
    }
}
// abstract class Pesanan {
//     public void prosesPesanan() {
//         inputData();

//         if (cekKetersediaan()) {
//             hitungTotal();
//             buatID();
//             simpanPesanan();
//         } else {
//             System.out.println("Menu tidak tersedia, silakan input ulang");
//             inputData();
//         }
//     }

//     abstract void inputData();
//     abstract boolean cekKetersediaan();
//     abstract void hitungTotal();
//     abstract void buatID();
//     abstract void simpanPesanan();
// }

// class PesananMandiri extends Pesanan {

//     void inputData() {
//         System.out.println("User input sendiri di sistem");
//     }

//     boolean cekKetersediaan() {
//         System.out.println("Cek menu tersedia");
//         return true;
//     }

//     void hitungTotal() {
//         System.out.println("Hitung total + pajak");
//     }

//     void buatID() {
//         System.out.println("Generate ID pesanan");
//     }

//     void simpanPesanan() {
//         System.out.println("Pesanan disimpan");
//     }
// }

// class PesananKasir extends Pesanan {
//     void inputData() {
//         System.out.println("Kasir input pesanan");
//     }

//     boolean cekKetersediaan() {
//         System.out.println("Kasir cek menu");
//         return true;
//     }

//     void hitungTotal() {
//         System.out.println("Kasir hitung total");
//     }

//     void buatID() {
//         System.out.println("Generate ID");
//     }

//     void simpanPesanan() {
//         System.out.println("Simpan pesanan");
//     }
// }

// class PesananKaryawan extends Pesanan {

//     void inputData() {
//         System.out.println("Karyawan bantu input via tablet");
//     }

//     boolean cekKetersediaan() {
//         System.out.println("Cek menu di sistem");
//         return true;
//     }

//     void hitungTotal() {
//         System.out.println("Hitung total");
//     }

//     void buatID() {
//         System.out.println("Generate ID");
//     }

//     void simpanPesanan() {
//         System.out.println("Simpan pesanan");
//     }
// }

// SUPER CLASS PELANGGAN --- INHERITANCE
class Pelanggan{
    enum Status{
        Member,
        Reguler
    }
    String pelangganId; //BISE KE PAKEIN AUTO INCREMENT?? 
    String pelangganNama;
    Status status;

    public Pelanggan(String pelangganId, String pelangganNama, Status status){ 
        this.pelangganId = pelangganId;
        this.pelangganNama = pelangganNama;
        this.status = status;   
    }

    public void menampilkanPelanggan(){
        System.out.println("Nama\t\t: " + pelangganNama);
        System.out.println("Status\t\t: " + status);
    }
}

// SUBCLASS MEMBER (DARI SUPER CLASS PELANGGAN) 
class Member extends Pelanggan{
    int poin = 0;
    String pelangganNoHp;
    // public void tampilkanPoin(){
    //     System.out.println("Poin Anda: " + poin);
    // }

    public Member(String pelangganId, String pelangganNama, Status status, String pelangganNoHp){
        super(pelangganId, pelangganNama, Status.Member);
        this.pelangganNoHp = pelangganNoHp;
    }

    @Override // override untuk output lebih lengkap
    public void menampilkanPelanggan(){
        super.menampilkanPelanggan();
        System.out.println("No. HP\t\t: " + pelangganNoHp);
        System.out.println("Poin\t\t: " + poin);
    }
}

// SUBCLASS REGULER (DARI SUPER CLASS PELANGGAN)
class Reguler extends Pelanggan{
    public Reguler(String pelangganId, String pelangganNama, Status status){
        super(pelangganId, pelangganNama, Status.Reguler);
    }
}

//ABSTRACTION: Yang disembunyikan adalah detail proses pembayaran seperti validasi saldo dan perhitungan kembalian. User hanya menggunakan method bayar() tanpa mengetahui implementasinya
abstract class Pembayaran{
    int total;
    int saldo;
    public Pembayaran(int total) { //QRIS
        this.total = total;
    }
    public Pembayaran(int total, int saldo) { //Cash
        this.total = total;
        this.saldo = saldo;
    }
    public abstract void bayar();
    public boolean cekPembayaran(int total, int saldo){
        if(saldo<total){
            System.out.println("Saldo tidak mencukupi");
            return false;
        }
        else{
            return true;
        }
    }
}

class PembayaranCash extends Pembayaran implements CetakStruk{
    public PembayaranCash(int total, int saldo) {
        super(total,saldo);
    }

    public int hitungKembalian(){
        return saldo - total;
    }

    @Override // override untuk output lebih lengkap
    public void bayar(){
        System.out.println("Silahkan bayar di kasir dengan nominal Rp" + total);
        System.out.println("Uang yang diterima Rp" + saldo);
        System.out.println();

        if(cekPembayaran(total, saldo)){
            System.out.println("===== Pembayaran Berhasil =====");
            System.out.println("Kembalian anda Rp" + hitungKembalian());
            System.out.println();
            cetakStruk();
        } else {
            System.out.println("Uang anda kurang Rp " + (total - saldo));
        }
    }

    @Override // override untuk output lebih lengkap
    public void cetakStruk(){
        System.out.println("======= STRUK PEMBAYARAN =======");
        System.out.println("================================");
        System.out.println("Total\t\t: Rp" + total);
        System.out.println("Bayar\t\t: Rp" + saldo);
        System.out.println("Kembalian\t: Rp" + hitungKembalian());
        System.out.println("Terima kasih!");
    }
}

class PembayaranQRIS extends Pembayaran implements CetakStruk{
    public PembayaranQRIS(int total, int saldo) {
        super(total,saldo);
    }

    @Override // override untuk output lebih lengkap
    public void bayar(){
        System.out.println("====== Silakan scan QRIS ======");
        System.out.println("Total pesanan anda Rp" + total);
         if(cekPembayaran(total, saldo)){
            System.out.println("===== Pembayaran berhasil =====");
            System.out.println();
            cetakStruk();
        } else {
            System.out.println("Saldo anda kurang Rp" + (total - saldo));
        }
    }

    @Override // override untuk output lebih lengkap
    public void cetakStruk(){
        System.out.println("==== STRUK PEMBAYARAN QRIS ====");
        System.out.println("===============================");
        System.out.println("Total\t\t: Rp" + total);
        System.out.println("Terima kasih!");
    }
}

public class Tugas1 {
    public static void main(String[] args) {
        System.out.println("========= SELAMAT DATANG ========");
        System.out.println("=== RESTORAN IKAN BAKAR MUARA ===");
        System.out.println();

        // Pelanggan reguler (1) melihat menu reguler, menambahkan pesanan dine in, dan melakukan pembayaran cash
        Pelanggan pl1 = new Reguler("PL001", "Anita", Pelanggan.Status.Reguler);
        Menu m1 = new MenuReguler("M001", "Nila Bakar Muara", "Tersedia", 23000);
        Pesanan ps1 = new DineIn("PS001", 52000, "A1");
        Pembayaran pb1 = new PembayaranCash(52000, 250000);
        
        pl1.menampilkanPelanggan();
        System.out.println();

        m1.tampilMenu();
        System.out.println();

        ps1.pesan();
        ps1.proses();
        System.out.println();

        pb1.bayar();


        // // Pelanggan member (2) melihat menu poin, menambahkan pesanan take away, dan melakukan pembayaran qris
        // Pelanggan pl2 = new Member("P002", "Budi", Pelanggan.Status.Member, "089667788995");
        // Menu m2 = new MenuPoin("M010", "Tumis Kangkung Poin", "Tersedia", 15000);
        // Pesanan ps2 = new TakeAway("PS002", 15000);
        // Pembayaran pb2 = new PembayaranQRIS(15000, 60000);
        
        // pl2.menampilkanPelanggan();
        // System.out.println();

        // m2.tampilMenu();
        // System.out.println();

        // ps2.pesan();
        // ps2.proses();
        // System.out.println();

        // pb2.bayar();
    }
}
