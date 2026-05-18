abstract class Pembayaran{
    int total;
    int saldo;
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

class PembayaranCash extends Pembayaran{
    public PembayaranCash(int total, int saldo) {
        super(total,saldo);
    }

    public int hitungKembalian(){
        return saldo - total;
    }
    public void bayar(){
        System.out.println("Silahkan bayar di kasir dengan nominal Rp" + total);
        System.out.println("Uang yang diterima Rp" + saldo);
        System.out.println();

        if(cekPembayaran(total, saldo)){
            System.out.println("===== Pembayaran Berhasil =====");
            System.out.println("Kembalian anda Rp" + hitungKembalian());
            System.out.println();
        } else {
            System.out.println("Uang anda kurang Rp " + (total - saldo));
        }
    }
}

class PembayaranQRIS extends Pembayaran{
    public PembayaranQRIS(int total, int saldo) {
        super(total,saldo);
    }
    public void bayar(){
        System.out.println("====== Silakan scan QRIS ======");
        System.out.println("Total pesanan anda Rp" + total);
         if(cekPembayaran(total, saldo)){
            System.out.println("===== Pembayaran berhasil =====");
            System.out.println();
        } else {
            System.out.println("Saldo anda kurang Rp" + (total - saldo));
        }
    }
}
