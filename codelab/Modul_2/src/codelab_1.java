// Kelas Hewan
class Hewan {
    String nama;
    String jenis;
    String suara;

    // Constructor
    public Hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    // Metode untuk menampilkan informasi hewan
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);
        System.out.println(); // Baris kosong untuk pemisah
    }
}

// Kelas Main
public class codelab_1 {
    public static void main(String[] args) {
        // Membuat objek hewan
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~");
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");
        Hewan hewan3 = new Hewan("Buaya", "Reptil", "kalau aku chat ada yang marah gak?");

        // Menampilkan informasi hewan
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();
        hewan3.tampilkanInfo();
    }
}
