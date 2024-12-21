package com.company.payroll.controller;

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.ManagerModel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class ManagerController {

    @FXML
    private Button view_salary_btn;

    @FXML
    private StackPane leave_pane;
    
    @FXML
    private Button view_resignation_btn;

    @FXML
    private Button issue_resignation_btn;

    @FXML
    private StackPane salary_pane;

    @FXML
    private Button view_btn;

    @FXML
    private StackPane employee_pane;
    
    @FXML
    private Button view_payment_btn;

    @FXML
    private Button issue_salary_btn;

    @FXML
    private Button add_btn;

    @FXML
    private Label manager_label;
    
    @FXML
    private Button view_training_btn;

    @FXML
    private StackPane loan_pane;

    @FXML
    private Button issue_training_btn;
    
    @FXML
    private StackPane other_pane;

    @FXML
    private TabPane tab_pane;
    
    @FXML
    private Tab employee_tab;

    @FXML
    private Tab salary_tab;
    
    @FXML
    private Tab leave_tab;
    
    @FXML
    private Tab loan_tab;
    
    @FXML
    private Tab other_tab;
    
    private int user_id;

    @FXML
    void viewEmployee(MouseEvent event) {
    	new InterfaceElements().viewEmployee(employee_pane);
    }

    @FXML
    void addEmployee(MouseEvent event) {
    	new InterfaceElements().addEmployee(employee_pane);
    }

	@FXML
    void viewSalary(MouseEvent event) {
		new InterfaceElements().viewSalary(salary_pane, manager_label);
    }
    
    
	@FXML
    void viewPayment(MouseEvent event) {
		new InterfaceElements().viewMonthlySalary(salary_pane);
    }

    @FXML
    void issueSalary(MouseEvent event) {
    	new InterfaceElements().issueSalary(salary_pane, manager_label);
    }
    
    @FXML
    void viewTraining(MouseEvent event) {
    	new InterfaceElements().viewTraining(other_pane);
    }

    @FXML
    void issueTraining(MouseEvent event) {
    	new InterfaceElements().issueTraining(other_pane, manager_label);
    }
    
    @FXML
    void viewResignation(MouseEvent event) {
    	new InterfaceElements().viewResignList(other_pane);
    }

    @FXML
    void issueResignation(MouseEvent event) {
    	new InterfaceElements().issueResignationForm(manager_label);
    }
    
    public void setInitialize(int id) {
		ManagerModel manager = ManagerDao.getFullName(id);
    	manager_label.setText("Welcome back, " + manager.getFullname());
    	
    	tab_pane.getSelectionModel().selectedItemProperty().addListener( e -> {
			String tabs = tab_pane.getSelectionModel().getSelectedItem().getText();
			if(tabs.equals("Leave Section")) {
				new InterfaceElements().viewLeave(leave_pane, id);
			} else if(tabs.equals("Loan Section")) {
				new InterfaceElements().viewLoan(loan_pane, id);
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
