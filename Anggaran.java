public class Anggaran {
    private int idAnggaran;
    private double totalAnggaran;
    private double anggaranTerealisasi;
    private double anggaranTersisa;
    private List<Material> materials;
    private Projek proyek;

    public Anggaran(int idAnggaran, double totalAnggaran) {
        this.idAnggaran = idAnggaran;
        this.totalAnggaran = totalAnggaran;
        this.materials = new ArrayList<>();
    }

    public void setProyek(Projek proyek) {
        this.proyek = proyek;
    }

    public Projek getProyek() {
        return proyek;
    }

    public void tambahMaterial(Material material) {
        materials.add(material);
        hitungAnggaranTerealisasi();
    }

    public void tambahMaterial(String jenisMaterial, String namaMaterial, int kuantitas, double hargaMaterial) {
        Material material = new Material(jenisMaterial, namaMaterial, kuantitas, hargaMaterial);
        tambahMaterial(material);
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
