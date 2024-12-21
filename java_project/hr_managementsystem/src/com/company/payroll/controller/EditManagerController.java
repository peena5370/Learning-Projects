package com.company.payroll.controller;

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.ManagerModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditManagerController {

    @FXML
    private Button cancel;

    @FXML
    private TextField role;

    @FXML
    private Button submit;

    @FXML
    private TextField phone;

    @FXML
    private TextField fullname;

    @FXML
    private TextField position;

    @FXML
    private TextField department;

    @FXML
    private TextField email;
    
    private int id_number;
    
    @FXML
    void submit(ActionEvent event) {
    	String m_role = role.getText();
    	String m_name = fullname.getText();
    	String post = position.getText();
    	String dept = department.getText();
    	String phone_num = phone.getText();
    	String mail = email.getText();
    	int id = getId_number();
    	
    	ManagerModel manager = new ManagerModel(id, m_name, m_role, post, dept, phone_num, mail);
    	int status = ManagerDao.update(manager);
    	if(status > 0) {
    		InterfaceElements.dialog("Info", "Sucessful updated info.");
    		Stage stage = (Stage) submit.getScene().getWindow();
    	    stage.close();
    	} else {
    		InterfaceElements.dialog("Info", "Failed to update info.");
    	}
    }

    @FXML
    void clear(MouseEvent event) {
    	clearTextField();
    }

    /**
     * clear all text field
     * */
    private void clearTextField() {
    	fullname.clear();
    	role.clear();
    	department.clear();
    	position.clear();
    	phone.clear();
    	email.clear();
    }

	public int getId_number() {
		return id_number;
	}

	public void setId_number(int id_number) {
		this.id_number = id_number;
	}
}
