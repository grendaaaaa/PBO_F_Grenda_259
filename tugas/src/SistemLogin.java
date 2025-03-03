import java.util.Scanner;

public class SistemLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loginUlang;

        do {
            loginUlang = false;

            // Menampilkan pilihan login
            System.out.println("Pilih jenis login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            if (pilihan == 1) {
                // Login Admin
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                // Cek kredensial admin (misalnya 3 digit terakhir NIM adalah 010)
                String nimAkhir = "259jhgg";
                String usernameValid = "Admin" + nimAkhir;
                String passwordValid = "password" + nimAkhir;

                if (username.equals(usernameValid) && password.equals(passwordValid)) {
                    System.out.println("Login Admin berhasil!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                    loginUlang = promptLoginUlang(scanner);
                }
            } else if (pilihan == 2) {
                // Login Mahasiswa
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                // Data mahasiswa valid (contoh)
                String namaValid = "Grenda agriansyah";
                String nimValid = "202410370110259";

                if (nama.equals(namaValid) && nim.equals(nimValid)) {
                    System.out.println("Login Mahasiswa berhasil!");
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                    loginUlang = promptLoginUlang(scanner);
                }
            } else {
                System.out.println("Pilihan tidak valid.");
                loginUlang = promptLoginUlang(scanner);
            }
        } while (loginUlang);

        // Menutup scanner
        scanner.close();
    }

    private static boolean promptLoginUlang(Scanner scanner) {
        System.out.print("Apakah ingin login ulang? (ya/tidak): ");
        String ulang = scanner.nextLine();
        return ulang.equalsIgnoreCase("ya");
    }
}