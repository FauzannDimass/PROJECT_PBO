import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        ArrayList<Projek> daftarProyek = new ArrayList<>();
        ArrayList<ProgresReport> laporanProgresList = new ArrayList<>();
        Anggaran anggaran = null;
        Team team = null;

        while (continueProgram) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Masukkan Proyek Baru");
            System.out.println("2. Masukkan Laporan Progres");
            System.out.println("3. Tampilkan Laporan Progres");
            System.out.println("4. Tampilkan Rincian Proyek");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Klien: ");
                    String namaKlien = scanner.nextLine();

                    System.out.println("Pilih Proyek:");
                    System.out.println("1. Proyek Perumahan");
                    System.out.println("2. Proyek Jalan");
                    System.out.println("3. Proyek Gedung");
                    System.out.print("Pilihan Anda: ");
                    int pilihanProyek = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan ID Proyek: ");
                    int idProyek = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama Proyek: ");
                    String namaProyek = scanner.nextLine();
                    System.out.print("Masukkan Lokasi Proyek: ");
                    String lokasi = scanner.nextLine();

                    Projek proyekDipilih = null;
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

                    if (proyekDipilih != null) {
                        System.out.print("Masukkan Total Anggaran: ");
                        double totalAnggaran = scanner.nextDouble();
                        scanner.nextLine();
                        anggaran = new Anggaran(1, totalAnggaran);

                        ArrayList<Material> materialList = new ArrayList<>();
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

                        team = new Team(1, "Tim Konstruksi");
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

                        daftarProyek.add(proyekDipilih);
                    } else {
                        System.out.println("Proyek tidak dapat dibuat.");
                    }
                    break;

                case 2:
                    if (daftarProyek.isEmpty()) {
                        System.out.println("Belum ada proyek yang dimasukkan.");
                    } else {
                        LocalDate today = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String tanggal = today.format(formatter);

                        System.out.print("\nMasukkan Laporan Progres: ");
                        String laporan = scanner.nextLine();

                        ProgresReport progresHarian = new ProgresHarian(tanggal, laporan);
                        laporanProgresList.add(progresHarian);
                        progresHarian.tampilkanLaporan();
                    }
                    break;

                case 3:
                    if (!laporanProgresList.isEmpty()) {
                        System.out.println("\n=== Laporan Progres ===");
                        for (ProgresReport progres : laporanProgresList) {
                            progres.tampilkanLaporan();
                        }
                    } else {
                        System.out.println("Tidak ada laporan progres yang tersedia.");
                    }
                    break;

                case 4:
                    if (!daftarProyek.isEmpty()) {
                        System.out.println("\n=== Daftar Proyek ===");
                        for (Projek proyek : daftarProyek) {
                            proyek.tampilkanInfo();
                            System.out.println("Total Anggaran: " + anggaran.getAnggaranTersisa());
                            anggaran.tampilkanMaterial();
                            team.tampilkanAnggota();
                            System.out.println();
                        }
                    } else {
                        System.out.println("Belum ada proyek yang dimasukkan.");
                    }
                    break;

                case 5:
                    continueProgram = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
                    break;
            }
        }

        scanner.close();
    }
}
