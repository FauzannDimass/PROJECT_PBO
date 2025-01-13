public class ProyekPerumahan extends Projek {
    private int banyakRumah;

    public ProyekPerumahan(int projekId, String nama, String lokasi, String status, int banyakRumah) {
        super(projekId, nama, lokasi, 0, status);
        this.banyakRumah = banyakRumah;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Proyek Perumahan - Nama: " + nama + ", Lokasi: " + lokasi +
                ", Status: " + status + ", Banyak Rumah: " + banyakRumah);
    }
}
