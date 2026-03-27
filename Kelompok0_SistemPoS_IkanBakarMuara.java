/**
* Mini Project 1: Sistem Point of Sale (PoS)
* Bisnis: Ikan Bakar Muara - Pontianak
* Kelompok: [Nama Anggota 1, 2, Violaine Gunawan (D1041241036)]
*
* Pertemuan 16: Integrasi OOP Dasar
*/
// ========== CLASS PRODUK ==========
class Menu{
    String menuId;
    String menuNama;
    String menuStatus;
    String menuKategori;
    int menuHarga;
    //Constructor
    public Menu(String menuId, String menuNama, String menuStatus, String menuKategori, int menuHarga){
        this.menuId = menuId;
        this.menuNama = menuNama;
        this.menuStatus = menuStatus;
        this.menuKategori = menuKategori;
        this.menuHarga = menuHarga;
    }
    //Method tampil produk
    public void tampilMenu(){
        System.out.println(menuId + " - " + menuNama + " - " + menuKategori + " - Rp " + menuHarga + " - " + menuStatus);
    }
}
// ========== MAIN PROGRAM ==========
public class Kelompok0_SistemPoS_IkanBakarMuara {
    public static void main(String[] args) {
        // Header sistem
        System.out.println("=== SISTEM POINT OF SALE ===");
        System.out.println("Bisnis: Ikan Bakar Muara - Pontianak\n");
        
        // 1. Membuat array produk (minimal 5)
        Menu[] daftarMenu = new Menu[5];
        
        // 2. Mengisi data produk
        daftarMenu[0] = new Menu("M0001", "Nila Bakar Muara", "Tersedia", "Makanan", 26000);
        daftarMenu[1] = new Menu("M0002", "Nila Bakar Madu", "Tersedia", "Makanan", 26000);
        daftarMenu[2] = new Menu("M0003", "Nila Goreng", "Tersedia", "Makanan", 23000);
        daftarMenu[3] = new Menu("M0004", "Jeruk Kecil", "Tersedia", "Minuman", 8000);
        daftarMenu[4] = new Menu("M0005", "Lemon Tea", "Tersedia", "Minuman", 7000);
        
        // 3. Menampilkan daftar produk
        System.out.println("DAFTAR MENU:");
        for (int i = 0; i < daftarMenu.length; i++) {
            daftarMenu[i].tampilMenu();
        }
        System.out.println();

        // 4. Simulasi transaksi
        System.out.println("=== TRANSAKSI ===");
        
    }
}
