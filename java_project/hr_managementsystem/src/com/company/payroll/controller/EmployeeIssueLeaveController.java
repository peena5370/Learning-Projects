package com.company.payroll.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.LeaveModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EmployeeIssueLeaveController implements Initializable {

    @FXML
    private ComboBox<String> timeFrom;

    @FXML
    private TextField reasons;

    @FXML
    private ComboBox<String> timeTo;

    @FXML
    private ComboBox<String> leave;

    @FXML
    private DatePicker dateTo;

    @FXML
    private DatePicker dateFrom;
    
    private int user_id;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String[] hour = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", 
				"16", "17", "18", "19", "20", "21", "22", "23"};
		String[] min = {"00", "30"};
		for(int i=0; i < hour.length; i++) {
			for(int j=0; j < min.length; j++) {
				timeFrom.getItems().addAll(hour[i] + ":" + min[j]);
				timeTo.getItems().addAll(hour[i] + ":" + min[j]);
			}
		}
		
		String[] type = {"ANNUAL LEAVE", "MATERNITY LEAVE", "SICK LEAVE", "UNPAID LEAVE"};
		for(int i=0; i < type.length; i++) {
			leave.getItems().addAll(type[i]);
		}	
	}

    @FXML
    void submit(MouseEvent event) {
    	String reason = reasons.getText();
    	String leaveType = leave.getSelectionModel().getSelectedItem();
    	Date date_from = Date.valueOf(dateFrom.getValue());
    	String time_from = timeFrom.getSelectionModel().getSelectedItem();
    	String str_dateTimeFrom = date_from.toString() + " " + time_from;
    	Date date_to = Date.valueOf(dateTo.getValue());
    	String time_to = timeTo.getSelectionModel().getSelectedItem();
    	String str_dateTimeTo = date_to.toString() + " " + time_to;
    	String status = "PENDING";
    	
    	LeaveModel leave = new LeaveModel(reason, str_dateTimeFrom, str_dateTimeTo, leaveType, status, getUser_id());
    	int l_status = EmployeeDao.issueLeave(leave);
    	if(l_status > 0) {
    		InterfaceElements.dialog("Info", "Application success, please query with your manager for further informations.");
    		clearField();
    	} else {
    		InterfaceElements.dialog("Info", "Failed to apply leave. Please try again.");
    	}
    	
    }

    @FXML
    void clear(MouseEvent event) {
    	clearField();
    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	private void clearField() {
		reasons.clear();
		leave.getEditor().clear();
		dateFrom.getEditor().clear();
		dateTo.getEditor().clear();
		timeFrom.getEditor().clear();
		timeTo.getEditor().clear();
	}

}
