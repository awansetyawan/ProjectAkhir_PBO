package Akun.AkunSeniman;

import MessageAndDesaign.MessageAndDesaign;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class RiwayatTransaksiSeniman {
    
    // Property
    static Statement Stmt;
    static ResultSet Rs;

    public int IdTransaksi;
    public int IdPesanan;
    public int JumlahItem;
    public int TotalTransaksi;
    public String NoRekSumber;
    public String NoRekTujuan;
    public String NamaUser;
    public String NamaSeniman;
    public String Item;
    public String TanggalTransaksi;
    
    // Constructor
    public RiwayatTransaksiSeniman(int idTransaksi, int idPesanan, int jumlahItem, int totalTransaksi,
            String noRekSumber, String noRekTujuan, String namaUser, String namaSeniman, String item,
            String tanggalTransaksi) {
        this.IdTransaksi = idTransaksi;
        this.IdPesanan = idPesanan;
        this.JumlahItem = jumlahItem;
        this.TotalTransaksi = totalTransaksi;
        this.NoRekSumber = noRekSumber;
        this.NoRekTujuan = noRekTujuan;
        this.NamaUser = namaUser;
        this.NamaSeniman = namaSeniman;
        this.Item = item;
        this.TanggalTransaksi = tanggalTransaksi;
    }

    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        RiwayatTransaksiSeniman.Stmt = Stmt;
    }

    // Prosedur
    public void RiwayatTransaksi(int IdAkun) throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        DSG.ClrScreen();
        DSG.Header();
        try {
            // Query Select
            String Username = "SELECT * FROM dataakun WHERE IdAkun = " + IdAkun;

            // Eksekusi
            ResultSet UsernameResult = Stmt.executeQuery(Username);
            String NamaUsername = "";

            if (UsernameResult.next()) {
                NamaUsername = UsernameResult.getString("Username");
            }

            // Query Select
            String Sql = "SELECT * FROM datatransaksi WHERE NamaSeniman = '"+ NamaUsername +"'";
            
            // Eksekusi
            Rs = Stmt.executeQuery(Sql);

            DSG.DesainRiwayatTransaksi();
            if (!Rs.next()) {
                MSG.DesainNotTransaksi();
            } else {
                do {
                    IdTransaksi = Rs.getInt("IdTransaksi");
                    NoRekSumber = Rs.getString("NoRekSumber");
                    NoRekTujuan = Rs.getString("NoRekTujuan");
                    NamaUser = Rs.getString("NamaUser");
                    NamaSeniman = Rs.getString("NamaSeniman");
                    Item = Rs.getString("Item");
                    JumlahItem = Rs.getInt("JumlahItem");
                    TotalTransaksi = Rs.getInt("TotalTransaksi");
                    TanggalTransaksi = Rs.getString("TanggalTransaksi");
                    System.out.println((char)27 +  "[05;36m\n                                            ==================== " + TanggalTransaksi + " ======================"+ (char)27 + "[00;00m");
                    System.out.println(String.format("\n                                                                                                  ID TRK%s", IdTransaksi));
                    System.out.println(String.format("                                                    Nama Pengirim        : %s", NamaUser));
                    System.out.println(String.format("                                                    Nomor rekening       : %s", NoRekSumber));
                    System.out.println(String.format("                                                    Nama Penerima        : %s", NamaSeniman));
                    System.out.println(String.format("                                                    Nomor Rekening       : %s", NoRekTujuan));
                    System.out.println(String.format("                                                    Item                 : %s", Item));
                    System.out.println(String.format("                                                    Jumlah Item          : %s", JumlahItem));
                    System.out.println(String.format("                                                    ---------------------------------------------+"));
                    System.out.println(String.format("                                                                             Total : Rp.%s", TotalTransaksi));
                } while (Rs.next());
            }
            DSG.Press();
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }
}
