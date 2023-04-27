package Akun.AkunSeniman.KaryaSeni;

import java.sql.Statement;

public abstract class SeniPatung extends KaryaSeni{
    
    // Property
    static Statement Stmt;

    private int Id;
    private int Tinggi;
    private String Jenis;

    public final String Kode = "PT";
    
    // Constructor
    public SeniPatung(String nama, String seniman, String tahunPublikasi, int idSeniman, int harga, int panjang,
            int lebar, int stok, int id, int tinggi, String jenis) {
        super(nama, seniman, tahunPublikasi, idSeniman, harga, panjang, lebar, stok);
        this.Id = id;
        this.Tinggi = tinggi;
        this.Jenis = jenis;
    }

    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        SeniPatung.Stmt = Stmt;
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

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String jenis) {
        this.Jenis = jenis;
    }

    public String getKode() {
        return Kode;
    }

    // Abstract Method
    @Override
    public void MenuManage() {
        System.out.println((char)27 +  "[05;36m \n                                                                   Menu Manajemen");
        System.out.println("                                                                   ..............\n" + (char)27 + "[00;00m");
        System.out.print("                    ");
        System.out.print("[1] Tambah Patung          ");
        System.out.print("[2] Lihat Patung          ");
        System.out.print("[3] Update Patung          ");
        System.out.print("[4] Hapus Patung          ");
        System.out.println("[0] Kembali");
    } 
}