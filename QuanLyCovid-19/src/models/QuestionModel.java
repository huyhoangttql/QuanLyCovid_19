/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import services.MysqlConnection;

/**
 *
 * @author Admin
 */
public class QuestionModel {
    private String questionID;
    private String question;
    private String answer;
    private String senderID;
    private String answererID;
    private String subject;
    private String sendTime;
    private String sendDate;
    private String answeredTime;
    private String answeredDate;
    private String isAnswered;

    public QuestionModel(String questionID, String question, String answer, String senderID, String answererID, 
                         String subject, String sendTime, String sendDate, String answeredTime, String answeredDate,
                         String isAnswered) {
        this.questionID = questionID;
        this.question = question;
        this.answer = answer;
        this.senderID = senderID;
        this.answererID = answererID;
        this.subject = subject;
        this.sendTime = sendTime;
        this.sendDate = sendDate;
        this.answer = answer;
        this.answeredTime = answeredTime;
        this.answeredDate = answeredDate;
        this.isAnswered = isAnswered;
    }

    public String getQuestionID() {
        return questionID;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        if (isAnswered.equals("False")){
            return "";
        }
        return answer;
    }

    public String getSenderID() {
        return senderID;
    }

    public String getAnswererID() {
        return answererID;
    }

    public String getSubject() {
        return subject;
    }

    public String getSendTime() {
        return sendTime;
    }

    public String getSendDate() {
        return sendDate;
    }

    public String getAnsweredTime() {
        return answeredTime;
    }

    public String getAnsweredDate() {
        return answeredDate;
    }

    public String getIsAnswered() {
        return isAnswered;
    }
    
    public String getSenderName() throws SQLException, ClassNotFoundException{
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement statement = connection.createStatement();
        String sql = "Select * from `nhan_khau` where ID = " + this.senderID;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            String name = rs.getString("hoTen");
            return name;
        }
        return null;
    }
    
     public String getAnswererName() throws SQLException, ClassNotFoundException{
        if (this.isAnswered.equals("False")){
            return "";
        }
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement statement = connection.createStatement();
        String sql = "Select * from `MedicalStaff` where ID = '" + this.answererID + "'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            String name = rs.getString("Name");
            return name;
        }
        return null;
    }
}