
package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.NhanKhauModel;
import models.UserMoldel;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */
public class LoginController {
    
    public static UserMoldel currentUser = new UserMoldel();
    public static NhanKhauModel currentPersonalInfo;
    
    public boolean login(String userName, String password, String accessPermission) throws SQLException, ClassNotFoundException{
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users WHERE userName = '" + userName +"'");
        if (rs == null) {
            return false;
        }
        while (rs.next()) {
            if (rs.getString("passwd") == null ? password == null : rs.getString("passwd").equals(password)
                && rs.getString("accessPermission").equals(accessPermission)) {
                LoginController.currentUser.setID(rs.getInt("ID"));
                LoginController.currentUser.setUserName(rs.getString("userName"));
                LoginController.currentUser.setPasswd(rs.getString("passwd"));
                LoginController.currentUser.setIDNhanKhau(rs.getInt("ID_nhankhau"));
                LoginController.currentUser.setAccessPermission(rs.getString("accessPermission"));
                ResultSet rs2 = st.executeQuery("SELECT * FROM nhan_khau WHERE ID = " + rs.getInt("ID_nhankhau"));
                while(rs2.next()){
                    currentPersonalInfo = new NhanKhauModel(rs2.getString("hoTen"), rs2.getDate("namSinh"), rs2.getString("gioiTinh"), rs2.getString("soHoChieu"), rs2.getString("diaChiHienNay"), rs2.getString("soDienThoai"), rs2.getString("email"), rs2.getString("covid19affected"));
                }
                return true;
            }
        }
        connection.close();
        return false;
    }
}
