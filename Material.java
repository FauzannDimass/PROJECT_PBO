class Material {
    private String jenisMaterial;
    private String namaMaterial;
    private int kuantitas;
    private double hargaMaterial;

    public Material(String jenisMaterial, String namaMaterial, int kuantitas, double hargaMaterial) {
        this.jenisMaterial = jenisMaterial;
        this.namaMaterial = namaMaterial;
        this.kuantitas = kuantitas;
        this.hargaMaterial = hargaMaterial;
    }

    public double getTotalHarga() {
        return kuantitas * hargaMaterial;
    }

    public String getNamaMaterial() {
        return namaMaterial;
    }

    @Override
    public String toString() {
        return "Material [Jenis: " + jenisMaterial + ", Nama: " + namaMaterial +
                ", Kuantitas: " + kuantitas + ", Harga: " + hargaMaterial +
                ", Total Harga: " + getTotalHarga() + "]";
    }
}
