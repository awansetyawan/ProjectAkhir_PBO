package Akun.AkunSeniman.KaryaSeni;

import java.sql.Statement;

public abstract class SeniUkir extends KaryaSeni{
    
    // Property
    static Statement Stmt;
    
    private int Id;
    private int Tinggi;
    private String Motif;

    public final String Kode = "UKR";

    // Constructor
    public SeniUkir(String nama, String seniman, String tahunPublikasi, int idSeniman, int harga, int panjang,
            int lebar, int stok, int id, int tinggi, String motif) {
        super(nama, seniman, tahunPublikasi, idSeniman, harga, panjang, lebar, stok);
        this.Id = id;
        this.Tinggi = tinggi;
        this.Motif = motif;
    }

    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        SeniUkir.Stmt = Stmt;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getTinggi() {
        return Tinggi;
    }

    public void setTinggi(int tinggi) {
        this.Tinggi = tinggi;
    }

    public String getMotif() {
        return Motif;
    }

    public void setMotif(String motif) {
        this.Motif = motif;
    }

    public String getKode() {
        return Kode;
    }

    // Abstract Method
    @Override
    public void MenuManage() {
        System.out.println((char)27 +  "[05;36m \n                                                                   Menu Manajemen");
        System.out.println("                                                                   ..............\n" + (char)27 + "[00;00m");
        System.out.print("                     ");
        System.out.print("[1] Tambah Ukir          ");
        System.out.print("[2] Lihat Ukir          ");
        System.out.print("[3] Update Ukir          ");
        System.out.print("[4] Hapus Ukir          ");
        System.out.println("[0] Kembali");
    }
}