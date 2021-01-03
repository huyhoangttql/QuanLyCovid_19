/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.NhanKhauManagerController;

import Bean.NhanKhauBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.NhanKhauModel;

/**
 *
 * @author Dell
 */
public class DeletePeople {
    public static void deletePeople(NhanKhauBean nhanKhau){
        //NhanKhauModel nkModel = nhanKhau.getNhanKhauModel();
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;
        PreparedStatement statement4 = null;
        PreparedStatement statement5 = null;
        PreparedStatement statement6 = null;
        PreparedStatement statement7 = null;
        PreparedStatement statement8 = null;
        PreparedStatement statement9 = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhankhau1", "root", "");
            
            //query
//            String sql = "delete from nhan_khau where ID = ?";           
//            statement = connection.prepareCall(sql);
//            statement.setInt(1, nhanKhau.getNhanKhauModel().getID());
//            statement.execute();
            
//            ResultSet rs = statement.getGeneratedKeys();
//            if(rs.next()){
//                int genid = rs.getInt(1);
//                String sql1 = "delete from chung_minh_thu where idNhanKhau = ?"; 
//                statement1 = connection.prepareCall(sql1);
//                statement1.setInt(1, genid);
//                statement1.execute();
//            }

            String sql1 = "delete from chung_minh_thu where idNhanKhau = ?";
            statement1 = connection.prepareCall(sql1);
            //statement1.setInt(1, nhanKhau.getChungMinhThuModel().getIdNhanKhau());
            statement1.setInt(1, nhanKhau.getNhanKhauModel().getID());
            statement1.execute();
                 
            String sql2 = "delete from gia_dinh where idNhanKhau = ?";           
            statement2 = connection.prepareCall(sql2);
            //statement2.setInt(1, nhanKhau.getGiaDinhModel().getIdNhanKhau());
            statement2.setInt(1, nhanKhau.getNhanKhauModel().getID());
            statement2.execute();
            
            String sql3 = "delete from tieu_su where idNhanKhau = ?";           
            statement3 = connection.prepareCall(sql3);
            //statement3.setInt(1, nhanKhau.getTieuSuModel().getIdNhanKhau());
            statement3.setInt(1, nhanKhau.getNhanKhauModel().getID());
            statement3.execute();
            
            String sql5 = "delete from thanh_vien_cua_ho where idNhanKhau = ?";           
            statement5 = connection.prepareCall(sql5);
            //statement3.setInt(1, nhanKhau.getTieuSuModel().getIdNhanKhau());
            statement5.setInt(1, nhanKhau.getNhanKhauModel().getID());
            statement5.execute();
            
            String sql4 = "delete from ho_khau where idChuHo = ?";           
            statement4 = connection.prepareCall(sql4);
            //statement3.setInt(1, nhanKhau.getTieuSuModel().getIdNhanKhau());
            statement4.setInt(1, nhanKhau.getNhanKhauModel().getID());
            statement4.execute();
            
            String sql6 = "delete from users where ID_nhankhau = ?";           
            statement6 = connection.prepareCall(sql6);
            //statement3.setInt(1, nhanKhau.getTieuSuModel().getIdNhanKhau());
            statement6.setInt(1, nhanKhau.getNhanKhauModel().getID());
            statement6.execute();
            
            String sql7 = "delete from covid19management where ID = ?";           
            statement7 = connection.prepareCall(sql7);
            //statement3.setInt(1, nhanKhau.getTieuSuModel().getIdNhanKhau());
            statement7.setInt(1, nhanKhau.getNhanKhauModel().getID());
            statement7.execute();
            
            String sql8 = "delete from form where ID = ?";           
            statement8 = connection.prepareCall(sql8);
            statement8.setInt(1, nhanKhau.getNhanKhauModel().getID());
            statement8.execute();
            
//            String sql9 = "delete from sender where ID = ?";           
//            statement8 = connection.prepareCall(sql8);
//            statement8.setInt(1, nhanKhau.getNhanKhauModel().getID());
//            statement8.execute();
            
            String sql = "delete from nhan_khau where ID = ?";           
            statement = connection.prepareCall(sql);
            statement.setInt(1, nhanKhau.getNhanKhauModel().getID());
            statement.execute();
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DeletePeople.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DeletePeople.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DeletePeople.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
