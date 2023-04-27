package Akun.AkunUser;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import MessageAndDesaign.MessageAndDesaign;

public class Transaksi {

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
    public String Alamat;
    public String Email;
    
    static BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
    
    // Constructor


    public static Statement getStmt() {
        return Stmt;
    }

    public Transaksi(int idTransaksi, int idPesanan, int jumlahItem, int totalTransaksi, String noRekSumber,
            String noRekTujuan, String namaUser, String namaSeniman, String item, String tanggalTransaksi,
            String alamat, String email) {
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
        this.Alamat = alamat;
        this.Email = email;
    }

    public static void setStmt(Statement Stmt) {
        Transaksi.Stmt = Stmt;
    }

    public void CreateTransaksi(int IdAkun) throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();

        Pattern PolaAngka = Pattern.compile("[0-9]+");

        try {
            DSG.ClrScreen();
            DSG.Header();

            do{
                DSG.DesainNoRek();
                this.NoRekSumber = Input.readLine();

                if (this.NoRekSumber.trim().isEmpty()) {
                    MSG.MsgNoRekIsEmpty();
                }else if(!PolaAngka.matcher(this.NoRekSumber).matches()) {
                    MSG.MsgNotNumberNoRek();
                }
                else if (this.NoRekSumber.length()  < 10) {
                    MSG.MsgNoRekDigitMinimal();
                } 
                
            }while(this.NoRekSumber.length() < 10 ||!PolaAngka.matcher(this.NoRekSumber).matches() || this.NoRekSumber.trim().isEmpty());

            do{
                DSG.DesainAlamat();
                this.Alamat = Input.readLine();

                if (this.Alamat.length() < 1) {
                    MSG.MsgAlamatIsEmpty();
                }else if (this.Alamat.trim().isEmpty()) {
                    MSG.MsgAlamatIsEmpty();
                }
            }while(this.Alamat.length() < 1 || this.Alamat.trim().isEmpty());

            do {
                DSG.DesainEmail();
                this.Email = Input.readLine();
            
                if (this.Email.length() < 1) {
                    MSG.MsgEmailIsEmpty();
                } else if (this.Email.trim().isEmpty()) {
                    MSG.MsgEmailIsEmpty();
                } else if (!this.Email.contains("@")) {
                    MSG.MsgInvalidEmail();
                }
            } while (this.Email.length() < 1 || this.Email.trim().isEmpty() || !this.Email.contains("@"));
            
    
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime waktuSekarang = LocalDateTime.now();
            TanggalTransaksi = waktuSekarang.format(formatter);
    
            // Query mencari data pesanan terakhir yang dipesan oleh user
            String SqlSelectItem = "SELECT IdPesanan, NamaUser, NamaSeniman, NamaItem, JumlahItem, TotalPembayaran, NoRekSeniman FROM datapesanan WHERE IdUser =" + IdAkun + " AND IdPesanan = (SELECT MAX(IdPesanan) FROM datapesanan WHERE IdUser =" + IdAkun + ")";
            
            // Eksekusi
            ResultSet Rs = Stmt.executeQuery(SqlSelectItem);
    
            if (Rs.next()) {
                this.IdPesanan = Rs.getInt("IdPesanan");
                this.NamaUser = Rs.getString("NamaUser");
                this.NamaSeniman = Rs.getString("NamaSeniman");
                this.Item = Rs.getString("NamaItem");
                this.JumlahItem = Rs.getInt("JumlahItem");
                this.TotalTransaksi = Rs.getInt("TotalPembayaran");
                this.NoRekTujuan = Rs.getString("NoRekSeniman");
    
                // Query Alter Table
                String CekId = String.format("ALTER TABLE DataTransaksi AUTO_INCREMENT=0");
                
                // Eksekusi
                Stmt.execute(CekId);

                // Query simpan
                String SqlAppend = "INSERT INTO DataTransaksi (IdPesanan, IdUser, NoRekSumber, NoRekTujuan, NamaUser, NamaSeniman, Item, JumlahItem, TotalTransaksi, TanggalTransaksi, Alamat, Email) VALUES (%d, %d, '%s', '%s', '%s', '%s', '%s', %d, %d, '%s', '%s', '%s')";
    
                SqlAppend = String.format(SqlAppend, this.IdPesanan, IdAkun, this.NoRekSumber, this.NoRekTujuan, this.NamaUser, this.NamaSeniman, this.Item, this.JumlahItem, this.TotalTransaksi, this.TanggalTransaksi, this.Alamat, this.Email);
    
                // Eksekusi
                Stmt.execute(SqlAppend);
            }
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainBuktiPembayaran();
            System.out.println((char)27 +  "[05;33m     \n                                                Informasi Pengiriman Item Karya Seni Akan Dikirim Ke Email " + (char)27 + "[00;00m");
            System.out.println("\n                                                                   " + this.Email);
            DSG.Press();
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }
    
    public void ShowTransaksi() throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        DSG.ClrScreen();
        DSG.Header();
        System.out.println("\n\n\n\n\n\n\n                                        --------------------------Detail Transaksi-------------------------");
        System.out.println((char)27 +  "[05;36m\n                                                                                  " + this.TanggalTransaksi + (char)27 + "[00;00m");
        System.out.println("\n                                              Id Pesanan       : " +  this.IdPesanan);
        System.out.println("                                              Nama Pengirim    : " +  this.NamaUser);
        System.out.println("                                              Rekening Sumber  : " +  this.NoRekSumber);
        System.out.println("                                              Nama Penerima    : " +  this.NamaSeniman);
        System.out.println("                                              Rekening Tujuan  : " +  this.NoRekTujuan);
        System.out.println("                                              Item             : " +  this.Item);
        System.out.println("                                              Jumlah Item      : " +  this.JumlahItem);
        System.out.println("                                        -------------------------------------------------------------------+");
        System.out.println(String.format("\n                                                                  Total : Rp.%s", this.TotalTransaksi));
    }

    public void RiwayatTransaksi(int IdAkun) throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();

        DSG.ClrScreen();
        DSG.Header();
        try {  
            // Query Select
            String Sql = "SELECT * FROM datatransaksi WHERE IdUser =" + IdAkun;
    
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