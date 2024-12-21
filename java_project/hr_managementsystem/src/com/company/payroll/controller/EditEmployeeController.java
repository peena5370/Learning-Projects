package com.company.payroll.controller;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.EmployeeModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditEmployeeController {

    @FXML
    private Button cancel;

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
    	String name = fullname.getText();
    	String post = position.getText();
    	String dept = department.getText();
    	String phone_num = phone.getText();
    	String mail = email.getText();	
    	int id = getId_number();
    	
    	EmployeeModel employee = new EmployeeModel(id, name, post, dept, phone_num, mail);
    	int status = EmployeeDao.update(employee);
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
