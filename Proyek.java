class Proyek {
    private String idProyek;
    private String namaProyek;

    public Proyek(String idProyek, String namaProyek) {
        this.idProyek = idProyek;
        this.namaProyek = namaProyek;
    }

    public String getIdProyek() {
        return idProyek;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    @Override
    public String toString() {
        return "ID: " + idProyek + ", Nama: " + namaProyek;
    }
}
