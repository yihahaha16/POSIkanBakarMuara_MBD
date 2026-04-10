package Tugas_Constructor_Overloading;

class Produk{//class produk
    String namaProduk;
    int harga;
    int stok;
    public Produk(String namaProduk, int harga){//Constructor Overloading 1: dengan dua parameter
        this.namaProduk = namaProduk;
        this.harga = harga;
        stok = 0;
    }
    public Produk(String namaProduk, int harga, int stok){//Constructor Overloading 2: dengan tiga parameter
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
    }
    public void tampilkanInfo(){//method class
        System.out.println("=== INFORMASI PRODUK ===");
        System.out.println("Nama Produk : " + namaProduk);
        System.out.println("Harga       : Rp " + harga);
        System.out.println("Stok        : " + stok + "\n");
    }
}

public class LatihanProdukOverloading {
    public static void main(String[] args) {
        Produk produk1 = new Produk("Laptop Asus", 8500000);//membuat objek dengan constructor 1
        produk1.tampilkanInfo();
        Produk produk2 = new Produk("Mouse Logitech", 250000, 50);//membuat objek dengan constructor 2
        produk2.tampilkanInfo();
    }
}