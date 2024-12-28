class Material {
    private String namaMaterial;
    private int stok;
    private int harga;

    public Material(String namaMaterial, int stok, int harga) {
        this.namaMaterial = namaMaterial;
        this.stok = Math.max(stok, 0);
        this.harga = Math.max(harga, 0);
    }

    public int getStok() {
        return stok;
    }

    public String getNamaMaterial() {
        return namaMaterial;
    }

//    public void setStok(int stok) {
//        this.stok = Math.max(stok, 0);
//    }

    public int getHarga() {
        return harga;
    }

//    public void setHarga(int harga) {
//        this.harga = Math.max(harga, 0);
//    }

    public int hitungTotalHarga() {
        return harga * stok;
    }
}
