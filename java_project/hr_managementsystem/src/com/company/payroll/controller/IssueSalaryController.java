package com.company.payroll.controller;

import java.sql.Date;

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.MonthlySalaryModel;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class IssueSalaryController {

    @FXML
    private TextField base_pay;

    @FXML
    private TextField deduction;

    @FXML
    private TextField ot_pay;

    @FXML
    private TextField employee_name;

    @FXML
    private DatePicker date_issue;
    
    private String user_name;

    @FXML
    void submit(MouseEvent event) {
    	String e_name = employee_name.getText();
    	Double base_salary = Double.valueOf(base_pay.getText());
    	Double ot_salary = Double.valueOf(ot_pay.getText());
    	Double deduct_salary = Double.valueOf(deduction.getText());
    	Double total_salary = base_salary + ot_salary - deduct_salary;
    	Date date = Date.valueOf(date_issue.getValue());
    	
    	MonthlySalaryModel salary = new MonthlySalaryModel(base_salary, ot_salary, deduct_salary, total_salary, e_name, getUser_name(), date);
    	int status = ManagerDao.issueSalary(salary);
    	if(status > 0) {
    		InterfaceElements.dialog("Info", "Sucessful issued employee salary.");
    		clearTextField();
    	} else {
    		InterfaceElements.dialog("Info", "Failed to issue salary.");
    	}
    }

    @FXML
    void cancel(MouseEvent event) {
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
    	base_pay.clear();
    	ot_pay.clear();
    	deduction.clear();
    	date_issue.getEditor().clear();
    }
}
