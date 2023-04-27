package Akun.AkunSeniman.Interface;

import java.io.IOException;

public interface IfaceManageUkir {
    void CreateDataUkir(int IdAkun, String Username) throws IOException;
    void ShowDataUkir(int IdAkun, String Username) throws IOException;
    void UpdateDataUkir(int IdAkun, String Username) throws IOException;
    void DeleteDataUkir(int IdAkun, String Username) throws IOException;
    void MenuManageUkir(int IdAkun, String Username) throws IOException;
}
