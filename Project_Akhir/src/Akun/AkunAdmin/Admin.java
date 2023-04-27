package Akun.AkunAdmin;

import Akun.Akun;
import Akun.AkunAdmin.Interface.IfaceLihatAkunAdmin;
import MessageAndDesaign.MessageAndDesaign;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin extends Akun implements IfaceLihatAkunAdmin{
    
    // Property
    static Statement Stmt;
    static ResultSet Rs;
    public int IdAkun;
    public String NoRek;
    public final String Status = "ADMIN";

    // Constructor
    public Admin(String username, String password, String namaLengkap, int idAkun, String noRek) {
        super(username, password, namaLengkap);
        this.IdAkun = idAkun;
        this.NoRek = noRek;
    }

    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        Admin.Stmt = Stmt;
    }

    // Implements Interface
    @Override
    public void ShowAkunAdmin(int IdAkun) throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();

        try {     
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainProfil();
            
            // Query Select
            String Sql = "SELECT Nama, Username, NoRek FROM dataakun WHERE IdAkun = %d";
            Sql = String.format(Sql, IdAkun);
            
            // Eksekusi
            Rs = Stmt.executeQuery(Sql);
            
            if (Rs.next()) {
                this.NamaLengkap = Rs.getString("Nama");
                this.Username = Rs.getString("Username");
                this.NoRek = Rs.getString("NoRek");
                
                System.out.println(String.format("Nama Lengkap       : %s", this.NamaLengkap));
                System.out.println(String.format("Username           : %s", this.Username));
                System.out.println(String.format("Status             : %s", this.Status));
                System.out.println(String.format("Nomor Rekening     : %s", this.NoRek));
            }
            DSG.Press();

        } catch (Exception Error) {
            Error.printStackTrace();
        }   
    }
}
