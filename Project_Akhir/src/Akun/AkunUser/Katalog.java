package Akun.AkunUser;

import Akun.AkunSeniman.KaryaSeni.SeniLukisan;
import Akun.AkunSeniman.KaryaSeni.SeniPatung;
import Akun.AkunSeniman.KaryaSeni.SeniUkir;
import MessageAndDesaign.MessageAndDesaign;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Katalog {

    // Property
    static Statement Stmt;
    static ResultSet Rs;

    static BufferedReader Input = new BufferedReader (new InputStreamReader (System.in)); 

    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        Katalog.Stmt = Stmt;
    }

    // Prosedur
    public void BiografiLukisan() {
        SeniLukisan KRYSN = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
        MessageAndDesaign DSG = new MessageAndDesaign();

        try { 
            DSG.PilihKaryaSeni();
            
            try {  
                int IdLks = Integer.parseInt(Input.readLine());
                DSG.ClrScreen();
                DSG.Header();

                // Query Select
                String Sql = "SELECT * FROM datasenilukisan WHERE IdLukisan =" + IdLks;
    
                // Eksekusi
                Rs = Stmt.executeQuery(Sql);
        
                if (Rs.next()) { // Memeriksa apakah result set tidak kosong
    
                    DSG.DesainBiografi();
                    int IdLukisan = Rs.getInt("IdLukisan");
                    int IdSeniman = Rs.getInt("IdSeniman");
                    String Seniman = Rs.getString("Seniman");
                    String Nama = Rs.getString("Nama");
                    String Teknik = Rs.getString("Teknik");
                    String Aliran = Rs.getString("Aliran");
                    String TahunPublikasi = Rs.getString("TahunPublikasi");
                    int Harga = Rs.getInt("Harga");
                    int Panjang = Rs.getInt("Panjang");
                    int Lebar = Rs.getInt("Lebar");
                    System.out.println(String.format("\n                                                               Id Lukisan      : %s%s", KRYSN.getKode(), IdLukisan));
                    System.out.println(String.format("                                                               Id Seniman      : %s", IdSeniman));
                    System.out.println(String.format("                                                               Seniman         : %s", Seniman));
                    System.out.println(String.format("                                                               Nama            : %s", Nama));
                    System.out.println(String.format("                                                               Teknik          : %s", Teknik));
                    System.out.println(String.format("                                                               Aliran          : %s", Aliran));
                    System.out.println(String.format("                                                               Tahun Publikasi : %s", TahunPublikasi));
                    System.out.println(String.format("                                                               Harga           : %s", Harga));
                    System.out.println(String.format("                                                               Panjang         : %s", Panjang));
                    System.out.println(String.format("                                                               Lebar           : %s", Lebar));
                    DSG.Press();
                } else {
                    DSG.ClrScreen();
                    DSG.Header();
                    DSG.DesainNotFind();
                    DSG.Press();
                }
            } catch (NumberFormatException Error) {
                DSG.MsgInputNotNumber();
                DSG.Press();
            }

        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    public void BiografiPatung() {
        SeniPatung KRYSN = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();

        try { 
            DSG.PilihKaryaSeni();

            try {  
                int IdPt = Integer.parseInt(Input.readLine());
    
                DSG.ClrScreen();
                DSG.Header();
                // Query Select
                String Sql = "SELECT * FROM datasenipatung WHERE Idpatung =" + IdPt;
                
                // Eksekusi
                Rs = Stmt.executeQuery(Sql);
        
                if (Rs.next()) { // Memeriksa apakah result set tidak kosong
                    DSG.DesainBiografi();
                    int IdPatung = Rs.getInt("IdPatung");
                    int IdSeniman = Rs.getInt("IdSeniman");
                    String Seniman = Rs.getString("Seniman");
                    String Nama = Rs.getString("Nama");
                    String Jenis = Rs.getString("Jenis");
                    String TahunPublikasi = Rs.getString("TahunPublikasi");
                    int Harga = Rs.getInt("Harga");
                    int Panjang = Rs.getInt("Panjang");
                    int Lebar = Rs.getInt("Lebar");
                    int Tinggi = Rs.getInt("Tinggi");
                    
                    System.out.println(String.format("\n                                                               Id Patung       : %s%s",KRYSN.getKode(), IdPatung));
                    System.out.println(String.format("                                                               Id Seniman      : %s",IdSeniman));
                    System.out.println(String.format("                                                               Seniman         : %s",Seniman));
                    System.out.println(String.format("                                                               Nama            : %s",Nama));
                    System.out.println(String.format("                                                               Jenis           : %s",Jenis));
                    System.out.println(String.format("                                                               Tahun Publikasi : %s",TahunPublikasi));
                    System.out.println(String.format("                                                               Harga           : %s",Harga));
                    System.out.println(String.format("                                                               Panjang         : %s",Panjang));
                    System.out.println(String.format("                                                               Lebar           : %s",Lebar));  
                    System.out.println(String.format("                                                               Tinggi          : %s",Tinggi));   
                    DSG.Press();
                } else {
                    DSG.ClrScreen();
                    DSG.Header();
                    DSG.DesainNotFind();
                    DSG.Press();
                }
            } catch (NumberFormatException Error) {
                DSG.MsgInputNotNumber();
                DSG.Press();
            }
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    public void BiografiUkir() {
        SeniPatung KRYSN = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();

        try { 
            DSG.PilihKaryaSeni();

            try {  
                int IdUkr = Integer.parseInt(Input.readLine());
    
                DSG.ClrScreen();
                DSG.Header();
                // Query Select
                String Sql = "SELECT * FROM dataseniukir WHERE IdUkir =" + IdUkr;
    
                // Eksekusi
                Rs = Stmt.executeQuery(Sql);
        
                if (Rs.next()) { // Memeriksa apakah result set tidak kosong
                    DSG.DesainBiografi();
                    int IdUkir = Rs.getInt("IdUkir");
                    int IdSeniman = Rs.getInt("IdSeniman");
                    String Seniman = Rs.getString("Seniman");
                    String Nama = Rs.getString("Nama");
                    String Motif = Rs.getString("Motif");
                    String TahunPublikasi = Rs.getString("TahunPublikasi");
                    int Harga = Rs.getInt("Harga");
                    int Panjang = Rs.getInt("Panjang");
                    int Lebar = Rs.getInt("Lebar");
                    int Tinggi = Rs.getInt("Tinggi");
                    
                    System.out.println(String.format("\n                                                               Id Patung       : %s%s",KRYSN.getKode(), IdUkir));
                    System.out.println(String.format("                                                               Id Seniman      : %s",IdSeniman));
                    System.out.println(String.format("                                                               Seniman         : %s",Seniman));
                    System.out.println(String.format("                                                               Nama            : %s",Nama));
                    System.out.println(String.format("                                                               Jenis           : %s",Motif));
                    System.out.println(String.format("                                                               Tahun Publikasi : %s",TahunPublikasi));
                    System.out.println(String.format("                                                               Harga           : %s",Harga));
                    System.out.println(String.format("                                                               Panjang         : %s",Panjang));
                    System.out.println(String.format("                                                               Lebar           : %s",Lebar));  
                    System.out.println(String.format("                                                               Tinggi          : %s",Tinggi)); 
                    DSG.Press();
                } else {
                    DSG.ClrScreen();
                    DSG.Header();
                    DSG.DesainNotFind();
                    DSG.Press();
                }
            } catch (NumberFormatException Error) {
                DSG.MsgInputNotNumber();
                DSG.Press();
            }
        } catch (Exception Error) {
            Error.printStackTrace();
        } 
    }

    public void KatalogLukisan() {
        SeniLukisan KRYSN = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        
        try {
            // Query Select
            String Sql = "SELECT * FROM datasenilukisan";

            // Eksekusi
            Rs = Stmt.executeQuery(Sql);

            DSG.DesainShowKatalog();
            while (Rs.next()) {
                KRYSN.setId(Rs.getInt("IdLukisan"));
                KRYSN.setNama(Rs.getString("Nama"));
                KRYSN.setHarga(Rs.getInt("Harga"));

                System.out.println(String.format("                                              | %s%-11s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
                
            }
            DSG.DesainShowKatalog2();
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    public void KatalogPatung() {
        SeniPatung KRYSN = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        
        try { 
            // Query Select
            String Sql = "SELECT * FROM datasenipatung";

            // Eksekusi
            Rs = Stmt.executeQuery(Sql);
            
            DSG.DesainShowKatalog();
            while (Rs.next()) {
                KRYSN.setId(Rs.getInt("IdPatung"));
                KRYSN.setNama(Rs.getString("Nama"));
                KRYSN.setHarga(Rs.getInt("Harga"));

                System.out.println(String.format("                                              | %s%-11s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
                
            }
            DSG.DesainShowKatalog2();
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    public void KatalogUkir() {
        SeniUkir KRYSN = new SeniUkir(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        
        try {
            // Query Select
            String Sql = "SELECT * FROM dataseniukir";

            // Eksekusi
            Rs = Stmt.executeQuery(Sql);

            DSG.DesainShowKatalog();
            while (Rs.next()) {
                KRYSN.setId(Rs.getInt("IdUkir"));
                KRYSN.setNama(Rs.getString("Nama"));
                KRYSN.setHarga(Rs.getInt("Harga"));

                System.out.println(String.format("                                              | %s%-10s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
                
            }
            DSG.DesainShowKatalog2();
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    public void SearchingLukisan() {
        SeniLukisan KRYSN = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
        MessageAndDesaign DSG = new MessageAndDesaign();

        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainCari();
            String Keyword = Input.readLine().toLowerCase();
            
            // Query Select
            String Sql = "SELECT * FROM datasenilukisan " +
                         "WHERE LOWER(Seniman) LIKE '%" + Keyword + "%' OR " +
                               "LOWER(Nama) LIKE '%" + Keyword + "%' OR " +
                               "LOWER(Teknik) LIKE '%" + Keyword + "%' OR " +
                               "LOWER(Aliran) LIKE '%" + Keyword + "%' OR " +
                               "LOWER(TahunPublikasi) LIKE '%" + Keyword + "%' OR " +
                               "Harga LIKE '%" + Keyword + "%' OR " +
                               "Panjang LIKE '%" + Keyword + "%' OR " +
                               "Lebar LIKE '%" + Keyword + "%'";
            
            // Eksekusi
            Rs = Stmt.executeQuery(Sql);
    
            if (Rs.isBeforeFirst()) { // Memeriksa apakah result set tidak kosong
                DSG.DesainShowKatalog();
                while (Rs.next()) {
                    KRYSN.setId(Rs.getInt("IdLukisan"));
                    KRYSN.setNama(Rs.getString("Nama"));
                    KRYSN.setHarga(Rs.getInt("Harga"));
    
                    System.out.println(String.format("                                              | %s%-11s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
                    
                }
                DSG.DesainShowKatalog2();
            } else {
                DSG.DesainNotFind();
            }
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    public void SearchingPatung() {
        SeniPatung KRYSN = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();

        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainCari();
            String Keyword = Input.readLine().toLowerCase();
            
            // Query Select
            String Sql = "SELECT * FROM datasenipatung " +
                         "WHERE LOWER(Seniman) LIKE '%" + Keyword + "%' OR " +
                               "LOWER(Nama) LIKE '%" + Keyword + "%' OR " +
                               "LOWER(Jenis) LIKE '%" + Keyword + "%' OR " +
                               "LOWER(TahunPublikasi) LIKE '%" + Keyword + "%' OR " +
                               "Harga LIKE '%" + Keyword + "%' OR " +
                               "Panjang LIKE '%" + Keyword + "%' OR " +
                               "Lebar LIKE '%" + Keyword + "%' OR " +
                               "Tinggi LIKE '%" + Keyword + "%'";
            
            // Eksekusi
            Rs = Stmt.executeQuery(Sql);
    
            if (Rs.isBeforeFirst()) { // Memeriksa apakah result set tidak kosong
                DSG.DesainShowKatalog();
                while (Rs.next()) {
                    KRYSN.setId(Rs.getInt("IdPatung"));
                    KRYSN.setNama(Rs.getString("Nama"));
                    KRYSN.setHarga(Rs.getInt("Harga"));
    
                    System.out.println(String.format("                                              | %s%-11s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
                    
                }
                DSG.DesainShowKatalog2();
            } else {
                DSG.DesainNotFind();
            }
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    public void SearchingUkir() {
        SeniUkir KRYSN = new SeniUkir(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();

        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainCari();
            String Keyword = Input.readLine().toLowerCase();
    
            // Query Select
            String sql = "SELECT * FROM dataseniukir " +
                         "WHERE LOWER(Seniman) LIKE '%" + Keyword + "%' OR " +
                               "LOWER(Nama) LIKE '%" + Keyword + "%' OR " +
                               "LOWER(Motif) LIKE '%" + Keyword + "%' OR " +
                               "LOWER(TahunPublikasi) LIKE '%" + Keyword + "%' OR " +
                               "Harga LIKE '%" + Keyword + "%' OR " +
                               "Panjang LIKE '%" + Keyword + "%' OR " +
                               "Lebar LIKE '%" + Keyword + "%' OR " +
                               "Tinggi LIKE '%" + Keyword + "%'";
            // Eksekusi
            Rs = Stmt.executeQuery(sql);
    
            if (Rs.isBeforeFirst()) { // Memeriksa apakah result set tidak kosong
                DSG.DesainShowKatalog();
                while (Rs.next()) {
                    KRYSN.setId(Rs.getInt("IdUkir"));
                    KRYSN.setNama(Rs.getString("Nama"));
                    KRYSN.setHarga(Rs.getInt("Harga"));
    
                    System.out.println(String.format("                                              | %s%-10s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
                    
                }
                DSG.DesainShowKatalog2();
            } else {
                DSG.DesainNotFind();
            }
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }
    
    public void ManageKatalog() throws IOException {
        User USR = new User(null, null, null, 0, null) {};
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        Boolean Stop = false;
        Boolean Back = false;

        while (Stop == false){
            Back = false;
            Stop = false;

            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainMenuKaryaSeni();

            try {  
                int Chs = Integer.parseInt(Input.readLine());
                
                // Kode Kembali Katalog
                do{
                    switch(Chs){
                        case 1:
                            
                            try {
                                // Eksekusi query untuk mengambil jumlah baris dari tabel DataSeniLukisan
                                ResultSet Rs1 = Stmt.executeQuery("SELECT COUNT(*) AS Count FROM DataSeniLukisan");
                                Rs1.next();
                                int CountDataLKS = Rs1.getInt("Count");
        
                                // Eksekusi query untuk mengambil jumlah baris dari tabel DataSeniPatunh
                                ResultSet Rs2 = Stmt.executeQuery("SELECT COUNT(*) AS Count FROM DataSeniPatung");
                                Rs2.next();
                                int CountDataPTG = Rs2.getInt("Count");
        
                                // Eksekusi query untuk mengambil jumlah baris dari tabel DataSeniUkir
                                ResultSet Rs3 = Stmt.executeQuery("SELECT COUNT(*) AS Count FROM DataSeniUkir");
                                Rs3.next();
                                int CountDataUKR = Rs3.getInt("Count");
    
                                if (CountDataLKS == 0 && CountDataPTG == 0 && CountDataUKR == 0){
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    MSG.DesainDataEmpty();
                                    DSG.Press();
                                    Back = true;
                                }
                                else if (CountDataLKS == 0 && CountDataPTG == 0){
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    DSG.DesainMenuKatalog();
                                    USR.DataSeni("Katalog Ukir");
                                    DSG.Press();
                                    Back = true;
                                } 
                                else if (CountDataLKS == 0 && CountDataUKR == 0){
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    DSG.DesainMenuKatalog();
                                    USR.DataSeni("Katalog Patung");
                                    DSG.Press();
                                    Back = true;
                                } 
                                else if (CountDataPTG == 0 && CountDataUKR == 0){
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    DSG.DesainMenuKatalog();
                                    USR.DataSeni("Katalog Lukisan");
                                    DSG.Press();
                                    Back = true;
                                } 
                                else if (CountDataLKS == 0){
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    DSG.DesainMenuKatalog();
                                    USR.DataSeni("Katalog Patung");
                                    USR.DataSeni("Katalog Ukir");
                                    DSG.Press();
                                    Back = true;
                                }
                                else if (CountDataPTG == 0){
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    DSG.DesainMenuKatalog();
                                    USR.DataSeni("Katalog Lukisan");
                                    USR.DataSeni("Katalog Ukir");
                                    DSG.Press();
                                    Back = true;
                                }  
                                else if (CountDataUKR == 0){
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    DSG.DesainMenuKatalog();
                                    USR.DataSeni("Katalog Lukisan");
                                    USR.DataSeni("Katalog Patung");
                                    DSG.Press();
                                    Back = true;
                                } 
                                else{
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    DSG.DesainMenuKatalog();
                                    USR.DataSeni("Katalog Lukisan");
                                    USR.DataSeni("Katalog Patung");
                                    USR.DataSeni("Katalog Ukir");
                                    DSG.Press();
                                    Back = true;
                                }
                                
                            } catch (Exception Error) {
                                Error.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                // Query Select
                                String Sql = "SELECT * FROM DataSeniLukisan";
    
                                // Eksekusi
                                Rs = Stmt.executeQuery(Sql);
    
                                if (!Rs.next()){
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    MSG.DesainDataEmpty();
                                    DSG.Press();
                                    Back = true;
                                }else{
                                    try {
                                        DSG.ClrScreen();
                                        DSG.Header();
                                        DSG.DesainKatalogLukisan();
                                        USR.DataSeni("Katalog Lukisan");
                    
                                        DSG.DesainMenuKatalog2();
                                        int Chs2 = Integer.parseInt(Input.readLine());
                                        switch(Chs2){
                                            case 1:
                                                USR.SearchingDataSeni("Searching Lukisan");
                                                Back = false;
                                                DSG.Press();
                                                break;
                                            case 2:
                                                USR.DataSeni(1);
                                                Back = false;
                                                break;
                                            case 0:
                                                Back = true;
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
    
                            } catch (SQLException Error) {
                                Error.printStackTrace();
                            }
                            break;
                        case 3:
                            try {
                                // Query Select
                                String Sql = "SELECT * FROM DataSeniPatung";
    
                                // Eksekusi
                                Rs = Stmt.executeQuery(Sql);
    
                                if (!Rs.next()){
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    MSG.DesainDataEmpty();
                                    DSG.Press();
                                    Back = true;
                                }else{
                                    try {  
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    DSG.DesainKatalogPatung();
                                    USR.DataSeni("Katalog Patung");
                
                                    DSG.DesainMenuKatalog2();
                                        int Chs3 = Integer.parseInt(Input.readLine());
                                        switch(Chs3){
                                            case 1:
                                                USR.SearchingDataSeni("Searching Patung");
                                                Back = false;
                                                DSG.Press();
                                                break;
                                            case 2:
                                                USR.DataSeni(2);
                                                Back = false;
                                                break; 
                                            case 0:
                                                Back = true;
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
                            } catch (SQLException Error) {
                                Error.printStackTrace();
                            }
                            break;
                        case 4:
                            try {
                                // Query Select
                                String Sql = "SELECT * FROM DataSeniUkir";
    
                                // Eksekusi
                                Rs = Stmt.executeQuery(Sql);
                                
                                if (!Rs.next()){
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    MSG.DesainDataEmpty();
                                    DSG.Press();
                                    Back = true;
                                }else{
                                    DSG.ClrScreen();
                                    DSG.Header();
                                    DSG.DesainKatalogUkir();
                                    USR.DataSeni("Katalog Ukir");
                
                                    DSG.DesainMenuKatalog2();
                                    try {  
                                        int Chs4 = Integer.parseInt(Input.readLine());
                                        switch(Chs4){
                                            case 1:
                                                USR.SearchingDataSeni("Searching Ukir");
                                                Back = false;
                                                DSG.Press();
                                                break;
                                            case 2:
                                                USR.DataSeni(3);
                                                Back = false;
                                                break;
                                            case 0:
                                                Back = true;
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
                            } catch (SQLException Error) {
                                Error.printStackTrace();
                            }
                            break;
                        case 0:
                            Back = true;
                            Stop = true;
                            break;
                        default:
                            MSG.MsgIsntAny();
                            DSG.Press();
                            Back = true;
                            break;
                    }
                }while(Back == false);
            } catch (NumberFormatException Error) {
                DSG.MsgInputNotNumber();
                DSG.Press();
            }
            
        }
    }
}