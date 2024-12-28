class ProgresHarian implements LaporanProgres {
    public String tanggal;
    public String laporan;

    public ProgresHarian() {
    }

    @Override
    public void simpanLaporan(String tanggal, String laporan) {
        this.tanggal = tanggal;
        this.laporan = laporan;
    }

    @Override
    public void tampilkanLaporan() {
        System.out.println("Tanggal: " + this.tanggal);
        System.out.println("Laporan: " + this.laporan);
    }
}
