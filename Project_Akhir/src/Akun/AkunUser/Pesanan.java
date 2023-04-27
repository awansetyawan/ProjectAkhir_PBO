package Akun.AkunUser;

import Akun.AkunSeniman.KaryaSeni.SeniLukisan;
import Akun.AkunSeniman.KaryaSeni.SeniPatung;
import Akun.AkunSeniman.KaryaSeni.SeniUkir;
import MessageAndDesaign.MessageAndDesaign;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pesanan {

    // Property
    static Statement Stmt;
    static ResultSet Rs;
    
    int IdPesanan;
    public int IdUser;
    public int IdSeniman;
    public int IdBarangSeni;
    public int JumlahItem;
    public int HargaItem;
    public int TotalPembayaran;
    public int StokItem;
    public String NamaUser;
    public String NamaSeniman;
    public String NamaItem;
    public String NoRekSeniman;

    static BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));

    // Constructor
    public Pesanan(int idPesanan, int idUser, int idSeniman, int idBarangSeni, int jumlahItem, int hargaItem, 
                   int totalPembayaran, String namaUser, String namaSeniman, String namaItem) {
        this.IdPesanan = idPesanan;
        this.IdUser = idUser;
        this.IdSeniman = idSeniman;
        this.IdBarangSeni = idBarangSeni;
        this.JumlahItem = jumlahItem;
        this.HargaItem = hargaItem;
        this.TotalPembayaran = totalPembayaran;
        this.NamaUser = namaUser;
        this.NamaSeniman = namaSeniman;
        this.NamaItem = namaItem;
    }

    // Setter & Gettr
    public int getIdPesanan() {
        return IdPesanan;
    }

    public void setIdPesanan(int idPesanan) {
        this.IdPesanan = idPesanan;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        this.IdUser = idUser;
    }

    public int getIdSeniman() {
        return IdSeniman;
    }

    public void setIdSeniman(int idSeniman) {
        this.IdSeniman = idSeniman;
    }

    public int getIdBarangSeni() {
        return IdBarangSeni;
    }

    public void setIdBarangSeni(int idBarangSeni) {
        this.IdBarangSeni = idBarangSeni;
    }

    public int getJumlahItem() {
        return JumlahItem;
    }

    public void setJumlahItem(int jumlahItem) {
        this.JumlahItem = jumlahItem;
    }

    public int getTotalPembayaran() {
        return TotalPembayaran;
    }

    public void setTotalPembayaran(int totalPembayaran) {
        this.TotalPembayaran = totalPembayaran;
    }

    public String getNamaUser() {
        return NamaUser;
    }

    public void setNamaUser(String namaUser) {
        this.NamaUser = namaUser;
    }

    public String getNamaSeniman() {
        return NamaSeniman;
    }

    public void setNamaSeniman(String namaSeniman) {
        this.NamaSeniman = namaSeniman;
    }

    public String getNamaItem() {
        return NamaItem;
    }

    public void setNamaItem(String namaItem) {
        this.NamaItem = namaItem;
    }
    
    public int getHargaItem() {
        return HargaItem;
    }

    public void setHargaItem(int hargaItem) {
        this.HargaItem = hargaItem;
    }

    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        Pesanan.Stmt = Stmt;
    }

    public void CreatePesanLukisan(int IdAkun) throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        SeniLukisan KRYSN = new SeniLukisan(null, null, null, 0, 0, 0, 0, 0, null, null, 0){};
    
        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainPesan();

            IdUser = IdAkun;
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
            
            boolean UlangPilih = true;

        do {
            DSG.PilihKaryaSeni();
            this.IdBarangSeni = Integer.parseInt(Input.readLine()); 

            
            String SqlSelectItem = "SELECT Harga, IdSeniman, Seniman, Nama, Stok FROM datasenilukisan WHERE IdLukisan =" + IdBarangSeni;
            Rs = Stmt.executeQuery(SqlSelectItem);
        
            if (Rs.next()) {
                this.HargaItem = Rs.getInt("Harga");
                this.IdSeniman = Rs.getInt("IdSeniman");
                this.NamaSeniman = Rs.getString("Seniman");
                this.NamaItem = Rs.getString("Nama");
                
                this.StokItem = Rs.getInt("Stok");
                
                boolean Ulang = true;
                do {
                    DSG.DesainJumlahItem();
                    this.JumlahItem = Integer.parseInt(Input.readLine());

                    if (this.JumlahItem <= this.StokItem) {
                        Ulang = false;
                    } else {
                        System.out.println((char)27 +  "[05;33m\n                                                          Mohon maaf stok yang tersedia hanya "+ this.StokItem + (char)27 + "[00;00m");
                    }
                } while (Ulang == true);

                this.NamaItem = "Lukisan : " + this.NamaItem;
    
                System.out.print(String.format("         "));
                this.TotalPembayaran = this.JumlahItem * this.HargaItem;
    
                this.StokItem = this.StokItem - this.JumlahItem;

                // Query Update
                String SqlUpdateStok = String.format("UPDATE datasenilukisan SET Stok=%d WHERE IdLukisan=%d", this.StokItem, this.IdBarangSeni);
                
                // Eksekusi
                Stmt.execute(SqlUpdateStok);
    
                if (StokItem == 0) {

                    // Query Delete
                    String SqlDelete = String.format("DELETE FROM datasenilukisan WHERE IdLukisan=%d", this.IdBarangSeni);
                    
                    // Eksekusi
                    Stmt.execute(SqlDelete);
                }
    
                // Query Simpan
                String SqlAppend = "INSERT INTO datapesanan (IdUser, IdSeniman, IdBarangSeni, NamaUser, NamaSeniman, NamaItem, JumlahItem, HargaItem, TotalPembayaran, NoRekSeniman) VALUE('%d', '%d', '%d', '%s', '%s', '%s', '%d', '%d', '%d', '%s')";
                
                // Query Select
                String SqlSelectUser = "SELECT Nama FROM dataakun WHERE IdAkun =" + this.IdUser;
                
                // Eksekusi
                Rs = Stmt.executeQuery(SqlSelectUser);
    
                String NamaLengkap = this.NamaUser;
                if (Rs.next()) {
                    NamaLengkap = Rs.getString("Nama");
                }

                this.NamaUser = NamaLengkap;

                // Query Select
                String SqlSelectSeniman = "SELECT NoRek FROM dataakun WHERE IdAkun =" + this.IdSeniman;
                
                // Eksekusi
                Rs = Stmt.executeQuery(SqlSelectSeniman);

                String NoRek = this.NoRekSeniman;
                if (Rs.next()) {
                    NoRek = Rs.getString("NoRek");
                }
                this.NoRekSeniman = NoRek;

                // Query Alter Table
                String CekId = String.format("ALTER TABLE DataPesanan AUTO_INCREMENT=0");
                
                // Eksekusi
                Stmt.execute(CekId);

                SqlAppend = String.format(SqlAppend, this.IdUser, this.IdSeniman, this.IdBarangSeni, this.NamaUser, this.NamaSeniman, this.NamaItem, this.JumlahItem, this.HargaItem, this.TotalPembayaran, this.NoRekSeniman);
    
                // Eksekusi
                Stmt.execute(SqlAppend);
                UlangPilih = false;
            } else {
                DSG.DesainNotFind();
                UlangPilih = true;
            }
            } while (UlangPilih == true);
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }

    public void CreatePesanPatung(int IdAkun) throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();
        SeniPatung KRYSN = new SeniPatung(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
    
        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainPesan();

            IdUser = IdAkun;

            String Sql = "SELECT * FROM datasenipatung";
            Rs = Stmt.executeQuery(Sql);
    
            DSG.DesainShowKatalog();
            while (Rs.next()) {
                KRYSN.setId(Rs.getInt("IdPatung"));
                KRYSN.setNama(Rs.getString("Nama"));
                KRYSN.setHarga(Rs.getInt("Harga"));

                System.out.println(String.format("                                              | %s%-11s | %-19s | %-20s |", "" +  KRYSN.getKode(), KRYSN.getId(), KRYSN.getNama(), KRYSN.getHarga()));
                
            }
            DSG.DesainShowKatalog2();
            
            boolean UlangPilih = true;

        do {
            DSG.PilihKaryaSeni();
            IdBarangSeni = Integer.parseInt(Input.readLine()); 

            // Query Select
            String SqlSelectItem = "SELECT Harga, IdSeniman, Seniman, Nama, Stok FROM datasenipatung WHERE IdPatung =" + IdBarangSeni;
            
            // Eksekusi
            Rs = Stmt.executeQuery(SqlSelectItem);
        
            if (Rs.next()) {
                HargaItem = Rs.getInt("Harga");
                IdSeniman = Rs.getInt("IdSeniman");
                NamaSeniman = Rs.getString("Seniman");
                NamaItem = Rs.getString("Nama");
                
                StokItem = Rs.getInt("Stok");
                boolean Ulang = true;
                do {
                    DSG.DesainJumlahItem();
                    JumlahItem = Integer.parseInt(Input.readLine());

                    if (JumlahItem <= StokItem) {
                        Ulang = false;
                    } else {
                        System.out.println((char)27 +  "[05;33m\n                                                          Mohon maaf stok yang tersedia hanya "+ StokItem + (char)27 + "[00;00m");
                    }
                } while (Ulang == true);

                NamaItem = "Patung  : " + NamaItem;
    
                System.out.print(String.format("         "));
                TotalPembayaran = JumlahItem * HargaItem;
    
                StokItem = StokItem - JumlahItem;

                // Query Update
                String SqlUpdateStok = String.format("UPDATE datasenipatung SET Stok=%d WHERE IdPatung=%d", StokItem, IdBarangSeni);
                
                // Eksekusi
                Stmt.execute(SqlUpdateStok);
    
                if (StokItem == 0) {

                    // Query Delete
                    String SqlDelete = String.format("DELETE FROM datasenipatung WHERE IdPatung=%d", IdBarangSeni);
                    
                    // Eksekusi
                    Stmt.execute(SqlDelete);
                }
    
                // Query Simpan
                String SqlAppend = "INSERT INTO datapesanan (IdUser, IdSeniman, IdBarangSeni, NamaUser, NamaSeniman, NamaItem, JumlahItem, HargaItem, TotalPembayaran, NoRekSeniman) VALUE('%d', '%d', '%d', '%s', '%s', '%s', '%d', '%d', '%d', '%s')";
                
                // Query Select
                String SqlSelectUser = "SELECT Nama FROM dataakun WHERE IdAkun =" + IdUser;
                
                // Eksekusi
                Rs = Stmt.executeQuery(SqlSelectUser);
    
                String NamaLengkap = NamaUser;
                if (Rs.next()) {
                    NamaLengkap = Rs.getString("Nama");
                }

                NamaUser = NamaLengkap;

                // Query Select
                String SqlSelectSeniman = "SELECT NoRek FROM dataakun WHERE IdAkun =" + IdSeniman;
                
                // Eksekusi
                Rs = Stmt.executeQuery(SqlSelectSeniman);

                String NoRek = NoRekSeniman;
                if (Rs.next()) {
                    NoRek = Rs.getString("NoRek");
                }
                NoRekSeniman = NoRek;
                
                // Query Alter Table
                String CekId = String.format("ALTER TABLE DataPesanan AUTO_INCREMENT=0");
                
                // Eksekusi
                Stmt.execute(CekId);

                SqlAppend = String.format(SqlAppend, IdUser, IdSeniman, IdBarangSeni, NamaUser, NamaSeniman, NamaItem, JumlahItem, HargaItem, TotalPembayaran, NoRekSeniman);
    
                // Eksekusi
                Stmt.execute(SqlAppend);
                UlangPilih =false;
            } else {
                DSG.DesainNotFind();
                UlangPilih =true;
            }
            } while (UlangPilih == true);
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }

    public void CreatePesanUkir(int IdAkun) throws IOException {
        SeniUkir KRYSN = new SeniUkir(null, null, null, 0, 0, 0, 0, 0, 0, 0, null){};
        MessageAndDesaign DSG = new MessageAndDesaign();

        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainPesan();
            IdUser = IdAkun;

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
            
            boolean UlangPilih = true;

        do {
            DSG.PilihKaryaSeni();
            IdBarangSeni = Integer.parseInt(Input.readLine()); 

            // Query Select
            String SqlSelectItem = "SELECT Harga, IdSeniman, Seniman, Nama, Stok FROM dataseniukir WHERE IdUkir =" + IdBarangSeni;
            
            // Eksekusi
            Rs = Stmt.executeQuery(SqlSelectItem);
        
            if (Rs.next()) {
                HargaItem = Rs.getInt("Harga");
                IdSeniman = Rs.getInt("IdSeniman");
                NamaSeniman = Rs.getString("Seniman");
                NamaItem = Rs.getString("Nama");
                
                StokItem = Rs.getInt("Stok");
                boolean Ulang = true;
                do {
                    DSG.DesainJumlahItem();
                    JumlahItem = Integer.parseInt(Input.readLine());

                    if (JumlahItem <= StokItem) {
                        Ulang = false;
                    } else {
                        System.out.println((char)27 +  "[05;33m\n                                                          Mohon maaf stok yang tersedia hanya "+ StokItem + (char)27 + "[00;00m");
                    }
                } while (Ulang == true);

                NamaItem = "Ukir    : " + NamaItem;
    
                System.out.print(String.format("         "));
                TotalPembayaran = JumlahItem * HargaItem;
    
                StokItem = StokItem - JumlahItem;

                // Query Update
                String SqlUpdateStok = String.format("UPDATE dataseniukir SET Stok=%d WHERE IdUkir=%d", StokItem, IdBarangSeni);
                
                // Eksekusi
                Stmt.execute(SqlUpdateStok);
    
                if (StokItem == 0) {

                    // Query Delete
                    String SqlDelete = String.format("DELETE FROM dataseniukir WHERE IdUkir=%d", IdBarangSeni);
                    
                    // Eksekusi
                    Stmt.execute(SqlDelete);
                }
    
                // Query Simpan
                String SqlAppend = "INSERT INTO datapesanan (IdUser, IdSeniman, IdBarangSeni, NamaUser, NamaSeniman, NamaItem, JumlahItem, HargaItem, TotalPembayaran, NoRekSeniman) VALUE('%d', '%d', '%d', '%s', '%s', '%s', '%d', '%d', '%d', '%s')";
                
                // Query Select
                String SqlSelectUser = "SELECT Nama FROM dataakun WHERE IdAkun =" + IdUser;

                // Eksekusi
                Rs = Stmt.executeQuery(SqlSelectUser);
    
                String NamaLengkap = NamaUser;
                if (Rs.next()) {
                    NamaLengkap = Rs.getString("Nama");
                }

                NamaUser = NamaLengkap;

                // Query Select
                String SqlSelectSeniman = "SELECT NoRek FROM dataakun WHERE IdAkun =" + IdSeniman;
                
                // Eksekusi
                Rs = Stmt.executeQuery(SqlSelectSeniman);

                String NoRek = NoRekSeniman;
                if (Rs.next()) {
                    NoRek = Rs.getString("NoRek");
                }
                NoRekSeniman = NoRek;

                // Query Alter Table
                String CekId = String.format("ALTER TABLE DataPesanan AUTO_INCREMENT=0");

                // Eksekusi
                Stmt.execute(CekId);
                
                SqlAppend = String.format(SqlAppend, IdUser, IdSeniman, IdBarangSeni, NamaUser, NamaSeniman, NamaItem, JumlahItem, HargaItem, TotalPembayaran, NoRekSeniman);
    
                // Eksekusi
                Stmt.execute(SqlAppend);
                UlangPilih =false;
            } else {
                DSG.DesainNotFind();
                UlangPilih =true;
            }
            } while (UlangPilih == true);
        } catch (SQLException Error) {
            Error.printStackTrace();
        }
    }

    public void ManagePesanan(int IdAkun) throws IOException {
        Transaksi Trk = new Transaksi(0, 0, 0, 0, null, null, null, null, null, null, null, null);
        MessageAndDesaign DSG = new MessageAndDesaign();
        MessageAndDesaign MSG = new MessageAndDesaign();
        Boolean Stop = false;

        while (Stop == false){
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainMenuPesanan();

            try {      
                int chs2 = Integer.parseInt(Input.readLine());
                switch(chs2){
                    case 1:
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
                            }else{
                                CreatePesanLukisan(IdAkun);
                                Trk.CreateTransaksi(IdAkun);
                                Trk.ShowTransaksi();
                                DSG.Press();
                            }
    
                        } catch (SQLException Error) {
                            Error.printStackTrace();
                        }
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
                                MSG.DesainDataEmpty();
                                DSG.Press();
                            }else{
                                CreatePesanPatung(IdAkun);
                                Trk.CreateTransaksi(IdAkun);
                                Trk.ShowTransaksi();
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
                                MSG.DesainDataEmpty();
                                DSG.Press();
                            }else{
                                CreatePesanUkir(IdAkun);
                                Trk.CreateTransaksi(IdAkun);
                                Trk.ShowTransaksi();
                                DSG.Press();
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
