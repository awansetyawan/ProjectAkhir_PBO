package Akun.AkunSeniman.ManajemenGaleri;

import Akun.AkunSeniman.KaryaSeni.KaryaSeni;
import Akun.AkunSeniman.KaryaSeni.SeniUkir;
import MessageAndDesaign.MessageAndDesaign;
import Akun.AkunSeniman.Interface.IfaceManageUkir;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

public class ManageSeniUkir implements IfaceManageUkir{

    // Property
    static Statement Stmt;
    static ResultSet Rs;

    Pattern PolaHuruf = Pattern.compile("[a-zA-Z ]+");
    Pattern PolaAngka = Pattern.compile("[0-9]+");

    MessageAndDesaign DSG = new MessageAndDesaign();

    static BufferedReader Input = new BufferedReader (new InputStreamReader (System.in)); 

    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        ManageSeniUkir.Stmt = Stmt;
    }

    // Implements Interface
    @Override
    public void CreateDataUkir(int IdAkun, String Username) throws IOException {
        KaryaSeni KRY = new SeniUkir(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        SeniUkir KRYSN = new SeniUkir(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        
        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainDelete();
            
            String Seniman = Username;
            KRY.setSeniman(Seniman);
            
            // Nama Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
            do{
                System.out.print("\nMasukkan Nama            : ");
                String Nama = Input.readLine();
                KRY.setNama(Nama);
                
                if (KRY.getNama().length() < 1) {
                    MSG.MsgNamaUkIsEmpty();
                }else if (!PolaHuruf.matcher(KRY.getNama()).matches()) {
                    MSG.MsgNamaUkNotAlfabet();
                }else if (KRY.getNama().trim().isEmpty()) {
                    MSG.MsgNamaUkIsEmpty();
                }

            }while(KRY.getNama().length() < 1||!PolaHuruf.matcher(KRY.getNama()).matches()|| KRY.getNama().trim().isEmpty());
            
            // Motif Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
            do{
                System.out.print("Masukkan Motif           : ");
                String Motif = Input.readLine();
                KRYSN.setMotif(Motif);
                
                if (KRYSN.getMotif().length() < 1) {
                    MSG.MsgMotifUkIsEmpty();
                }else if (!PolaHuruf.matcher(KRYSN.getMotif()).matches()) {
                    MSG.MsgMotifUkNotAlfabet();
                }else if (KRYSN.getMotif().trim().isEmpty()) {
                    MSG.MsgMotifUkIsEmpty();
                }

            }while(KRYSN.getMotif().length() < 1||!PolaHuruf.matcher(KRYSN.getMotif()).matches()|| KRYSN.getMotif().trim().isEmpty());

            // Tahun Publikasi Hanya Boleh Angka serta tidak boleh kosong
            do{
                System.out.print("Masukkan Tahun Publikasi : ");
                String TahunPublikasi = Input.readLine();
                KRY.setTahunPublikasi(TahunPublikasi);
                
                if (KRY.getTahunPublikasi().trim().isEmpty()) {
                    MSG.MsgTahunPublikasiLukIsEmpty();
                } else if (KRY.getTahunPublikasi().length()  > 4 || KRY.getTahunPublikasi().length()  < 4) {
                    MSG.MsgTahunDigitMinimal();
                }else if(!PolaAngka.matcher(KRY.getTahunPublikasi()).matches()) {
                    MSG.MsgTahunPublikasiLukNotAngka();
                }
                
            }while(KRY.getTahunPublikasi().length()  > 4 || KRY.getTahunPublikasi().length()  < 4 ||!PolaAngka.matcher(KRY.getTahunPublikasi()).matches() || KRY.getTahunPublikasi().trim().isEmpty());

            Boolean Ulang = false;
            
            while (Ulang == false){
                try {  
                    System.out.print("Masukkan Harga           : Rp. ");
                    String Cek = Input.readLine();
                    
                    if (Cek.matches("\\d+")) {
                        Ulang = true;
                    }else{
                        throw new NumberFormatException();
                    }

                    int Harga = Integer.parseInt(Cek);
                    KRY.setHarga(Harga);

                } catch (NumberFormatException Error) {
                    Ulang = false;
                    DSG.MsgInputNotNumber();
                }
            }

            Ulang = false;

            while (Ulang == false){
                try {  
                    System.out.print("Masukkan Panjang (CM)    : ");
                    String Cek = Input.readLine();
                    
                    if (Cek.matches("\\d+")) {
                        Ulang = true;
                    }else{
                        throw new NumberFormatException();
                    }

                    int Panjang = Integer.parseInt(Cek);
                    KRY.setPanjang(Panjang);
                    
                } catch (NumberFormatException Error) {
                    Ulang = false;
                    DSG.MsgInputNotNumber();
                }
            }

            Ulang = false;

            while (Ulang == false){
                try {  
                    System.out.print("Masukkan Lebar (CM)      : ");
                    String Cek = Input.readLine();
                    
                    if (Cek.matches("\\d+")) {
                        Ulang = true;
                    }else{
                        throw new NumberFormatException();
                    }

                    int Lebar = Integer.parseInt(Cek);
                    KRY.setLebar(Lebar);
                    
                } catch (NumberFormatException Error) {
                    Ulang = false;
                    DSG.MsgInputNotNumber();
                }
            }

            Ulang = false;

            while (Ulang == false){
                try {  
                    System.out.print("Masukkan Tinggi (CM)     : ");
                    String Cek = Input.readLine();
                    
                    if (Cek.matches("\\d+")) {
                        Ulang = true;
                    }else{
                        throw new NumberFormatException();
                    }

                    int Tinggi = Integer.parseInt(Cek);
                    KRYSN.setTinggi(Tinggi);
                    
                } catch (NumberFormatException Error) {
                    Ulang = false;
                    DSG.MsgInputNotNumber();
                }
            }

            Ulang = false;

            while (Ulang == false){
                try {  
                    System.out.print("Masukkan Stok            : ");
                    String Cek = Input.readLine();
                    
                    if (Cek.matches("\\d+")) {
                        Ulang = true;
                    }else{
                        throw new NumberFormatException();
                    }

                    int Stok = Integer.parseInt(Cek);
                    KRY.setStok(Stok);
                    
                } catch (NumberFormatException Error) {
                    Ulang = false;
                    DSG.MsgInputNotNumber();
                }
            }
            
            // Query Alter Table
            String CekId = String.format("ALTER TABLE DataSeniUkir AUTO_INCREMENT=0");

            // Eksekusi
            Stmt.execute(CekId);

            // Query Simpan
            String Sql = "INSERT INTO DataSeniUkir (IdSeniman, Seniman, Nama, Motif, TahunPublikasi, Harga, Panjang, Lebar, Tinggi, Stok) "
                    + "VALUE('%d', '%s', '%s', '%s', '%s', '%d', '%d', '%d', '%d', '%d')";
            Sql = String.format(Sql, IdAkun, KRY.getSeniman(), KRY.getNama(), KRYSN.getMotif(), KRY.getTahunPublikasi(), KRY.getHarga(), KRY.getPanjang(), KRY.getLebar(), KRYSN.getTinggi(), KRY.getStok());

            // Eksekusi
            Stmt.execute(Sql);
            MSG.MsgBerhasilTambahUkir();
            DSG.Press();
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }

    @Override
    public void ShowDataUkir(int IdAkun, String Username) throws IOException {
        SeniUkir KRYSN = new SeniUkir(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        
        try {
            DSG.ClrScreen();
            DSG.Header();
            // Query Select
            String sql = "SELECT * FROM dataseniukir WHERE IdSeniman ="+ IdAkun;

            // Eksekusi
            Rs = Stmt.executeQuery(sql);

            int i = 1;
            while (Rs.next()) {
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
                int Stok = Rs.getInt("Stok");
                
                System.out.println((char)27 +  "[05;36m  \n                                                ==================== Data Ukir Ke-" + (i++) + " ======================"+ (char)27 + "[00;00m");
                System.out.println(String.format("\n                                                            Id Patung       : %s%s",KRYSN.getKode(), IdUkir));
                System.out.println(String.format("                                                            Id Seniman      : %s",IdSeniman));
                System.out.println(String.format("                                                            Seniman         : %s",Seniman));
                System.out.println(String.format("                                                            Nama            : %s",Nama));
                System.out.println(String.format("                                                            Jenis           : %s",Motif));
                System.out.println(String.format("                                                            Tahun Publikasi : %s",TahunPublikasi));
                System.out.println(String.format("                                                            Harga           : %s",Harga));
                System.out.println(String.format("                                                            Panjang         : %s",Panjang));
                System.out.println(String.format("                                                            Lebar           : %s",Lebar));  
                System.out.println(String.format("                                                            Tinggi          : %s",Tinggi)); 
                System.out.println(String.format("                                                            Stok            : %s",Stok)); 
        } 
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    @Override
    public void UpdateDataUkir(int IdAkun, String Username) throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        KaryaSeni KRY = new SeniUkir(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        SeniUkir KRYSN = new SeniUkir(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        
        try {
            DSG.ClrScreen();
            DSG.Header();
            // Query Select
            String SqlSelect = "SELECT * FROM dataseniukir WHERE IdSeniman ="+ IdAkun;
            
            // Eksekusi
            Rs = Stmt.executeQuery(SqlSelect);
            System.out.println("\n                                                                       DATA UKIR");
            

            DSG.DesainShowKatalog();
                while (Rs.next()) {
                    KRYSN.setId(Rs.getInt("IdUkir"));
                    KRYSN.setNama(Rs.getString("Nama"));
                    KRYSN.setHarga(Rs.getInt("Harga"));
                
                System.out.println(String.format("                                              | %s%-10s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
            }
            DSG.DesainShowKatalog2();
           
            Boolean Ulang = false;
            
            while (Ulang == false){
                try {  
                    DSG.PilihKaryaSeni();
                    String Cek = Input.readLine();
                    
                    if (Cek.matches("\\d+")) {
                        Ulang = true;
                    }else{
                        throw new NumberFormatException();
                    }

                    int Id = Integer.parseInt(Cek);
                    KRYSN.setId(Id);

                } catch (NumberFormatException Error) {
                    Ulang = false;
                    DSG.MsgInputNotNumber();
                    DSG.Press();
                }
            }

            Ulang = false;
            
            // Query Select
            String SqlCek = "SELECT * FROM dataseniukir WHERE IdUkir ="+ KRYSN.getId();

            // Eksekusi
            Rs = Stmt.executeQuery(SqlCek);

            if(Rs.next()){
                DSG.ClrScreen();
                DSG.Header();
                DSG.DesainUpdateUkir();
                // Nama Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
                do{
                    System.out.print("\nMasukkan Nama            : ");
                    String Nama = Input.readLine();
                    KRY.setNama(Nama);
                    
                    if (KRY.getNama().length() < 1) {
                        MSG.MsgNamaUkIsEmpty();
                    }else if (!PolaHuruf.matcher(KRY.getNama()).matches()) {
                        MSG.MsgNamaUkNotAlfabet();
                    }else if (KRY.getNama().trim().isEmpty()) {
                        MSG.MsgNamaUkIsEmpty();
                    }
    
                }while(KRY.getNama().length() < 1||!PolaHuruf.matcher(KRY.getNama()).matches()|| KRY.getNama().trim().isEmpty());
                
                // Motif Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
                do{
                    System.out.print("Masukkan Motif           : ");
                    String Motif = Input.readLine();
                    KRYSN.setMotif(Motif);
                    
                    if (KRYSN.getMotif().length() < 1) {
                        MSG.MsgMotifUkIsEmpty();
                    }else if (!PolaHuruf.matcher(KRYSN.getMotif()).matches()) {
                        MSG.MsgMotifUkNotAlfabet();
                    }else if (KRYSN.getMotif().trim().isEmpty()) {
                        MSG.MsgMotifUkIsEmpty();
                    }
    
                }while(KRYSN.getMotif().length() < 1||!PolaHuruf.matcher(KRYSN.getMotif()).matches()|| KRYSN.getMotif().trim().isEmpty());
    
                // Tahun Publikasi Hanya Boleh Angka serta tidak boleh kosong
                do{
                    System.out.print("Masukkan Tahun Publikasi : ");
                    String TahunPublikasi = Input.readLine();
                    KRY.setTahunPublikasi(TahunPublikasi);
                    
                    if (KRY.getTahunPublikasi().trim().isEmpty()) {
                        MSG.MsgTahunPublikasiLukIsEmpty();
                    } else if (KRY.getTahunPublikasi().length()  > 4 || KRY.getTahunPublikasi().length()  < 4) {
                        MSG.MsgTahunDigitMinimal(); 
                    }else if(!PolaAngka.matcher(KRY.getTahunPublikasi()).matches()) {
                        MSG.MsgTahunPublikasiLukNotAngka();
                    }
                    
                }while(KRY.getTahunPublikasi().length()  > 4 || KRY.getTahunPublikasi().length()  < 4 ||!PolaAngka.matcher(KRY.getTahunPublikasi()).matches() || KRY.getTahunPublikasi().trim().isEmpty());
    
                while (Ulang == false){
                    try {  
                        System.out.print("Masukkan Harga           : Rp. ");
                        String Cek = Input.readLine();
                        
                        if (Cek.matches("\\d+")) {
                            Ulang = true;
                        }else{
                            throw new NumberFormatException();
                        }
    
                        int Harga = Integer.parseInt(Cek);
                        KRY.setHarga(Harga);
    
                    } catch (NumberFormatException Error) {
                        Ulang = false;
                        DSG.MsgInputNotNumber();
                        DSG.Press();
                    }
                }
                
                Ulang = false;

                while (Ulang == false){
                    try {  
                        System.out.print("Masukkan Panjang (CM)    : ");
                        String Cek = Input.readLine();
                        
                        if (Cek.matches("\\d+")) {
                            Ulang = true;
                        }else{
                            throw new NumberFormatException();
                        }

                        int Panjang = Integer.parseInt(Cek);
                        KRY.setPanjang(Panjang);
                        
                    } catch (NumberFormatException Error) {
                        Ulang = false;
                        DSG.MsgInputNotNumber();
                        DSG.Press();
                    }
                }
                
                Ulang = false;

                while (Ulang == false){
                    try {  
                        System.out.print("Masukkan Lebar (CM)      : ");
                        String Cek = Input.readLine();
                        
                        if (Cek.matches("\\d+")) {
                            Ulang = true;
                        }else{
                            throw new NumberFormatException();
                        }

                        int Lebar = Integer.parseInt(Cek);
                        KRY.setLebar(Lebar);
                        
                    } catch (NumberFormatException Error) {
                        Ulang = false;
                        DSG.MsgInputNotNumber();
                        DSG.Press();
                    }
                }

                Ulang = false;

                while (Ulang == false){
                    try {  
                        System.out.print("Masukkan Tinggi (CM)     : ");
                        String Cek = Input.readLine();
                        
                        if (Cek.matches("\\d+")) {
                            Ulang = true;
                        }else{
                            throw new NumberFormatException();
                        }

                        int Tinggi = Integer.parseInt(Cek);
                        KRYSN.setTinggi(Tinggi);
                        
                    } catch (NumberFormatException Error) {
                        Ulang = false;
                        DSG.MsgInputNotNumber();
                        DSG.Press();
                    }
                }

                Ulang = false;

                while (Ulang == false){
                    try {  
                        System.out.print("Masukkan Stok            : ");
                        String Cek = Input.readLine();
                        
                        if (Cek.matches("\\d+")) {
                            Ulang = true;
                        }else{
                            throw new NumberFormatException();
                        }

                        int Stok = Integer.parseInt(Cek);
                        KRY.setStok(Stok);
                        
                    } catch (NumberFormatException Error) {
                        Ulang = false;
                        DSG.MsgInputNotNumber();
                        DSG.Press();
                    }
                }
                
                // Query Update
                String Sql = "UPDATE dataseniukir SET Nama = '%s', "
                                               + "Motif = '%s',"
                                               + "TahunPublikasi = '%s',"
                                               + "Harga = '%d',"
                                               + "Panjang = '%d',"
                                               + "Lebar = '%d',"
                                               + "Tinggi = '%d',"
                                               + "Stok = '%d' WHERE IdUkir='%d'";
                Sql = String.format(Sql, KRY.getNama(),KRYSN.getMotif(),KRY.getTahunPublikasi(),KRY.getHarga(),KRY.getPanjang(),KRY.getLebar(),KRYSN.getTinggi(),KRY.getStok(), KRYSN.getId());
                
                // Eksekusi
                Stmt.execute(Sql);
                MSG.MsgBerhasilEditUkir();
                DSG.Press();
            }else{
                MSG.DesainNotFind();
                DSG.Press();
            }
            
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }

    @Override
    public void DeleteDataUkir(int IdAkun, String Username) throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        SeniUkir KRYSN = new SeniUkir(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        
        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainDelete();

            // Query Select
            String sqlSelect = "SELECT * FROM dataseniukir WHERE IdSeniman ="+ IdAkun;
            
            // Eksekusi
            Rs = Stmt.executeQuery(sqlSelect);
            System.out.println("\n                                                                       DATA UKIR");
            

            DSG.DesainShowKatalog();
                while (Rs.next()) {
                    KRYSN.setId(Rs.getInt("IdUkir"));
                    KRYSN.setNama(Rs.getString("Nama"));
                    KRYSN.setHarga(Rs.getInt("Harga"));
                
                System.out.println(String.format("                                              | %s%-10s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
            }
            DSG.DesainShowKatalog2();

            Boolean Ulang = false;
            
            while (Ulang == false){
                try {  
                    DSG.PilihKaryaSeni();
                    String Cek = Input.readLine();
                    
                    if (Cek.matches("\\d+")) {
                        Ulang = true;
                    }else{
                        throw new NumberFormatException();
                    }

                    int Id = Integer.parseInt(Cek);
                    KRYSN.setId(Id);

                } catch (NumberFormatException Error) {
                    Ulang = false;
                    DSG.MsgInputNotNumber();
                    DSG.Press();
                }
            }
            
            // Query Select
            String SqlCek = "SELECT * FROM dataseniukir WHERE IdUkir ="+ KRYSN.getId();

            // Eksekusi
            Rs = Stmt.executeQuery(SqlCek);

            if(Rs.next()){
                MSG.QuestionDelKarya();
                String Konfirmasi = Input.readLine();
                
                if (Konfirmasi.equals("Y") || Konfirmasi.equals("y")){
    
                    // Query Delete
                    String Sql = String.format("DELETE FROM dataseniukir WHERE IdUkir = %d", KRYSN.getId());
                    
                    // Eksekusi
                    Stmt.execute(Sql);
    
                    MSG.MsgBerhasilHapusKarya();
                    DSG.Press();
                }else{
                    MSG.MsgGagalHapusKarya();
                    DSG.Press();
                }
            }else{
                MSG.DesainNotFind();
                DSG.Press();
            }

            
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }

    @Override
    public void MenuManageUkir(int IdAkun, String Username) throws IOException {
        SeniUkir KRYSN = new SeniUkir(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();;
        
        Boolean Stop = false;

        while (Stop == false){
            DSG.ClrScreen();
            DSG.Header();
            KRYSN.MenuManage();
            DSG.InputPilihan();
            try {  
                int Chs = Integer.parseInt(Input.readLine());
                switch(Chs){
                    case 1:
                        CreateDataUkir(IdAkun, Username);
                        break;
                    case 2:
                        try {
                            // Query Select
                            String Sql = "SELECT * FROM DataSeniUkir";
    
                            // Eksekusi
                            Rs = Stmt.executeQuery(Sql);
    
                            if (!Rs.next()){
                                DSG.ClrScreen();
                                DSG.Header();
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                ShowDataUkir(IdAkun, Username);
                                DSG.Press();
                            }
    
                        } catch (SQLException Error) {
                            Error.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            // Query Select
                            String Sql = "SELECT * FROM DataSeniUkir";
    
                            // Eksekusi
                            Rs = Stmt.executeQuery(Sql);
    
                            if (!Rs.next()){
                                DSG.ClrScreen();
                                DSG.Header();
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                UpdateDataUkir(IdAkun, Username);
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
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                DeleteDataUkir(IdAkun, Username);
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
            } catch (NumberFormatException Error) {
                DSG.MsgInputNotNumber();
                DSG.Press();
            }

        }
    }
}
    