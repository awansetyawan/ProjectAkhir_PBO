package Akun.AkunSeniman.Interface;

import java.io.IOException;

public interface IfaceManagePatung {
    void CreateDataPatung(int IdAkun, String Username) throws IOException;
    void ShowDataPatung(int IdAkun, String Username) throws IOException;
    void UpdateDataPatung(int IdAkun, String Username) throws IOException;
    void DeleteDataPatung(int IdAkun, String Username) throws IOException;
    void MenuManagePatung(int IdAkun, String Username) throws IOException;
}
