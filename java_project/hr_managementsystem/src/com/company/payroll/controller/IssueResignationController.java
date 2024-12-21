package com.company.payroll.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.ResignationModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class IssueResignationController implements Initializable {

    @FXML
    private TextField reason;

    @FXML
    private Button submit;

    @FXML
    private DatePicker date_table;

    @FXML
    private Button clear;

    @FXML
    private TextField employee_name;

    @FXML
    private ComboBox<String> time_list;
    
    private String user_name;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String[] hour = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", 
				"16", "17", "18", "19", "20", "21", "22", "23"};
		String[] min = {"00", "30"};
		for(int i=0; i < hour.length; i++) {
			for(int j=0; j < min.length; j++) {
				time_list.getItems().addAll(hour[i] + ":" + min[j]);
			}
		}
	}

    @FXML
    void submit(MouseEvent event) {
    	String e_name = employee_name.getText();
    	String reasons = reason.getText();
    	Date end_date = Date.valueOf(date_table.getValue());
    	String end_time = time_list.getSelectionModel().getSelectedItem();
    	String str_date = end_date.toString() + " " + end_time;

    	ResignationModel resign = new ResignationModel(reasons, end_date, e_name, getUser_name());
    	int status = ManagerDao.issueResignation(resign);
		int status2 = ManagerDao.insertResignDate(str_date, e_name);
    	if(status > 0 && status2 > 0) {
    		InterfaceElements.dialog("Info", "Resign details issued.");
    		clearTextField();
    	} else {
    		InterfaceElements.dialog("Info", "Failed to issue resign details");
    	}
    }

    @FXML
    void clear(MouseEvent event) {
    	clearTextField();
    }

    private void clearTextField() {
    	employee_name.clear();
    	reason.clear();
    	date_table.getEditor().clear();
    	time_list.getEditor().clear();
    }
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
