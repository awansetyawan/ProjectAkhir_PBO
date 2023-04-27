package Main;

import Akun.AkunUser.*;
import Login.LoginAkun;
import MessageAndDesaign.MessageAndDesaign;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

public class Main {
    
    static Connection Conn;
    static Statement Stmt;
    
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader Input = new BufferedReader(inputStreamReader);

    public static void main(String[] args) {
        try{
            Conn = Koneksi.koneksi.getConnection();
            Stmt = Conn.createStatement();
            
            User USR = new User(null, null, null, 0, null) {};
            LoginAkun LGN = new LoginAkun();
            MessageAndDesaign DSG = new MessageAndDesaign();
            MessageAndDesaign MSG = new MessageAndDesaign();
            
            User.setStmt(Stmt);
           
            while (!Conn.isClosed()) {
                DSG.ClrScreen();
                DSG.Header();
                DSG.DesainMenuUtama();
                try {  
                    int Chs = Integer.parseInt(Input.readLine());
                    switch(Chs){
                        case 1:
                            USR.CreateAkunUser();
                            break;
                        case 2:
                            LGN.Login(Stmt);
                            break;
                        case 0:
                            DSG.ClrScreen();
                            DSG.Header();
                            DSG.MsgExit();
                            System.exit(0);
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
            Stmt.close();
            Conn.close();
        }catch (Exception Error){
            Error.printStackTrace();
        }
    }
}
