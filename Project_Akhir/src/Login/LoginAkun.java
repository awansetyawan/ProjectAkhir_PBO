package Login;

import Akun.AkunUser.Katalog;
import Akun.AkunUser.ManajemenAkun;
import Akun.AkunUser.Pesanan;
import Akun.AkunUser.Transaksi;
import MessageAndDesaign.MessageAndDesaign;
import Akun.Akun;
import Akun.AkunAdmin.Admin;
import Akun.AkunAdmin.Pengguna;
import Akun.AkunAdmin.Seniman;
import Akun.AkunAdmin.StatistikPenjualan;
import Akun.AkunSeniman.ManajemenGaleri.ManageSeniLukisan;
import Akun.AkunSeniman.ManajemenGaleri.ManageSeniPatung;
import Akun.AkunSeniman.ManajemenGaleri.ManageSeniUkir;
import Akun.AkunSeniman.RiwayatTransaksiSeniman;
import Akun.AkunSeniman.DataSeniman.DataSeniman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginAkun {

    // Property
    static Connection Conn;
    static Statement Stmt;
    static ResultSet Rs;
    
    public int IdLogin;

    static InputStreamReader InputStreamReader = new InputStreamReader(System.in);
    static BufferedReader Input = new BufferedReader(InputStreamReader);

    // Setter & Getter
    public int getIdLogin() {
        return IdLogin;
    }

    public void setIdLogin(int IdLogin) {
        this.IdLogin = IdLogin;
    }

    public void Login(Statement Stmt) throws IOException, SQLException {
        Conn = Koneksi.koneksi.getConnection();
        Stmt = Conn.createStatement();
        Akun AKN = new Akun(null, null, null);

        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
            
        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainLogin();

            // Username Tidak Boleh Kosong
            do{
                System.out.print("Masukkan Username           : ");
                AKN.setUsername(Input.readLine());

                if (AKN.getUsername().length() < 1) {
                    DSG.MsgUsernameIsEmpty();
                }else if (AKN.getUsername().trim().isEmpty()) {
                    DSG.MsgUsernameIsEmpty();
                }

            }while(AKN.getUsername().length() < 1 || AKN.getUsername().trim().isEmpty());

            
            // Password Tidak Boleh Kosong
            do{
                // Masking Password
                EraserThread td = new EraserThread("Masukkan Password           :  ");
                Thread thread = new Thread(td);
                thread.start();
                AKN.setPassword(Input.readLine());

                if (AKN.getPassword().length() < 1) {
                    DSG.MsgPasswordIsEmpty();
                }else if (AKN.getPassword().trim().isEmpty()) {
                    DSG.MsgPasswordIsEmpty();
                }

                td.maskEnd();
            }while(AKN.getPassword().length() < 1 || AKN.getPassword().trim().isEmpty());

            // Query Select
            String SqlAuthenticate = "SELECT * FROM DataAkun WHERE Username='%s' AND Password='%s'";
            SqlAuthenticate = String.format(SqlAuthenticate, AKN.getUsername(), AKN.getPassword());
            
            // Eksekusi
            ResultSet Rs = Stmt.executeQuery(SqlAuthenticate);

            if (Rs.next()) {
                Boolean Stop = false;
                int IdAkun = Rs.getInt("IdAkun");
                String GetUsername = Rs.getString("Username");
                String Role = Rs.getString("StatusAkun");
                
                while (Stop == false){

                    if (Role.equals("ADMIN") && AKN.getUsername().equals(GetUsername)) {
                        DSG.ClrScreen();
                        DSG.Header();

                        Admin.setStmt(Stmt);
                        Seniman.setStmt(Stmt);
                        Pengguna.setStmt(Stmt);
                        StatistikPenjualan.setStmt(Stmt);
                        
                        Seniman AKNSEN = new Seniman(null, null, null, 0, null);
                        Admin AKNADM = new Admin(null, null, null, 0, null);
                        Pengguna PGN = new Pengguna();
                        StatistikPenjualan STSTK = new StatistikPenjualan();

                        DSG.DesainMenuAdmin();

                        try {  
                            int Chs = Integer.parseInt(Input.readLine());
                            switch(Chs){
                                case 1:
                                    AKNADM.ShowAkunAdmin(IdAkun);
                                    break;
                                case 2:
                                    AKNSEN.MenuAkunSeniman();
                                    break;
                                case 3:
                                    try {
                                        // Query Select
                                        String Sql = "SELECT * FROM dataakun WHERE StatusAkun = 'USER'";
                
                                        // Eksekusi
                                        Rs = Stmt.executeQuery(Sql);
                
                                        if (!Rs.next()){
                                            DSG.ClrScreen();
                                            System.out.println("Data Kosong");
                                            DSG.Press();
                                        }else{
                                            PGN.ShowAkunPengguna();
                                        }
                
                                    } catch (SQLException Error) {
                                        Error.printStackTrace();
                                    }
                                    break;
                                case 4:
                                    try {
                                        // Query Select
                                        String Sql = "SELECT * FROM DataTransaksi";
                
                                        // Eksekusi
                                        Rs = Stmt.executeQuery(Sql);
                
                                        if (!Rs.next()){
                                            DSG.ClrScreen();
                                            DSG.Header();
                                            MSG.DesainNotStatistik();
                                            DSG.Press();
                                        }else{
                                            STSTK.ShowStatistikPenjualan();
                                        }
                
                                    } catch (SQLException Error) {
                                        Error.printStackTrace();
                                    }
                                    break;
                                case 0:
                                    Stop = true;
                                    break;
                                default:
                                    MSG.MsgIsntAny();
                                    DSG.Press();
                                    break;
                            }
                            DSG.ClrScreen();
                        } catch (NumberFormatException Error) {
                            DSG.MsgInputNotNumber();
                            DSG.Press();
                        }
                        
                    } 
                    else if (Role.equals("SENIMAN") && AKN.getUsername().equals(GetUsername)){
                        DSG.ClrScreen();
                        DSG.Header();

                        ManageSeniLukisan.setStmt(Stmt);
                        ManageSeniPatung.setStmt(Stmt);
                        ManageSeniUkir.setStmt(Stmt);
                        DataSeniman.setStmt(Stmt);
                        RiwayatTransaksiSeniman.setStmt(Stmt);
                        
                        ManageSeniLukisan MngLks = new ManageSeniLukisan();
                        ManageSeniPatung MngPt = new ManageSeniPatung();
                        ManageSeniUkir MngUkr = new ManageSeniUkir();
                        DataSeniman DtSnm = new DataSeniman();
                        RiwayatTransaksiSeniman RWYTSN = new RiwayatTransaksiSeniman(0, 0, 0, 0, null, null, null, null, null, null);
                    
                        DSG.DesainMenuSeniman();
                        try {  
                            int Chs = Integer.parseInt(Input.readLine());
                            switch(Chs){
                                case 1:
                                    DtSnm.ShowAkunSeniman(IdAkun);
                                    break;
                                case 2:
                                    MngLks.MenuManageLukisan(IdAkun,GetUsername);
                                    break;
                                case 3:
                                    MngPt.MenuManagePatung(IdAkun,GetUsername);
                                    break;
                                case 4:
                                    MngUkr.MenuManageUkir(IdAkun,GetUsername);
                                    break;
                                case 5:
                                    try {
                                        // Query Select
                                        String Sql = "SELECT * FROM DataTransaksi";
                
                                        // Eksekusi
                                        Rs = Stmt.executeQuery(Sql);
                
                                        if (!Rs.next()){
                                            DSG.ClrScreen();
                                            System.out.println("Data Kosong");
                                            DSG.Press();
                                        }else{                                        
                                            RWYTSN.RiwayatTransaksi(IdAkun);
                                        }
                
                                    } catch (SQLException Error) {
                                        Error.printStackTrace();
                                    }
                                    break;
                                case 0:
                                    Stop = true;
                                    break;
                                default:
                                    MSG.MsgIsntAny();
                                    DSG.Press();
                                    break;
                            }
                            DSG.ClrScreen();
                        } catch (NumberFormatException Error) {
                            DSG.MsgInputNotNumber();
                            DSG.Press();
                        }

                    }
                    else if (Role.equals("USER") && AKN.getUsername().equals(GetUsername)){
                        DSG.ClrScreen();
                        DSG.Header();

                        Katalog.setStmt(Stmt);
                        Pesanan.setStmt(Stmt);
                        Transaksi.setStmt(Stmt);
    
                        ManajemenAkun MjAkun = new ManajemenAkun();
                        Katalog KTLG = new Katalog();
                        Pesanan PSN = new Pesanan(0, 0, 0, 0, 0, 0,0, null, null, null);
                        Transaksi Trsk = new Transaksi(0, 0, 0, 0, null, null, null, null, null, null, null, null);
                        
                        DSG.DesainMenuUser();
                        
                        try {  
                            int Chs = Integer.parseInt(Input.readLine());
                            switch(Chs){
                                case 1: 
                                    MjAkun.ShowMenu(IdAkun);
        
                                    if (MjAkun.getCekHapus() == true){
                                        Stop = true;
                                    }
                                    
                                    break;
                                case 2:
                                    KTLG.ManageKatalog();
                                    break;
                                case 3:
                                    PSN.ManagePesanan(IdAkun);
                                    break;
                                case 4:
                                    Trsk.RiwayatTransaksi(IdAkun);
                                    break;
                                case 0:
                                    Stop = true;
                                    break;
                                default:
                                    MSG.MsgIsntAny();
                                    DSG.Press();
                                    break;
                            }
                            DSG.ClrScreen();
                        } catch (NumberFormatException Error) {
                            DSG.MsgInputNotNumber();
                            DSG.Press();
                        }

                    }
                    else {
                        MSG.MsgNotLogin();
                        DSG.Press();
                        Stop = true;
                    }
                }
            } else {
                MSG.MsgNotLogin();
                DSG.Press();
            }
            DSG.ClrScreen();
        } catch (SQLException error) {
            error.printStackTrace();
        } 
    }
}
