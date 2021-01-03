/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import services.MysqlConnection;
import views.UpdateInfoPanel;

/**
 *
 * @author levietdung
 */
public class UpdateInfoPanelController {
    boolean isChangingPassword = false;
    public void changePassword(UpdateInfoPanel panel) throws SQLException, ClassNotFoundException{
        String newPassword = new String(panel.getNewPasswordField().getPassword());
        String oldPassword = new String(panel.getOldPasswordField().getPassword());
        boolean check2 = newPassword.equals(oldPassword);
        boolean check1 = LoginController.currentUser.getPasswd().equals(oldPassword);
        if (panel.getIsChangingPassword().isSelected()){
            if (check1 && check2){
                isChangingPassword = true;
                JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công!", "Succeed", JOptionPane.YES_OPTION);
                Connection connection = MysqlConnection.getMysqlConnection();
                Statement st = connection.createStatement();
                st.executeUpdate("Update users set `passwd` = '" + newPassword + "' WHERE `ID_nhankhau` = " + LoginController.currentUser.getIDNhanKhau());
            } else if (!check1) {
                JOptionPane.showMessageDialog(null, "Sai mật khẩu cũ!", "Failed", JOptionPane.WARNING_MESSAGE);
            } else if (!check2 && check1) {
                JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu mới không đúng!", "Failed", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    public void changeInfo(UpdateInfoPanel panel) throws SQLException, ClassNotFoundException{
        String gender;
        if (panel.getjRadioButton1().isSelected()){
            gender = "Nam";
        } else {
            gender = "Nữ";
        }
        String[] dob = panel.getBodField().getText().split("-");
        String dateOfBirth = dob[0] + "-" + dob[1] + "-" + dob[2];
        
        Connection connection = MysqlConnection.getMysqlConnection();
        Statement st = connection.createStatement();
        String sql = "Update nhan_khau SET `hoTen` = N'" + panel.getNameField().getText() + "'" + 
                                         ",`namSinh` = '" + dateOfBirth + "'" + 
                                         ",`gioiTinh` = N'" + gender + "'" + 
                                         ",`diaChiHienNay` = N'" + panel.getAddressField().getText() + "'" + 
                                         ",`soHoChieu` = '" + panel.getIDField().getText() + "'" + 
                                         ",`email` = '" + panel.getEmailField().getText() + "'" + 
                                         ",`soDienThoai` = '" + panel.getPhoneNumberField().getText() + "'" + 
                                         "WHERE `ID` = " + LoginController.currentUser.getIDNhanKhau();
        st.executeUpdate(sql);
        if (isChangingPassword){
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin thành công!", "Succeed", JOptionPane.WARNING_MESSAGE);
        }
    }
}