class AnggaranProyek extends ManajemenAnggaran {

    public AnggaranProyek(int totalAnggaran) {
        super(totalAnggaran);
    }

    @Override
    public int hitungSisaAnggaran(int totalHargaMaterial) {
        return totalAnggaran - anggaranTerpakai - totalHargaMaterial;
    }
}
