import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ArrayList<Proyek> daftarProyek = new ArrayList<>();
    private static ArrayList<TimPekerja> daftarTim = new ArrayList<>();
    private static ArrayList<Material> daftarMaterial = new ArrayList<>();
    private static ArrayList<ProgresHarian> daftarProgres = new ArrayList<>();
    private static AnggaranProyek anggaranProyek;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistem Manajemen Proyek Konstruksi");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JTabbedPane tabbedPane = new JTabbedPane();

            tabbedPane.add("Proyek", buatPanelProyek());
            tabbedPane.add("Tim", buatPanelTim());
            tabbedPane.add("Material", buatPanelMaterial());
            tabbedPane.add("Anggaran", buatPanelAnggaran());
            tabbedPane.add("Progres Harian", buatPanelProgres());
            tabbedPane.add("Tampilan", buatPanelTampilan());

            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }

    private static JPanel buatPanelProgres() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JSpinner tanggalSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(tanggalSpinner, "dd/MM/yyyy");
        tanggalSpinner.setEditor(dateEditor);

        JTextField laporanField = new JTextField();
        JButton tambahButton = new JButton("Tambah Progres");
        JButton lihatButton = new JButton("Lihat Semua Progres");

        inputPanel.add(new JLabel("Tanggal:"));
        inputPanel.add(tanggalSpinner);
        inputPanel.add(new JLabel("Laporan:"));
        inputPanel.add(laporanField);
        inputPanel.add(tambahButton);
        inputPanel.add(lihatButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        tambahButton.addActionListener(e -> {
            String tanggal = dateEditor.getFormat().format(tanggalSpinner.getValue());
            String laporan = laporanField.getText();

            ProgresHarian progres = new ProgresHarian();
            progres.simpanLaporan(tanggal, laporan);
            daftarProgres.add(progres);

            displayArea.append("Progres ditambahkan: \nTanggal: " + tanggal + "\nLaporan: " + laporan + "\n\n");
            laporanField.setText("");
        });

        lihatButton.addActionListener(e -> {
            displayArea.setText("");
            displayArea.append("--- Daftar Progres Harian ---\n");
            for (ProgresHarian progres : daftarProgres) {
                displayArea.append("Tanggal: " + progres.tanggal + "\nLaporan: " + progres.laporan + "\n\n");
            }
        });

        return panel;
    }

    private static JPanel buatPanelProyek() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        JTextField idField = new JTextField();
        JComboBox<String> namaField = new JComboBox<>(new String[]{"Proyek Jalan", "Proyek Perumahan", "Proyek Gedung"});
        JTextField lokasiField = new JTextField();
        JTextField anggaranField = new JTextField();
        JButton tambahButton = new JButton("Tambah Proyek");

        inputPanel.add(new JLabel("ID Proyek:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Pilih Proyek:"));
        inputPanel.add(namaField);
        inputPanel.add(new JLabel("Tempat Proyek:"));
        inputPanel.add(lokasiField);
        inputPanel.add(new JLabel("Anggaran Proyek:"));
        inputPanel.add(anggaranField);
        inputPanel.add(tambahButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        tambahButton.addActionListener(e -> {
            String id = idField.getText();
            String nama = (String) namaField.getSelectedItem();
            String lokasi = lokasiField.getText();
            String anggaranText = anggaranField.getText();

            try {
                int anggaran = Integer.parseInt(anggaranText);
                Proyek proyek = new Proyek(id, nama + " di " + lokasi + " (Anggaran: " + anggaran + ")");
                daftarProyek.add(proyek);
                anggaranProyek = new AnggaranProyek(anggaran); // Set anggaran proyek
                displayArea.append("Proyek ditambahkan: " + nama + " di " + lokasi + " dengan anggaran " + anggaran + "\n");

                idField.setText("");
                lokasiField.setText("");
                anggaranField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Masukkan anggaran yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    private static JPanel buatPanelTim() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JComboBox<String> namaTimField = new JComboBox<>(new String[]{"Kuli", "Mandor", "Operator Alat Berat"});
        JTextField anggotaField = new JTextField();
        JTextField jobdeskField = new JTextField();
        JButton tambahButton = new JButton("Tambah Tim");

        inputPanel.add(new JLabel("Nama Tim:"));
        inputPanel.add(namaTimField);
        inputPanel.add(new JLabel("Anggota (dipisah koma):"));
        inputPanel.add(anggotaField);
        inputPanel.add(new JLabel("Jobdesk:"));
        inputPanel.add(jobdeskField);
        inputPanel.add(tambahButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        tambahButton.addActionListener(e -> {
            String namaTim = (String) namaTimField.getSelectedItem();
            String[] anggota = anggotaField.getText().split(",");
            String jobdesk = jobdeskField.getText();

            TimPekerja tim = new TimPekerja(namaTim, List.of(anggota), jobdesk);
            daftarTim.add(tim);
            displayArea.append("Tim ditambahkan: " + namaTim + "\n");

            anggotaField.setText("");
            jobdeskField.setText("");
        });

        return panel;
    }

    private static JPanel buatPanelAnggaran() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        JButton hitungButton = new JButton("Hitung Sisa Anggaran");

        panel.add(hitungButton, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        hitungButton.addActionListener(e -> {
            if (anggaranProyek == null) {
                JOptionPane.showMessageDialog(panel, "Set total anggaran terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int totalHargaMaterial = daftarMaterial.stream().mapToInt(Material::hitungTotalHarga).sum();
            int sisaAnggaran = anggaranProyek.hitungSisaAnggaran(totalHargaMaterial);

            displayArea.append("Sisa Anggaran: " + sisaAnggaran + "\n");
        });

        return panel;
    }

    private static JPanel buatPanelMaterial() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5)); // Menambahkan margin antar elemen
        JTextField namaMaterialField = new JTextField();
        JTextField stokField = new JTextField();
        JTextField hargaField = new JTextField();

        JButton tambahButton = new JButton("Tambah Material");
        JButton tampilkanButton = new JButton("Tampilkan Semua Material");

        inputPanel.add(new JLabel("Nama Material:"));
        inputPanel.add(namaMaterialField);
        inputPanel.add(new JLabel("Stok:"));
        inputPanel.add(stokField);
        inputPanel.add(new JLabel("Harga:"));
        inputPanel.add(hargaField);
        inputPanel.add(tambahButton);
        inputPanel.add(tampilkanButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        tambahButton.addActionListener(e -> {
            String nama = namaMaterialField.getText();
            try {
                int stok = Integer.parseInt(stokField.getText());
                int harga = Integer.parseInt(hargaField.getText());

                Material material = new Material(nama, stok, harga);
                daftarMaterial.add(material);

                displayArea.append("Material berhasil ditambahkan: " + nama + " (Stok: " + stok + ", Harga: " + harga + ")\n");

                // Reset field input setelah data dimasukkan
                namaMaterialField.setText("");
                stokField.setText("");
                hargaField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Masukkan stok dan harga yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        tampilkanButton.addActionListener(e -> {
            displayArea.setText(""); // Reset area tampilan sebelum menampilkan data baru
            displayArea.append("--- Daftar Material ---\n");
            for (Material material : daftarMaterial) {
                displayArea.append("Nama: " + material.getNamaMaterial() + "\n");
                displayArea.append("Stok: " + material.getStok() + "\n");
                displayArea.append("Harga: " + material.getHarga() + "\n");
                displayArea.append("Total Harga: " + material.hitungTotalHarga() + "\n\n");
            }
        });

        return panel;
    }


    private static JPanel buatPanelTampilan() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JButton refreshButton = new JButton("Tampilkan Semua Data");
        panel.add(refreshButton, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        refreshButton.addActionListener(e -> {
            displayArea.setText("");

            // Menampilkan daftar proyek
            displayArea.append("--- Daftar Proyek ---\n");
            for (Proyek proyek : daftarProyek) {
                displayArea.append(proyek.toString() + "\n");
            }

            // Menampilkan daftar tim pekerja
            displayArea.append("\n--- Daftar Tim ---\n");
            for (TimPekerja tim : daftarTim) {
                displayArea.append(tim.toString() + "\n");
            }

            // Menampilkan daftar material
            displayArea.append("\n--- Daftar Material ---\n");
            for (Material material : daftarMaterial) {
                displayArea.append("Nama: " + material.getNamaMaterial() + "\n");
                displayArea.append("Stok: " + material.getStok() + "\n");
                displayArea.append("Harga: " + material.getHarga() + "\n");
                displayArea.append("Total Harga: " + material.hitungTotalHarga() + "\n\n");
            }

            // Menampilkan data anggaran
            if (anggaranProyek != null) {
                int totalHargaMaterial = daftarMaterial.stream()
                        .mapToInt(Material::hitungTotalHarga) // Menggunakan metode dari kelas Material
                        .sum();
                int sisaAnggaran = anggaranProyek.hitungSisaAnggaran(totalHargaMaterial); // Menggunakan metode dari kelas AnggaranProyek

                displayArea.append("\n--- Anggaran ---\n");
                displayArea.append("Total Anggaran: " + anggaranProyek.getTotalAnggaran() + "\n");
                displayArea.append("Total Harga Material: " + totalHargaMaterial + "\n");
                displayArea.append("Sisa Anggaran: " + sisaAnggaran + "\n");
            } else {
                displayArea.append("\n--- Anggaran ---\n");
                displayArea.append("Anggaran belum diatur.\n");
            }

            // Menampilkan progres harian
            displayArea.append("\n--- Progres Harian ---\n");
            for (ProgresHarian progres : daftarProgres) {
                displayArea.append("Tanggal: " + progres.tanggal + "\n");
                displayArea.append("Laporan: " + progres.laporan + "\n\n");
            }
        });

        return panel;
    }

}
