package com.company.payroll.controller;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.EmployeeModel;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class EmployeeController {
	
	@FXML
    private Label user_label;
	
    @FXML
    private TabPane tab_pane;
    
    @FXML
    private StackPane profile_pane;

    @FXML
    private StackPane training_pane;
    
    @FXML
    private StackPane salary_pane;
    
    @FXML
    private StackPane leave_pane;
    
    @FXML
    private StackPane other_pane;
    
    private int user_id;
    
    @FXML
    void aboutInfo(ActionEvent event) {
    	String title = "About the application";
		String info = "HR Management System.\n\n"
					+ "For enquiry, please visit us on:\n"
					+ "Blok M32-A, Vengence Road,\n"
					+ "47301, Ara Damansara,\n"
					+ "Kuala Lumpur, Malaysia.\n\n"
					+ "Tel: +60 3-20750423\n"
					+ "Email: companyemail@mail.com";
    	InterfaceElements.dialog(title, info);
    }

    @FXML
    void exit(ActionEvent event) {
    	Platform.exit();
    }
    
    @FXML
    void issueEmployeeLeave(MouseEvent event) {
    	new InterfaceElements().employeeIssueLeave(other_pane, getUser_id());
    }

    @FXML
    void issueEmployeeLoan(MouseEvent event) {
    	new InterfaceElements().employeeIssueLoan(other_pane, getUser_id());
    }

    public void setInitialize(int id) {
    	EmployeeModel employee = EmployeeDao.queryInfo(id);
		String name = employee.getFullname();
		user_label.setText("Welcome back, " + name);
		setUser_id(id);
		tab_pane.getSelectionModel().selectedItemProperty().addListener( e -> {
			String tabs = tab_pane.getSelectionModel().getSelectedItem().getText();
			if(tabs.equals("Profile")) {
				new InterfaceElements().employeeProfile(profile_pane, id);		
			} else if(tabs.equals("Training")) {
				new InterfaceElements().employeeViewTraining(training_pane, id);
			} else if(tabs.equals("Salary")) {
				new InterfaceElements().employeeViewSalary(salary_pane, id);
			} else if(tabs.equals("Leave")) {
				new InterfaceElements().employeeViewLeave(leave_pane, id);
			} else { 
				System.out.println("others.");
			}
		});
		
		
    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
