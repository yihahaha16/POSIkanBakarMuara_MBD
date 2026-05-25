package Tugas1;
import java.util.ArrayList;
import java.util.Scanner; 

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

    //Karena dia private, jadi untuk ambilnya pakai get
    public String getMenuId(){
        return menuId;
    }
    public String getmenuNama(){
        return menuNama;
    }
    public Status getMenuStatus(){
        return menuStatus;
    }
    //Karena dia private, jadi untuk ubahnya pakai set
    public void setMenuStatus(Status menuStatus){
        this.menuStatus = menuStatus; 
    }

    //Method untuk menampilkan Menu
    public void tampilMenu(){
        System.out.println(menuId + " - " + menuNama + " - " + menuStatus);
    }

}
//inheritance karena menu terbagi jadi dua jenis, satunya yang pakai harga saja, satunya pakai poin saja
class MenuHarga extends Menu{
    //encapsulation
    private int hargaMenuHarga;
    //constructor
    public MenuHarga(String menuId, String menuNama, Status menuStatus, int hargaMenuHarga){
        super(menuId, menuNama, menuStatus); //panggil constructor superclass menu 
        this.hargaMenuHarga = hargaMenuHarga;
    }
    //get
    public int getHargaMenuHarga(){
        return hargaMenuHarga;
    }
}
class MenuPoin extends Menu{
    //encapsulation
    private int hargaMenuPoin;
    //constructor
    public MenuPoin(String menuId, String menuNama, Status menuStatus, int hargaMenuPoin){
        super(menuId, menuNama, menuStatus); //panggil constructor superclass menu
        this.hargaMenuPoin = hargaMenuPoin;
    }
    //get
    public int getHargaMenuPoin(){
        return hargaMenuPoin;
    }
}

//POLYMORPHISM: memungkinkan method yang sama digunakan untuk perilaku yang berbeda (pada class DineIn dan TakeAway)
class Pesanan {
    //encapsulation
    private String pesananId;
    private int pesananTotal;
    private int pesananPajak;
    static float pajak = 0.1f;
    //constructor
    public Pesanan(String pesananId, int pesananTotal){ 
        this.pesananId = pesananId;
        this.pesananTotal = pesananTotal;   
    }
    //get
    public String getPesananId(){
        return pesananId;
    }
    public int getPesananTotal(){
        return pesananTotal;
    }
    public int getPesananPajak(){
        return pesananPajak;
    }
    //Hitung pajak dan tampilkan total pesanan
    public void pesan() {
        pesananPajak = (int)(pesananTotal * pajak);//casting
        int totalBayar = pesananTotal + pesananPajak;
        System.out.println("Pesanan telah dibuat");
        System.out.println("Total\t\t: Rp" + pesananTotal);
        System.out.println("Pajak (10%)\t: Rp" + pesananPajak);
        System.out.println("Total bayar\t: Rp" + totalBayar);
        System.out.println();
    }
    //proses pesanan
    public void proses() {
        System.out.println("Pesanan sedang diproses");
    }
}

//inheritance dari pesanan
class DineIn extends Pesanan{
    String noMeja;
    //constructor
    DineIn(String pesananId, int pesananTotal, String noMeja) {
        super(pesananId, pesananTotal);
        this.noMeja = noMeja;
    }
    //polymorphism: sesuatu yang sama tapi punya bentuk beda-beda 
    @Override // Method override: method di subclass yang namanya sama dengan method di parent, tapi isinya diubah.
    public void proses() {
        System.out.println("Pesanan dine-in di meja " + noMeja + " sedang diproses!");
    }
}
//inheritance dari pesanan
class TakeAway extends Pesanan{
    //constructor
    TakeAway(String pesananId, int pesananTotal) {
        super(pesananId, pesananTotal);
    }
    //polymorphism
    @Override /// Method override: method di subclass yang namanya sama dengan method di parent, tapi isinya diubah.
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
    //encapsulation
    private String pelangganId; 
    private String pelangganNama;
    private Status pelangganStatus;
    //constructor
    public Pelanggan(String pelangganId, String pelangganNama, Status pelangganStatus){ 
        this.pelangganId = pelangganId;
        this.pelangganNama = pelangganNama;
        this.pelangganStatus = pelangganStatus;   
    }
    //get
    public String getPelangganId(){
        return pelangganId;
    }
    public String getPelangganNama(){
        return pelangganNama;
    }
    public Status getPelangganStatus(){
        return pelangganStatus;
    }
    //tampilkan pelanggan
    public void menampilkanPelanggan(){
        System.out.println("Nama\t\t: " + pelangganNama);
        System.out.println("Status\t\t: " + pelangganStatus);
    }
}

// SUBCLASS MEMBER (DARI SUPER CLASS PELANGGAN) 
class Member extends Pelanggan{
    //encapsulation
    private int poin = 0;
    private String pelangganNoHp;
    private String password;
    //constructor
    public Member(String pelangganId, String pelangganNama, Status status, String pelangganNoHp){
        super(pelangganId, pelangganNama, Status.Member);
        this.pelangganNoHp = pelangganNoHp;
    }
    //get
    public int getPoin(){
        return poin;
    }
    public String getPelangganNoHP(){
        return pelangganNoHp;
    }
    //hitung poin tambahan
    public void hitungPoin(int totalBayar){
        int totalPoin = (totalBayar*3)/100;
        this.poin = totalPoin;
    }
    @Override //override 
    public void menampilkanPelanggan(){
        super.menampilkanPelanggan();
        System.out.println("No. HP\t\t: " + pelangganNoHp);
        System.out.println("Poin\t\t: " + poin);
    }
}

// SUBCLASS Guest (DARI SUPER CLASS PELANGGAN)
class Guest extends Pelanggan{
    //constructor
    public Guest(String pelangganId, String pelangganNama, Status status){
        super(pelangganId, pelangganNama, Status.Guest); //panggil constructor parent
    }
}

//ABSTRACTION: Yang disembunyikan adalah detail proses pembayaran seperti validasi saldo dan perhitungan kembalian. User hanya menggunakan method bayar() tanpa mengetahui implementasinya
abstract class Pembayaran{
//
//
//
//          ????????????????????????? protected
//
//
//

    protected int total;
    protected int saldo;
    //get
    public int getTotal(){
        return total;
    }
    public int getSaldo(){
        return saldo;
    }
    //constructor pembayaran
    public Pembayaran(int total, int saldo) { //Cash
        this.total = total;
        this.saldo = saldo;
    }
    public abstract void bayar();
    //method
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
//inheritace dan pakai interface
class PembayaranCash extends Pembayaran implements CetakStruk{
    //constructor
    public PembayaranCash(int total, int saldo) {
        super(total,saldo);
    }
    //method
    public int hitungKembalian(){
        return saldo - total;
    }
    //poly
    @Override //override 
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
    //poly
    @Override // override
    public void cetakStruk(){
        System.out.println("======= STRUK PEMBAYARAN =======");
        System.out.println("================================");
        System.out.println("Total\t\t: Rp" + total);
        System.out.println("Bayar\t\t: Rp" + saldo);
        System.out.println("Kembalian\t: Rp" + hitungKembalian());
        System.out.println("Terima kasih!");
    }
}
//inheritance
class PembayaranQRIS extends Pembayaran implements CetakStruk{
    public PembayaranQRIS(int total, int saldo) {
        super(total,saldo);
    }
    //poly
    @Override // override
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
    //poly
    @Override // override 
    public void cetakStruk(){
        System.out.println("==== STRUK PEMBAYARAN QRIS ====");
        System.out.println("===============================");
        System.out.println("Total\t\t: Rp" + total);
        System.out.println("Terima kasih!");
    }
}

public class Tugas1 {
    static Scanner input = new Scanner(System.in); //static karena mau dipanggil langsung tanpa buat object dulu
    ArrayList<Member> members = new ArrayList<>();
    static void dashboard1(){ //harus static juga karena scannernya static
        System.out.println("===Selamat Datang di Ikan Bakar Muara===\n===1. Login Member\n2. Daftar menjadi Member\n3. Lanjut Sebagai Guest\n0. Keluar");
        System.out.println("Pilih: ");
        int pilih = input.nextInt(); 
        switch(pilih){
        case 1:
        loginMember();
        break;
        case 2:
        daftarMember();
        break;
        case 3:
        masukGuest();
        break;
        default:
        System.out.println("Pilihan tidak ada");
        dashboard1();
        }
    }
    static void loginMember(){

    }
    static void daftarMember(){
    System.out.println("Nama Lengkap:");
    int nama=input.nextInt();
    System.out.println("Nomor Telepon:");
        int no=input.nextInt();
    System.out.println("Password:");
        int pass=input.nextInt();
        members.add(new Member(, , ));
    }
    public static void main(String[] args) {

       
    }
}
