import java.util.ArrayList;
import java.util.List;

class Anggaran {
    private int idAnggaran;
    private double totalAnggaran;
    private double anggaranTerealisasi;
    private double anggaranTersisa;
    private List<Material> materials;

    public Anggaran(int idAnggaran, double totalAnggaran) {
        this.idAnggaran = idAnggaran;
        this.totalAnggaran = totalAnggaran;
        this.materials = new ArrayList<>();
    }

    public void tambahMaterial(Material material) {
        materials.add(material);
        hitungAnggaranTerealisasi();
    }

    private void hitungAnggaranTerealisasi() {
        anggaranTerealisasi = 0;
        for (Material material : materials) {
            anggaranTerealisasi += material.getTotalHarga();
        }
        anggaranTersisa = totalAnggaran - anggaranTerealisasi;
    }

    public void tampilkanMaterial() {
        for (Material material : materials) {
            System.out.println(material);
        }
    }

    public double getAnggaranTerealisasi() {
        return anggaranTerealisasi;
    }

    public double getAnggaranTersisa() {
        return anggaranTersisa;
    }
}
