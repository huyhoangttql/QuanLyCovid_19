package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import services.MysqlConnection;

/**
 *
 * @author Hai
 */
public class HomeCotrollerHoR {
    private JLabel tongNhanKhauLb;
    private JLabel tongCovidLb;
    private JLabel nhanKhauDiaPhuongLb;
    private JLabel nhanKhauDiCuDenLb;

    public HomeCotrollerHoR(JLabel tongNhanKhauLb, JLabel tongCovidLb, JLabel nhanKhauDiaPhuongLb, JLabel nhanKhauDiCuDenLb) {
        this.tongNhanKhauLb = tongNhanKhauLb;
        this.tongCovidLb = tongCovidLb;
        this.nhanKhauDiaPhuongLb = nhanKhauDiaPhuongLb;
        this.nhanKhauDiCuDenLb = nhanKhauDiCuDenLb;
    }
    
    public void setData() {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT COUNT(*) AS tong FROM nhan_khau";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongNhanKhauLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM nhan_khau where covid19affected like N'%có%'";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongCovidLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM nhan_khau WHERE noiThuongTru like '%Hà Nội%'";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.nhanKhauDiaPhuongLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM nhan_khau WHERE noiThuongTru NOT LIKE '%Hà Nội%'";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.nhanKhauDiCuDenLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            connection.close();
        } catch (Exception e) {
        }
    }

    public JLabel getTongCovidLb() {
        return tongCovidLb;
    }

    public void setTongCovidLb(JLabel tongCovidLb) {
        this.tongCovidLb = tongCovidLb;
    }

    public JLabel getNhanKhauDiaPhuongLb() {
        return nhanKhauDiaPhuongLb;
    }

    public void setNhanKhauDiaPhuongLb(JLabel nhanKhauDiaPhuongLb) {
        this.nhanKhauDiaPhuongLb = nhanKhauDiaPhuongLb;
    }

    public JLabel getNhanKhauDiCuDenLb() {
        return nhanKhauDiCuDenLb;
    }

    public void setNhanKhauDiCuDenLb(JLabel nhanKhauDiCuDenLb) {
        this.nhanKhauDiCuDenLb = nhanKhauDiCuDenLb;
    }

    public JLabel getTongNhanKhauLb() {
        return tongNhanKhauLb;
    }

    public void setTongNhanKhauLb(JLabel tongNhanKhauLb) {
        this.tongNhanKhauLb = tongNhanKhauLb;
    }


    
}
