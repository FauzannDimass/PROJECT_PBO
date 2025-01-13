public class ProgresHarian implements ProgresReport {
    private String tanggal;
    private String laporan;

    public ProgresHarian(String tanggal, String laporan) {
        this.tanggal = tanggal;
        this.laporan = laporan;
    }

    @Override
    public void simpanLaporan(String laporan) {
        this.laporan = laporan;
    }

    @Override
    public void tampilkanLaporan() {
        System.out.println("Tanggal: " + tanggal + ", Laporan: " + laporan);
    }
}
