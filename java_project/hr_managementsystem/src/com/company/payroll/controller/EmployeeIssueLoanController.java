package com.company.payroll.controller;

import java.sql.Date;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.LoanModel;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EmployeeIssueLoanController {

    @FXML
    private DatePicker date;

    @FXML
    private TextField reason;

    @FXML
    private TextField amount;
    
    private int user_id;

    @FXML
    void submit(MouseEvent event) {
    	String reasons = reason.getText();
    	Double loan_amount = Double.valueOf(amount.getText());
    	Date issue_date = Date.valueOf(date.getValue());
    	String loan_status = "PENDING";
    	
    	LoanModel loan = new LoanModel(reasons, loan_amount, issue_date, loan_status, getUser_id());
    	int l_status = EmployeeDao.issueLoan(loan);
    	if(l_status > 0) {
        	InterfaceElements.dialog("Info", "Application submitted. Please visit manager for further assistance.");
        	clearTextField();
    	} else {
    		InterfaceElements.dialog("Info", "Application failed. Please try again.");
    	}
    }

    @FXML
    void clear(MouseEvent event) {
    	clearTextField();
    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	private void clearTextField() {
		reason.clear();
		amount.clear();
		date.getEditor().clear();
	}
}
