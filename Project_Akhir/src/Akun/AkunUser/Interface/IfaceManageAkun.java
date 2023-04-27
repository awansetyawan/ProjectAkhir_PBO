package Akun.AkunUser.Interface;

import java.io.IOException;

public interface IfaceManageAkun {
    void ShowAkunUser(int IdAkun) throws IOException;
    void UpdateAkunUser(int IdAkun) throws IOException;
    void DeleteAkunUser(int IdAkun) throws IOException;
    void ShowMenu(int IdAkun) throws IOException;
}
