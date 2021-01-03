/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.QuestionModel;
import services.MysqlConnection;
import views.UpdateInfo;

/**
 *
 * @author Admin
 */
public class TraLoiCauHoiController {
    public void reply(String questionID, UpdateInfo panel) throws ClassNotFoundException, SQLException {
        if (panel.getjTextArea2().getText().equals("")){
            return;
        }
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement statement = connection.createStatement();
        LocalDateTime day = java.time.LocalDateTime.now();
        String hour = "" + day.getHour();
        if (hour.length() == 1){
            hour = "0" + hour;
        }
        String minute = "" + day.getMinute();
        if (minute.length() == 1){
            minute = "0" + minute;
        }
        String time = hour + ":" + minute;  
        String date = "" + day.getDayOfMonth() + "/" + day.getMonth().getValue() + "/" + day.getYear();
        String sql = "Update questionsandanswers set Answer = '" + panel.getjTextArea2().getText() + 
                     "', answeredTime = '" + time + "', answeredDate = '" + date + "', isAnswered = 'True' where questionID = '" + questionID + "'";
        System.out.printf(sql);
        statement.executeUpdate(sql);
    }

    /**
     *
     * @return
     */
    public List<QuestionModel> showTraLoiCauHoi() throws ClassNotFoundException{
        List<QuestionModel> traloicauhoilist = new ArrayList<>();               
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = MysqlConnection.getMysqlConnection();
            String sql = "select * from questionsAndAnswers";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                QuestionModel tlch = new QuestionModel(resultSet.getString("QuestionID"),
                        resultSet.getString("Question"),
                        resultSet.getString("Answer"),
                        resultSet.getString("SenderID"),
                        resultSet.getString("AnswererID"),
                        resultSet.getString("Subject"),
                        resultSet.getString("sendTime"),
                        resultSet.getString("sendDate"),
                        resultSet.getString("answeredTime"),
                        resultSet.getString("answeredDate"),
                        resultSet.getString("isAnswered")
                ); 
                traloicauhoilist.add(tlch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraLoiCauHoiController.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TraLoiCauHoiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null){
                try {               
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TraLoiCauHoiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       return traloicauhoilist;
    }
    
    public QuestionModel getQuestion(String questionID) throws SQLException, ClassNotFoundException{
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement statement = connection.createStatement();
        String sql = "Select * from questionsAndAnswers where QuestionID = '" + questionID + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            QuestionModel question = new QuestionModel(resultSet.getString("QuestionID"),
                        resultSet.getString("Question"),
                        resultSet.getString("Answer"),
                        resultSet.getString("SenderID"),
                        resultSet.getString("AnswererID"),
                        resultSet.getString("Subject"),
                        resultSet.getString("sendTime"),
                        resultSet.getString("sendDate"),
                        resultSet.getString("answeredTime"),
                        resultSet.getString("answeredDate"),
                        resultSet.getString("isAnswered")
            ); 
            return question;
        }
        return null;
    }
}
