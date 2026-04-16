package Tugas1;

//INTERFACE: digunakan untuk class yang mempunyai method sama namun logika cetak struk yang berbeda (PembayaranQRIS dan PembayaranCash)
interface CetakStruk {
    public void cetakStruk();
}

class Menu{
    String menuId;
    String menuNama;
    String menuStatus;
    String menuKategori;
    int menuHarga;

    //Constructor untuk menginisialisasi data Menu
    public Menu(String menuId, String menuNama, String menuStatus, String menuKategori, int menuHarga){
        this.menuId = menuId;
        this.menuNama = menuNama;
        this.menuStatus = menuStatus;
        this.menuKategori = menuKategori;
        this.menuHarga = menuHarga;
    }

    //Method untuk menampilkan Menu
    public void tampilMenu(){
        System.out.println(menuId + " - " + menuNama + " - " + menuKategori + " - Rp " + menuHarga + " - " + menuStatus);
    }
}

// class Pesanan(){
//     String tanggalPesanan;
    
//     public void tampilkanPesanan(){

//     }
// }
abstract class Pesanan {
    public void prosesPesanan() {
        inputData();
        if (cekKetersediaan()) {
            hitungTotal();
            buatID();
            simpanPesanan();
        } else {
            System.out.println("Menu tidak tersedia, silakan input ulang");
            inputData();
        }
    }

    abstract void inputData();
    abstract boolean cekKetersediaan();
    abstract void hitungTotal();
    abstract void buatID();
    abstract void simpanPesanan();
}

class PesananMandiri extends Pesanan {

    void inputData() {
        System.out.println("User input sendiri di sistem");
    }

    boolean cekKetersediaan() {
        System.out.println("Cek menu tersedia");
        return true;
    }

    void hitungTotal() {
        System.out.println("Hitung total + pajak");
    }

    void buatID() {
        System.out.println("Generate ID pesanan");
    }

    void simpanPesanan() {
        System.out.println("Pesanan disimpan");
    }
}

class PesananKasir extends Pesanan {
    void inputData() {
        System.out.println("Kasir input pesanan");
    }

    boolean cekKetersediaan() {
        System.out.println("Kasir cek menu");
        return true;
    }

    void hitungTotal() {
        System.out.println("Kasir hitung total");
    }

    void buatID() {
        System.out.println("Generate ID");
    }

    void simpanPesanan() {
        System.out.println("Simpan pesanan");
    }
}

class PesananKaryawan extends Pesanan {

    void inputData() {
        System.out.println("Karyawan bantu input via tablet");
    }

    boolean cekKetersediaan() {
        System.out.println("Cek menu di sistem");
        return true;
    }

    void hitungTotal() {
        System.out.println("Hitung total");
    }

    void buatID() {
        System.out.println("Generate ID");
    }

    void simpanPesanan() {
        System.out.println("Simpan pesanan");
    }
}

class Pelanggan{
    enum Status{
        Member,
        Reguler
    }
    String pelangganId;
    String pelangganNoHP;
    String pelangganNama;
    Status status;

    // utk input data pelanggan dan bedakan status
    public Pelanggan(String pelangganId, String pelangganNoHP, String pelangganNama, Status status){ 
        this.pelangganId = pelangganId;
        this.pelangganNoHP = pelangganNoHP;
        this.pelangganNama = pelangganNama;
        this.status = status;   
    }

    public void pesanDineIn(){
        
    }

    public void pesanTakeAway(){

    }
}

class Member extends Pelanggan{
    int poin = 0;
    String estimasiKedatangan;

    public void tambahPoin(){
        poin += ...; // (total bayar/10) kah?
    }
    
    public void pesanOnline(){
        
    }
}

class Reguler extends Pelanggan{
    //bingung ape isinye
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
    public void bayar(){
        System.out.println("Silahkan bayar di kasir dengan nominal Rp " + total);
        System.out.println("Uang yang diterima Rp " + saldo);
         if(cekPembayaran(total, saldo)){
            System.out.println("Pembayaran berhasil");
            System.out.println("Kembalian anda Rp " + hitungKembalian());
            cetakStruk();
        } else {
            System.out.println("Uang anda kurang Rp " + (total - saldo));
        }
    }
    public void cetakStruk(){
        System.out.println("STRUK PEMBAYARAN");
        System.out.println("Total: Rp " + total);
        System.out.println("Bayar: Rp " + saldo);
        System.out.println("Kembalian: Rp " + hitungKembalian());
        System.out.println("Terima kasih!");
    }
}

class PembayaranQRIS extends Pembayaran implements CetakStruk{
    public PembayaranQRIS(int total, int saldo) {
        super(total,saldo);
    }

    public void bayar(){
        System.out.println("Silahkan scan QRIS");
        System.out.println("Total pesanan anda Rp " + total);
         if(cekPembayaran(total, saldo)){
            System.out.println("Pembayaran berhasil");
            cetakStruk();
        } else {
            System.out.println("Saldo anda kurang Rp " + (total - saldo));
        }
    }
    public void cetakStruk(){
        System.out.println("STRUK PEMBAYARAN QRIS");
        System.out.println("Total: Rp " + total);
        System.out.println("Terima kasih!");
    }
}

public class Tugas1 {
    public static void main(String[] args) {
        // PembayaranDebit pelanggan1 = new PembayaranDebit();
        // pelanggan1.bayar(80000);
        
    }
}
