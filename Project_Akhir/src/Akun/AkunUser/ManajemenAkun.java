package Akun.AkunUser;
import Akun.AkunUser.Interface.IfaceManageAkun;
import MessageAndDesaign.MessageAndDesaign;

import static Akun.AkunUser.User.Rs;
import static Akun.AkunUser.User.Stmt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class ManajemenAkun implements IfaceManageAkun {

    // Property
    Boolean CekHapus;

    static BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));

    // Setter & Getter
    public Boolean getCekHapus() {
        return CekHapus;
    }

    public void setCekHapus(Boolean cekHapus) {
        this.CekHapus = cekHapus;
    }

    // Implements Interface
    @Override
    public void UpdateAkunUser(int IdAkun) throws IOException {
        User USR = new User(null, null, null, 0, null);
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        Pattern PolaHuruf = Pattern.compile("[a-zA-Z ]+");
        Boolean Stop = false;
        boolean Repeat = true;

        DSG.Header();
        try {
            while (Stop == false){
                ShowAkunUser(IdAkun);
                DSG.DesainMenuEditUser();

                try {             
                    int chs = Integer.parseInt(Input.readLine());
    
                    DSG.ClrScreen();
                    DSG.Header();
                    switch(chs){
                        case 1:
                            System.out.println((char)27 +  "[05;36m\n        Update Nama Lengkap" + (char)27 + "[00;00m");
                            System.out.println("..................................");
                            
                            // Nama Lengkap Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
                            do{
                                System.out.print("\nMasukkan Nama Lengkap Baru       : ");
                                USR.setNamaLengkap(Input.readLine());
                                
                                if (USR.getNamaLengkap().length() < 1) {
                                    MSG.MsgNamaIsEmpty();
                                }else if (!PolaHuruf.matcher(USR.getNamaLengkap()).matches()) {
                                    MSG.MsgNamaNotAlfabet();
                                }else if (USR.getNamaLengkap().trim().isEmpty()) {
                                    MSG.MsgNamaIsEmpty();
                                }

                            }while(USR.getNamaLengkap().length() < 1||!PolaHuruf.matcher(USR.getNamaLengkap()).matches()|| USR.getNamaLengkap().trim().isEmpty());
    
                            USR.setIdAkun(IdAkun);
    
                            // Query Update
                            String SqlNama = "UPDATE DataAkun SET Nama = '%s'WHERE IdAkun='%d'";
                            SqlNama = String.format(SqlNama, USR.getNamaLengkap(), USR.getIdAkun());
                
                            // Eksekusi
                            Stmt.execute(SqlNama);
                            MSG.MsgBerhasilEditUser();
                            DSG.Press();
                            break;
                        case 2:
                            System.out.println((char)27 +  "[05;36m\n        Update Username" + (char)27 + "[00;00m");
                            System.out.println("..................................");
                            do{ 
                                // Username Tidak Boleh Kosong
                                do{
                                    System.out.print("\nMasukkan Username Baru           : ");
                                    USR.setUsername(Input.readLine());

                                    if (USR.getUsername().length() < 1) {
                                        MSG.MsgUsernameIsEmpty();
                                    }else if (USR.getUsername().trim().isEmpty()) {
                                        MSG.MsgUsernameIsEmpty();
                                    }

                                }while(USR.getUsername().length() < 1 || USR.getUsername().trim().isEmpty());
                
                                // Query Select
                                String CheckSql = "SELECT COUNT(*) FROM DataAkun WHERE Username = '%s'";
                                CheckSql = String.format(CheckSql, USR.getUsername());
                
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
                            USR.setIdAkun(IdAkun);
    
                            // Query Update
                            String SqlUsername = "UPDATE DataAkun SET username = '%s'WHERE IdAkun='%d'";
                            SqlUsername = String.format(SqlUsername, USR.getUsername(), USR.getIdAkun());
                
                            // Eksekusi
                            Stmt.execute(SqlUsername);
                            MSG.MsgBerhasilEditUser();
                            DSG.Press();
                            break;
                        case 3:
                            System.out.println((char)27 +  "[05;36m\n        Update Password" + (char)27 + "[00;00m");
                            System.out.println("..................................");

                            // Password Tidak Boleh Kosong
                            do{
                                System.out.print("Masukkan Password Baru          : ");
                                USR.setPassword(Input.readLine());

                                if (USR.getPassword().length() < 1) {
                                    MSG.MsgPasswordIsEmpty();
                                }else if (USR.getPassword().trim().isEmpty()) {
                                    MSG.MsgPasswordIsEmpty();
                                }

                            }while(USR.getPassword().length() < 1 || USR.getPassword().trim().isEmpty());
                            
                            USR.setIdAkun(IdAkun);
    
                            // Query Update
                            String SqlPassword = "UPDATE DataAkun SET Password = '%s'WHERE IdAkun='%d'";
                            SqlPassword = String.format(SqlPassword, USR.getPassword(), USR.getIdAkun());
                
                            // Eksekusi
                            Stmt.execute(SqlPassword);
                            MSG.MsgBerhasilEditUser();
                            DSG.Press();
                            break;
                        case 0:
                            Stop = true;
                            break;
                        default:
                            ShowAkunUser(IdAkun);
                            DSG.DesainMenuEditUser();
                            System.out.println(" ");
                            MSG.MsgIsntAny();
                            DSG.Press();
                            break;
                    }   
                } catch (NumberFormatException Error) {
                    DSG.MsgInputNotNumber();
                    DSG.Press();
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void DeleteAkunUser(int IdAkun) throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();

        DSG.Header();
        try {
            ShowAkunUser(IdAkun);
            
            MSG.QuestionDel();
            String Konfirmasi = Input.readLine();
            
            if (Konfirmasi.equals("Y") || Konfirmasi.equals("y")){

                // Query Delete
                String Sql = String.format("DELETE FROM dataakun WHERE IdAkun = %d", IdAkun);
                // Query Delete
                String SqlDeleTeDataPsn = String.format("DELETE FROM datapesanan WHERE IdUser = %d", IdAkun);
                
                // Eksekusi
                Stmt.execute(Sql);
                // Eksekusi
                Stmt.execute(SqlDeleTeDataPsn);

                MSG.MsgBerhasilHapusUser();
                setCekHapus(true);
            }else{
                MSG.MsgGagalHapusUser();
                setCekHapus(false);
            }
            
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }

    @Override
    public void ShowAkunUser(int IdAkun) throws IOException {
        User USR = new User(null, null, null, 0, null);
        MessageAndDesaign DSG = new MessageAndDesaign();
        
        try {            
            DSG.ClrScreen();
            DSG.Header();

            // Query Select
            String Sql = "SELECT IdAkun, Nama, Username FROM dataakun WHERE IdAkun = %d";
            Sql = String.format(Sql, IdAkun);

            // Eksekusi
            Rs = Stmt.executeQuery(Sql);
            
            DSG.DesainShowAkunUser();
            if (Rs.next()) {
                USR.setIdAkun(Rs.getInt("IdAkun"));
                USR.setNamaLengkap(Rs.getString("Nama"));
                USR.setUsername(Rs.getString("Username"));

                System.out.println(String.format("                                   | %-12s | %-19s | %-20s | %-19s |", "" + USR.getIdAkun(), USR.getNamaLengkap(), USR.getUsername(), USR.getStatus()));
            }
            DSG.DesainShowAkunUser2();
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    @Override
    public void ShowMenu(int IdAkun) throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        Boolean Stop = false;

        while (Stop == false){
            ShowAkunUser(IdAkun);
            DSG.DesainMenuProfilUser();

            try {  
                int chs2 = Integer.parseInt(Input.readLine());
                switch(chs2){
                    case 1:
                    DSG.ClrScreen();
                        UpdateAkunUser(IdAkun);
                        break;
                    case 2:
                        DSG.ClrScreen();
                        DeleteAkunUser(IdAkun);
    
                        if (CekHapus == true){
                            Stop = true;
                            DSG.Press();
                            break;
                        }
                        DSG.Press();
                        break;
                    case 0:
                        setCekHapus(false);
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
        }
    }

}
