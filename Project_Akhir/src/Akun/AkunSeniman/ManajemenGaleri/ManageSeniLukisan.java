package Akun.AkunSeniman.ManajemenGaleri;

import Akun.AkunSeniman.KaryaSeni.KaryaSeni;
import Akun.AkunSeniman.KaryaSeni.SeniLukisan;
import MessageAndDesaign.MessageAndDesaign;
import Akun.AkunSeniman.Interface.IfaceManageLukisan;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

public class ManageSeniLukisan implements IfaceManageLukisan{

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
        ManageSeniLukisan.Stmt = Stmt;
    }
    
    // Implements Interface
    @Override
    public void CreateDataLukisan(int IdAkun, String Username) throws IOException{  
        KaryaSeni KRY = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
        SeniLukisan KRYSN = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        
        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainCreateLukisan();
            
            KRY.setSeniman(Username);
            
            // Nama Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
            do{
                System.out.print("Masukkan Nama            : ");
                String Nama = Input.readLine();
                KRY.setNama(Nama);
                
                if (KRY.getNama().length() < 1) {
                    MSG.MsgNamaLukIsEmpty();
                }else if (!PolaHuruf.matcher(KRY.getNama()).matches()) {
                    MSG.MsgNamaLukNotAlfabet();
                }else if (KRY.getNama().trim().isEmpty()) {
                    MSG.MsgNamaLukIsEmpty();
                }

            }while(KRY.getNama().length() < 1||!PolaHuruf.matcher(KRY.getNama()).matches()|| KRY.getNama().trim().isEmpty());

            // Teknik Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
            do{
                System.out.print("Masukkan Teknik          : ");
                String Teknik = Input.readLine();
                KRYSN.setTeknik(Teknik);
                
                if (KRYSN.getTeknik().length() < 1) {
                    MSG.MsgTeknikLukIsEmpty();
                }else if (!PolaHuruf.matcher(KRYSN.getTeknik()).matches()) {
                    MSG.MsgTeknikLukNotAlfabet();
                }else if (KRYSN.getTeknik().trim().isEmpty()) {
                    MSG.MsgTeknikLukIsEmpty();
                }

            }while(KRYSN.getTeknik().length() < 1||!PolaHuruf.matcher(KRYSN.getTeknik()).matches()|| KRYSN.getTeknik().trim().isEmpty());
            
            // Aliran Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
            do{
                System.out.print("Masukkan Aliran          : ");
                String Aliran = Input.readLine();
                KRYSN.setAliran(Aliran);
                
                if (KRYSN.getAliran().length() < 1) {
                    MSG.MsgAliranLukIsEmpty();
                }else if (!PolaHuruf.matcher(KRYSN.getAliran()).matches()) {
                    MSG.MsgAliranLukNotAlfabet();
                }else if (KRYSN.getAliran().trim().isEmpty()) {
                    MSG.MsgAliranLukIsEmpty();
                }

            }while(KRYSN.getAliran().length() < 1||!PolaHuruf.matcher(KRYSN.getAliran()).matches()|| KRYSN.getAliran().trim().isEmpty());
            
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
                    System.out.print("Masukkan Stok            : ");
                    String Cek = Input.readLine();
                    
                    if (Cek.matches("\\d+")) {
                        Ulang = true;
                    }else{
                        throw new NumberFormatException();
                    }

                    KRY.setStok(Integer.parseInt(Cek));
                    
                } catch (NumberFormatException Error) {
                    Ulang = false;
                    DSG.MsgInputNotNumber();
                    DSG.Press();
                }
            }
            
            // Query Alter Table
            String CekId = String.format("ALTER TABLE DataSeniLukisan AUTO_INCREMENT=0");
            
            // Eksekusi
            Stmt.execute(CekId);

            // Query Simpan
            String Sql = "INSERT INTO DataSeniLukisan (IdSeniman, Seniman, Nama, Teknik, Aliran, TahunPublikasi, Harga, Panjang, Lebar, Stok) "
                    + "VALUE('%d', '%s', '%s', '%s', '%s', '%s', '%d', '%d', '%d', '%d')";
            Sql = String.format(Sql, IdAkun, KRY.getSeniman(), KRY.getNama(), KRYSN.getTeknik(), KRYSN.getAliran(), KRY.getTahunPublikasi(), KRY.getHarga(), KRY.getPanjang(), KRY.getLebar(), KRY.getStok());

            // Eksekusi
            Stmt.execute(Sql);
            MSG.MsgBerhasilTambahLukisan();
            DSG.Press();
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }
    
    @Override
    public void ShowDataLukisan(int IdAkun, String Username) throws IOException{
        SeniLukisan KRYSN = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
        MessageAndDesaign DSG = new MessageAndDesaign();

        try {     
            DSG.ClrScreen();
            DSG.Header();
            // Query Select
            String Sql = "SELECT * FROM datasenilukisan WHERE IdSeniman ="+ IdAkun;
            
            // Eksekusi
            Rs = Stmt.executeQuery(Sql);
            

            int i = 1;
            while (Rs.next()) {
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
                int Stok = Rs.getInt("Stok");

                System.out.println((char)27 +  "[05;36m  \n                                              ==================== Data Lukisan Ke-" + (i++) + " ======================"+ (char)27 + "[00;00m");
                System.out.println(String.format("\n                                                           Id Lukisan      : %s%s",KRYSN.getKode(), IdLukisan));
                System.out.println(String.format("                                                           Id Seniman      : %s",IdSeniman));
                System.out.println(String.format("                                                           Seniman         : %s",Seniman));
                System.out.println(String.format("                                                           Nama            : %s",Nama));
                System.out.println(String.format("                                                           Teknik          : %s",Teknik));
                System.out.println(String.format("                                                           Aliran          : %s",Aliran));
                System.out.println(String.format("                                                           Tahun Publikasi : %s",TahunPublikasi));
                System.out.println(String.format("                                                           Harga           : %s",Harga));
                System.out.println(String.format("                                                           Panjang         : %s",Panjang));
                System.out.println(String.format("                                                           Lebar           : %s",Lebar));       
                System.out.println(String.format("                                                           Stok            : %s",Stok));             
            }
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }
    
    @Override
    public void UpdateDataLukisan(int IdAkun, String Username) throws IOException{
        KaryaSeni KRY = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
        SeniLukisan KRYSN = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        
        try {
            DSG.ClrScreen();
            DSG.Header();
            
            // Query Select
            String SqlSelect = "SELECT * FROM datasenilukisan WHERE IdSeniman ="+ IdAkun;
            
            // Eksekusi
            Rs = Stmt.executeQuery(SqlSelect);
            System.out.println("\n                                                                     DATA LUKISAN\n");

            DSG.DesainShowKatalog();
                while (Rs.next()) {
                    KRYSN.setId(Rs.getInt("IdLukisan"));
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
            String SqlCek = "SELECT * FROM datasenilukisan WHERE IdLukisan ="+ KRYSN.getId();

            // Eksekusi
            Rs = Stmt.executeQuery(SqlCek);

            if(Rs.next()){
                DSG.ClrScreen();
                DSG.Header();
                DSG.DesainUpdateLukisan();
                // Nama Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
                do{
                    System.out.print("\nMasukkan Nama            : ");
                    String Nama = Input.readLine();
                    KRY.setNama(Nama);
                    
                    if (KRY.getNama().length() < 1) {
                        MSG.MsgNamaLukIsEmpty();
                    }else if (!PolaHuruf.matcher(KRY.getNama()).matches()) {
                        MSG.MsgNamaLukNotAlfabet();
                    }else if (KRY.getNama().trim().isEmpty()) {
                        MSG.MsgNamaLukIsEmpty();
                    }

                }while(KRY.getNama().length() < 1||!PolaHuruf.matcher(KRY.getNama()).matches()|| KRY.getNama().trim().isEmpty());
                
                // Teknik Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
                do{
                    System.out.print("Masukkan Teknik          : ");
                    String Teknik = Input.readLine();
                    KRYSN.setTeknik(Teknik);
                    
                    if (KRYSN.getTeknik().length() < 1) {
                        MSG.MsgTeknikLukIsEmpty();
                    }else if (!PolaHuruf.matcher(KRYSN.getTeknik()).matches()) {
                        MSG.MsgTeknikLukNotAlfabet();
                    }else if (KRYSN.getTeknik().trim().isEmpty()) {
                        MSG.MsgTeknikLukIsEmpty();
                    }

                }while(KRYSN.getTeknik().length() < 1||!PolaHuruf.matcher(KRYSN.getTeknik()).matches()|| KRYSN.getTeknik().trim().isEmpty());
                
                // Aliran Hanya Boleh Huruf dan Spasi serta tidak boleh kosong
                do{
                    System.out.print("Masukkan Aliran          : ");
                    String Aliran = Input.readLine();
                    KRYSN.setAliran(Aliran);
                    
                    if (KRYSN.getAliran().length() < 1) {
                        MSG.MsgAliranLukIsEmpty();
                    }else if (!PolaHuruf.matcher(KRYSN.getAliran()).matches()) {
                        MSG.MsgAliranLukNotAlfabet();
                    }else if (KRYSN.getAliran().trim().isEmpty()) {
                        MSG.MsgAliranLukIsEmpty();
                    }

                }while(KRYSN.getAliran().length() < 1||!PolaHuruf.matcher(KRYSN.getAliran()).matches()|| KRYSN.getAliran().trim().isEmpty());
                
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
                String sql = "UPDATE datasenilukisan SET Nama = '%s', "
                                               + "Teknik = '%s',"
                                               + "Aliran = '%s',"
                                               + "TahunPublikasi = '%s',"
                                               + "Harga = '%d',"
                                               + "Panjang = '%d',"
                                               + "Lebar = '%d',"
                                               + "Stok = '%d' WHERE IdLukisan='%d'";
                sql = String.format(sql, KRY.getNama(),KRYSN.getTeknik(),KRYSN.getAliran(),KRY.getTahunPublikasi(),KRY.getHarga(),KRY.getPanjang(),KRY.getLebar(),KRY.getStok(),KRYSN.getId());
                
                // Eksekusi
                Stmt.execute(sql);
                DSG.MsgBerhasilEditLukisan();
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
    public void DeleteDataLukisan(int IdAkun, String Username) throws IOException{
        SeniLukisan KRYSN = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        
        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainDelete();

            // Query Select
            String SqlSelect = "SELECT * FROM datasenilukisan WHERE IdSeniman ="+ IdAkun;
            
            // Eksekusi
            Rs = Stmt.executeQuery(SqlSelect);
            System.out.println("\n                                                                     DATA LUKISAN\n");

            DSG.DesainShowKatalog();
                while (Rs.next()) {
                    KRYSN.setId(Rs.getInt("IdLukisan"));
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
            String SqlCek = "SELECT * FROM datasenilukisan WHERE IdLukisan ="+ KRYSN.getId();

            // Eksekusi
            Rs = Stmt.executeQuery(SqlCek);

            if(Rs.next()){
                MSG.QuestionDelKarya();
                String Konfirmasi = Input.readLine();
        
                if (Konfirmasi.equals("Y") || Konfirmasi.equals("y")){
    
                    // Query Delete
                    String Sql = String.format("DELETE FROM datasenilukisan WHERE IdLukisan = %d", KRYSN.getId());
                    
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

    public void MenuManageLukisan(int IdAkun, String Username) throws IOException {
        SeniLukisan KRYSN = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        
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
                        CreateDataLukisan(IdAkun, Username);
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
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                ShowDataLukisan(IdAkun, Username);
                                DSG.Press();
                            }
    
                        } catch (SQLException Error) {
                            Error.printStackTrace();
                        }
    
                        break;
                    case 3:
                        try {
                            // Query Select
                            String Sql = "SELECT * FROM DataSeniLukisan";
    
                            // Eksekusi
                            Rs = Stmt.executeQuery(Sql);
    
                            if (!Rs.next()){
                                DSG.ClrScreen();
                                DSG.Header();
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                UpdateDataLukisan(IdAkun, Username);
                            }
    
                        } catch (SQLException Error) {
                            Error.printStackTrace();
                        }
    
                        break;
                    case 4:
                        try {
                            // Query Select
                            String Sql = "SELECT * FROM DataSeniLukisan";
    
                            // Eksekusi
                            Rs = Stmt.executeQuery(Sql);
    
                            if (!Rs.next()){
                                DSG.ClrScreen();
                                DSG.Header();
                                MSG.DesainNotData();
                                DSG.Press();
                            }else{
                                DeleteDataLukisan(IdAkun, Username);
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