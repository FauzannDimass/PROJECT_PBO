abstract class Projek {
    protected int projekId;
    protected String nama;
    protected String lokasi;
    protected double budget;
    protected String status;

    public Projek(int projekId, String nama, String lokasi, double budget, String status) {
        this.projekId = projekId;
        this.nama = nama;
        this.lokasi = lokasi;
        this.budget = budget;
        this.status = status;
    }

    public abstract void tampilkanInfo();
}
