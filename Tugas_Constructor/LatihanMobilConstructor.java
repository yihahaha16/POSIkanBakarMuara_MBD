package Tugas_Constructor;

class Mobil{ //Class Mobil
    String merk; //Atribut class
    String warna;
    int tahun;

    public Mobil(){//Constructor tanpa parameter
        merk = "Belum diisi";
        warna = "Belum diisi";
        tahun = 0;
    }

    public Mobil(String merk){//Constructor dengan parameter merk dan menggunakan this
        warna = "Belum diisi";
        tahun = 0;
    }

    public Mobil(String merk, String warna, int tahun){//Constructor dengan parameter merk, warna, tahun dan menggunakan this
        this.merk = merk;
        this.warna = warna;
        this.tahun = tahun;
    }

    public void tampilkanSpesifikasi(){//Method untuk menampilkan spesifikasi
        System.out.println("=== SPESIFIKASI MOBIL ===");
        System.out.println("Merk : " + merk);
        System.out.println("Warna: " + warna);
        System.out.println("Tahun: " + tahun + "\n");
    }
}

public class LatihanMobilConstructor {
    public static void main(String[] args) {
        Mobil mobil1 = new Mobil(); //Object baru dengan constructor tanpa parameter
        mobil1.tampilkanSpesifikasi();
        Mobil mobil2 = new Mobil("Toyota"); //Object baru constructor dengan parameter
        mobil2.tampilkanSpesifikasi();
        Mobil mobil3 = new Mobil("Honda Civic","Merah",2023); //Object baru constructor dengan parameter
        mobil3.tampilkanSpesifikasi();
    }
}