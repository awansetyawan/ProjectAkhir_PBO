package Akun;

public class Akun {
    
    // Property
    protected String Username;
    protected String Password;
    protected String NamaLengkap;

    // Constructor
    public Akun(String username, String password, String namaLengkap) {
        this.Username = username;
        this.Password = password;
        this.NamaLengkap = namaLengkap;
    }

    // Setter & Getter
    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getNamaLengkap() {
        return NamaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.NamaLengkap = namaLengkap;
    }    
}
