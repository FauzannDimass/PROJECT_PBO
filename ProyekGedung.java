class ProyekGedung extends Projek {
    private int jumlahLantai;

    public ProyekGedung(int projekId, String nama, String lokasi, String status, int jumlahLantai) {
        super(projekId, nama, lokasi, 0, status);  // Budget for building projects can be added later
        this.jumlahLantai = jumlahLantai;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Proyek Gedung - Nama: " + nama + ", Lokasi: " + lokasi +
                ", Status: " + status + ", Jumlah Lantai: " + jumlahLantai);
    }
}
