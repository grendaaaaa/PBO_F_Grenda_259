import java.util.Scanner;

public class SistemLogin {
    public static void main(String[] args) {
        Scanner objInput = new Scanner(System.in);
        boolean loginUlang;

        do {
            loginUlang = false;

            // demo w1
            // Menampilkan pilihan login
            System.out.println("Pilih jenis login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Masukkan pilihan: ");
            int pilihan = objInput.nextInt();
            objInput.nextLine(); // Membersihkan buffer

            if (pilihan == 1) {
                // Login Admin
                System.out.print("Masukkan username: ");
                String username = objInput.nextLine();
                System.out.print("Masukkan password: ");
                String password = objInput.nextLine();

                // Cek kredensial admin (misalnya 3 digit terakhir NIM adalah 010)
                String nimAkhir = "259";
                String usernameValid = "Admin" + nimAkhir;
                String passwordValid = "password" + nimAkhir;

                if (username.equals(usernameValid) && password.equals(passwordValid)) {
                    System.out.println("Login Admin berhasil!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                    loginUlang = promptLoginUlang(objInput);
                }
            } else if (pilihan == 2) {
                // Login Mahasiswa
                System.out.print("Masukkan nama: ");
                String nama = objInput.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = objInput.nextLine();

                // Data mahasiswa valid (contoh)
                String namaValid = "Grenda agriansyah";
                String nimValid = "202410370110259";

                if (nama.equals(namaValid) && nim.equals(nimValid)) {
                    System.out.println("Login Mahasiswa berhasil!");
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                    loginUlang = promptLoginUlang(objInput);
                }
            } else {
                System.out.println("Pilihan tidak valid.");
                loginUlang = promptLoginUlang(objInput);
            }
        } while (loginUlang);

        // Menutup scanner
        objInput.close();
    }

    private static boolean promptLoginUlang(Scanner objInput) {
        System.out.print("Apakah ingin login ulang? (ya/tidak): ");
        String ulang = objInput.nextLine();
        return ulang.equalsIgnoreCase("ya");
    }
}