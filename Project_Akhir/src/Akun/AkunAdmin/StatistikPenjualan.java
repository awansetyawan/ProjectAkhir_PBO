package Akun.AkunAdmin;

import MessageAndDesaign.MessageAndDesaign;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import Akun.AkunAdmin.Interface.IFaceStatistikPenjualan;

public class StatistikPenjualan implements IFaceStatistikPenjualan{
    
    // Property
    static Statement Stmt;
    static ResultSet Rs;

    // Setter & Getter
    public static Statement getStmt() {
        return Stmt;
    }

    public static void setStmt(Statement Stmt) {
        StatistikPenjualan.Stmt = Stmt;
    }

    // Implements Interface
    @Override
    public void ShowStatistikPenjualan() throws IOException {
        MessageAndDesaign DSG = new MessageAndDesaign();

        try {
            DSG.ClrScreen();
            DSG.Header();
            DSG.DesainStatistikPenjualan();

            // Query Select
            String Sql = "SELECT SUM(TotalTransaksi) AS TotalPendapatan, AVG(TotalTransaksi) AS RataRataPenjualan, MAX(TotalTransaksi) AS PenjualanTertinggi, MIN(TotalTransaksi) AS PenjualanTerendah, Item, COUNT(Item) AS FrekuensiPenjualan FROM datatransaksi GROUP BY Item ORDER BY COUNT(Item) DESC";
            
            // Eksekusi
            Rs = Stmt.executeQuery(Sql);

            while (Rs.next()) {
                int TotalPendapatan = Rs.getInt("TotalPendapatan");
                int AvgPenjualan = Rs.getInt("RataRataPenjualan");
                int MaxPenjualan = Rs.getInt("PenjualanTertinggi");
                int MinPenjualan = Rs.getInt("PenjualanTerendah");
                String Item = Rs.getString("Item");
                int FrekuansiPenjualan = Rs.getInt("FrekuensiPenjualan");
    
                System.out.println(String.format("          | %-20s | %-19s | %-20s | %-19s | %-25s | %-19s |", "Rp." + TotalPendapatan, "Rp." + AvgPenjualan, "Rp." + MaxPenjualan, "Rp." + MinPenjualan, Item, FrekuansiPenjualan));
            }
            DSG.DesainStatistikPenjualan2();
    
            DSG.Press();
    
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
     
}