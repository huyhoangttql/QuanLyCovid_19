/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Bean.NhanKhauBean;
import java.util.logging.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author Dell
 */
public class KbytController {
    public static void insert(NhanKhauBean nhankhau) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhankhau1", "root", "");
            
            //query
            String sql = "insert into form(Name, HealthInsurance, Symptom, Base Disease, Exposure, Pregnant, ID) values(?, ?, ?, ?, ?, ?, ?)";
            if (nhankhau.getKbyt().getBhyt() == "Có"){
                nhankhau.getKbyt().setBhyt("Yes");
            } else {
                nhankhau.getKbyt().setBhyt("No");
            }
                    
            String sql1 = "insert into `form`(Name, HealthInsurance, Symptom, BaseDisease, Exposure, Pregnant, ID) values ('" 
                        + nhankhau.getNhanKhauModel().getHoTen() + "', '" + nhankhau.getKbyt().getBhyt() + "', '"
                        + nhankhau.getKbyt().getDauhieu() + "', '" + nhankhau.getKbyt().getBenh() + "', '"
                        + nhankhau.getKbyt().getTiepxuc() + "', '" + nhankhau.getKbyt().getThai() + "', "
                        + nhankhau.getNhanKhauModel().getID() + ")";
                        statement = connection.prepareCall(sql1);

//            statement.setString(1, nhankhau.getNhanKhauModel().getHoTen());
//            statement.setString(2, nhankhau.getKbyt().getBhyt());
//            statement.setString(3, nhankhau.getKbyt().getDauhieu());
//            
//            
//            statement.setString(4, nhankhau.getKbyt().getBenh());
//            statement.setString(5, nhankhau.getKbyt().getTiepxuc());
//            statement.setString(6, nhankhau.getKbyt().getThai());
//            statement.setInt(7, nhankhau.getNhanKhauModel().getID());
            
            System.out.print(sql1);
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(KbytController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KbytController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KbytController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
