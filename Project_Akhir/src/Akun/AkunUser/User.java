package Akun.AkunUser;
import Akun.*;
import Akun.AkunUser.Interface.IfaceRegisUser;
import MessageAndDesaign.MessageAndDesaign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends Akun implements IfaceRegisUser{
    
    // Property
    static Statement Stmt;
    static ResultSet Rs;

    public int IdAkun;
    public String NoRek;
    public final String Status = "USER";
    
    static BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
    
    // Constructor
    public User(String username, String password, String namaLengkap, int idAkun, String noRek) {
        super(username, password, namaLengkap);
        this.IdAkun = idAkun;
        this.NoRek = noRek;
    }

    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        User.Stmt = Stmt;
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

    @Override
    public void CreateAkunUser() throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        Pattern PolaHuruf = Pattern.compile("[a-zA-Z ]+");
        boolean Repeat = true;

        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainRegistrasi();

            // Nama Lengkap Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
            do{
                System.out.print("Masukkan Nama Lengkap       : ");
                this.NamaLengkap = Input.readLine();
                
                if (this.NamaLengkap.length() < 1) {
                    MSG.MsgNamaIsEmpty();
                }else if (!PolaHuruf.matcher(this.NamaLengkap).matches()) {
                    MSG.MsgNamaNotAlfabet();
                }else if (this.NamaLengkap.trim().isEmpty()) {
                    MSG.MsgNamaIsEmpty();
                }

            }while(this.NamaLengkap.length() < 1||!PolaHuruf.matcher(this.NamaLengkap).matches()|| this.NamaLengkap.trim().isEmpty());
            
            // Mengecek apakah username sudah ada atau tidak
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

            this.NoRek = null;
            
            // Query Simpan
            String sql = "INSERT INTO DataAkun (Nama, Username, Password, NoRek, StatusAkun) VALUE('%s', '%s', '%s', '%s', '%s')";
            sql = String.format(sql, this.NamaLengkap, this.Username, this.Password, this.NoRek, Status);

            // Eksekusi
            Stmt.execute(sql);
            MSG.MsgBerhasilRegisUser();
            DSG.Press();
        } catch (SQLException Error) {
            Error.printStackTrace();
        } 
    }  

    // Overloading Polymorphism
    public void DataSeni(String PilihDataSeni) {
        Katalog KTLG = new Katalog();
        if (PilihDataSeni.equals("Katalog Lukisan")){
            KTLG.KatalogLukisan();
        } else if (PilihDataSeni.equals("Katalog Patung")){
            KTLG.KatalogPatung();
        } else {
            KTLG.KatalogUkir();
        }
    }

    public void DataSeni(int PilihDataSeni) {
        Katalog KTLG = new Katalog();
        if (PilihDataSeni == 1){
            KTLG.BiografiLukisan();
        } else if (PilihDataSeni == 2){
            KTLG.BiografiPatung();
        } else {
            KTLG.BiografiUkir();
        }
    }

    public void SearchingDataSeni(String PilihSearching) {
        Katalog KTLG = new Katalog();
        if (PilihSearching.equals("Searching Lukisan")){
            KTLG.SearchingLukisan();
        } else if (PilihSearching.equals("Searching Patung")){
            KTLG.SearchingPatung();
        } else {
            KTLG.SearchingUkir();
        }
    }
}
