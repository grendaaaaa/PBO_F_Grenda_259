import java.util.Scanner;

class KarakterGame {
    private final String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan){
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama(){
        return nama;
    }

    public int getKesehatan(){
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target, String serangan, int damage){
        System.out.println(nama + " menyerang " + target.getNama() + " menggunakan " + serangan + "!");
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

class Pahlawan extends KarakterGame{
    public Pahlawan (String nama){
        super(nama, 150);
    }

    @Override
    public void serang(KarakterGame target, String serangan, int damage){
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan " + serangan + "!");
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

class Musuh extends KarakterGame{
    public Musuh(String nama){
        super(nama, 200);
    }

    @Override
    public void serang(KarakterGame target, String serangan, int damage){
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan " + serangan + "!");
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama pahlawan: ");
        String namaPahlawan = scanner.nextLine();

        System.out.print("Masukkan nama musuh: ");
        String namaMusuh = scanner.nextLine();

        System.out.print("Masukkan jenis serangan pahlawan: ");
        String seranganPahlawan = scanner.nextLine();
        int damagePahlawan = 20;

        System.out.print("Masukkan jenis serangan musuh: ");
        String seranganMusuh = scanner.nextLine();
        int damageMusuh = 15;

        Pahlawan pahlawan = new Pahlawan(namaPahlawan);
        Musuh musuh = new Musuh(namaMusuh);

        System.out.println("\nStatus awal:");
        System.out.println(pahlawan.getNama() + " memiliki kesehatan: " + pahlawan.getKesehatan());
        System.out.println(musuh.getNama() + " memiliki kesehatan: " + musuh.getKesehatan());

        // Melakukan serangan
        pahlawan.serang(musuh, seranganPahlawan, damagePahlawan);
        musuh.serang(pahlawan, seranganMusuh, damageMusuh);
    }
}
