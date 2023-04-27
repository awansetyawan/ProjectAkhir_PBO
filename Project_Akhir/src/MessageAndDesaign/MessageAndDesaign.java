package MessageAndDesaign;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageAndDesaign {
    static BufferedReader input = new BufferedReader (new InputStreamReader (System.in)); 
    
    public void Header()  throws IOException{
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println((char)27 +  "[05;36m                                                 S I S T E M || P E N G E L O L A A N || G A L L E R Y " + (char)27 + "[00;00m");
        System.out.println("\n                                                              LUKISAN - PATUNG - UKIRAN ");
        System.out.println((char)27 +  "[03;36m                                                                                                                                      Final Project by Group 3" + (char)27 + "[00;00m");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void Press() throws IOException {
        Boolean stop = false;

        while(stop == false){
            System.out.print("\u001B[1;30m\n                                                             >> Press enter to continue" + (char)27 + "[00;00m");
            String cek = input.readLine();

            if (cek.isEmpty()) {
                stop = true;
            } else { 
                System.out.println((char)27 +  "[05;31m\n                                                        Error:  Hanya dapat menekan tombol enter!" + (char)27 + "[00;00m");
            }
        }
    }

    public final void InputPilihan() throws IOException{
        System.out.print((char)27 +  "[03;36m \n                                                                      ~ Pilih : "+ (char)27 + "[00;00m");
    }

    public final void MsgIsntAny() throws IOException{
        System.out.println((char)27 +  "[05;31m\n                                                         Information: Opsi Menu Tidak Tersedia!" + (char)27 + "[00;00m");
    }
    
    public final void ClrScreen() throws IOException{
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public final void DesainUpdateAkun() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                         ----------------UPDATE--------------");
    }

    public final void DesainDeleteAkun() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                         ----------------DELETE--------------");
    }

    public final void DesainProfil() throws IOException{
        System.out.println((char)27 +  "[05;36m \nProfil");
        System.out.println("......\n" + (char)27 + "[00;00m");
    }

    public final void DesainProfilPengguna() throws IOException{
        System.out.println((char)27 +  "[05;36m \nProfil Pengguna");
        System.out.println("...............\n" + (char)27 + "[00;00m");
    }

    public final void DesainRegistrasi() throws IOException{
        System.out.println((char)27 +  "[05;36m \nRegistrasi");
        System.out.println("..........\n" + (char)27 + "[00;00m");
    }

    public final void DesainLogin() throws IOException{
        System.out.println((char)27 +  "[05;36m \nLogin");
        System.out.println(".....\n" + (char)27 + "[00;00m");
    }

    public final void DesainCreateAkunSeniman() throws IOException{
        System.out.println((char)27 +  "[05;36m \nTambah Akun Seniman");
        System.out.println("...................\n" + (char)27 + "[00;00m");
    }

    public final void DesainMenuAdmin() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                                      Menu Utama");
        System.out.println("                                                                      ..........\n" + (char)27 + "[00;00m");
        System.out.print("           ");
        System.out.print("[1] Profil          ");
        System.out.print("[2] Manajemen Seniman          ");
        System.out.print("[3] Lihat Data Pengguna          ");
        System.out.print("[4] Lihat Statistik Penjualan          ");
        System.out.println("[0] Logout");
        InputPilihan();
    }

    public final void DesainStatistikPenjualan() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                              Data Statistik Penjualan");
        System.out.println("                                                              ........................\n" + (char)27 + "[00;00m");
        System.out.println("          +-------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("          |   Total Pendapatan   | Rata-Rata Penjualan |  Penjualan Tertinggi | Penjualan Terendah  |           Produk          | Frekuensi Penjualan |");
        System.out.println("          +----------------------+---------------------+----------------------+---------------------+---------------------------+---------------------+");
    }

    public final void DesainShowAkunSeniman() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                                     Data Seniman");
        System.out.println("                                                                     ............\n" + (char)27 + "[00;00m");
        System.out.println("                                   +---------------------------------------------------------------------------------+");
        System.out.println("                                   |    ID Akun   |     Nama Lengkap    |        Username      |    Nomor Rekening   |");
        System.out.println("                                   +--------------+---------------------+----------------------+---------------------+");
    }

    public final void DesainShowAkunSeniman2() throws IOException{
        System.out.println("                                   +--------------+---------------------+----------------------+---------------------+");
    }

    public final void DesainStatistikPenjualan2() throws IOException{
        System.out.println("          +----------------------+---------------------+----------------------+---------------------+---------------------------+---------------------+");
    }

    public final void MsgUsernameAlready() throws IOException{
        System.out.println((char)27 +  "[05;31m\n                                                         Warning: Username Telah Digunakan!\n" + (char)27 + "[00;00m");
    }

    // Berhasil Manage Seniman
    public final void MsgBerhasilTambahSeniman() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\nSuccesed: Akun seniman berhasil ditambahkan!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgBerhasilEditSeniman() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\nSuccesed: Akun seniman berhasil diedit!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }
    
    public final void MsgBerhasilHapusSeniman() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\n                                                        Succesed: Akun seniman berhasil dihapus!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgGagalHapusSeniman() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                           Error: Akun seniman gagal dihapus" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void Sleep() throws IOException{
        try{
            Thread.sleep(1000);
        } catch (InterruptedException Error) {}
    }

    public final void DesainMenuAdminSeniman() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                                     Menu Seniman");
        System.out.println("                                                                     ............\n" + (char)27 + "[00;00m");
        System.out.print("                      ");
        System.out.print("[1] Tambah Akun          ");
        System.out.print("[2] Lihat Akun          ");
        System.out.print("[3] Update Akun          ");
        System.out.print("[4] Hapus Akun          ");
        System.out.println("[0] Kembali");
        InputPilihan();
    }

    public final void MsgIdNot() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                        Error: ID yang dipilih tidak tersedia!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void QuestionDel() throws IOException{
        try{
            Thread.sleep(500);
            System.out.print((char)27 +  "[05;33m\n                                                         Question: Yakin hapus akun ini (Y/N)? " + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void DesainMenuEditSeniman() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                        ---------------Menu Edit--------------"+ (char)27 + "[00;00m");
        System.out.println("\n                                                                [1] Update Nama Lengkap");
        System.out.println("                                                                [2] Update Password");
        System.out.println("                                                                [3] Update Nomor Rekening");
        System.out.println("                                                                [0] Kembali");
        InputPilihan();
    }

    // Pengguna
    public final void DesainShowAkunPengguna() throws IOException{
        System.out.println((char)27 +  "[05;36m\n                                                                     Data Pengguna");
        System.out.println("                                                                     ............\n" + (char)27 + "[00;00m");
        System.out.println("                                             +-----------------------------------------------------------+");
        System.out.println("                                             |    ID Akun   |     Nama Lengkap    |        Username      |");
        System.out.println("                                             +--------------+---------------------+----------------------+");
    }

    public final void DesainShowAkunPengguna2() throws IOException{
        System.out.println("                                             +--------------+---------------------+----------------------+");
    }

    public final void MsgNotLogin() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                        Error: Username atau Password Salah!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void DesainMenuUtama() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                                     Landing Page");
        System.out.println("                                                                     ............\n" + (char)27 + "[00;00m");
        System.out.print("                                               ");
        System.out.print("[1] Registrasi          ");
        System.out.print("[2] Login          ");
        System.out.println("[0] Exit Program");
        InputPilihan();
    }

    public final void MsgExit() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                       Y O U - E X I T - T H E - S Y S T E M" + (char)27 + "[00;00m");
        System.out.print("\n");
    }

    // User
    public final void DesainMenuUser() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                                      Menu Utama");
        System.out.println("                                                                      ..........\n" + (char)27 + "[00;00m");
        System.out.print("                           ");
        System.out.print("[1] Profil          ");
        System.out.print("[2] Karya Seni          ");
        System.out.print("[3] Pesan          ");
        System.out.print("[4] Riwayat Transaksi          ");
        System.out.println("[0] Logout");
        InputPilihan();
    }

    public final void DesainShowAkunUser() throws IOException{
        System.out.println((char)27 +  "[05;36m\n                                                                        Profil");
        System.out.println("                                                                        ......\n" + (char)27 + "[00;00m");
        System.out.println("                                   +---------------------------------------------------------------------------------+");
        System.out.println("                                   |    ID Akun   |     Nama Lengkap    |        Username      |         Status      |");
        System.out.println("                                   +--------------+---------------------+----------------------+---------------------+");
    }

    public final void DesainShowAkunUser2() throws IOException{
        System.out.println("                                   +--------------+---------------------+----------------------+---------------------+");
    }

    public final void DesainMenuProfilUser() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                       ---------------Menu Profil--------------"+ (char)27 + "[00;00m");
        System.out.println("\n                                                                    [1] Update Akun");
        System.out.println("                                                                    [2] Hapus Akun");
        System.out.println("                                                                    [0] Kembali");
        InputPilihan();
    }

    public final void MsgBerhasilHapusUser() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\n                                                        Succesed: Akun Anda berhasil dihapus!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgGagalHapusUser() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                           Error: Akun Anda gagal dihapus" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgBerhasilRegisUser() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\n                                                        Succesed: Akun Anda berhasil DiBuat!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgNotInput() throws IOException{
        System.out.println((char)27 +  "[05;31m\nError: Data tidak boleh kosong!"  + (char)27 + "[00;00m");
    }

    public final void MsgBerhasilLogin() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\n                                                            Succesed: Anda Berhasil Login!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgBerhasilEditUser() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\nSuccesed: Akun Anda berhasil diedit!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }
    
    public final void DesainMenuEditUser() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                        ---------------Menu Edit--------------"+ (char)27 + "[00;00m");
        System.out.println("\n                                                                [1] Update Nama Lengkap");
        System.out.println("                                                                [2] Update Username");
        System.out.println("                                                                [3] Update Password");
        System.out.println("                                                                [0] Kembali");
        InputPilihan();
    }

    public final void DesainRiwayatTransaksi() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                                  Riwayat Transaksi");
        System.out.println("                                                                  .................\n" + (char)27 + "[00;00m");
    }

    public final void DesainMenuKatalog() throws IOException{
        System.out.println((char)27 +  "[05;36m\n                                                                      All Katalog");
        System.out.println("                                                                      ...........\n" + (char)27 + "[00;00m");
    }

    public final void DesainShowKatalog() throws IOException{
        System.out.println("                                              +------------------------------------------------------------+");
        System.out.println("                                              | ID Karya Seni |      Karya Seni     |         Harga        |");
        System.out.println("                                              +---------------+---------------------+----------------------+");
    }

    public final void DesainShowKatalog2() throws IOException{
        System.out.println("                                              +---------------+---------------------+----------------------+");
    }

    public final void DesainMenuKatalog2() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                       ---------------Menu Katalog--------------"+ (char)27 + "[00;00m");
        System.out.println("\n                                                                      [1] Cari");
        System.out.println("                                                                      [2] Biografi");
        System.out.println("                                                                      [0] Kembali");
        InputPilihan();
    }

    public final void DesainKatalogPatung() throws IOException{
        System.out.println((char)27 +  "[05;36m\n                                                                    Katalog Patung");
        System.out.println("                                                                    ..............\n" + (char)27 + "[00;00m");
    }

    public final void DesainKatalogLukisan() throws IOException{
        System.out.println((char)27 +  "[05;36m\n                                                                    Katalog Lukisan");
        System.out.println("                                                                    ...............\n" + (char)27 + "[00;00m");
    }

    public final void DesainKatalogUkir() throws IOException{
        System.out.println((char)27 +  "[05;36m\n                                                                     Katalog Ukir");
        System.out.println("                                                                     ............\n" + (char)27 + "[00;00m");
    }

    public final void DesainCari() throws IOException{
        System.out.print((char)27 +  "[05;36m\n                                                                    Kata Kunci : " + (char)27 + "[00;00m");
    }

    public final void DesainNotFind() throws IOException{
        System.out.println((char)27 +  "[05;31m\n                                                                    Tidak ditemukan." + (char)27 + "[00;00m");
    }

    public final void DesainMenuKaryaSeni() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                                    Menu Karya Seni");
        System.out.println("                                                                    ...............\n" + (char)27 + "[00;00m");
        System.out.print("                          ");
        System.out.print("[1] Katalog          ");
        System.out.print("[2] Lihat Lukisan          ");
        System.out.print("[3] Lihat Patung          ");
        System.out.print("[4] Lihat Ukir          ");
        System.out.println("[0] Kembali");
        InputPilihan();
    }

    public final void DesainBiografi() throws IOException{
        System.out.println((char)27 +  "[05;36m\n                                                                       Biografi" + (char)27 + "[00;00m");
        System.out.println("                                                       ..........................................\n");
    }

    public final void DesainDataEmpty() throws IOException{
        System.out.println((char)27 +  "[05;33m\n                                                              Karya Seni Terjual Habis." + (char)27 + "[00;00m");
    }

    public final void DesainMenuPesanan() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                                      Menu Pesan");
        System.out.println("                                                                      ..........\n" + (char)27 + "[00;00m");
        System.out.print("                                 ");
        System.out.print("[1] Pesan Lukisan          ");
        System.out.print("[2] Pesan Patung          ");
        System.out.print("[3] Pesan Ukir          ");
        System.out.println("[0] Kembali");
        InputPilihan();
    }

    public final void DesainPesan() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                                         Item");
        System.out.println("                                                                         ....\n" + (char)27 + "[00;00m");
    }

    public final void DesainJumlahItem() throws IOException{
        System.out.print((char)27 +  "[05;36m \n                                                                     Jumlah Item : "+ (char)27 + "[00;00m");
    }

    public final void DesainNoRek() throws IOException{
        System.out.print((char)27 +  "[05;36m \nIsi Nomor Rekening Anda : "+ (char)27 + "[00;00m");
    }

    public final void DesainAlamat() throws IOException{
        System.out.print((char)27 +  "[05;36m \nIsi Alamat Anda         : "+ (char)27 + "[00;00m");
    }

    public final void DesainEmail() throws IOException{
        System.out.print((char)27 +  "[05;36m \nIsi Email Anda          : "+ (char)27 + "[00;00m");
    }

    public final void DesainBuktiPembayaran() throws IOException{
        System.out.println((char)27 +  "[05;33m     \n                                             Kirim Bukti Pembayaran Melalui Email GaleriSeniGroup3@gmail.com"+ (char)27 + "[00;00m");
    }

    public final void PilihKaryaSeni() throws IOException{
        System.out.println((char)27 +  "[03;36m   \n                                                        ~ Pilih Digit Terakhir ID Karya Seni ~"+ (char)27 + "[00;00m");
        System.out.print(                      "                                                                          ");
    }
    
    public final void DesainIdAkun() throws IOException{
        System.out.println((char)27 +  "[03;36m \n                                                           ~ Pilih Digit Terakhir ID Akun ~ "+ (char)27 + "[00;00m");
        System.out.print(                      "                                                                           ");
    }

    public final void MsgPasswordIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                         Error: Password Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgUsernameIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                         Error: Username Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgNamaIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                        Error: Nama Lengkap Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgNoRekIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                        Error: Nomor Rekening Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgNoRekDigitMinimal() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                         Error: Nomor Rekening Minimal 10 Digit!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgAlamatIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                            Error: Alamat Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgEmailIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                             Error: Email Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgInvalidEmail() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                             Error: Email Harus Mengandung @!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgNamaNotAlfabet() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                   Error: Nama Lengkap Hanya Boleh Terdiri Dari Huruf!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgNotNumberNoRek() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                  Error: Nomor Rekening Hanya Boleh Terdiri Dari Angka!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }


    public final void MsgInputNotNumber() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                             Error: Input Hanya Boleh Angka!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void DesainNotData() throws IOException{
        System.out.println((char)27 +  "[05;33m\n                                                               Data Belum Ditambahkan." + (char)27 + "[00;00m");
    }

    public final void DesainNotStatistik() throws IOException{
        System.out.println((char)27 +  "[05;33m\n                                                              Karya Seni Belum Terjual." + (char)27 + "[00;00m");
    }

    public final void DesainNotTransaksi() throws IOException{
        System.out.println((char)27 +  "[05;33m                                                            Anda Belum melakukan transaksi."+ (char)27 + "[00;00m");
    }



    //SENIMAN
    public final void DesainMenuSeniman() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                                      Menu Utama");
        System.out.println("                                                                      ..........\n" + (char)27 + "[00;00m");
        System.out.print("\n         [1] Profil     ");
        System.out.print("[2] Manajemen Data Lukisan     ");
        System.out.print("[3] Manajemen Data Patung     ");
        System.out.print("[4] Manajemen Data Ukir     ");
        System.out.print("[5] Riwayat Transaksi     ");
        System.out.println("[0] Logout");
        InputPilihan();
    }

    public final void DesainCreateLukisan() throws IOException{
        System.out.println((char)27 +  "[05;36m \nTambah Data Lukisan");
        System.out.println("...................\n" + (char)27 + "[00;00m");
    }

    public final void MsgNamaLukIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                        Error: Nama Lukisan Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgNamaLukNotAlfabet() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                   Error: Nama Lukisan Hanya Boleh Terdiri Dari Huruf!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgTeknikLukIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                       Error: Teknik Lukisan Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgTeknikLukNotAlfabet() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                  Error: Teknik Lukisan Hanya Boleh Terdiri Dari Huruf!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgAliranLukIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                       Error: Aliran Lukisan Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgAliranLukNotAlfabet() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                  Error: Aliran Lukisan Hanya Boleh Terdiri Dari Huruf!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgTahunPublikasiLukIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                    Error: Tahun Publikasi Lukisan Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgTahunPublikasiLukNotAngka() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                               Error: Tahun Publikasi Lukisan Hanya Boleh Terdiri Dari Angka!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgTahunDigitMinimal() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                            Error: Tahun Publikasi Harus 4 Digit!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgBerhasilTambahLukisan() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\nSuccesed: Data Lukisan Berhasil Ditambahkan!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    } 

    public final void MsgBerhasilEditLukisan() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\nSuccesed: Data Lukisan Berhasil Diedit!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    } 
    
    
    public final void DesainUpdateLukisan() throws IOException{
        System.out.println((char)27 +  "[05;36m \nUpdate Data Lukisan");
        System.out.println("...................\n" + (char)27 + "[00;00m");
    }

    public final void DesainDelete() throws IOException{
        System.out.println((char)27 +  "[05;36m \n                                                         ----------------DELETE--------------" + (char)27 + "[00;00m");
    }

    public final void QuestionDelKarya() throws IOException{
        try{
            Thread.sleep(500);
            System.out.print((char)27 +  "[05;33m\n                                                         Question: Yakin hapus Data ini (Y/N)? " + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgBerhasilHapusKarya() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\n                                                       Succesed: Data Karya Seni berhasil dihapus!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgGagalHapusKarya() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                           Error: Karya Seni gagal dihapus" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void DesainCreatePatung() throws IOException{
        System.out.println((char)27 +  "[05;36m \nTambah Data Patung");
        System.out.println("...................\n" + (char)27 + "[00;00m");
    }

    public final void MsgNamaPatIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                         Error: Nama Patung Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgNamaPatNotAlfabet() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                    Error: Nama Patung Hanya Boleh Terdiri Dari Huruf!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgJenisPatIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                         Error: Jenis Patung Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgJenisPatNotAlfabet() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                    Error: Jenis Patung Hanya Boleh Terdiri Dari Huruf!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgTahunPublikasiPatIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                    Error: Tahun Publikasi Patung Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgTahunPublikasiPatNotAngka() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                               Error: Tahun Publikasi Patung Hanya Boleh Terdiri Dari Angka!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void DesainUpdatePatung() throws IOException{
        System.out.println((char)27 +  "[05;36m \nUpdate Data Patung");
        System.out.println("...................\n" + (char)27 + "[00;00m");
    }

    public final void DesainUpdateUkir() throws IOException{
        System.out.println((char)27 +  "[05;36m \nUpdate Data Ukir");
        System.out.println("...................\n" + (char)27 + "[00;00m");
    }

    public final void DesainCreateUkir() throws IOException{
        System.out.println((char)27 +  "[05;36m \nTambah Data Ukir");
        System.out.println("...................\n" + (char)27 + "[00;00m");
    }

    public final void MsgNamaUkIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                          Error: Nama Ukir Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgNamaUkNotAlfabet() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                     Error: Nama Ukir Hanya Boleh Terdiri Dari Huruf!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgMotifUkIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                         Error: Motif Ukir Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgMotifUkNotAlfabet() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                    Error: Motif Ukir Hanya Boleh Terdiri Dari Huruf!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgTahunPublikasiUkIsEmpty() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                     Error: Tahun Publikasi Ukir Tidak Boleh Kosong!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgTahunPublikasiUkNotAngka() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;31m\n                                                Error: Tahun Publikasi Ukir Hanya Boleh Terdiri Dari Angka!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    }

    public final void MsgBerhasilTambahUkir() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\nSuccesed: Data Ukir Berhasil Ditambahkan!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    } 

    public final void MsgBerhasilEditUkir() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\nSuccesed: Data Ukir Berhasil Diedit!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    } 

    public final void MsgBerhasilTambahPatung() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\nSuccesed: Data Patung Berhasil Ditambahkan!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    } 

    public final void MsgBerhasilEditPatung() throws IOException{
        try{
            Thread.sleep(500);
            System.out.println((char)27 +  "[05;32m\nSuccesed: Data Patung Berhasil Diedit!" + (char)27 + "[00;00m");
        } catch (InterruptedException Error) {}
    } 
}