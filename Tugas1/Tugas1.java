package Tugas1;

interface MetodePembayaran {
    void bayar(int total);
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

class Pesanan(){
    String tanggalPesanan;
    
    public void tampilkanPesanan(){

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
    String pelangganStatus;

    // utk input data pelanggan dan bedakan status
    public Pelanggan(String pelangganId, String pelangganNoHP, String pelangganNama, String pelangganStatus){ 
        this.pelangganId = pelangganId;
        this.pelangganNoHP = pelangganNoHP;
        this.pelangganNama = pelangganNama;
        this.pelangganStatus = pelangganStatus;   
    }

    public void inputPelanggan(){

    }
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
        PembayaranDebit pelanggan1 = new PembayaranDebit();
        pelanggan1.bayar(80000);
    }
}
