import java.util.List;

class TimPekerja extends Tim {
    private List<String> anggota;
    private String jobDesk;

    public TimPekerja(String namaTim, List<String> anggota, String jobDesk) {
        super(namaTim);
        this.anggota = anggota;
        this.jobDesk = jobDesk;
    }

    @Override
    public void tetapkanTugas(String tugas) {
        System.out.println("Tugas diberikan ke " + getNamaTim() + ": " + tugas);
    }

    @Override
    public String toString() {
        return super.toString() + ", Anggota: " + String.join(", ", anggota) + ", JobDesk: " + jobDesk;
    }
}
