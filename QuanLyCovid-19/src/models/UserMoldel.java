package models;

/**
 *
 * @author Hai
 */
public class UserMoldel {
    private int ID;
    private String userName;
    private String passwd;
    private String accessPermission;
    private int ID_nhankhau;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public int getIDNhanKhau(){
        return this.ID_nhankhau;
    }
    
    public String getAccessPermission(){
        return this.accessPermission;
    }

    public void setIDNhanKhau(int idNhanKhau) {
        this.ID_nhankhau = idNhanKhau;
    }

    public void setAccessPermission(String accessPermission) {
        this.accessPermission = accessPermission;
    }
}
