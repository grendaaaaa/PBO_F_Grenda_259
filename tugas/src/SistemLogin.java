import java.util.Scanner;

// Kelas Admin
class Admin {
    String username;
    String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validLogin(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}

// Kelas Mahasiswa
class Mahasiswa {
    String nama;
    String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public boolean isValid(String inputNama, String inputNim) {
        return this.nama.equals(inputNama) && this.nim.equals(inputNim);
    }

    public void displayInfo() {
        System.out.println("Nama Mahasiswa: " + nama);
        System.out.println("NIM Mahasiswa: " + nim);
    }
}

// Kelas utama SistemLogin
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
            objinp.nextLine(); // Membersihkan buffer

            if (pilihan == 1) {
                // Login Admin
                System.out.print("Masukkan username: ");
                String username = objinp.nextLine();
                System.out.print("Masukkan password: ");
                String password = objinp.nextLine();

                Admin admin = new Admin("Admin259", "password259");
                if (admin.validLogin(username, password)) {
                    System.out.println("Login Admin berhasil!");
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

                Mahasiswa mahasiswa = new Mahasiswa("Grenda Agriansyah", "202410370110259");
                if (mahasiswa.isValid(nama, nim)) {
                    System.out.println("Login Mahasiswa berhasil!");
                    mahasiswa.displayInfo();
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
