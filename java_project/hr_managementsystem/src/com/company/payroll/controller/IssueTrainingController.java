package com.company.payroll.controller;

import java.sql.Date;

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.TrainingModel;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class IssueTrainingController {

    @FXML
    private TextField training_info;

    @FXML
    private DatePicker date_start;

    @FXML
    private TextField employee_name;

    @FXML
    private DatePicker date_end;

    private String user_name;
    
    @FXML
    void submit(MouseEvent event) {
    	String e_name = employee_name.getText();
    	String info = training_info.getText();
    	Date startdate = Date.valueOf(date_start.getValue());
    	Date enddate = Date.valueOf(date_end.getValue());
    	String training_status = "PENDING";
    	
    	TrainingModel training = new TrainingModel(info, startdate, enddate, training_status, e_name, getUser_name());
    	int status = ManagerDao.issueTraining(training);
    	if(status > 0) {
    		InterfaceElements.dialog("Info", "Sucessful issued employee training info.");
    		clearTextField();
    	} else {
    		InterfaceElements.dialog("Info", "Failed to issue employee training info.");
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
    	training_info.clear();
    	date_start.getEditor().clear();
    	date_end.getEditor().clear();
    }
}
