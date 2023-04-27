package Akun.AkunSeniman.ManajemenGaleri;

import Akun.AkunSeniman.KaryaSeni.KaryaSeni;
import Akun.AkunSeniman.KaryaSeni.SeniPatung;
import MessageAndDesaign.MessageAndDesaign;
import Akun.AkunSeniman.Interface.IfaceManagePatung;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

public class ManageSeniPatung implements IfaceManagePatung{

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
        ManageSeniPatung.Stmt = Stmt;
    }
    
    // Implements Interface
    @Override
    public void CreateDataPatung(int IdAkun, String Username) throws IOException{  
        KaryaSeni KRY = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        SeniPatung KRYSN = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();

        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainCreatePatung();
            String Seniman = Username;
            KRY.setSeniman(Seniman);
            
            // Nama Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
            do{
                System.out.print("\nMasukkan Nama            : ");
                String Nama = Input.readLine();
                KRY.setNama(Nama);
                
                if (KRY.getNama().length() < 1) {
                    MSG.MsgNamaPatIsEmpty();
                }else if (!PolaHuruf.matcher(KRY.getNama()).matches()) {
                    MSG.MsgNamaPatNotAlfabet();
                }else if (KRY.getNama().trim().isEmpty()) {
                    MSG.MsgNamaPatIsEmpty();
                }

            }while(KRY.getNama().length() < 1||!PolaHuruf.matcher(KRY.getNama()).matches()|| KRY.getNama().trim().isEmpty());
            
            // Jenis Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
            do{
                System.out.print("Masukkan Jenis           : ");
                String Jenis = Input.readLine();
                KRYSN.setJenis(Jenis);
                
                if (KRYSN.getJenis().length() < 1) {
                    MSG.MsgJenisPatIsEmpty();
                }else if (!PolaHuruf.matcher(KRYSN.getJenis()).matches()) {
                    MSG.MsgJenisPatNotAlfabet();
                }else if (KRYSN.getJenis().trim().isEmpty()) {
                    MSG.MsgJenisPatIsEmpty();
                }

            }while(KRYSN.getJenis().length() < 1||!PolaHuruf.matcher(KRYSN.getJenis()).matches()|| KRYSN.getJenis().trim().isEmpty());

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
            String CekId = String.format("ALTER TABLE DataSeniPatung AUTO_INCREMENT=0");

            // Eksekusi
            Stmt.execute(CekId);

            // Query Simpan
            String Sql = "INSERT INTO DataSeniPatung (IdSeniman, Seniman, Nama, Jenis, TahunPublikasi, Harga, Panjang, Lebar, Tinggi, Stok) "
                    + "VALUE('%d', '%s', '%s', '%s', '%s', '%d', '%d', '%d', '%d', '%d')";
            Sql = String.format(Sql, IdAkun, KRY.getSeniman(), KRY.getNama(), KRYSN.getJenis(), KRY.getTahunPublikasi(), KRY.getHarga(), KRY.getPanjang(), KRY.getLebar(), KRYSN.getTinggi(), KRY.getStok());;

            // Eksekusi
            Stmt.execute(Sql);
            MSG.MsgBerhasilTambahPatung();
            DSG.Press();
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }
    
    @Override 
    public void ShowDataPatung(int IdAkun, String Username) throws IOException{
        SeniPatung KRYSN = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();

        try {     
            DSG.ClrScreen();
            DSG.Header();
            // Query Select
            String Sql = "SELECT * FROM datasenipatung WHERE IdSeniman ="+ IdAkun;
            
            // Eksekusi
            Rs = Stmt.executeQuery(Sql);
            
            int i = 1;
            while (Rs.next()) {
                KRYSN.setId(Rs.getInt("IdPatung"));
                int IdSeniman = Rs.getInt("IdSeniman");
                String Seniman = Rs.getString("Seniman");
                String Nama = Rs.getString("Nama");
                String Jenis = Rs.getString("Jenis");
                String TahunPublikasi = Rs.getString("TahunPublikasi");
                int Harga = Rs.getInt("Harga");
                int Panjang = Rs.getInt("Panjang");
                int Lebar = Rs.getInt("Lebar");
                int Tinggi = Rs.getInt("Tinggi");
                int Stok = Rs.getInt("Stok");
                
                System.out.println((char)27 +  "[05;36m  \n                                               ==================== Data Patung Ke-" + (i++) + " ======================"+ (char)27 + "[00;00m");
                System.out.println(String.format("\n                                                            Id Patung       : %s%s",KRYSN.getKode(), KRYSN.getId()));
                System.out.println(String.format("                                                            Id Seniman      : %s",IdSeniman));
                System.out.println(String.format("                                                            Seniman         : %s",Seniman));
                System.out.println(String.format("                                                            Nama            : %s",Nama));
                System.out.println(String.format("                                                            Jenis           : %s",Jenis));
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
    public void UpdateDataPatung(int IdAkun, String Username) throws IOException {
        KaryaSeni KRY = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        SeniPatung KRYSN = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();

        try {
            DSG.ClrScreen();
            DSG.Header();

            // Query Select
            String SqlSelect = "SELECT * FROM datasenipatung WHERE IdSeniman ="+ IdAkun;
            
            // Eksekusi
            Rs = Stmt.executeQuery(SqlSelect);
            System.out.println("\n                                                                      DATA PATUNG");
            
            DSG.DesainShowKatalog();
                while (Rs.next()) {
                    KRYSN.setId(Rs.getInt("IdPatung"));
                    KRYSN.setNama(Rs.getString("Nama"));
                    KRYSN.setHarga(Rs.getInt("Harga"));
                
                System.out.println(String.format("                                              | %s%-11s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
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
            String SqlCek = "SELECT * FROM datasenipatung WHERE IdPatung ="+ KRYSN.getId();

            // Eksekusi
            Rs = Stmt.executeQuery(SqlCek);

            if(Rs.next()){

                // Nama Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
                do{
                    DSG.ClrScreen();
                    DSG.Header();
                    DSG.DesainUpdatePatung();
                    System.out.print("Masukkan Nama            : ");
                    String Nama = Input.readLine();
                    KRY.setNama(Nama);
                    
                    if (KRY.getNama().length() < 1) {
                        MSG.MsgNamaPatIsEmpty();
                    }else if (!PolaHuruf.matcher(KRY.getNama()).matches()) {
                        MSG.MsgNamaPatNotAlfabet();
                    }else if (KRY.getNama().trim().isEmpty()) {
                        MSG.MsgNamaPatIsEmpty();
                    }

                }while(KRY.getNama().length() < 1||!PolaHuruf.matcher(KRY.getNama()).matches()|| KRY.getNama().trim().isEmpty());
                
                // Jenis Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
                do{
                    System.out.print("Masukkan Jenis           : ");
                    String Jenis = Input.readLine();
                    KRYSN.setJenis(Jenis);
                    
                    if (KRYSN.getJenis().length() < 1) {
                        MSG.MsgJenisPatIsEmpty();
                    }else if (!PolaHuruf.matcher(KRYSN.getJenis()).matches()) {
                        MSG.MsgJenisPatNotAlfabet();
                    }else if (KRYSN.getJenis().trim().isEmpty()) {
                        MSG.MsgJenisPatIsEmpty();
                    }

                }while(KRYSN.getJenis().length() < 1||!PolaHuruf.matcher(KRYSN.getJenis()).matches()|| KRYSN.getJenis().trim().isEmpty());
                
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
                
                // Query Update
                String Sql = "UPDATE datasenipatung SET Nama = '%s', "
                                               + "Jenis = '%s',"
                                               + "TahunPublikasi = '%s',"
                                               + "Harga = '%d',"
                                               + "Panjang = '%d',"
                                               + "Lebar = '%d',"
                                               + "Tinggi = '%d',"
                                               + "Stok = '%d' WHERE IdPatung='%d'";
                Sql = String.format(Sql, KRY.getNama(),KRYSN.getJenis(),KRY.getTahunPublikasi(),KRY.getHarga(),KRY.getPanjang(),KRY.getLebar(),KRYSN.getTinggi(),KRY.getStok(),KRYSN.getId());
                
                // Eksekusi
                Stmt.execute(Sql);
                MSG.MsgBerhasilEditPatung();
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
    public void DeleteDataPatung(int IdAkun, String Username) throws IOException {
        SeniPatung KRYSN = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        
        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainDelete();

            // Query Select
            String SqlSelect = "SELECT * FROM datasenipatung WHERE IdSeniman ="+ IdAkun;
            
            // Eksekusi
            Rs = Stmt.executeQuery(SqlSelect);
            System.out.println("\n                                                                     DATA LUKISAN\n");

            DSG.DesainShowKatalog();
                while (Rs.next()) {
                    KRYSN.setId(Rs.getInt("IdPatung"));
                    KRYSN.setNama(Rs.getString("Nama"));
                    KRYSN.setHarga(Rs.getInt("Harga"));
                
                System.out.println(String.format("                                              | %s%-11s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
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
            String SqlCek = "SELECT * FROM datasenipatung WHERE IdPatung ="+ KRYSN.getId();

            // Eksekusi
            Rs = Stmt.executeQuery(SqlCek);

            if(Rs.next()){
                MSG.QuestionDelKarya();
                String Konfirmasi = Input.readLine();
                
                if (Konfirmasi.equals("Y") || Konfirmasi.equals("y")){
    
                    // Query Delete
                    String Sql = String.format("DELETE FROM datasenipatung WHERE IdPatung = %d", KRYSN.getId());
                    
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
    public void MenuManagePatung(int IdAkun, String Username) throws IOException {  
        SeniPatung KRYSN = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign MSG = new MessageAndDesaign();
        MessageAndDesaign DSG = new MessageAndDesaign();

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
                        CreateDataPatung(IdAkun, Username);
                        break;
                    case 2:
                        try {
                            // Query Select
                            String Sql = "SELECT * FROM DataSeniPatung";
    
                            // Eksekusi
                            Rs = Stmt.executeQuery(Sql);
    
                            if (!Rs.next()){
                                DSG.ClrScreen();
                                DSG.Header();
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                ShowDataPatung(IdAkun, Username);
                                DSG.Press();
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
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                UpdateDataPatung(IdAkun, Username);
                            }
    
                        } catch (SQLException Error) {
                            Error.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            // Query Select
                            String Sql = "SELECT * FROM DataSeniPatung";
    
                            // Eksekusi
                            Rs = Stmt.executeQuery(Sql);
    
                            if (!Rs.next()){
                                DSG.ClrScreen();
                                DSG.Header();
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                DeleteDataPatung(IdAkun, Username);
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

