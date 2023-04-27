package Akun.AkunAdmin;

import Akun.Akun;
import MessageAndDesaign.MessageAndDesaign;
import Akun.AkunAdmin.Interface.IfaceManageAkunSeniman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

public class Seniman extends Akun implements IfaceManageAkunSeniman{
    
    // Property
    static Statement Stmt;
    static ResultSet Rs;
    public int IdAkun;
    public String NoRek;
    public final String Status = "SENIMAN";
    static Connection Conn;

    Pattern PolaHuruf = Pattern.compile("[a-zA-Z ]+");
    
    static BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
    
    // Constructor
    public Seniman(String username, String password, String namaLengkap, int idAkun, String noRek) {
        super(username, password, namaLengkap);
        this.IdAkun = idAkun;
        this.NoRek = noRek;
    }

    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        Seniman.Stmt = Stmt;
    }
        
    public int getIdAkun() {
        return IdAkun;
    }

    public void setIdAkun(int idAkun) {
        this.IdAkun = idAkun;
    }

    public String getNoRek() {
        return NoRek;
    }

    public void setNoRek(String noRek) {
        this.NoRek = noRek;
    }

    public String getStatus() {
        return Status;
    }

    // Implements Interface
    @Override
    public void CreateAkunSeniman() throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        Pattern PolaAngka = Pattern.compile("[0-9]+");
        boolean Repeat = true;

        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainCreateAkunSeniman();
            
            // Nama Lengkap Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
            do{
                System.out.print("Masukkan Nama Lengkap       : ");
                this.NamaLengkap = Input.readLine();
                
                if (this.NamaLengkap.length() < 1) {
                    DSG.MsgNamaIsEmpty();
                }else if (!PolaHuruf.matcher(this.NamaLengkap).matches()) {
                    DSG.MsgNamaNotAlfabet();
                }else if (this.NamaLengkap.trim().isEmpty()) {
                    DSG.MsgNamaIsEmpty();
                }

            }while(this.NamaLengkap.length() < 1||!PolaHuruf.matcher(this.NamaLengkap).matches()|| this.NamaLengkap.trim().isEmpty());

            do{

                // Username Tidak Boleh Kosong
                do{
                    System.out.print("Masukkan Username           : ");
                    this.Username = Input.readLine();

                    if (this.Username.length() < 1) {
                        MSG.MsgUsernameIsEmpty();
                    }else if (this.Username.trim().isEmpty()) {
                        MSG.MsgUsernameIsEmpty();
                    }

                }while(this.Username.length() < 1 || this.Username.trim().isEmpty());

                // Query Select
                String CheckSql = "SELECT COUNT(*) FROM DataAkun WHERE Username = '%s'";
                CheckSql = String.format(CheckSql, this.Username);

                // Eksekusi
                ResultSet Rs = Stmt.executeQuery(CheckSql);
                Rs.next();
                int Count = Rs.getInt(1);

                if (Count > 0) {
                    MSG.MsgUsernameAlready();
                    Repeat = true;
                } else {
                    Repeat = false;
                }
            } while (Repeat == true);

            // Password Tidak Boleh Kosong
            do{
                System.out.print("Masukkan Password           : ");
                this.Password = Input.readLine();

                if (this.Password.length() < 1) {
                    MSG.MsgPasswordIsEmpty();
                }else if (this.Password.trim().isEmpty()) {
                    MSG.MsgPasswordIsEmpty();
                }

            }while(this.Password.length() < 1 || this.Password.trim().isEmpty());

            // Nomor Rekening Tidak Boleh Kosong
            do{
                System.out.print("Masukkan Nomor Rekening     : ");
                this.NoRek = Input.readLine();

                if (this.NoRek.trim().isEmpty()) {
                    MSG.MsgNoRekIsEmpty();
                }else if(!PolaAngka.matcher(this.NoRek).matches()) {
                    MSG.MsgNotNumberNoRek();
                }
                else if (this.NoRek.length()  < 10) {
                    MSG.MsgNoRekDigitMinimal();
                }
                
            }while(this.NoRek.length() < 10 ||!PolaAngka.matcher(this.NoRek).matches() || this.NoRek.trim().isEmpty());


            // Query Simpan
            String Sql = "INSERT INTO DataAkun (Nama, Username, Password, NoRek, StatusAkun) VALUE('%s', '%s', '%s', '%s', '%s')";
            Sql = String.format(Sql, this.NamaLengkap, this.Username, this.Password, this.NoRek, Status); 
            
            // Eksekusi
            Stmt.execute(Sql);
            MSG.MsgBerhasilTambahSeniman();
            DSG.Press();

        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }

    @Override
    public void ShowAkunSeniman() throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();

        try {         
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainShowAkunSeniman();
            
            // Query Select
            String Sql = "SELECT * FROM dataakun WHERE StatusAkun = 'SENIMAN'";
            
            // Eksekusi
            Rs = Stmt.executeQuery(Sql);

            while (Rs.next()) {
                this.IdAkun = Rs.getInt("IdAkun");
                this.NamaLengkap = Rs.getString("Nama");
                this.Username = Rs.getString("Username");
                this.NoRek = Rs.getString("NoRek");

                System.out.println(String.format("                                   | %-12s | %-19s | %-20s | %-19s |", "" + this.IdAkun, this.NamaLengkap, this.Username, this.NoRek));
            
            }
            DSG.DesainShowAkunSeniman2();
            DSG.Press();

        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    @Override
    public void UpdateAkunSeniman() throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        Pattern PolaAngka = Pattern.compile("[0-9]+");

        Boolean Stop = false;

        try {
            while (Stop == false){
                ShowAkunSeniman();
                DSG.DesainUpdateAkun();
                DSG.DesainIdAkun();

                try {  
                    this.IdAkun = Integer.parseInt(Input.readLine());
    
                    // Query Select
                    String SqlPilih = "SELECT * FROM dataakun WHERE StatusAkun = 'SENIMAN' and IdAkun = " + this.IdAkun;
                    // Eksekusi
                    Rs = Stmt.executeQuery(SqlPilih);
    
                    if (Rs.next()) {
                        DSG.ClrScreen();
                        DSG.Header();
    
                        DSG.DesainShowAkunSeniman();
                        this.IdAkun = Rs.getInt("IdAkun");
                        this.NamaLengkap = Rs.getString("Nama");
                        this.Username = Rs.getString("Username");
                        this.NoRek = Rs.getString("NoRek");
    
                        System.out.println(String.format("                                   | %-12s | %-19s | %-20s | %-19s |", "" + this.IdAkun, this.NamaLengkap, this.Username, this.NoRek));
                        DSG.DesainShowAkunSeniman2(); 
                        DSG.DesainMenuEditSeniman();
                        
                        try {  
    
                            int Chs = Integer.parseInt(Input.readLine());
        
                            DSG.ClrScreen();
                            DSG.Header();
                            
                            switch(Chs){
                                case 1:
                                    System.out.println((char)27 +  "[05;36m\nUpdate Nama Lengkap Seniman " + (char)27 + "[00;00m");
                                    System.out.println("..................................");
        
                                    // Nama Lengkap Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
                                    do{
                                        System.out.print("\nMasukkan Nama Lengkap Baru       : ");
                                        this.NamaLengkap = Input.readLine();
                                        
                                        if (this.NamaLengkap.length() < 1) {
                                            MSG.MsgNamaIsEmpty();
                                        }else if (!PolaHuruf.matcher(this.NamaLengkap).matches()) {
                                            MSG.MsgNamaNotAlfabet();
                                        }else if (this.NamaLengkap.trim().isEmpty()) {
                                            MSG.MsgNamaIsEmpty();
                                        }
        
                                    }while(this.NamaLengkap.length() < 1||!PolaHuruf.matcher(this.NamaLengkap).matches()|| this.NamaLengkap.trim().isEmpty());
        
                                    // Query Update
                                    String SqlNama = "UPDATE DataAkun SET Nama = '%s' WHERE IdAkun='%d'";
                                    SqlNama = String.format(SqlNama, this.NamaLengkap, this.IdAkun);
        
                                    // Eksekusi
                                    Stmt.execute(SqlNama);
                                    MSG.MsgBerhasilEditSeniman();
                                    DSG.Press();
                                    Stop = true;
                                    break;
                                case 2:
                                    System.out.println((char)27 +  "[05;36m\nUpdate Password Seniman " + (char)27 + "[00;00m");
                                    System.out.println("..................................");
        
                                    // Password Tidak Boleh Kosong
                                    do{
                                        System.out.print("\nMasukkan Password Baru           : ");
                                        this.Password = Input.readLine();
        
                                        if (this.Password.length() < 1) {
                                            MSG.MsgPasswordIsEmpty();
                                        }else if (this.Password.trim().isEmpty()) {
                                            MSG.MsgPasswordIsEmpty();
                                        }
        
                                    }while(this.Password.length() < 1 || this.Password.trim().isEmpty());
        
                                    // Query Update
                                    String SqlPassword = "UPDATE DataAkun SET Password = '%s' WHERE IdAkun='%d'";
                                    SqlPassword = String.format(SqlPassword, this.Password, this.IdAkun);
        
                                    // Eksekusi
                                    Stmt.execute(SqlPassword);
                                    MSG.MsgBerhasilEditSeniman();
                                    DSG.Press();
                                    Stop = true;
                                    break;
                                case 3:
                                    System.out.println((char)27 +  "[05;36m\nUpdate Nomor Rekening Seniman " + (char)27 + "[00;00m");
                                    System.out.println("..................................");
        
                                    // Nomor Rekening Tidak Boleh Kosong
                                    do{
                                        System.out.print("\nMasukkan Nomor Rekening Baru     : ");
                                        this.NoRek = Input.readLine();
                        
                                        if (this.NoRek.trim().isEmpty()) {
                                            MSG.MsgNoRekIsEmpty();
                                        }else if(!PolaAngka.matcher(this.NoRek).matches()) {
                                            MSG.MsgNotNumberNoRek();
                                        }
                                        else if (this.NoRek.length()  < 10) {
                                            MSG.MsgNoRekDigitMinimal();
                                        }
                                        
                                    }while(this.NoRek.length() < 10 ||!PolaAngka.matcher(this.NoRek).matches() || this.NoRek.trim().isEmpty());
        
                                    // Query Update
                                    String SqlNoRek = "UPDATE DataAkun SET NoRek = '%s' WHERE IdAkun='%d'";
                                    SqlNoRek = String.format(SqlNoRek, this.NoRek, this.IdAkun);
        
                                    // Eksekusi
                                    Stmt.execute(SqlNoRek);
                                    MSG.MsgBerhasilEditSeniman();
                                    DSG.Press();
                                    Stop = true;
                                    break;
                                case 0:
                                    Stop = true;
                                    break;
                                default:
                                    MSG.MsgIsntAny();
                                    DSG.Press();
                                    break;
                            }   
                        } catch (NumberFormatException Error) {
                            DSG.MsgInputNotNumber();
                            DSG.Press();
                        }
                        
                    } else {
                        MSG.MsgIdNot();
                        DSG.Press();
                        return;
                    }
                } catch (NumberFormatException Error) {
                    DSG.MsgInputNotNumber();
                    DSG.Press();
                }

            }
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }

    @Override
    public void DeleteAkunSeniman() throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        
        boolean Repeat = true;

        try {
            do{
                ShowAkunSeniman();
                DSG.DesainDeleteAkun();
                DSG.DesainIdAkun();

                try {  
                    this.IdAkun = Integer.parseInt(Input.readLine());
    
                    // Query Select
                    String SqlPilih = "SELECT * FROM dataakun WHERE StatusAkun = 'SENIMAN' and IdAkun = " + this.IdAkun;
                    
                    // Eksekusi
                    Rs = Stmt.executeQuery(SqlPilih);
    
                    if (Rs.next()) {
                        
                        DSG.ClrScreen();
                        DSG.Header();
                        DSG.DesainShowAkunSeniman();

                        this.IdAkun = Rs.getInt("IdAkun");
                        this.NamaLengkap = Rs.getString("Nama");
                        this.Username = Rs.getString("Username");
                        this.NoRek = Rs.getString("NoRek");
    
                        System.out.println(String.format("                                   | %-12s | %-19s | %-20s | %-19s |", "" + this.IdAkun, this.NamaLengkap, this.Username, this.NoRek));
                        DSG.DesainShowAkunSeniman2(); 
    
                        MSG.QuestionDel();
                        String Konfirmasi = Input.readLine();
                        
                        if (Konfirmasi.equals("Y") || Konfirmasi.equals("y")){
                            // Query Delete
                            String Sql = String.format("DELETE FROM DataAkun WHERE IdAkun = %d", this.IdAkun);
                            // Query Delete
                            String SqlDeleTeDataLks = String.format("DELETE FROM DataSeniLukisan WHERE IdSeniman = %d", this.IdAkun);
                            // Query Delete
                            String SqlDeleTeDataPtg = String.format("DELETE FROM DataSeniPatung WHERE IdSeniman = %d", this.IdAkun);
                            // Query Delete
                            String SqlDeleTeDataUkr = String.format("DELETE FROM DataSeniUkir WHERE IdSeniman = %d", this.IdAkun);
                            
                            // Eksekusi 
                            Stmt.execute(Sql);
                            // Eksekusi 
                            Stmt.execute(SqlDeleTeDataLks);
                            // Eksekusi 
                            Stmt.execute(SqlDeleTeDataPtg);
                            // Eksekusi 
                            Stmt.execute(SqlDeleTeDataUkr);
    
                            MSG.MsgBerhasilHapusSeniman();
                            DSG.Press();
                            return;
                        }else{
                            MSG.MsgGagalHapusSeniman();
                            DSG.Press();
                            return;
                        }
                    } else {
                        MSG.MsgIdNot();
                        Repeat = true;
                        DSG.Press();
                        return;
                    }
                } catch (NumberFormatException Error) {
                    DSG.MsgInputNotNumber();
                    DSG.Press();
                }
                
            } while (Repeat == true);
            
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }

    @Override
    public void MenuAkunSeniman() throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();

        Boolean stop = false;

        while (stop == false){
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainMenuAdminSeniman();

            try {  
                int chs = Integer.parseInt(Input.readLine());
                switch(chs){
                    case 1: 
                        CreateAkunSeniman();
                        break;
                    case 2:
                        try {
                            // Query Select
                            String Sql = "SELECT * FROM DataAkun WHERE StatusAkun = 'SENIMAN'";
    
                            // Eksekusi
                            Rs = Stmt.executeQuery(Sql);
    
                            if (!Rs.next()){
                                DSG.ClrScreen();
                                DSG.Header();
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                ShowAkunSeniman();
                            }
    
                        } catch (SQLException Error) {
                            Error.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            // Query Select
                            String Sql = "SELECT * FROM DataAkun WHERE StatusAkun = 'SENIMAN'";
    
                            // Eksekusi
                            Rs = Stmt.executeQuery(Sql);
    
                            if (!Rs.next()){
                                DSG.ClrScreen();
                                DSG.Header();
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                UpdateAkunSeniman();
                            }
    
                        } catch (SQLException Error) {
                            Error.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            // Query Select
                            String Sql = "SELECT * FROM DataAkun WHERE StatusAkun = 'SENIMAN'";
    
                            // Eksekusi
                            Rs = Stmt.executeQuery(Sql);
    
                            if (!Rs.next()){
                                DSG.ClrScreen();
                                DSG.Header();
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                DeleteAkunSeniman();
                            }
    
                        } catch (SQLException Error) {
                            Error.printStackTrace();
                        }
                        break;
                    case 0:
                        stop = true;
                        break;
                    default:
                        MSG.MsgIsntAny();
                        DSG.Press();
                        break;
                }
                } catch (NumberFormatException Error) {
                    DSG.MsgInputNotNumber();
                    DSG.Press();
            }
            
        }
    }
}
