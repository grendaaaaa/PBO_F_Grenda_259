import java.util.Scanner;
import java.time.LocalDate;

public class DataDiri {
    public static void main(String[] args) {
        Scanner objinp = new Scanner(System.in);

        // Input nama
        System.out.print("Masukkan nama: ");
        String nama = objinp.nextLine();

        // Input jenis kelamin
        System.out.print("Masukkan jenis kelamin (P/L): ");
        char jenisKelamin = objinp.next().charAt(0);

        // Input tahun lahir
        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = objinp.nextInt();

        // Menutup scanner
        objinp.close();

        // Menghitung umur
        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;

        // Menentukan jenis kelamin
        String jenisKelaminStr = (jenisKelamin == 'L' || jenisKelamin == 'l') ? "Laki-laki" : "Perempuan";

        // Output data diri
        System.out.println("\nData Diri:");
        System.out.println("Nama          : " + nama);
        System.out.println("Jenis Kelamin : " + jenisKelaminStr);
        System.out.println("Umur          : " + umur + " tahun");
    }
}
