package com.company.payroll.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.SalaryModel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class IssueIncrementController {

    @FXML
    private Button submit;

    @FXML
    private Button clear;

    @FXML
    private TextField employee_name;

    @FXML
    private TextField increment_salary;
    
    private String user_name;

    @FXML
    void submit(MouseEvent event) {
    	String e_name = employee_name.getText();
    	Double inc_salary = Double.valueOf(increment_salary.getText());
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = new Date(System.currentTimeMillis());
    	String inc_date = dateFormat.format(date);
    	
    	SalaryModel salary = new SalaryModel(inc_salary, inc_date, e_name, getUser_name());
    	int status = ManagerDao.issueIncrement(salary);
    	if(status > 0) {
    		InterfaceElements.dialog("Info", "Successful updated employee salary.");
    		clearTextField();
    	} else {
    		InterfaceElements.dialog("Info", "Failed to update employee salary.");
    	}
    }

    @FXML
    void clear(MouseEvent event) {
    	clearTextField();
    }

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	private void clearTextField() {
		employee_name.clear();
    	increment_salary.clear();
	}
}
