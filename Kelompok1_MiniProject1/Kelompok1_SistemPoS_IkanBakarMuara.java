package Kelompok1_MiniProject1;
/**
* Mini Project 1: Sistem Point of Sale (PoS)
* Bisnis: Ikan Bakar Muara - Pontianak
* Kelompok: [Faliha Imtinan (D1041241004), Zalikhah Khairunnisa (D1041241018), Violaine Gunawan (D1041241036)]
*
* Pertemuan 16: Integrasi OOP Dasar
*/
// ========== CLASS MENU ==========
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

class Pelanggan{
    String idPelanggan;
    String nomorHp;
    String namaLengkap;

    public Pelanggan(String idPelanggan){
        this.idPelanggan = idPelanggan;
        nomorHp = "-";
        namaLengkap = "-";
    }

    public Pelanggan(String idPelanggan, String nomorHp, String namaLengkap){
        this.idPelanggan = idPelanggan;
        this.nomorHp = nomorHp;
        this.namaLengkap = namaLengkap;
    }

    public void tampilPelanggan(){
        System.out.println(idPelanggan + " - " + nomorHp + " - " + namaLengkap);
    }
}

class Member{
    String nomorHp;
    String namaLengkap;

    public Member(String nomorHp, String namaLengkap){
        this.nomorHp = nomorHp;
        this.namaLengkap = namaLengkap;
    }

    public void tampilMember(){
        System.out.println(nomorHp + " - " + namaLengkap);
    }
    //fitur diskon member
}

class Pesanan{
    String pesananTanggal;

}


// ========== MAIN PROGRAM ==========
public class Kelompok1_SistemPoS_IkanBakarMuara {
    public static void main(String[] args) {
        // Header sistem
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║       SISTEM POINT OF SALE (PoS)       ║");
        System.out.println("║      Ikan Bakar Muara - Pontianak      ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        // 1. Membuat array menu (minimal 5)
        Menu[] daftarMenu = new Menu[5];
        
        // 2. Mengisi data menu
        daftarMenu[0] = new Menu("M0001", "Nila Bakar Muara", "Tersedia", "Makanan", 26000);
        daftarMenu[1] = new Menu("M0002", "Nila Bakar Madu", "Tersedia", "Makanan", 26000);
        daftarMenu[2] = new Menu("M0003", "Nila Goreng", "Tersedia", "Makanan", 23000);
        daftarMenu[3] = new Menu("M0004", "Jeruk Kecil", "Tersedia", "Minuman", 8000);
        daftarMenu[4] = new Menu("M0005", "Lemon Tea", "Tersedia", "Minuman", 7000);
        
        // 3. Menampilkan daftar menu
        System.out.println("════════════ DAFTAR MENU ════════════");
        for (int i = 0; i < daftarMenu.length; i++) {
            daftarMenu[i].tampilMenu();
        }
        System.out.println();

        // 4. Simulasi transaksi
        System.out.println("═══════════ TRANSAKSI BARU ══════════");
        System.out.println("Tanggal: 20 Februari 2026");
        System.out.println("Kasir  : Kelompok 1");
        System.out.println("─────────────────────────────────────");

        // === TRANSAKSI 1 ===
        // Item 1: Nila Bakar Muara (qty 1)
        int qty1 = 1;
        double subtotal1 = daftarMenu[0].menuHarga * qty1;
        System.out.println("Item 1: " + daftarMenu[0].menuNama + " (" + qty1 + "x) - Rp " + subtotal1);

        // Item 2: Nila Bakar Madu (qty 2)
        int qty2 = 2;
        double subtotal2 = daftarMenu[1].menuHarga * qty2;
        System.out.println("Item 2: " + daftarMenu[1].menuNama + " (" + qty2 + "x) - Rp " + subtotal2);

        // Item 3: Lemon Tea (qty 3)
        int qty3 = 3;
        double subtotal3 = daftarMenu[4].menuHarga * qty3;
        System.out.println("Item 3: " + daftarMenu[4].menuNama + " (" + qty3 + "x) - Rp " + subtotal3);
        
        // === TRANSAKSI 2 ===
        // // Item 1: Nila Goreng (qty 1)
        // int qty1 = 1;
        // double subtotal1 = daftarMenu[2].menuHarga * qty1;
        // System.out.println("Item 1: " + daftarMenu[2].menuNama + " (" + qty1 + "x) - Rp " + subtotal1);

        // // Item 2: Nila Bakar Madu (qty 2)
        // int qty2 = 2;
        // double subtotal2 = daftarMenu[1].menuHarga * qty2;
        // System.out.println("Item 2: " + daftarMenu[1].menuNama + " (" + qty2 + "x) - Rp " + subtotal2);

        // // Item 3: Lemon Tea (qty 3)
        // int qty3 = 3;
        // double subtotal3 = daftarMenu[4].menuHarga * qty3;
        // System.out.println("Item 3: " + daftarMenu[4].menuNama + " (" + qty3 + "x) - Rp " + subtotal3);
        // System.out.println("─────────────────────────────────────");

        // === TRANSAKSI 3 ===
        // // Item 1: Nila Bakar Muara (qty 2)
        // int qty1 = 2;
        // double subtotal1 = daftarMenu[0].menuHarga * qty1;
        // System.out.println("Item 1: " + daftarMenu[0].menuNama + " (" + qty1 + "x) - Rp " + subtotal1);

        // // Item 2: Nila Bakar Madu (qty 1)
        // int qty2 = 1;
        // double subtotal2 = daftarMenu[1].menuHarga * qty2;
        // System.out.println("Item 2: " + daftarMenu[1].menuNama + " (" + qty2 + "x) - Rp " + subtotal2);

        // // Item 3: Jeruk Kecil (qty 2)
        // int qty3 = 2;
        // double subtotal3 = daftarMenu[3].menuHarga * qty3;
        // System.out.println("Item 3: " + daftarMenu[3].menuNama + " (" + qty3 + "x) - Rp " + subtotal3);
        // System.out.println("─────────────────────────────────────");

        // 5. Hitung total
        double total = subtotal1 + subtotal2 + subtotal3;
        System.out.println("SUBTOTAL: Rp " + total);
        System.out.println("─────────────────────────────────────");
        System.out.println("TOTAL: Rp " + total);
        System.out.println("═════════════════════════════════════");
        System.out.println();
        System.out.println("Terima kasih telah berbelanja!");
    }
}