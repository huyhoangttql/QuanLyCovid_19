/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import services.MysqlConnection;
import views.HealthDeclarationPanel;

/**
 *
 * @author levietdung
 */
public class HealthDeclarationPanelController {
    
    private int districtID = 0;
    private int provinceID = 0;
    
    public void setAddressBox(HealthDeclarationPanel panel) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement st = connection.createStatement();
        String sql = "SELECT * FROM `province`";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            panel.getProvinceBox().addItem(rs.getString("_name"));
        }
    }
    
    public void setDistrictBox(HealthDeclarationPanel panel) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement st = connection.createStatement();
        String sql1 = "SELECT * FROM `province` WHERE `_name` = '" + (String) panel.getProvinceBox().getSelectedItem() + "'";
        ResultSet rs1 = st.executeQuery(sql1);
        while(rs1.next()){
            provinceID = rs1.getInt("id");
        }
        String sql2 = "SELECT * FROM `district` WHERE `_province_id` = " + provinceID;
        panel.getDistrictBox().removeAllItems();
        ResultSet rs2 = st.executeQuery(sql2);
        while(rs2.next()){
            panel.getDistrictBox().addItem(rs2.getString("_name"));
        }
    }
    
    public void setWardBox(HealthDeclarationPanel panel) throws SQLException, ClassNotFoundException {
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement st = connection.createStatement();
        String sql2 = "SELECT * FROM `district` WHERE `_name` = '" + (String) panel.getDistrictBox().getSelectedItem() + "'";
        ResultSet rs2 = st.executeQuery(sql2);
        while(rs2.next()){
            districtID = rs2.getInt("id");
            provinceID = rs2.getInt("_province_id");
        }
        String sql3 = "SELECT * FROM `ward` WHERE `_province_id` = " + provinceID + " AND `_district_id` = " + districtID;
        panel.getWardBox().removeAllItems();
        ResultSet rs3 = st.executeQuery(sql3);
        while(rs3.next()){
            panel.getWardBox().addItem(rs3.getString("_name"));
        }
    }
    
    public void confirmForm(HealthDeclarationPanel panel) throws SQLException, ClassNotFoundException{
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement st = connection.createStatement();
        String name = panel.getNameField().getText();
        String ID = panel.getIDField().getText();
        String haveHealthInsurance = (panel.getHaveHealthInsuranceField().isSelected()) ? "Yes" : "No";
        String province = (String) panel.getProvinceBox().getSelectedItem();
        String district = (String) panel.getDistrictBox().getSelectedItem();
        String ward = (String) panel.getWardBox().getSelectedItem();
        String address = panel.getAddressField().getText();
        String travellingHistory = panel.getTravellingHistoryField().getText();
        String phoneNumber = panel.getPhoneNumberField().getText();
        String email = panel.getEmailField().getText();
        String symptoms = "";
        if (panel.getFeverField().isSelected()){
            symptoms += ",Sốt";
        }
        if (panel.getCoughField().isSelected()){
            symptoms += ",Ho";
        }
        if (panel.getStuffyField().isSelected()){
            symptoms += ",Khó thở";
        }
        if (panel.getPneumoniaField().isSelected()){
            symptoms += ",Viêm phổi";
        }
        if (panel.getShoreThroatField().isSelected()){
            symptoms += ",Đau họng";
        }
        if (panel.getFeverField().isSelected()){
            symptoms += ",Mệt mỏi";
        }
        symptoms = symptoms.substring(1);
        String exposure = "";
        if (panel.getMeetInfectedField().isSelected()){
            exposure += ",Người bị/nghi bị bệnh";
        }
        if (panel.getFromInfectedCountryField().isSelected()){
            exposure += ",Người từ nước có Covid-19";
        }
        if (panel.getHaveSymptomsField().isSelected()){
            exposure += ",Người có biểu hiện";
        }
        exposure = exposure.substring(1);
        String baseDisease = "";
        if (panel.getHepatitisField().isSelected()){
            baseDisease += ",Bệnh gan mãn tính";
        }
        if (panel.getLungDiseaseField().isSelected()){
            baseDisease += ",Bệnh phổi mãn tính";
        }
        if (panel.getHeartRelatedDiseaseField().isSelected()){
            baseDisease += ",Bệnh tim mạch";
        }
        if (panel.getImmunodeficiencyField().isSelected()){
            baseDisease += ",Suy giảm miễn dịch";
        }
        if (panel.getDiabetesFIeld().isSelected()){
            baseDisease += ",Tiểu đường";
        }
        if (panel.getBloodRelatedDiseaseField().isSelected()){
            baseDisease += ",Bệnh máu mãn tính";
        }
        if (panel.getKidneyDisease().isSelected()){
            baseDisease += ",Bệnh thận mãn tính";
        }
        if (panel.getHighBloodPressureField().isSelected()){
            baseDisease += ",Huyết áp cao";
        }
        if (panel.getCancerField().isSelected()){
            baseDisease += ",Ung thư";
        }
        if (panel.getTransplantField().isSelected()){
            baseDisease += ",Người nhận ghép tạng";
        }
        baseDisease = baseDisease.substring(1);
        String pregnantStatus = "";
        if (panel.getHavePregnantButton().isSelected()){
            pregnantStatus = "Có";
        } else if (panel.getDontHavePregnantButton().isSelected()){
            pregnantStatus = "Không";
        }
        String sql = "Insert into `form` (`Name`, `PersonalID`, `HealthInsurance`, `Province`, `District`, `Ward`, "
                   + "`Address`, `PhoneNumber`, `Email`, `TravellingHistory`, `Symptom`, `BaseDisease`, `Exposure`, "
                   + "`Pregnant`, `ID`) values ('" + name + "', '" + ID + "', '" + haveHealthInsurance + "', '"
                   + province + "', '" + district + "', '" + ward + "', '" + address + "', '" + phoneNumber + "', '"
                   + email + "', '" + travellingHistory + "', '" + symptoms + "', '" + baseDisease + "', '" 
                   + exposure + "', '" + pregnantStatus + "', " + LoginController.currentUser.getIDNhanKhau() + ")";
        st.executeUpdate(sql);
    }
}
