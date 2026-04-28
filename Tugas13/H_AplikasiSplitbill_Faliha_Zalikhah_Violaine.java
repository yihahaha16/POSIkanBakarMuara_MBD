package Tugas13;

interface Detail{
    public void cetakDetailPesanan();
    public void cetakMenu();
}
class PembayaranSplitBill{
    //static: digunakan untuk pajak karena pajak bersifat tetap (static)
    static float pajak = 0.1f;

    //instance: yg ada di lingkup masing-masing object
    String[] orang; //array 1D untuk menampung orang yang ingin split bill
    String[][] menuHarga; //array 2D untuk menampung keseluruhan menu dan harga yang dipesan
    int[][] menuPerOrang; //array jagged untuk menampung menu(by index) yang dipesan masing-masing orang

    //constructor
     PembayaranSplitBill(String[] orang, String[][] menuHarga, int[][] menuPerOrang) {
        this.orang = orang;
        this.menuHarga = menuHarga;
        this.menuPerOrang = menuPerOrang;
    }

    void hitungSplitBill() {
        cetakMenu();
        System.out.println("==  TOTAL PESANAN  ==");
        for (int i = 0; i < orang.length; i++) {
            System.out.println("Nama:\t"+orang[i]);
            int total = 0;
            for (int j = 0; j < menuPerOrang[i].length; j++) {
                int harga = Integer.parseInt(menuHarga[menuPerOrang[i][j]][1]);//https://www.geeksforgeeks.org/java/how-to-convert-string-to-int-in-java/
                total += harga;
                System.out.println(menuHarga[menuPerOrang[i][j]][0] + " " + menuHarga[menuPerOrang[i][j]][1]);
            }
            total += (total * pajak);

            System.out.println("Total: Rp " + total);
            System.out.println("-----------------");
        }
    }

    public void cetakMenu(){
        System.out.println("==== APLIKASI SPLIT BILL ====");
        System.out.println("\n==  MENU  ==");
        for (int i=0; i < menuHarga.length; i++){
            System.out.println(menuHarga[i][0]+ " " + menuHarga[i][1]);
        }
        System.err.println("");
    }
}

public class H_AplikasiSplitbill_Faliha_Zalikhah_Violaine {
    public static void main(String[] args) {
        PembayaranSplitBill pb = new PembayaranSplitBill(
            new String[]{"Faliha", "Zalikhah", "Violaine"},
            new String[][]{
                {"Nasi Goreng", "15000"},
                {"Ayam", "20000"},
                {"Es Teh", "10000"},
                {"Kelp Shake", "10000"},
                {"Krabby Patty", "20000"}
            },
            new int[][]{
                {0, 1, 2},
                {3, 4},
                {0, 2}
            }
        );

        pb.hitungSplitBill();
    }
}
