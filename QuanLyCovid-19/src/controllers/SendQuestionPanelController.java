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
import services.MysqlConnection;
import views.SendQuestionPanel;

/**
 *
 * @author levietdung
 */
public class SendQuestionPanelController {
    public void sendQuestion(SendQuestionPanel panel) throws SQLException, ClassNotFoundException{
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement st = connection.createStatement();
        String question = panel.getQuestionArea().getText();
        String subject = panel.getSubjectArea().getText();
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
        int senderID = LoginController.currentUser.getIDNhanKhau();
        Connection connection2 = MysqlConnection.getMysqlConnection();
        Statement statement2 = connection2.createStatement();
        String sql2 = "Select count(QuestionID) From questionsandanswers";
        ResultSet rs2 = statement2.executeQuery(sql2);
        int number = 0;
        while (rs2.next()){
            number = rs2.getInt("count(QuestionID)");
        }
        String questionID = (number > 10) ? "Q" + number : "Q0" + number;
        
        String sql = "Insert into `questionsandanswers` (`Question`, `QuestionID`, `SenderID`, `Subject`, `sendTime`, `sendDate`, `isAnswered`) values"
                   + "('" + question + "', '" + questionID + "', '" + senderID + "', '" + subject + "', '" + time + "', '" + date + "', 'False')";
        System.out.print(sql);
        st.executeUpdate(sql);
    }
}
