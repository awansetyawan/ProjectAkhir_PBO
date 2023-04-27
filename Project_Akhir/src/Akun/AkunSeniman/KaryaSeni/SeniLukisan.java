package Akun.AkunSeniman.KaryaSeni;
import java.sql.Statement;

public abstract class SeniLukisan extends KaryaSeni{

    // Property
    static Statement Stmt;

    private String Teknik;
    private String Aliran;
    private int Id;

    public final String Kode = "LK";
    
    // Constructor
    public SeniLukisan(String nama, String seniman, String tahunPublikasi, int idSeniman, int harga, int panjang,
            int lebar, int stok, String teknik, String aliran, int id) {
        super(nama, seniman, tahunPublikasi, idSeniman, harga, panjang, lebar, stok);
        this.Teknik = teknik;
        this.Aliran = aliran;
        this.Id = id;
    }

    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        SeniLukisan.Stmt = Stmt;
    }

    public String getTeknik() {
        return Teknik;
    }

    public void setTeknik(String teknik) {
        this.Teknik = teknik;
    }

    public String getAliran() {
        return Aliran;
    }

    public void setAliran(String aliran) {
        this.Aliran = aliran;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getKode() {
        return Kode;
    }

    // Abstract Method
    @Override
    public void MenuManage() {
        System.out.println((char)27 +  "[05;36m \n                                                                   Menu Manajemen");
        System.out.println("                                                                   ..............\n" + (char)27 + "[00;00m");
        System.out.print("                   ");
        System.out.print("[1] Tambah Lukisan          ");
        System.out.print("[2] Lihat Lukisan          ");
        System.out.print("[3] Update Lukisan          ");
        System.out.print("[4] Hapus Lukisan          ");
        System.out.println("[0] Kembali");
    }
}