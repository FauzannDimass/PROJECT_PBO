abstract class ManajemenAnggaran {
    protected int totalAnggaran;
    protected int anggaranTerpakai;

    public ManajemenAnggaran(int totalAnggaran) {
        this.totalAnggaran = totalAnggaran;
        this.anggaranTerpakai = 0;
    }

    public int getTotalAnggaran() {
        return totalAnggaran;
    }

    public int getAnggaranTerpakai() {
        return anggaranTerpakai;
    }

    public void tambahPengeluaran(int jumlah) {
        if (jumlah > 0 && anggaranTerpakai + jumlah <= totalAnggaran) {
            anggaranTerpakai += jumlah;
        } else {
            System.out.println("Pengeluaran tidak valid atau melebihi anggaran!");
        }
    }

    public abstract int hitungSisaAnggaran(int totalHargaMaterial);
}
