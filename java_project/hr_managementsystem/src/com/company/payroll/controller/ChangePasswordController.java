package com.company.payroll.controller;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.dao.UserDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.EmployeeModel;
import com.company.payroll.services.PasswordEncription;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

public class ChangePasswordController {

    @FXML
    private Label password_status;

    @FXML
    private PasswordField new_pass;

    @FXML
    private Label confirmed_pass_status;

    @FXML
    private PasswordField confirmed_pass;

    @FXML
    private PasswordField old_pass;
    
    private int user_id;

    @FXML
    void submit(MouseEvent event) {
    	String oldPass = old_pass.getText();
    	EmployeeModel auth = UserDao.employeeAuth(getUser_id());
    	Boolean validate = PasswordEncription.verifyUserPassword(oldPass, auth.getPassword(), auth.getKey());
    	if(validate==true) {
        	String newPass = new_pass.getText();
        	String confirmedPass = confirmed_pass.getText();
        	if(newPass.equals(confirmedPass)) {
        		String salt = PasswordEncription.getSaltvalue(30);
		    	String hashed_password = PasswordEncription.generateSecurePassword(newPass, salt);
		    	
        		System.out.println("id: " + getUser_id() + "\nnew pass: " + newPass + "\tconfrimed pass: " + confirmedPass + "\nsalt: " + salt + "\thash: " + 
        				hashed_password);
        		EmployeeModel employee = new EmployeeModel(getUser_id(), hashed_password, salt);
        		int status = EmployeeDao.updatePassword(employee);
        		if(status > 0 ) {
        			InterfaceElements.dialog("Info", "Password changed successful.");
        			confirmed_pass_status.setVisible(false);
            		password_status.setVisible(false);
            		clearTextField();
        		} else {
        			InterfaceElements.dialog("Info", "Failed to change password");
        		}
        	} else {
        		confirmed_pass_status.setText("New password and confirmed password are not equal.");
        		confirmed_pass_status.setStyle("-fx-text-fill: #f00;");
        		confirmed_pass_status.setVisible(true);
        	}	
		} else {
			password_status.setText("Old password incorrect.");
			password_status.setStyle("-fx-text-fill: #f00;");
			password_status.setVisible(true);
		}
    }

    @FXML
    void clear(MouseEvent event) {
    	clearTextField();
    }
    
    private void clearTextField() {
    	old_pass.clear();
    	new_pass.clear();
    	confirmed_pass.clear();
    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
