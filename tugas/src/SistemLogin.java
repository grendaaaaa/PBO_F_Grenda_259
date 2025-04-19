import java.util.Scanner;

// Kelas utama: SistemLogin
public class SistemLogin {
    public static void main(String[] args) {
        Scanner objinp = new Scanner(System.in);
        boolean loginUlang;

        do {
            loginUlang = false;
            System.out.println("Pilih jenis login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Masukkan pilihan: ");
            int pilihan = objinp.nextInt();
            objinp.nextLine(); // Clear buffer

            if (pilihan == 1) {
                // Login Admin
                System.out.print("Masukkan username: ");
                String username = objinp.nextLine();
                System.out.print("Masukkan password: ");
                String password = objinp.nextLine();

                Admin admin = new Admin("Admin judol", "202410370110259", "Admin259", "password259");
                if (admin.login(username, password)) {
                    admin.displayInfo();
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                    loginUlang = promptLoginUlang(objinp);
                }

            } else if (pilihan == 2) {
                // Login Mahasiswa
                System.out.print("Masukkan nama: ");
                String nama = objinp.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = objinp.nextLine();

                Mahasiswa mhs = new Mahasiswa("Grenda Agriansyah", "202410370110259");
                if (mhs.login(nama, nim)) {
                    mhs.displayInfo();
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                    loginUlang = promptLoginUlang(objinp);
                }

            } else {
                System.out.println("Pilihan tidak valid!");
                loginUlang = promptLoginUlang(objinp);
            }
        } while (loginUlang);

        objinp.close();
    }

    private static boolean promptLoginUlang(Scanner objinp) {
        System.out.print("Apakah ingin login ulang? (ya/tidak): ");
        String ulang = objinp.nextLine();
        return ulang.equalsIgnoreCase("ya");
    }
}
