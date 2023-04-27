package Akun.AkunSeniman.Interface;

import java.io.IOException;

public interface IfaceManageLukisan {
    void CreateDataLukisan(int IdAkun, String Username) throws IOException;
    void ShowDataLukisan(int IdAkun, String Username) throws IOException;
    void UpdateDataLukisan(int IdAkun, String Username) throws IOException;
    void DeleteDataLukisan(int IdAkun, String Username) throws IOException;
}
