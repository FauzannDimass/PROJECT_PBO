public class Main {
    public static void main(String[] args) {
        Kuli timKuli = new Kuli(3);
        timKuli.tambahAnggota(0, "Budi", "Pengangkat Material");
        timKuli.tambahAnggota(1, "Susi", "Pemasang Pipa");
        timKuli.tambahAnggota(2, "Joko", "Penggali Lubang");
        timKuli.tampilkanAnggota();

        Mandor timMandor = new Mandor(2);
        timMandor.tambahAnggota(0, "Rudi", "Koordinasi Tim");
        timMandor.tambahAnggota(1, "Linda", "Pemantau Proyek");
        timMandor.tampilkanAnggota();

        OperatorAlatBerat timOperator = new OperatorAlatBerat(2);
        timOperator.tambahAnggota(0, "Andi", "Operator Excavator");
        timOperator.tambahAnggota(1, "Tina", "Operator Bulldozer");
        timOperator.tampilkanAnggota();
    }
}

class Kuli extends Tim {
    Kuli(int jumlahAnggota) {
        super(jumlahAnggota);
    }

    @Override
    void tampilkanAnggota() {
        System.out.println("Anggota Tim Kuli:");
        super.tampilkanAnggota();
    }
}

class Mandor extends Tim {
    Mandor(int jumlahAnggota) {
        super(jumlahAnggota);
    }

    @Override
    void tampilkanAnggota() {
        System.out.println("Anggota Tim Mandor:");
        super.tampilkanAnggota();
    }
}

class OperatorAlatBerat extends Tim {
    OperatorAlatBerat(int jumlahAnggota) {
        super(jumlahAnggota);
    }

    @Override
    void tampilkanAnggota() {
        System.out.println("Anggota Tim Operator Alat Berat:");
        super.tampilkanAnggota();
    }
}

class Tim {
    class Anggota {
        String nama;
        String tugas;

        Anggota(String nama, String tugas) {
            this.nama = nama;
            this.tugas = tugas;
        }

        void tampilkanInfo() {
            System.out.println("Nama: " + nama + ", Tugas: " + tugas);
        }
    }

    Anggota[] anggota;

    Tim(int jumlahAnggota) {
        anggota = new Anggota[jumlahAnggota];
    }

    void tambahAnggota(int index, String nama, String tugas) {
        anggota[index] = new Anggota(nama, tugas);
    }

    void tampilkanAnggota() {
        for (Anggota anggotaTim : anggota) {
            anggotaTim.tampilkanInfo();
        }
    }
}
