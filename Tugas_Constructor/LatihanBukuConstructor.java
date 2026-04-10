package Tugas_Constructor;

class Buku{
    String judul; //atribut class 
    String pengarang; 
    int harga; 
    public Buku(){//Constructor tanpa parameter
        judul = "Belum diisi";
        pengarang = "Belum diisi"; 
        harga = 0;
    }
    public Buku(String judul, String pengarang, int harga){//Constructor dengan parameter dan menggunakan this
        this.judul = judul;
        this.pengarang = pengarang; 
        this.harga = harga;
    }
    public void tampilkanInfo(){ //method class
        System.out.println("=== INFORMASI BUKU ===");
        System.out.println("Judul        : "+ judul);
        System.out.println("Pengarang    : "+ pengarang);
        System.out.println("Harga        : Rp "+ harga + "\n");
    }
}

public class LatihanBukuConstructor {
    public static void main(String[] args) {
        Buku buku1 = new Buku(); //membuat objek menggunakan constructor tanpa parameter
        buku1.tampilkanInfo(); 

        Buku buku2 = new Buku("Pemrograman Java","Budi Raharjo",125000); //membuat objek menggunakan Constructor dengan parameter
        buku2.tampilkanInfo();

        Buku buku3 = new Buku("Algoritma dan Struktur Data","Rinaldi Munir",150000); //membuat objek menggunakan Constructor dengan parameter
        buku3.tampilkanInfo(); 
    }
}