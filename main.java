public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Klien: ");
        String namaKlien = scanner.nextLine();

        System.out.println("Pilih Proyek:");
        System.out.println("1. Proyek Perumahan");
        System.out.println("2. Proyek Jalan");
        System.out.println("3. Proyek Gedung");
        System.out.print("Pilihan Anda: ");
        int pilihanProyek = scanner.nextInt();
        scanner.nextLine();

        Projek proyekDipilih = null;

        System.out.print("Masukkan ID Proyek: ");
        int idProyek = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama Proyek: ");
        String namaProyek = scanner.nextLine();
        System.out.print("Masukkan Lokasi Proyek: ");
        String lokasi = scanner.nextLine();

        switch (pilihanProyek) {
            case 1 -> {
                System.out.print("Masukkan Banyak Rumah: ");
                int banyakRumah = scanner.nextInt();
                proyekDipilih = new ProyekPerumahan(idProyek, namaProyek, lokasi, "Dalam Proses", banyakRumah);
            }
            case 2 -> {
                System.out.print("Masukkan Panjang Jalan (km): ");
                double panjangJalan = scanner.nextDouble();
                proyekDipilih = new ProyekJalan(idProyek, namaProyek, lokasi, "Dalam Proses", panjangJalan);
            }
            case 3 -> {
                System.out.print("Masukkan Jumlah Lantai: ");
                int jumlahLantai = scanner.nextInt();
                proyekDipilih = new ProyekGedung(idProyek, namaProyek, lokasi, "Dalam Proses", jumlahLantai);
            }
            default -> System.out.println("Pilihan tidak valid.");
        }

        if (proyekDipilih == null) {
            System.out.println("Proyek tidak dapat dibuat. Keluar dari program.");
            return;
        }

        System.out.print("Masukkan Total Anggaran: ");
        double totalAnggaran = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        Anggaran anggaran = new Anggaran(1, totalAnggaran); // Set Anggaran ID appropriately

        List<Material> materialList = new ArrayList<>();
        System.out.print("Masukkan Jumlah Material: ");
        int jumlahMaterial = scanner.nextInt();
        scanner.nextLine();
        double totalHargaMaterial = 0;
        for (int i = 0; i < jumlahMaterial; i++) {
            System.out.print("Masukkan Nama Material: ");
            String namaMaterial = scanner.nextLine();
            System.out.print("Masukkan Jumlah: ");
            int jumlah = scanner.nextInt();
            System.out.print("Masukkan Harga: ");
            double harga = scanner.nextDouble();
            scanner.nextLine();
            Material material = new Material("Bangunan", namaMaterial, jumlah, harga);
            anggaran.tambahMaterial(material);
            materialList.add(material);
            totalHargaMaterial += material.getTotalHarga();
        }

        Team team = new Team(1, "Tim Konstruksi");
        System.out.print("Masukkan Jumlah Mandor: ");
        int jumlahMandor = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < jumlahMandor; i++) {
            System.out.print("Masukkan Nama Mandor: ");
            String namaMandor = scanner.nextLine();
            team.tambahAnggota(new Mandor(i + 1, namaMandor));
        }

        System.out.print("Masukkan Jumlah Operator Alat Berat: ");
        int jumlahOperator = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < jumlahOperator; i++) {
            System.out.print("Masukkan Nama Operator: ");
            String namaOperator = scanner.nextLine();
            team.tambahAnggota(new OperatorAlatBerat(i + 1, namaOperator));
        }

        System.out.print("Masukkan Jumlah Tukang: ");
        int jumlahTukang = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < jumlahTukang; i++) {
            System.out.print("Masukkan Nama Tukang: ");
            String namaTukang = scanner.nextLine();
            team.tambahAnggota(new Tukang(i + 1, namaTukang));
        }

        System.out.println("\n=== Rincian Proyek ===");
        System.out.println("Nama Klien: " + namaKlien);
        System.out.println("Proyek yang Dipilih: ");
        proyekDipilih.tampilkanInfo();
        System.out.println("Total Anggaran: " + totalAnggaran);
        System.out.println("Material yang Dibutuhkan:");
        anggaran.tampilkanMaterial();
        System.out.println("Tim: ");
        team.tampilkanAnggota();
        
        double sisaAnggaran = anggaran.getAnggaranTersisa();
        System.out.println("\nSisa Anggaran: " + sisaAnggaran);
    }
}
