package Tugas1;

interface MetodePembayaran {
    public void bayar(int total);
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
class PembayaranCash implements MetodePembayaran {
    public void bayar(int total) {
        System.out.println("Bayar cash: " + total);
    }
}

class PembayaranQRIS implements MetodePembayaran {
    public void bayar(int total) {
        System.out.println("Scan QRIS untuk bayar: " + total);
    }
}

class PembayaranDebit implements MetodePembayaran {
    public void bayar(int total) {
        System.out.println("Gesek / tap kartu debit: " + total);
    }
}

public class Tugas1 {
    public static void main(String[] args) {
        // PembayaranDebit pelanggan1 = new PembayaranDebit();
        // pelanggan1.bayar(80000);
        
    }
}
