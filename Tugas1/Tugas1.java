package Tugas1;

//INTERFACE: digunakan untuk class yang mempunyai method sama namun logika cetak struk yang berbeda (PembayaranQRIS dan PembayaranCash)
interface CetakStruk {
    public void cetakStruk();
}

//INHERITANCE: digunakan untuk mewarisi atribut dan perilaku yang dimiliki oleh superclass ke subclass
class Menu{
    enum Status{
        Tersedia,
        Habis
    }
    //Encapsulation: dilindungi supaya tidak bisa diubah sembarangan dari luar class.
    private String menuId;
    private String menuNama;
    private Status menuStatus;          

    //Constructor untuk menginisialisasi data Menu
    public Menu(String menuId, String menuNama, Status menuStatus){
        this.menuId = menuId;
        this.menuNama = menuNama;
        this.menuStatus = menuStatus;
    }

    public String getMenuId(){
        return menuId;
    }

    public String getmenuNama(){
        return menuNama;
    }

    public Status getMenuStatus(){
        return menuStatus;
    }

    public void setMenuStatus(Status menuStatus){
        this.menuStatus = menuStatus; 
    }

    //Method untuk menampilkan Menu
    public void tampilMenu(){
        System.out.println(menuId + " - " + menuNama + " - " + menuStatus);
    }

}

class MenuHarga extends Menu{
    private int hargaMenuHarga;

    public MenuHarga(String menuId, String menuNama, Status menuStatus, int hargaMenuHarga){
        super(menuId, menuNama, menuStatus);
        this.hargaMenuHarga = hargaMenuHarga;
    }

    public int getHargaMenuHarga(){
        return hargaMenuHarga;
    }
}

class MenuPoin extends Menu{
    private int hargaMenuPoin;

    public MenuPoin(String menuId, String menuNama, Status menuStatus, int hargaMenuPoin){
        super(menuId, menuNama, menuStatus);
        this.hargaMenuPoin = hargaMenuPoin;
    }

    public int getHargaMenuPoin(){
        return hargaMenuPoin;
    }
}

//POLYMORPHISM: memungkinkan method yang sama digunakan untuk perilaku yang berbeda (pada class DineIn dan TakeAway)
class Pesanan {
    private String pesananId;
    private int pesananTotal;
    private int pesananPajak;

    public Pesanan(String pesananId, int pesananTotal){ 
        this.pesananId = pesananId;
        this.pesananTotal = pesananTotal;   
    }

    public String getPesananId(){
        return pesananId;
    }

    public int getPesananTotal(){
        return pesananTotal;
    }

    public int getPesananPajak(){
        return pesananPajak;
    }

    public void pesan() {
        pesananPajak = (int)(pesananTotal * 0.1);
        int totalBayar = pesananTotal + pesananPajak;

        System.out.println("Pesanan telah dibuat");
        System.out.println("Total\t\t: Rp" + pesananTotal);
        System.out.println("Pajak (10%)\t: Rp" + pesananPajak);
        System.out.println("Total bayar\t: Rp" + totalBayar);
        System.out.println();
    }

    public void proses() {
        System.out.println("Pesanan sedang diproses");
    }
}

class DineIn extends Pesanan{
    String noMeja;

    DineIn(String pesananId, int pesananTotal, String noMeja) {
        super(pesananId, pesananTotal);
        this.noMeja = noMeja;
    }

    @Override // override untuk output lebih lengkap
    public void proses() {
        System.out.println("Pesanan dine-in di meja " + noMeja + " sedang diproses!");
    }
}

class TakeAway extends Pesanan{
    TakeAway(String pesananId, int pesananTotal) {
        super(pesananId, pesananTotal);
    }

    @Override // override untuk output lebih lengkap
    public void proses() {
        System.out.println("Pesanan take away sedang diproses!");
    }
}

// SUPERCLASS PELANGGAN --- INHERITANCE
class Pelanggan{
    enum Status{
        Member,
        Guest
    }
    private String pelangganId; 
    private String pelangganNama;
    private Status pelangganStatus;

    public Pelanggan(String pelangganId, String pelangganNama, Status pelangganStatus){ 
        this.pelangganId = pelangganId;
        this.pelangganNama = pelangganNama;
        this.pelangganStatus = pelangganStatus;   
    }

    public String getPelangganId(){
        return pelangganId;
    }

    public String getPelangganNama(){
        return pelangganNama;
    }

    public Status getPelangganStatus(){
        return pelangganStatus;
    }

    public void menampilkanPelanggan(){
        System.out.println("Nama\t\t: " + pelangganNama);
        System.out.println("Status\t\t: " + pelangganStatus);
    }
}

// SUBCLASS MEMBER (DARI SUPER CLASS PELANGGAN) 
class Member extends Pelanggan{
    private int poin = 0;
    private String pelangganNoHp;

    public Member(String pelangganId, String pelangganNama, Status status, String pelangganNoHp){
        super(pelangganId, pelangganNama, Status.Member);
        this.pelangganNoHp = pelangganNoHp;
    }

    public int getPoin(){
        return poin;
    }

    public String getPelangganNoHP(){
        return pelangganNoHp;
    }

    public void hitungPoin(int totalBayar){
        int totalPoin = (totalBayar*3)/100;
        this.poin = totalPoin;
    }

    @Override //override untuk output lebih lengkap
    public void menampilkanPelanggan(){
        super.menampilkanPelanggan();
        System.out.println("No. HP\t\t: " + pelangganNoHp);
        System.out.println("Poin\t\t: " + poin);
    }
}

// SUBCLASS Guest (DARI SUPER CLASS PELANGGAN)
class Guest extends Pelanggan{
    public Guest(String pelangganId, String pelangganNama, Status status){
        super(pelangganId, pelangganNama, Status.Guest);
    }
}

//ABSTRACTION: Yang disembunyikan adalah detail proses pembayaran seperti validasi saldo dan perhitungan kembalian. User hanya menggunakan method bayar() tanpa mengetahui implementasinya
abstract class Pembayaran{
    protected int total;
    protected int saldo;

    public int getTotal(){
        return total;
    }

    public int getSaldo(){
        return saldo;
    }

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

    @Override // override untuk output lebih lengkap
    public void bayar(){
        System.out.println("Silahkan bayar di kasir dengan nominal Rp" + total);
        System.out.println("Uang yang diterima Rp" + saldo);
        System.out.println();

        if(cekPembayaran(total, saldo)){
            System.out.println("===== Pembayaran Berhasil =====");
            System.out.println("Kembalian anda Rp" + hitungKembalian());
            System.out.println();
            cetakStruk();
        } else {
            System.out.println("Uang anda kurang Rp " + (total - saldo));
        }
    }

    @Override // override untuk output lebih lengkap
    public void cetakStruk(){
        System.out.println("======= STRUK PEMBAYARAN =======");
        System.out.println("================================");
        System.out.println("Total\t\t: Rp" + total);
        System.out.println("Bayar\t\t: Rp" + saldo);
        System.out.println("Kembalian\t: Rp" + hitungKembalian());
        System.out.println("Terima kasih!");
    }
}

class PembayaranQRIS extends Pembayaran implements CetakStruk{
    public PembayaranQRIS(int total, int saldo) {
        super(total,saldo);
    }

    @Override // override untuk output lebih lengkap
    public void bayar(){
        System.out.println("====== Silakan scan QRIS ======");
        System.out.println("Total pesanan anda Rp" + total);
         if(cekPembayaran(total, saldo)){
            System.out.println("===== Pembayaran berhasil =====");
            System.out.println();
            cetakStruk();
        } else {
            System.out.println("Saldo anda kurang Rp" + (total - saldo));
        }
    }

    @Override // override untuk output lebih lengkap
    public void cetakStruk(){
        System.out.println("==== STRUK PEMBAYARAN QRIS ====");
        System.out.println("===============================");
        System.out.println("Total\t\t: Rp" + total);
        System.out.println("Terima kasih!");
    }
}

public class Tugas1 {
    public static void main(String[] args) {
        System.out.println("========= SELAMAT DATANG ========");
        System.out.println("=== RESTORAN IKAN BAKAR MUARA ===");
        System.out.println();

        // Pelanggan Guest (1) melihat menu Guest, menambahkan pesanan dine in, dan melakukan pembayaran cash
        Pelanggan pl1 = new Guest("PL001", "Anita", Pelanggan.Status.Guest);
        Menu m1 = new MenuHarga("M001", "Nila Bakar Muara", Menu.Status.Tersedia, 23000);
        Pesanan ps1 = new DineIn("PS001", 52000, "A1");
        Pembayaran pb1 = new PembayaranCash(52000, 250000);
        
        pl1.menampilkanPelanggan();
        System.out.println();

        m1.tampilMenu();
        System.out.println();

        ps1.pesan();
        ps1.proses();
        System.out.println();

        pb1.bayar();

        // // Pelanggan member (2) melihat menu poin, menambahkan pesanan take away, dan melakukan pembayaran qris
        // Pelanggan pl2 = new Member("P002", "Budi", Pelanggan.Status.Member, "089667788995");
        // Menu m2 = new MenuPoin("M010", "Tumis Kangkung Poin", Menu.Status.Tersedia, 15000);
        // Pesanan ps2 = new TakeAway("PS002", 15000);
        // Pembayaran pb2 = new PembayaranQRIS(15000, 60000);
        
        // pl2.menampilkanPelanggan();
        // System.out.println();

        // m2.tampilMenu();
        // System.out.println();

        // ps2.pesan();
        // ps2.proses();
        // System.out.println();

        // pb2.bayar();
    }
}
