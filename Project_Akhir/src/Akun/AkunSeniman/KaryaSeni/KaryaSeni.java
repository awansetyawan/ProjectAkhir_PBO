package Akun.AkunSeniman.KaryaSeni;

public abstract class KaryaSeni {

    // Property
    protected String Nama;
    protected String Seniman;
    protected String TahunPublikasi;
    protected int IdSeniman;
    protected int Harga;
    protected int Panjang;
    protected int Lebar;
    protected int Stok;

    // Constructor
    public KaryaSeni(String nama, String seniman, String tahunPublikasi, int idSeniman, int harga, int panjang,
            int lebar, int stok) {
        this.Nama = nama;
        this.Seniman = seniman;
        this.TahunPublikasi = tahunPublikasi;
        this.IdSeniman = idSeniman;
        this.Harga = harga;
        this.Panjang = panjang;
        this.Lebar = lebar;
        this.Stok = stok;
    }
    
    // Setter & Getter
    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        this.Nama = nama;
    }

    public String getSeniman() {
        return Seniman;
    }

    public void setSeniman(String seniman) {
        this.Seniman = seniman;
    }

    public String getTahunPublikasi() {
        return TahunPublikasi;
    }

    public void setTahunPublikasi(String tahunPublikasi) {
        this.TahunPublikasi = tahunPublikasi;
    }

    public int getIdSeniman() {
        return IdSeniman;
    }

    public void setIdSeniman(int idSeniman) {
        this.IdSeniman = idSeniman;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int harga) {
        this.Harga = harga;
    }

    public int getPanjang() {
        return Panjang;
    }

    public void setPanjang(int panjang) {
        this.Panjang = panjang;
    }

    public int getLebar() {
        return Lebar;
    }

    public void setLebar(int lebar) {
        this.Lebar = lebar;
    }

    public int getStok() {
        return Stok;
    }

    public void setStok(int stok) {
        this.Stok = stok;
    }

    // Abstract Method
    public abstract void MenuManage();
}