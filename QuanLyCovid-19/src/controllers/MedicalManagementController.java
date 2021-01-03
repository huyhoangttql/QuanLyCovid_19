/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import models.KhaiBaoYTe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.MysqlConnection;
import views.MedicalManagement;

public class MedicalManagementController {
    public List<KhaiBaoYTe> findAll() throws ClassNotFoundException{
        List<KhaiBaoYTe> khaibaoytelist = new ArrayList<>();               
        Connection connection = null;
        Statement statement = null;
        try {
            //lấy tất cả thông tin khai báo y tế
            connection = MysqlConnection.getMysqlConnection();
            //query
            String sql = "select * from covid19Management";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                KhaiBaoYTe kbyt = new KhaiBaoYTe(resultSet.getString("ID"),
                        resultSet.getString("Status"),
                        resultSet.getString("InfectedFrom"),
                        resultSet.getString("RecoveredConfirm"),
                        resultSet.getString("TreatingPlace"),
                        resultSet.getString("QuarantineStartDate"),
                        resultSet.getString("QuarantineFinishDate"),
                        resultSet.getString("QuarantinePlace"));
                khaibaoytelist.add(kbyt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicalManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicalManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null){
                try {               
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicalManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       return khaibaoytelist;
    }
    
    public List<KhaiBaoYTe> findFilter(MedicalManagement parentPanel) throws ClassNotFoundException{
        List<KhaiBaoYTe> khaibaoytelist = new ArrayList<>();               
        Connection connection = null;
        Statement statement = null;
        try {
            //lấy tất cả thông tin khai báo y tế
            connection = MysqlConnection.getMysqlConnection();
            //query
            String sql = "select * from covid19Management where ";
            
            if (parentPanel.getjComboBox1().getSelectedItem().equals("Đang cách ly")){
                sql += "Status = 'Self-Quarantine'";
                if (!parentPanel.getjTextField1().getText().equals("") &&
                    !parentPanel.getjTextField2().getText().equals("")){
                    String[] startDate = parentPanel.getjTextField1().getText().split("/");
                    String[] finishDate = parentPanel.getjTextField2().getText().split("/");
                    sql += " AND QuarantineStartDate >= '" + startDate[2] + "-" + startDate[1] + "-" + startDate[0] + "'"
                         + " AND QuarantineFinishDate <= '" + finishDate[2] + "-" + finishDate[1] + "-" + finishDate[0] + "'";
                } else if (parentPanel.getjTextField2().getText().equals("")){
                    String[] startDate = parentPanel.getjTextField1().getText().split("/");
                    sql += " AND QuarantineStartDate >= '" + startDate[2] + "-" + startDate[1] + "-" + startDate[0] + "'";
                } else if (parentPanel.getjTextField1().getText().equals("")){
                    String[] finishDate = parentPanel.getjTextField2().getText().split("/");
                    sql += " AND QuarantineFinishDate <= '" + finishDate[2] + "-" + finishDate[1] + "-" + finishDate[0] + "'";
                }
            } else if (parentPanel.getjComboBox1().getSelectedItem().equals("Đã nhiễm bệnh")){
                sql += "Status = 'Infected'";
                if (!parentPanel.getjTextField3().getText().equals("") &&
                    !parentPanel.getjTextField4().getText().equals("")){
                    String[] startDate = parentPanel.getjTextField3().getText().split("/");
                    String[] finishDate = parentPanel.getjTextField4().getText().split("/");
                    sql += " AND InfectedFrom >= '" + startDate[2] + "-" + startDate[1] + "-" + startDate[0] + "'"
                         + " AND RecoveredConfirm <= '" + finishDate[2] + "-" + finishDate[1] + "-" + finishDate[0] + "'";
                } else if (parentPanel.getjTextField4().getText().equals("")){
                    String[] startDate = parentPanel.getjTextField3().getText().split("/");
                    sql += " AND InfectedFrom >= '" + startDate[2] + "-" + startDate[1] + "-" + startDate[0] + "'";
                } else if (parentPanel.getjTextField3().getText().equals("")){
                    String[] finishDate = parentPanel.getjTextField4().getText().split("/");
                    sql += " AND RecoveredConfirm <= '" + finishDate[2] + "-" + finishDate[1] + "-" + finishDate[0] + "'";
                }
            } else if (parentPanel.getjComboBox1().getSelectedItem().equals("Chưa nhiễm bệnh")){
                sql += "Status = 'Not Infected'";
            }
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                KhaiBaoYTe kbyt = new KhaiBaoYTe(resultSet.getString("ID"),
                        resultSet.getString("Status"),
                        resultSet.getString("InfectedFrom"),
                        resultSet.getString("RecoveredConfirm"),
                        resultSet.getString("TreatingPlace"),
                        resultSet.getString("QuarantineStartDate"),
                        resultSet.getString("QuarantineFinishDate"),
                        resultSet.getString("QuarantinePlace"));
                khaibaoytelist.add(kbyt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicalManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicalManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null){
                try {               
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicalManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       return khaibaoytelist;
    }
}

