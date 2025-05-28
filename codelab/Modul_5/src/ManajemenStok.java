import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ManajemenStok {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        // Array kategori barang (contoh array tetap)
        String[] kategoriBarang = {"Elektronik", "Pakaian", "Makanan", "Alat Tulis", "Lainnya"};

        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println(CYAN + "====== Menu Manajemen Stok ======" + RESET);
            System.out.println("--- Kategori Barang (Array) ---");
            for (int i = 0; i < kategoriBarang.length; i++) {
                System.out.println(i + ". " + kategoriBarang[i]);
            }
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("4. Tampilkan Total Stok");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = -1;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // clear buffer
            } catch (InputMismatchException e) {
                System.out.println(RED + "Input harus berupa angka!" + RESET);
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine().trim();
                    if (nama.isEmpty()) {
                        System.out.println(RED + "Nama barang tidak boleh kosong!\n" + RESET);
                        break;
                    }
                    boolean duplikat = false;
                    for (Barang b : daftarBarang) {
                        if (b.getNama().equalsIgnoreCase(nama)) {
                            duplikat = true;
                            break;
                        }
                    }
                    if (duplikat) {
                        System.out.println(RED + "Barang dengan nama tersebut sudah ada.\n" + RESET);
                        break;
                    }

                    // Pilih kategori barang dari array
                    System.out.println("Pilih kategori barang:");
                    for (int i = 0; i < kategoriBarang.length; i++) {
                        System.out.println(i + ". " + kategoriBarang[i]);
                    }
                    System.out.print("Masukkan nomor kategori: ");

                    int kategoriIndex;
                    try {
                        kategoriIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (kategoriIndex < 0 || kategoriIndex >= kategoriBarang.length) {
                            System.out.println(RED + "Kategori tidak valid!\n" + RESET);
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(RED + "Input kategori harus berupa angka!\n" + RESET);
                        scanner.nextLine();
                        break;
                    }

                    String kategoriDipilih = kategoriBarang[kategoriIndex];

                    try {
                        System.out.print("Masukkan stok awal: ");
                        int stok = scanner.nextInt();
                        scanner.nextLine();
                        daftarBarang.add(new Barang(nama, stok, kategoriDipilih));
                        System.out.println(GREEN + "Barang '" + nama + "' berhasil ditambahkan.\n" + RESET);
                    } catch (InputMismatchException e) {
                        System.out.println(RED + "Stok harus berupa angka!\n" + RESET);
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    System.out.println(YELLOW + "\n--- Daftar Barang ---" + RESET);
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.\n");
                    } else {
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". Nama: " + b.getNama() + ", Kategori: " + b.getKategori() + ", Stok: " + b.getStok());
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (daftarBarang.isEmpty()) {
                        System.out.println(RED + "Belum ada barang untuk dikurangi stok.\n" + RESET);
                        break;
                    }

                    System.out.println(YELLOW + "\n--- Pilih Barang ---" + RESET);
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                    }

                    try {
                        System.out.print("Masukkan indeks barang: ");
                        int idx = scanner.nextInt();
                        scanner.nextLine();

                        if (idx < 0 || idx >= daftarBarang.size()) {
                            System.out.println(RED + "Indeks barang tidak valid.\n" + RESET);
                            break;
                        }

                        System.out.print("Jumlah stok yang dikurangi: ");
                        int jml = scanner.nextInt();
                        scanner.nextLine();

                        Barang b = daftarBarang.get(idx);
                        if (jml > b.getStok()) {
                            throw new StokTidakCukupException("Stok untuk '" + b.getNama() + "' hanya " + b.getStok());
                        }
                        b.setStok(b.getStok() - jml);
                        System.out.println(GREEN + "Stok '" + b.getNama() + "' berhasil dikurangi. Sisa: " + b.getStok() + "\n" + RESET);

                    } catch (InputMismatchException e) {
                        System.out.println(RED + "Input harus berupa angka!\n" + RESET);
                        scanner.nextLine();
                    } catch (StokTidakCukupException e) {
                        System.out.println(RED + e.getMessage() + "\n" + RESET);
                    }
                    break;

                case 4:
                    int total = 0;
                    for (Barang b : daftarBarang) {
                        total += b.getStok();
                    }
                    System.out.println(CYAN + "Total seluruh stok: " + total + "\n" + RESET);
                    break;

                case 0:
                    System.out.print("Yakin ingin keluar? (y/n): ");
                    String konfirmasi = scanner.nextLine().trim().toLowerCase();
                    if (konfirmasi.equals("y")) {
                        System.out.println(GREEN + "Terima kasih sudah menggunakan sistem manajemen stok!" + RESET);
                        isRunning = false;
                    } else {
                        System.out.println("Kembali ke menu...\n");
                    }
                    break;

                default:
                    System.out.println(RED + "Opsi tidak dikenali.\n" + RESET);
            }
        }

        scanner.close();
    }
}
