class Barang {
    private String nama;
    private int stok;
    private String kategori;

    public Barang(String nama, int stok, String kategori) {
        this.nama = nama;
        this.stok = stok;
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public String getKategori() {
        return kategori;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
