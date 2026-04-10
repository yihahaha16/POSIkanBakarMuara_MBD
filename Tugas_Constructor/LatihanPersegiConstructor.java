package Tugas_Constructor;
class Persegi { // Class Persegi
    // Atribut yang digunakan untuk class Persegi
    int sisi;
    int luas;
    int keliling;

    // Constructor 1, dengan parameter dan syarat bahwa sisi <= 0
    public Persegi(int sisi) {
        if (sisi <= 0) {
            System.out.println("ERROR: Sisi tidak boleh <= 0. Diset ke default (1).");
            this.sisi = 1; // kalau sisi <= 0, maka defaultnya jadi 1
        } else {
            this.sisi = sisi;
        }
        this.luas = this.sisi * this.sisi;
        this.keliling = 4 * this.sisi;
    }

    // Method untuk menampilkan hasil persegi
    public void tampilkanHasil() {
        System.out.println("=== PERSEGI ===");
        System.out.println("Sisi    : " + sisi + " cm");
        System.out.println("Luas    : " + luas + " cm2");
        System.out.println("Keliling: " + keliling + " cm");
        System.out.println();
    }
}

public class LatihanPersegiConstructor {
        public static void main(String[] args) {
        // Object ke-1, jika sisi > 0
        Persegi persegi1 = new Persegi(5);
        persegi1.tampilkanHasil();

        // Object ke-2, jika sisi <= 0
        Persegi persegi2 = new Persegi(-3);
        persegi2.tampilkanHasil();
    }
}
