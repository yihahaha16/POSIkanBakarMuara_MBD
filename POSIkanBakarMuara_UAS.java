import java.util.ArrayList;
import java.util.Scanner;
interface CetakStruk {//interface untuk class yang mempunyai method sama namun logika cetak struk yang berbeda (PembayaranQRIS dan PembayaranCash)
    public void cetakStruk();
}

class Menu {//superclass
    enum Status {Tersedia, Habis}
    enum Kategori {Makanan, Minuman}
    int menuId;
    String menuNama;
    Status menuStatus;  
    Kategori menuKategori;        
    
    public Menu(int menuId, String menuNama, Status menuStatus, Kategori menuKategori){//constructor
        this.menuId = menuId;
        this.menuNama = menuNama;
        this.menuStatus = menuStatus;
        this.menuKategori = menuKategori;
    }

    public void tampilMenu(){
    }
}

class MenuHarga extends Menu {//inheritance karena ada dua jenis menu, satu pakai harga, satu pakai poin
    private int hargaMenuHarga;//encapsulation, dilindungi supaya tidak bisa diubah sembarangan oleh class lain
    public MenuHarga(int menuId, String menuNama, Status menuStatus, int hargaMenuHarga, Kategori menuKategori){//constructor
        super(menuId, menuNama, menuStatus, menuKategori);//constructor dari superclass
        this.hargaMenuHarga = hargaMenuHarga;
    }
    public int getHargaMenuHarga(){ return hargaMenuHarga; }//getter untuk mengambil atribut yang private
    @Override
    public void tampilMenu(){
           System.out.println(menuNama+" Rp "+getHargaMenuHarga());
    }
}

class MenuPoin extends Menu {//inheritance
    private int hargaMenuPoin;//encapsulation
    public MenuPoin(int menuId, String menuNama, Status menuStatus, int hargaMenuPoin, Kategori menuKategori){//constructor
        super(menuId, menuNama, menuStatus, menuKategori);//constructor dari superclass
        this.hargaMenuPoin = hargaMenuPoin;
    }
    public int getHargaMenuPoin(){ return hargaMenuPoin; }//getter
        @Override
    public void tampilMenu(){
        System.out.println(menuNama+" "+getHargaMenuPoin()+" poin");
    }
}

class Keranjang {
    Menu menu;
    int kuantitas;
    public Keranjang(Menu menu, int kuantitas){
        this.menu = menu;
        this.kuantitas = kuantitas;
    }
}

class Pesanan {//superclass
    private String pesananId;//encapsulation
    private int pesananTotal;
    private int pesananPajak;
    static float pajak = 0.1f;
    public Pesanan(String pesananId, int pesananTotal){//constructor
        this.pesananId = pesananId;
        this.pesananTotal = pesananTotal;   
    }
    public String getPesananId(){ return pesananId; }//getter
    public int getPesananTotal(){ return pesananTotal; }
    public int getPesananPajak(){ return pesananPajak; }
    public void pesan() {//method hitung pesanan
        pesananPajak = (int)(pesananTotal * pajak);
        int totalBayar = pesananTotal + pesananPajak;
        System.out.println("Pesanan telah dibuat");
        System.out.println("Total: Rp" + pesananTotal);
        System.out.println("Pajak (10%): Rp" + pesananPajak);
        System.out.println("Total bayar: Rp" + totalBayar);
        System.out.println();
    }
    public void proses() {//method lagi proses pesanan
        System.out.println("Pesanan sedang diproses");
    }
}

class DineIn extends Pesanan {//inheritance
    String noMeja;
    DineIn(String pesananId, int pesananTotal, String noMeja) {//constructor
        super(pesananId, pesananTotal);//constructor superclass
        this.noMeja = noMeja;
    }
    @Override //polymorphism method di subclass yang namanya sama dengan method di parent, tapi isinya diubah.
    public void proses() {
        System.out.println("Pesanan dine-in di meja " + noMeja + " sedang diproses!");
    }
}

class TakeAway extends Pesanan {//subclass
    TakeAway(String pesananId, int pesananTotal) {//constructor
        super(pesananId, pesananTotal);//constructor superclass
    }
    @Override //polymorphism
    public void proses() {
        System.out.println("Pesanan take away sedang diproses!");
    }
}

class Pelanggan {//superclass
    enum Status { Member, Guest }
    private String pelangganNoHp; //encapsulation
    private Status pelangganStatus;
    public Pelanggan(String pelangganNoHp, Status pelangganStatus){ //constructor
        this.pelangganNoHp = pelangganNoHp;
        this.pelangganStatus = pelangganStatus;   
    }
    public String getPelangganNoHp(){ return pelangganNoHp; }//getter
    public Status getPelangganStatus(){ return pelangganStatus; }
    public void menampilkanPelanggan(){ //method tampilkan pelanggan
        System.out.println("Nama: " + pelangganNoHp);
        System.out.println("Status: " + pelangganStatus);
    }
}

class Member extends Pelanggan {//subclass
    private int poin = 0; //encapsulation
    private String nama;
    private String password; 
    public Member(String pelangganNoHp, Pelanggan.Status status, String password, String nama){//constructor
        super(pelangganNoHp, Pelanggan.Status.Member);//constructor superclass
        this.nama = nama;
        this.password = password;
    }
    public String getNama(){ return nama; }//getter
    public int getPoin(){ return poin; }
    public String getPassword(){ return password; }
    public void hitungPoin(int totalBayar){//hitung total poin yang didapatkan
        int totalPoin = (totalBayar * 3) / 100;
        this.poin += totalPoin;
    }
    @Override //polymorphism
    public void menampilkanPelanggan(){//tampilkan pelanggan
        super.menampilkanPelanggan();
        System.out.println("No HP: " + getPelangganNoHp());
        System.out.println("Poin: " + poin);
    }
}

class Guest extends Pelanggan {//inheritance
    public Guest(String pelangganNoHp, Pelanggan.Status status){//constructor
        super(pelangganNoHp, Pelanggan.Status.Guest);//constructor superclass
    }
}

abstract class Pembayaran {// abstraction yang disembunyikan adalah detail proses pembayaran seperti validasi saldo dan perhitungan kembalian. User hanya menggunakan method bayar() tanpa mengetahui implementasinya
    protected int total;//encapsulation
    protected int saldo;
    public int getTotal(){ return total; }//getter
    public int getSaldo(){ return saldo; }
    public Pembayaran(int total, int saldo) {//constructor
        this.total = total;
        this.saldo = saldo;
    }
    public abstract void bayar(); //abstraction
    public boolean cekPembayaran(int total, int saldo){//method logika pembayaran
        if(saldo < total){
            System.out.println("Saldo tidak mencukupi");
            return false;
        } else {
            return true;
        }
    }
}

class PembayaranCash extends Pembayaran implements CetakStruk {//inheritance + interface
    public PembayaranCash(int total, int saldo) { //constructor
        super(total, saldo); }//constructor superclass
    public int hitungKembalian(){ return saldo - total; }//method hitung kembalian
    @Override//polymorphism
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
    @Override//polymorphism
    public void cetakStruk(){
        System.out.println("======= STRUK PEMBAYARAN =======");
        System.out.println("================================");
        System.out.println("Total: Rp" + total);
        System.out.println("Bayar: Rp" + saldo);
        System.out.println("Kembalian: Rp" + hitungKembalian());
        System.out.println("Terima kasih!");
    }
}

class PembayaranQRIS extends Pembayaran implements CetakStruk {//inheritance + interface
    public PembayaranQRIS(int total, int saldo) { super(total, saldo); }//constructor
    @Override//polymorphism
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
    @Override//polymorphism
    public void cetakStruk(){
        System.out.println("==== STRUK PEMBAYARAN QRIS ====");
        System.out.println("===============================");
        System.out.println("Total: Rp" + total);
        System.out.println("Terima kasih!");
    }
}

public class POSIkanBakarMuara_UAS {
    static Scanner input = new Scanner(System.in);//scanner untuk input
    static ArrayList<Member> members = new ArrayList<>();//array list karena fleksibel, tidak tau berapa banyak yang akan diinput
    static boolean isMember=false; //untuk dashboard
    static MenuHarga[] menuHarga = new MenuHarga[10];
    static MenuPoin[] menuPoin = new MenuPoin[4];
    static ArrayList<Keranjang> keranjangPelanggan = new ArrayList<>();
    static Member usedMember;

    static void dashboardSebelumLogin() {
        System.out.println("=== Selamat Datang di Ikan Bakar Muara ===\n1. Login Member\n2. Daftar menjadi Member\n3. Lanjut Sebagai Guest\n0. Keluar");
        System.out.print("Pilih: "); int pilih = input.nextInt(); input.nextLine(); //pilih opsi, ada double input.nextLine() untuk mengecualikan enter
        switch(pilih) {
            case 1: loginMember(); break;
            case 2: daftarMember(); break;
            case 3: masukGuest(); break;
            case 0: keluar(); break;
            default:
                System.out.println("Pilihan tidak valid");
                dashboardSebelumLogin();
        }
    }
    static void loginMember() {
        System.out.println("\n=== Login Member ===");
        System.out.print("Nomor Telepon: "); String noHp = input.nextLine();
        System.out.print("Password     : "); String password = input.nextLine();
        try{//validasi angka & cek apakah member & password tersedia https://www.geeksforgeeks.org/java/check-if-a-given-string-is-a-valid-number-integer-or-floating-point-in-java/
            Integer.parseInt(noHp);
            Member ditemukan = null;//variabel dengan tipe data class menampung 1 buah nohp&pass
            for (Member m : members) {
            if (m.getPelangganNoHp().equals(noHp) && m.getPassword().equals(password)) {
                ditemukan = m;
                break;
            }}
        if (ditemukan == null) {
            System.out.println("Maaf, nomor telepon atau password salah!\n1. Login ulang\n0. Kembali");
            System.out.print("Pilih: "); int pilih = input.nextInt(); input.nextLine();
            if (pilih==1) loginMember();
            else dashboardSebelumLogin();
        } else {
            System.out.println("Login Berhasil!");
            isMember=true;
            usedMember= new Member(noHp, null, password, password)?????????
            dashboardSetelahLogin();
        }
        }
        catch (NumberFormatException e){
            System.out.println("Maaf, nomor telepon harus berupa angka!");
            System.out.println("1. Login ulang");
            System.out.println("0. Kembali");
            System.out.print("Pilih: "); int pilih = input.nextInt(); input.nextLine();
            if (pilih==1) loginMember();
            else dashboardSebelumLogin();
        } 
    }
    static void daftarMember() {
        System.out.println("\n=== Daftar Menjadi Member ===");
        System.out.print("Nama Lengkap  : "); String nama = input.nextLine();
        System.out.print("Nomor Telepon : "); String noHp = input.nextLine();
        System.out.print("Password      : ");  String password = input.nextLine();

         try{//validasi angka & cek apakah member & password tersedia https://www.geeksforgeeks.org/java/check-if-a-given-string-is-a-valid-number-integer-or-floating-point-in-java/
            Integer.parseInt(noHp);
            for (Member m : members) {
            if (m.getPelangganNoHp().equals(noHp)) {
                System.out.println("Maaf, nomor telepon telah terdaftar!\n1. Login Member\n2. Daftar ulang\n0. Kembali");
                System.out.print("Pilih: ");
                int pilih = input.nextInt();input.nextLine();
                if (pilih==1) loginMember();
                else if (pilih==2) daftarMember();
                else dashboardSebelumLogin();
            }
            }
            members.add(new Member(noHp, Pelanggan.Status.Member, password,nama));

        System.out.println("Pendaftaran Member BERHASIL!\n1. Login Member\n0. Kembali");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();input.nextLine();
        if (pilih==1) loginMember();
        else dashboardSebelumLogin();
    }
        catch (NumberFormatException e){
            System.out.println("Maaf, nomor telepon harus berupa angka!\n1. Daftar ulang\n0. Kembali");
            System.out.print("Pilih: ");
      int pilih = input.nextInt();input.nextLine();
        if (pilih==1) daftarMember();
            else dashboardSebelumLogin();
    }
    }
    static void masukGuest() {

        System.out.print("=== Login sebagai guest ===\nNomor Telepon: ");
        String noHp=input.nextLine();
        Guest guest = new Guest(noHp, Pelanggan.Status.Guest);
        dashboardSetelahLogin();;
    }
    static void dashboardSetelahLogin() {
        System.out.println("\n=== Dashboard ===\n1. Lihat Menu\n2. Pesan\n3. Lihat Keranjang");
        if(isMember){
            System.out.println("4. Lihat Poin\n5. Lihat Informasi Member");
        }
        System.out.println("0. Logout");
        System.out.print("Pilih: ");
        int pilih = input.nextInt();input.nextLine();
        switch(pilih) {
            case 1: 
            System.out.println("=== Menu ===");
            lihatMenu();
            if(isMember){
System.out.println("15. Pesan\n0. Kembali");
            }
            else{
                System.out.println("11. Pesan\n0. Kembali");
            }
            
            lihatMenu1(); 
            break;
            case 2:
            System.out.println("=== Pesan ===");    
            lihatMenu();
            if(isMember){
    System.out.println("15. Lihat Keranjang\n16. Bayar\n0. Kembali");
            }
            else{
                System.out.println("11. Lihat Keranjang\n12. Bayar\n0. Kembali");
            }
            pesan();
     break;
            case 3: lihatKeranjang(); break;
            case 4: lihatPoin(); break;
            case 5: lihatMember();break;
            case 0: keluar(); break;
            default:
                System.out.println("Pilihan tidak valid");    
                dashboardSetelahLogin();  
        }
    }
    static void lihatMenu(){
        int count=1;
        System.out.println("=== Makanan ===");
        for(MenuHarga menu: menuHarga){
            if(menu.menuKategori.equals(Menu.Kategori.Makanan)){
                System.out.print(count+". ");
                menu.tampilMenu();
                count++;
            }
        }
        System.out.println("=== Minuman ===");
        for(MenuHarga menu: menuHarga){
            if(menu.menuKategori.equals(Menu.Kategori.Minuman)){
                System.out.print(count+". ");
                count++;
                menu.tampilMenu();
            }
        }
        if(isMember){
        System.out.println("=== Poin ===");
        for(MenuPoin menu: menuPoin){
            System.out.print(count+". ");
            count++;    
            menu.tampilMenu();
        }}
    }
    static void lihatMenu1(){
        System.out.print("Pilih: ");
        int pilih = input.nextInt();input.nextLine();
        if(pilih==0){
            dashboardSetelahLogin();
        }
        else if(pilih==15&&isMember){
            System.out.println("=== Pesan ===");
            lihatMenu();
    System.out.println("15. Lihat Keranjang\n16. Bayar\n0. Kembali");
            pesan();
        }
        else if(pilih==11&&!isMember){
System.out.println("=== Pesan ===");
            lihatMenu();
            System.out.println("11. Lihat Keranjang\n12. Bayar\n0. Kembali");
            pesan();
        }
        else{
            System.out.println("Pilihan tidak valid");
            lihatMenu1();
        }
    }
static void pesan(){
    System.out.print("Pilih: ");
    int pilih = input.nextInt();input.nextLine();
    if(pilih==0){
        dashboardSetelahLogin();
    }
    else if(pilih>=1&&pilih<=10){
        System.out.print("Kuantitas: "); int kuantitas = input.nextInt();input.nextLine();
        keranjangPelanggan.add(new Keranjang(menuHarga[pilih-1], kuantitas));
        System.out.println("Menu "+menuHarga[pilih-1].menuNama+" ("+kuantitas+") berhasil ditambahkan ke keranjang");
        pesan();
    }else{
        if(isMember){
            if(pilih>=11&&pilih<=14){
            System.out.print("Kuantitas: "); int kuantitas = input.nextInt();input.nextLine();
            keranjangPelanggan.add(new Keranjang(menuPoin[pilih-11], kuantitas));
            System.out.println("Menu "+menuPoin[pilih-11].menuNama+" ("+kuantitas+") berhasil ditambahkan ke keranjang");
            pesan();
            }
            else if(pilih==15){
                lihatKeranjang();
            }
            else if(pilih==16){
                bayar();
            }
            else{
System.out.println("Pilihan tidak valid");
                pesan();
            }
        }
        else{
            if(pilih==11){
                lihatKeranjang();
            }
            else if(pilih==12){
                bayar();
            }
            else{
System.out.println("Pilihan tidak valid");
                pesan();}
        }
    }

}
    static void lihatKeranjang(){
        System.out.println("=== Keranjang ===");
        int i=0;
        for(i=0;i<keranjangPelanggan.size();i++){
            System.out.println((i+1)+". "+ keranjangPelanggan.get(i).menu.menuNama+" ("+keranjangPelanggan.get(i).kuantitas+")"); //arraylist memang pakai get(i) gabisa [i]
        }
        System.out.println((i+1)+". Tambah Pesanan\n"+(i+2)+". Bayar\n"+(i+3)+". Hapus item\n0. Kembali");
        System.out.print("Pilih: "); int pilih = input.nextInt(); input.nextLine(); //pilih opsi, ada double input.nextLine() untuk mengecualikan enter
        switch(pilih) {
            case 1: System.out.println("=== Pesan ===");
            lihatMenu();
            pesan(); break;
            case 2: bayar(); break;
            case 3: hapus(); break;
            case 0: dashboardSetelahLogin(); break;
            default:
                System.out.println("Pilihan tidak valid");
                lihatKeranjang();
        }
        
    }
    static void lihatPoin(){
        
    }
        static void lihatMember(){
        
    }
            static void bayar(){
        
    }
            static void hapus(){
        
    }
    static void keluar() {
        System.out.println("Terima kasih!");
    }
        public static void main(String[] args) {

            menuHarga[0]= new MenuHarga(1,  "Udang Wangkang Bakar Madu", Menu.Status.Tersedia, 45000, Menu.Kategori.Makanan);
            menuHarga[1]= new MenuHarga(2, "Ayam Bakar Rica", Menu.Status.Tersedia, 25220, Menu.Kategori.Makanan);
            menuHarga[2]= new MenuHarga(3, "Pakcoy Tahu", Menu.Status.Habis, 18000, Menu.Kategori.Makanan);
            menuHarga[3]= new MenuHarga(4, "Nila Bakar Muara", Menu.Status.Tersedia, 26000, Menu.Kategori.Makanan);
            menuHarga[4]= new MenuHarga(5, "Nasi Putih", Menu.Status.Tersedia, 7000, Menu.Kategori.Makanan);
            menuHarga[5]= new MenuHarga(6, "Kol Goreng", Menu.Status.Tersedia, 7000, Menu.Kategori.Makanan);
            menuHarga[9]= new MenuHarga(10,"Es Timun Selasih", Menu.Status.Tersedia, 12000, Menu.Kategori.Minuman);
            menuHarga[7]= new MenuHarga(8, "Lemon Tea", Menu.Status.Tersedia, 7000, Menu.Kategori.Minuman);
            menuHarga[8]= new MenuHarga(9, "Milo", Menu.Status.Tersedia, 8000, Menu.Kategori.Minuman);
            menuHarga[6]= new MenuHarga(7, "Tahu Goreng", Menu.Status.Tersedia, 10000, Menu.Kategori.Makanan);
            menuPoin[0]= new MenuPoin(1, "Es Timun Selasih", Menu.Status.Tersedia, 12000, Menu.Kategori.Minuman);
            menuPoin[1]= new MenuPoin(2, "Udang Wangkang Bakar Madu", Menu.Status.Tersedia, 45000, Menu.Kategori.Makanan);
            menuPoin[2]= new MenuPoin(3, "Pakcoy Tahu", Menu.Status.Habis, 18000, Menu.Kategori.Makanan);
            menuPoin[3]= new MenuPoin(4, "Nila Bakar Muara", Menu.Status.Tersedia, 26000, Menu.Kategori.Makanan);

        dashboardSebelumLogin();
    }
} 
