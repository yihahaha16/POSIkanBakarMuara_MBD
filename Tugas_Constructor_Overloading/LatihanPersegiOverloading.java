package Tugas_Constructor_Overloading;

class PersegiPanjang{ //Class PersegiPanjang
    int panjang; //atribut class PersegiPanjang
    int lebar;
    int luas;
    int keliling;

    public PersegiPanjang(int sisi){ //Constructor overloading 1: dengan satu parameter
        this.panjang = sisi;
        this.lebar = sisi;
        this.luas = this.panjang * this.lebar;
        this.keliling = 2 * (panjang + lebar);
    }

    public PersegiPanjang(int panjang, int lebar){ //Constructor overloading 2: dengan dua parameter
        this.panjang = panjang;
        this.lebar = lebar;
        this.luas = this.panjang * this.lebar; 
        this.keliling = 2 * (this.panjang + this.lebar);
    }

    public void tampilkanInfo(){ //Method untuk melihat informasi persegi 
        System.out.println("=== PERSEGI ===");
        System.out.println("Panjang : " + panjang + " cm");
        System.out.println("Lebar   : " + lebar + " cm");
        System.out.println("Luas    : " + luas + " cm²");
        System.out.println("Keliling: " + keliling + " cm\n");
    }

    public void tampilkanInfoPersegiPanjang(){ //Method untuk melihat informasi persegi panjang
        System.out.println("=== PERSEGI PANJANG ===");
        System.out.println("Panjang : " + panjang + " cm");
        System.out.println("Lebar   : " + lebar + " cm");
        System.out.println("Luas    : " + luas + " cm²");
        System.out.println("Keliling: " + keliling + " cm\n");
    }
}

public class LatihanPersegiOverloading {
    public static void main(String[] args) {
        PersegiPanjang persegi1 = new PersegiPanjang(5); //object persegi1 dengan menggunakan constructor overloading 1
        persegi1.tampilkanInfo();
        PersegiPanjang persegi2 = new PersegiPanjang(8, 4); //object persegi2 dengan menggunakan constructor overloading 2
        persegi2.tampilkanInfoPersegiPanjang();
    }
}