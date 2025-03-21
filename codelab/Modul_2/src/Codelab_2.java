class RekeningBank {
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    // Constructor
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo);
        System.out.println();
    }

    // Menyetor uang ke saldo
    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Setor uang: " + jumlah + " || Saldo saat ini: " + saldo);
        } else {
            System.out.println("Jumlah setor harus positif!");
        }
    }

    // Menarik uang dari saldo
    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Tarik uang: " + jumlah + " || Saldo saat ini: " + saldo);
        } else {
            System.out.println("Saldo tidak mencukupi atau jumlah tidak valid!");
        }
    }
}

class codelab_2 {
    public static void main(String[] args) {
        // Membuat dua objek rekening
        RekeningBank rekening1 = new RekeningBank("259", "grenda", 500000);
        RekeningBank rekening2 = new RekeningBank("245", "saput", 750000);

        // Menampilkan informasi rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Simulasi transaksi
        rekening1.setorUang(100000);
        rekening1.tarikUang(75000);
        rekening2.setorUang(50000);
        rekening2.tarikUang(100000);
    }
}