abstract class Tim {
    private String namaTim;

    public Tim(String namaTim) {
        this.namaTim = namaTim;
    }

    public String getNamaTim() {
        return namaTim;
    }

    public abstract void tetapkanTugas(String tugas);

    @Override
    public String toString() {
        return "Nama Tim: " + namaTim;
    }
}
