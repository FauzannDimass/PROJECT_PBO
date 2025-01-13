public class ProyekJalan extends Projek {
    private double panjangJalan;

    public ProyekJalan(int projekId, String nama, String lokasi, String status, double panjangJalan) {
        super(projekId, nama, lokasi, 0, status);
        this.panjangJalan = panjangJalan;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Proyek Jalan - Nama: " + nama + ", Lokasi: " + lokasi +
                ", Status: " + status + ", Panjang Jalan: " + panjangJalan + " km");
    }
}
