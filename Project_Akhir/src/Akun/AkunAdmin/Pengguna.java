package Akun.AkunAdmin;

import Akun.AkunAdmin.Interface.IfaceLihatDataPengguna;
import MessageAndDesaign.MessageAndDesaign;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.Statement;

public class Pengguna implements IfaceLihatDataPengguna{
    
    // Property
    static Statement Stmt;
    static ResultSet Rs;

    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        Pengguna.Stmt = Stmt;
    }

    // Implements Interface
    @Override
    public void ShowAkunPengguna() throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        
        try {            
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainShowAkunPengguna();

            // Query Select
            String Sql = "SELECT * FROM dataakun WHERE StatusAkun = 'USER'";
           
            // Eksekusi
            Rs = Stmt.executeQuery(Sql);

            while (Rs.next()) {
                int Id = Rs.getInt("IdAkun");
                String NamaLengkap = Rs.getString("Nama");
                String Username = Rs.getString("Username");
                
                System.out.println(String.format("                                             | %-12s | %-19s | %-20s |", "" + Id, NamaLengkap, Username));  
            }
            DSG.DesainShowAkunPengguna2();
            DSG.Press();

        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }
}
