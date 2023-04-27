package Akun.AkunSeniman.DataSeniman;

import Akun.AkunAdmin.Seniman;
import Akun.AkunSeniman.Interface.IfaceDataSeniman;
import MessageAndDesaign.MessageAndDesaign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataSeniman implements IfaceDataSeniman{
    
    // Property
    static Statement Stmt;
    static ResultSet Rs;

    static BufferedReader input = new BufferedReader (new InputStreamReader (System.in)); 
    
    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        DataSeniman.Stmt = Stmt;
    }

    // Implements Interface
    @Override
    public void ShowAkunSeniman(int IdAkun) throws IOException {
        Seniman SNM = new Seniman(null, null, null, 0, null) {};
        MessageAndDesaign DSG = new MessageAndDesaign();

        try {       
            
            // Query Select
            String Sql = "SELECT Nama, Username, NoRek FROM dataakun WHERE IdAkun = %d";
            Sql = String.format(Sql, IdAkun);

            // Eksekusi
            Rs = Stmt.executeQuery(Sql);

            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainProfil();
            
            if (Rs.next()) {
                SNM.setNamaLengkap(Rs.getString("Nama"));
                SNM.setUsername(Rs.getString("Username"));
                SNM.setNoRek(Rs.getString("NoRek"));
                
                System.out.println(String.format("Nama Lengkap       : %s", SNM.getNamaLengkap()));
                System.out.println(String.format("Username           : %s", SNM.getUsername()));
                System.out.println(String.format("Status             : %s", SNM.getStatus()));
                System.out.println(String.format("Nomor Rekening     : %s", SNM.getNoRek()));
                
            }
            DSG.Press();    

        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }
}
