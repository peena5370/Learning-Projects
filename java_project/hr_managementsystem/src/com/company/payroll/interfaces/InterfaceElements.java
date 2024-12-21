package com.company.payroll.interfaces;

import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.company.payroll.controller.AdminController;
import com.company.payroll.controller.ChangePasswordController;
import com.company.payroll.controller.EditEmployeeController;
import com.company.payroll.controller.EditManagerController;
import com.company.payroll.controller.EmployeeController;
import com.company.payroll.controller.EmployeeIssueLeaveController;
import com.company.payroll.controller.EmployeeIssueLoanController;
import com.company.payroll.controller.EmployeeProfileController;
import com.company.payroll.controller.IssueIncrementController;
import com.company.payroll.controller.IssueResignationController;
import com.company.payroll.controller.IssueSalaryController;
import com.company.payroll.controller.IssueTrainingController;
import com.company.payroll.controller.ManagerController;
import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.dao.ManagerDao;
import com.company.payroll.model.EmployeeModel;
import com.company.payroll.model.LeaveModel;
import com.company.payroll.model.LoanModel;
import com.company.payroll.model.ManagerModel;
import com.company.payroll.model.MonthlySalaryModel;
import com.company.payroll.model.ResignationModel;
import com.company.payroll.model.SalaryModel;
import com.company.payroll.model.TrainingModel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("unchecked")
public class InterfaceElements {
	
	/**
	 * Admin GUI interface
	 * @param	event
	 * 			ActionEvent taken from user action
	 * @param	username
	 * 			Username input, it should be a string called "administrator"
	 * */
	public void adminInterface(ActionEvent event, String username) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/AdminInterface.fxml"));
			BorderPane border = loader.load();
			AdminController controller = loader.getController();
			controller.setLabel(username);
			Scene scene = new Scene(border);
			Stage stage = new Stage();
			scene.getStylesheets().add(getClass().getResource("/resources/bootstrapFX.css").toExternalForm());
			stage.setTitle("Admin Section");
			stage.setScene(scene);
			stage.show();
			// close window after this node open
			((Node) event.getSource()).getScene().getWindow().hide();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * Manager GUI Interface
	 * @param	event
	 * 			ActionEvent taken from user action
	 * @param	id
	 * 			Manager identity id
	 * */
	public void managerInterface(ActionEvent event, int id) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/ManagerInterface.fxml"));
			GridPane grid = loader.load();
			ManagerController controller = loader.getController();
			controller.setInitialize(id);
			Scene scene = new Scene(grid);
			scene.getStylesheets().add(getClass().getResource("/resources/bootstrapFX.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("Manager Section");
			stage.setScene(scene);
			stage.show();
			((Node) event.getSource()).getScene().getWindow().hide();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * Employee GUI Interface
	 * @param	event
	 * 			ActionEvent taken from main interface
	 * @param	id
	 * 			User identity id
	 * */
	public void employeeInterface(ActionEvent event, int id) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/EmployeeInterface.fxml"));
			GridPane grid = loader.load();
			EmployeeController controller = loader.getController();
			controller.setInitialize(id);
			Scene scene = new Scene(grid);
			scene.getStylesheets().add(getClass().getResource("/resources/bootstrapFX.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("Employee Section");
			stage.setScene(scene);
			stage.show();
			((Node) event.getSource()).getScene().getWindow().hide();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * Dialog box element
	 * @param	title
	 * 			Title of the dialog
	 * @param	info
	 * 			Content text inside the dialog box
	 * */
	public static void dialog(String title, String info) {
		Dialog<String> dialog = new Dialog<String>();
		dialog.setTitle(title);
		dialog.setContentText(info);
		
		ButtonType closebtn = new ButtonType("OK", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(closebtn);
		dialog.showAndWait();
	}
    
	/**
     * View employee table
     * @param	pane
     * 			Stack pane used to store employee list
     * */
	public void viewEmployee(StackPane pane) {
    	pane.getChildren().clear();
		TableView<EmployeeModel> table = new TableView<>();
    	List<EmployeeModel> employee_list = EmployeeDao.view();
    	
    	for(EmployeeModel employee : employee_list) {
    		table.getItems().add(new EmployeeModel(employee.getId(), employee.getFullname(), employee.getPosition(), 
    				employee.getDepartment(), employee.getPhone(), employee.getEmail(), employee.getStartdate(), employee.getEnddate()));	
    	}
    	
    	TableColumn<EmployeeModel, Number> col_id = new TableColumn<>("EmployeeID");
    	col_id.setCellValueFactory(col -> new SimpleIntegerProperty(col.getValue().getId()));
        TableColumn<EmployeeModel, String> col_name = new TableColumn<>("Full Name");
        col_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getFullname()));
        TableColumn<EmployeeModel, String> col_position = new TableColumn<>("Position");
        col_position.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getPosition()));
        TableColumn<EmployeeModel, String> col_dept = new TableColumn<>("Department");
        col_dept.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getDepartment()));
        TableColumn<EmployeeModel, String> col_phone = new TableColumn<>("Phone Number");
        col_phone.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getPhone()));
        TableColumn<EmployeeModel, String> col_email = new TableColumn<>("Email");
        col_email.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getEmail()));
        TableColumn<EmployeeModel, String> col_startdate = new TableColumn<>("Starting Date");
        col_startdate.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getStartdate()));
        TableColumn<EmployeeModel, String> col_enddate = new TableColumn<>("Resign Date");
        col_enddate.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getEnddate()));
        table.getColumns().addAll(col_id, col_name, col_position, col_dept, col_phone, col_email, col_startdate, col_enddate);
        employeeActionColumn(table, pane);
        pane.getChildren().add(table);
	}
    
	/**
     * Employee table edit button column
     * @param	table
     * 			TableView table
     * */
    private void employeeActionColumn(TableView<EmployeeModel> table, StackPane pane) {
    	TableColumn<EmployeeModel, String> col_btn = new TableColumn<EmployeeModel, String>("Action");
    	col_btn.setCellFactory(param -> {
    			final TableCell<EmployeeModel, String> cell = new TableCell<EmployeeModel, String>() {
    				private final Button edit_btn = new Button("Edit");
    				private final Button del_btn = new Button("Delete");
    				{
	    				edit_btn.setOnAction(e -> {
	    					EmployeeModel employee = getTableView().getItems().get(getIndex());
	                        editEmployee(employee.getId());
	                    });
	    				del_btn.setOnAction(e -> {
	    					EmployeeModel employee = getTableView().getItems().get(getIndex());
	                        int status = EmployeeDao.delete(employee.getId());
	                        if(status > 0) {
		                        dialog("Info", "User have been deleted.");
		                        pane.getChildren().clear();
	                        } else {
	                        	dialog("Info", "Failed to delete employee.");
	                        }
	                    });
    				}
    				
    				 @Override
                     public void updateItem(String item, boolean empty) {
                         super.updateItem(item, empty);
                         if (empty) {
                             setGraphic(null);
                         } else {
                        	 HBox hbox = new HBox();
                        	 hbox.setSpacing(10);
                        	 hbox.getChildren().addAll(edit_btn, del_btn);
                             setGraphic(hbox);
                         }
                     }
    			};
    			return cell;
    		});
    	table.getColumns().add(col_btn);
    }
	
    /**
     * Add employee form
     * @param	pane
     * 			Stack pane used to store employee form
     * */
    public void addEmployee(StackPane pane) {
    	pane.getChildren().clear();
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/AddEmployeeForm.fxml"));
			VBox vbox = loader.load();
    		pane.getChildren().add(vbox);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
	}
    
    /**
     * Edit employee form
     * @param	id
     * 			Set employee id
     * */
    public void editEmployee(int id) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/EditEmployeeForm.fxml"));
			VBox vbox = loader.load();
			EditEmployeeController controller = loader.getController();
			controller.setId_number(id);
			Scene scene = new Scene(vbox);
			Stage stage = new Stage();
			scene.getStylesheets().add(getClass().getResource("/resources/bootstrapFX.css").toExternalForm());
			stage.setTitle("Edit Employee");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * View Manager List
     * @param	pane
     * 			Stack pane used to store manager list
     * */
	public void viewManager(StackPane pane) {
    	pane.getChildren().clear();
		TableView<ManagerModel> table = new TableView<>();
    	List<ManagerModel> manager_list = ManagerDao.view();
    	
    	for(ManagerModel manager : manager_list) {
    		table.getItems().add(new ManagerModel(manager.getId(), manager.getFullname(), manager.getRole(), 
    				manager.getPosition(), manager.getDepartment(), manager.getPhone(), manager.getEmail()));	
    	}
    	
    	TableColumn<ManagerModel, Number> col_id = new TableColumn<>("ManagerID");
    	col_id.setCellValueFactory(col -> new SimpleIntegerProperty(col.getValue().getId()));
        TableColumn<ManagerModel, String> col_name = new TableColumn<>("Full Name");
        col_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getFullname()));
        TableColumn<ManagerModel, String> col_role = new TableColumn<>("Role");
        col_role.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getRole()));
        TableColumn<ManagerModel, String> col_position = new TableColumn<>("Position");
        col_position.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getPosition()));
        TableColumn<ManagerModel, String> col_dept = new TableColumn<>("Department");
        col_dept.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getDepartment()));
        TableColumn<ManagerModel, String> col_phone = new TableColumn<>("Phone Number");
        col_phone.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getPhone()));
        TableColumn<ManagerModel, String> col_email = new TableColumn<>("Email");
        col_email.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getEmail())); 
        table.getColumns().addAll(col_id, col_name, col_role, col_position, col_dept, col_phone, col_email);
        managerActionColumn(table, pane);
        pane.getChildren().add(table);
    }
    
    /**
     * Manager table edit and delete button column
     * @param	table
     * 			TableView table
     * */
    private void managerActionColumn(TableView<ManagerModel> table, StackPane pane) {
    	TableColumn<ManagerModel, String> col_btn = new TableColumn<ManagerModel, String>("Action");
    	col_btn.setCellFactory(param -> {
    			final TableCell<ManagerModel, String> cell = new TableCell<ManagerModel, String>() {
    				private final Button edit_btn = new Button("Edit");
    				private final Button del_btn = new Button("Delete");
    				{
	    				edit_btn.setOnAction(e -> {
	    					ManagerModel manager = getTableView().getItems().get(getIndex());
	                        editManager(manager.getId());
	                    });
	    				del_btn.setOnAction(e -> {
	    					ManagerModel manager = getTableView().getItems().get(getIndex());
	                        ManagerDao.delete(manager.getId());
	                        InterfaceElements.dialog("Info", "User have been deleted.");
	                        pane.getChildren().clear();
	                    });
    				}
    				
    				 @Override
                     public void updateItem(String item, boolean empty) {
                         super.updateItem(item, empty);
                         if (empty) {
                             setGraphic(null);
                         } else {
                        	 HBox hbox = new HBox();
                        	 hbox.setSpacing(10);
                        	 hbox.getChildren().addAll(edit_btn, del_btn);
                             setGraphic(hbox);
                         }
                     }
    			};
    			return cell;
    		});
    	table.getColumns().add(col_btn);
    }
    
    /**
     * Add Manager Form
     * @param	pane
     * 			Stackpane use to store manager form
     * */
    public void addManager(StackPane pane) {
		pane.getChildren().clear();
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/AddManagerForm.fxml"));
			VBox vbox = loader.load();
    		pane.getChildren().add(vbox);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * Edit manager form
     * @param	id
     * 			Manager id
     * */
    private void editManager(int id) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/EditManagerForm.fxml"));
			VBox vbox = loader.load();
			EditManagerController controller = loader.getController();
			controller.setId_number(id);
			Scene scene = new Scene(vbox);
			Stage stage = new Stage();
			scene.getStylesheets().add(getClass().getResource("/resources/bootstrapFX.css").toExternalForm());
			stage.setTitle("Edit Manager");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * View Leave List
     * @param	pane
     * 			Stack pane to store leave list
     * */
    public void viewLeave(StackPane pane, int id) {
    	pane.getChildren().clear();
    	TableView<LeaveModel> table = new TableView<>();
    	List<LeaveModel> leave_list = ManagerDao.viewLeave();
    	
    	for(LeaveModel leave : leave_list) {
    		table.getItems().add(new LeaveModel(leave.getL_id(), leave.getReasons(), leave.getDate_from(), leave.getDate_to(), leave.getLeave_type(), 
    				leave.getStatus(), leave.getEmployee_name(), leave.getApprovedByManager()));
    	}
		TableColumn<LeaveModel, Number> col_id = new TableColumn<>("ID");
		col_id.setCellValueFactory(col -> new SimpleIntegerProperty(col.getValue().getL_id()));
        TableColumn<LeaveModel, String> col_reason = new TableColumn<>("Reasons");
        col_reason.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getReasons()));
        TableColumn<LeaveModel, String> col_start_date = new TableColumn<>("Start Date");
        col_start_date.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getDate_from()));
        TableColumn<LeaveModel, String> col_end_date = new TableColumn<>("End Date");
        col_end_date.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getDate_to()));
        TableColumn<LeaveModel, String> col_type = new TableColumn<>("Type");
        col_type.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getLeave_type()));
        TableColumn<LeaveModel, String> col_status = new TableColumn<>("Status");
        col_status.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getStatus()));
        TableColumn<LeaveModel, String> col_e_name = new TableColumn<>("Employee Name");
        col_e_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getEmployee_name()));
        TableColumn<LeaveModel, String> col_m_name = new TableColumn<>("Approved By");
        col_m_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getApprovedByManager()));
        table.getColumns().addAll(col_id, col_reason, col_start_date, col_end_date, col_type, col_status, col_e_name, col_m_name);
        leaveApprovedColumn(table, id);
        pane.getChildren().add(table);
    }
    
    /**
     * Leave table approve/rejected button column
     * @param	table
     * 			TableView table
     * */
    private void leaveApprovedColumn(TableView<LeaveModel> table, int id) {
    	TableColumn<LeaveModel, String> col_btn = new TableColumn<LeaveModel, String>("Action");
    	col_btn.setCellFactory(param -> {
    			final TableCell<LeaveModel, String> cell = new TableCell<LeaveModel, String>() {
    				private final Button approve_btn = new Button("Approved");
    				private final Button rej_btn = new Button("Rejected");
    				String approved = "APPROVED";
    				String rejected = "REJECTED";
    				String title = "Info";
    				{
    					approve_btn.setOnAction(e -> {
    						LeaveModel leave = getTableView().getItems().get(getIndex());
	                        int status = ManagerDao.updateLeaveStatus(leave.getL_id(), approved, id);
	                        if(status > 0) {
	                        	String approve_info = "Successful approved leave.";
	                        	InterfaceElements.dialog(title, approve_info);
	                        	table.getColumns().clear();
	                        } else {
	                        	String error_info = "Failed to approved leave.";
	                        	InterfaceElements.dialog(title, error_info);
	                        	table.getColumns().clear();
	                        }
	                    });
	    				rej_btn.setOnAction(e -> {
	    					LeaveModel leave = getTableView().getItems().get(getIndex());
	    					int status = ManagerDao.updateLeaveStatus(leave.getL_id(), rejected, id);
	    					if(status > 0) {
	    						String rej_info = "Leave rejected.";
	    						InterfaceElements.dialog(title, rej_info);
	                        	table.getColumns().clear();
	                        } else {
	                        	String error = "Rejected fail, please try again.";
	                        	InterfaceElements.dialog(title, error);
	                        	table.getColumns().clear();
	                        }
	    				});
    				}
    				
    				 @Override
                     public void updateItem(String item, boolean empty) {
                         super.updateItem(item, empty);
                         if (empty) {
                             setGraphic(null);
                         } else {
                        	 HBox hbox = new HBox();
                        	 hbox.setSpacing(10);
                        	 hbox.getChildren().addAll(approve_btn, rej_btn);
                             setGraphic(hbox);
                         }
                     }
    			};
    			return cell;
    		});
    	table.getColumns().add(col_btn);
    }
    
    /**
     * View Loan List
     * @param	pane
     * 			Stack pane to store loan list
     * */
    public void viewLoan(StackPane pane, int id) {
		pane.getChildren().clear();
    	TableView<LoanModel> table = new TableView<>();
    	List<LoanModel> loan_list = ManagerDao.viewLoan();
    	
    	for(LoanModel loan : loan_list) {
    		table.getItems().add(new LoanModel(loan.getLoan_id(), loan.getReasons(), loan.getLoan_amount(), loan.getIssued_date(), loan.getLoan_status(), loan.getEmployee_name(), 
    				loan.getApprovedByManager()));
    	}
    	
    	TableColumn<LoanModel, Number> col_id = new TableColumn<>("ID");
    	col_id.setCellValueFactory(col -> new SimpleIntegerProperty(col.getValue().getLoan_id()));
        TableColumn<LoanModel, String> col_reason = new TableColumn<>("Reasons");
        col_reason.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getReasons()));
        TableColumn<LoanModel, Number> col_loan_amount = new TableColumn<>("Loan Amount");
        col_loan_amount.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getLoan_amount()));
        TableColumn<LoanModel, Date> col_issue_date = new TableColumn<>("Issued Date");
        col_issue_date.setCellValueFactory(col -> new SimpleObjectProperty<Date>(col.getValue().getIssued_date()));
        TableColumn<LoanModel, String> col_status = new TableColumn<>("Status");
        col_status.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getLoan_status()));
        TableColumn<LoanModel, String> col_employee_name = new TableColumn<>("Employee Name");
        col_employee_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getEmployee_name()));
        TableColumn<LoanModel, String> col_manager_name = new TableColumn<>("Approved By");
        col_manager_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getApprovedByManager()));
        table.getColumns().addAll(col_id, col_reason, col_loan_amount, col_issue_date, col_status, col_employee_name, col_manager_name);
        loanApprovedColumn(table, id);
        pane.getChildren().add(table);
    }
    
    /**
     * Loan table approve/reject button column
     * @param	table
     * 			TableView table
     * */
    private void loanApprovedColumn(TableView<LoanModel> table, int id) {
    	TableColumn<LoanModel, String> col_btn = new TableColumn<LoanModel, String>("Action");
    	col_btn.setCellFactory(param -> {
    			final TableCell<LoanModel, String> cell = new TableCell<LoanModel, String>() {
    				private final Button approve_btn = new Button("Approved");
    				private final Button rej_btn = new Button("Rejected");
    				String approved = "APPROVED";
    				String rejected = "REJECTED";
    				String title = "Info";
    				{
    					approve_btn.setOnAction(e -> {
	    					LoanModel loan = getTableView().getItems().get(getIndex());
	                        int status = ManagerDao.updateLoanStatus(loan.getLoan_id(), approved, id);
	                        if(status > 0) {
	                        	String approve_info = "Successful approved loan.";
	                        	InterfaceElements.dialog(title, approve_info);
	                        	table.getColumns().clear();	
	                        } else {
	                        	String error_info = "Failed to approved loan.";
	                        	InterfaceElements.dialog(title, error_info);
	                        	table.getColumns().clear();
	                        }
	                    });
	    				rej_btn.setOnAction(e -> {
	    					LoanModel loan = getTableView().getItems().get(getIndex());
	    					int status = ManagerDao.updateLoanStatus(loan.getLoan_id(), rejected, id);
	    					if(status > 0) {
	    						String rej_info = "Loan rejected.";
	    						InterfaceElements.dialog(title, rej_info);
	                        	table.getColumns().clear();	
	                        } else {
	                        	String error = "Rejected fail, please try again.";
	                        	InterfaceElements.dialog(title, error);
	                        	table.getColumns().clear();
	                        }
	    				});
    				}
    				
    				 @Override
                     public void updateItem(String item, boolean empty) {
                         super.updateItem(item, empty);
                         if (empty) {
                             setGraphic(null);
                         } else {
                        	 HBox hbox = new HBox();
                        	 hbox.setSpacing(10);
                        	 hbox.getChildren().addAll(approve_btn, rej_btn);
                             setGraphic(hbox);
                         }
                     }
    			};
    			return cell;
    		});
    	table.getColumns().add(col_btn);
    }
    
    /**
     * View Employee salary list
     * @param	pane
     * 			Stack pane used to store employee salary list
     * @param	label
     * 			Used to get label string from interface
     * */
    public void viewSalary(StackPane pane, Label label) {
    	pane.getChildren().clear();
    	TableView<SalaryModel> table = new TableView<>();
    	List<SalaryModel> salary_list = ManagerDao.viewEmployeeSalary();
    	
    	for(SalaryModel salary : salary_list) {
    		table.getItems().add(new SalaryModel(salary.getS_id(), salary.getBase_salary(), salary.getIncremented_salary(), salary.getIncrement_date(),
    				 salary.getEmployee_name(), salary.getIssuedByManager()));
    	}
    	
		TableColumn<SalaryModel, Number> col_id = new TableColumn<>("ID");
		col_id.setCellValueFactory(col -> new SimpleIntegerProperty(col.getValue().getS_id()));
        TableColumn<SalaryModel, Number> col_base_salary = new TableColumn<>("Base Salary");
        col_base_salary.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getBase_salary()));
        TableColumn<SalaryModel, Number> col_increment_salary = new TableColumn<>("Incremented Salary");
        col_increment_salary.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getIncremented_salary()));
        TableColumn<SalaryModel, String> col_increment_date = new TableColumn<>("Increment Date");
        col_increment_date.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getIncrement_date()));
        TableColumn<SalaryModel, String> col_employee_name = new TableColumn<>("Employee Name");
        col_employee_name.setCellValueFactory( col -> new SimpleStringProperty(col.getValue().getEmployee_name()));
        TableColumn<SalaryModel, String> col_issued_by = new TableColumn<>("Increment Approved By");
        col_issued_by.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getIssuedByManager()));
        table.getColumns().addAll(col_id, col_base_salary, col_increment_salary, col_increment_date, col_employee_name, col_issued_by);
        issueIncrementColumn(table, label);
        pane.getChildren().add(table);
    }
    
    /**
     * Employee table edit button column
     * @param	table
     * 			TableView table
     * @param	label
     * 			Label tag use for issueIncrement(Label label) method, it consists of label string to get current operator
     * 			user full name.
     * */
    private void issueIncrementColumn(TableView<SalaryModel> table , Label label) {
    	TableColumn<SalaryModel, String> col_btn = new TableColumn<SalaryModel, String>("Action");
    	col_btn.setCellFactory(param -> {
    			final TableCell<SalaryModel, String> cell = new TableCell<SalaryModel, String>() {
    				private final Button issue_btn = new Button("Issue Increment");
    				{
    					issue_btn.setOnAction(e -> {
    						issueIncrement(label);
	                    });
    				}
    				
    				 @Override
                     public void updateItem(String item, boolean empty) {
                         super.updateItem(item, empty);
                         if (empty) {
                             setGraphic(null);
                         } else {
                             setGraphic(issue_btn);
                         }
                     }
    			};
    			return cell;
    		});
    	table.getColumns().add(col_btn);
    }
    
    /**
     * View employee monthly salary list
     * @param	pane
     * 			Stack pane used to store employee monthly salary list
     * */
    public void viewMonthlySalary(StackPane pane) {
    	pane.getChildren().clear();
    	TableView<MonthlySalaryModel> table = new TableView<>();
    	List<MonthlySalaryModel> salary_list = ManagerDao.viewMonthlySalary();
    	
    	for(MonthlySalaryModel salary : salary_list) {
    		table.getItems().add(new MonthlySalaryModel(salary.getMonthlysalary_id(), salary.getCurrent_salary(), salary.getOvertime_pay(), 
    				salary.getDeduction(), salary.getTotal_salary(), salary.getEmployee_name(), 
    				salary.getApprovedByManager(), salary.getPayment_date()));
    	}
		TableColumn<MonthlySalaryModel, Number> col_id = new TableColumn<>("ID");
		col_id.setCellValueFactory(col -> new SimpleIntegerProperty(col.getValue().getMonthlysalary_id()));
        TableColumn<MonthlySalaryModel, Number> col_base_salary = new TableColumn<>("Current Base Salary");
        col_base_salary.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getCurrent_salary()));
        TableColumn<MonthlySalaryModel, Number> col_ot_pay = new TableColumn<>("OT Pay");
        col_ot_pay.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getOvertime_pay()));
        TableColumn<MonthlySalaryModel, Number> col_deduction = new TableColumn<>("Deduction");
        col_deduction.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getDeduction()));
        TableColumn<MonthlySalaryModel, Number> col_total_pay = new TableColumn<>("Total Salary");
        col_total_pay.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getTotal_salary()));
        TableColumn<MonthlySalaryModel, String> col_employee_name = new TableColumn<>("Employee Name");
        col_employee_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getEmployee_name()));
        TableColumn<MonthlySalaryModel, String> col_manager_name = new TableColumn<>("Approved By");
        col_manager_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getApprovedByManager()));
        TableColumn<MonthlySalaryModel, Date> col_issue_date = new TableColumn<>("Issue Date");
        col_issue_date.setCellValueFactory(col -> new SimpleObjectProperty<Date>(col.getValue().getPayment_date()));
        table.getColumns().addAll(col_id, col_base_salary, col_ot_pay, col_deduction, col_total_pay, col_employee_name, col_manager_name, col_issue_date);
        pane.getChildren().add(table);
    }
    
    /**
     * View issue salary form
     * @param	pane
     * 			Stack pane used to store issue monthly salary form
     * @param	label
     * 			The label tag used to get string from interface
     * */
    public void issueSalary(StackPane pane, Label label) {
    	pane.getChildren().clear();
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/IssueSalaryForm.fxml"));
			VBox vbox = loader.load();
			IssueSalaryController controller = loader.getController();
			String lbl_str = label.getText();
			Pattern pattern = Pattern.compile("(.*)(\\, )(.*)", Pattern.CASE_INSENSITIVE);
			Matcher match = pattern.matcher(lbl_str);
			if(match.find()) {
				controller.setUser_name(match.group(3));
			}
			pane.getChildren().add(vbox);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * View training list
     * @param	pane
     * 			Stack pane used to store training list
     * */
    public void viewTraining(StackPane pane) {
		pane.getChildren().clear();
    	TableView<TrainingModel> table = new TableView<>();
    	List<TrainingModel> training_list = ManagerDao.viewTraining();
    	
    	for(TrainingModel training : training_list) {
    		table.getItems().add(new TrainingModel(training.getT_id(), training.getInfo(), training.getStartdate(), training.getEnddate(), 
    				training.getStatus(), training.getEmployee_name(), training.getIssuedByManager()));
    	}
    	
    	TableColumn<TrainingModel, Number> col_id = new TableColumn<>("ID");
    	col_id.setCellValueFactory(col -> new SimpleIntegerProperty(col.getValue().getT_id()));
        TableColumn<TrainingModel, String> col_info = new TableColumn<>("Info");
        col_info.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getInfo()));
        TableColumn<TrainingModel, Date> col_date_start = new TableColumn<>("Date Start");
        col_date_start.setCellValueFactory(col -> new SimpleObjectProperty<Date>(col.getValue().getStartdate()));
        TableColumn<TrainingModel, Date> col_date_end = new TableColumn<>("Date End");
        col_date_end.setCellValueFactory(col -> new SimpleObjectProperty<Date>(col.getValue().getEnddate()));
        TableColumn<TrainingModel, String> col_status = new TableColumn<>("Status");
        col_status.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getStatus()));
        TableColumn<TrainingModel, String> col_employee_name = new TableColumn<>("Employee Name");
        col_employee_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getEmployee_name()));
        TableColumn<TrainingModel, String> col_manager_name = new TableColumn<>("Approved By");
        col_manager_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getIssuedByManager()));
        table.getColumns().addAll(col_id, col_info, col_date_start, col_date_end, col_status, col_employee_name, col_manager_name);
        pane.getChildren().add(table);
    }
    
    /**
     * Issue employee training form
     * @param	pane
     * 			Stack pane used to store issue training form
     * @param	label
     * 			Label tag used get text value from interface
     * */
    public void issueTraining(StackPane pane, Label label) {
    	pane.getChildren().clear();
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/IssueTrainingForm.fxml"));
			VBox vbox = loader.load();
			IssueTrainingController controller = loader.getController();
			String lbl_str = label.getText();
			Pattern pattern = Pattern.compile("(.*)(\\, )(.*)", Pattern.CASE_INSENSITIVE);
			Matcher match = pattern.matcher(lbl_str);
			if(match.find()) {
				controller.setUser_name(match.group(3));
			}
			pane.getChildren().add(vbox);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * Issue employee salary increment form
     * @param	label
     * 			Label used to store user name. Example: manager full name
     * */
    private void issueIncrement(Label label) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/IssueIncrementForm.fxml"));
			VBox vbox = loader.load();
			IssueIncrementController controller = loader.getController();
			String lbl_str = label.getText();
			Pattern pattern = Pattern.compile("(.*)(\\, )(.*)", Pattern.CASE_INSENSITIVE);
			Matcher match = pattern.matcher(lbl_str);
			if(match.find()) {
				controller.setUser_name(match.group(3));
			}
			Scene scene = new Scene(vbox);
			Stage stage = new Stage();
			scene.getStylesheets().add(getClass().getResource("/resources/bootstrapFX.css").toExternalForm());
			stage.setTitle("Issue Employee Salary Increment Form");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * View resignation table list
     * */
    public void viewResignList(StackPane pane) {
    	pane.getChildren().clear();
    	TableView<ResignationModel> table = new TableView<>();
    	List<ResignationModel> resign_list = ManagerDao.viewResignation();
    	
    	for(ResignationModel resign : resign_list) {
    		table.getItems().add(new ResignationModel(resign.getR_id(), resign.getReasons(), resign.getEnddate(), resign.getEmployee_name(), 
    				resign.getIssuedByManager()));
    	}
    	
    	TableColumn<ResignationModel, Number> col_id = new TableColumn<>("ID");
    	col_id.setCellValueFactory(col -> new SimpleIntegerProperty(col.getValue().getR_id()));
        TableColumn<ResignationModel, String> col_reason = new TableColumn<>("Reasons");
        col_reason.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getReasons()));
        TableColumn<ResignationModel, Date> col_end_date = new TableColumn<>("End of Service Date");
        col_end_date.setCellValueFactory(col -> new SimpleObjectProperty<Date>(col.getValue().getEnddate()));
        TableColumn<ResignationModel, String> col_employee_name = new TableColumn<>("Employee Name");
        col_employee_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getEmployee_name()));
        TableColumn<ResignationModel, String> col_manager_name = new TableColumn<>("Approved By");
        col_manager_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getIssuedByManager()));
        table.getColumns().addAll(col_id, col_reason, col_end_date, col_employee_name, col_manager_name);
        pane.getChildren().add(table);
    }
    
    public void issueResignationForm(Label label) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/IssueResignationForm.fxml"));
			VBox vbox = loader.load();
			IssueResignationController controller = loader.getController();
			String lbl_str = label.getText();
			Pattern pattern = Pattern.compile("(.*)(\\, )(.*)", Pattern.CASE_INSENSITIVE);
			Matcher match = pattern.matcher(lbl_str);
			if(match.find()) {
				controller.setUser_name(match.group(3));
			}
			Scene scene = new Scene(vbox);
			Stage stage = new Stage();
			scene.getStylesheets().add(getClass().getResource("/resources/bootstrapFX.css").toExternalForm());
			stage.setTitle("Resignation Form");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public void employeeProfile(StackPane pane, int id) {
    	pane.getChildren().clear();
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/EmployeeProfile.fxml"));
			VBox vbox = loader.load();
			EmployeeProfileController controller = loader.getController();
			controller.setProfile(id);
    		pane.getChildren().add(vbox);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public void changePasswordForm(int id) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/ChangePasswordForm.fxml"));
			VBox vbox = loader.load();
			ChangePasswordController controller = loader.getController();
			controller.setUser_id(id);
			Scene scene = new Scene(vbox);
			Stage stage = new Stage();
			scene.getStylesheets().add(getClass().getResource("/resources/bootstrapFX.css").toExternalForm());
			stage.setTitle("Resignation Form");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public void employeeViewLeave(StackPane pane, int id) {
    	pane.getChildren().clear();
    	TableView<LeaveModel> table = new TableView<>();
    	List<LeaveModel> leave_list = EmployeeDao.viewLeave(id);
    	
    	for(LeaveModel leave : leave_list) {
    		table.getItems().add(new LeaveModel(leave.getReasons(), leave.getDate_from(), leave.getDate_to(), leave.getLeave_type(), leave.getStatus(), 
    				leave.getApprovedByManager()));
    	}
    	
    	TableColumn<LeaveModel, String> col_reasons = new TableColumn<>("Reasons");
    	col_reasons.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getReasons()));
        TableColumn<LeaveModel, String> col_dateFrom = new TableColumn<>("From Date");
        col_dateFrom.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getDate_from()));
        TableColumn<LeaveModel, String> col_dateTo = new TableColumn<>("To Date");
        col_dateTo.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getDate_to()));
        TableColumn<LeaveModel, String> col_leaveType = new TableColumn<>("Type");
        col_leaveType.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getLeave_type()));
        TableColumn<LeaveModel, String> col_status = new TableColumn<>("Status");
        col_status.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getStatus()));
        TableColumn<LeaveModel, String> col_manager_name = new TableColumn<>("Approved By");
        col_manager_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getApprovedByManager()));
        table.getColumns().addAll(col_reasons, col_dateFrom, col_dateTo, col_leaveType, col_status, col_manager_name);
        pane.getChildren().add(table);
    }
    
    public void employeeViewTraining(StackPane pane, int id) {
    	pane.getChildren().clear();
    	TableView<TrainingModel> table = new TableView<>();
    	List<TrainingModel> training_list = EmployeeDao.viewTraining(id);
    	
    	for(TrainingModel training : training_list) {
    		table.getItems().add(new TrainingModel(training.getT_id(), training.getInfo(), training.getStartdate(), training.getEnddate(), training.getStatus(), 
    				training.getIssuedByManager()));
    	}
    	TableColumn<TrainingModel, Number> col_id = new TableColumn<>("ID");
    	col_id.setCellValueFactory(col -> new SimpleIntegerProperty(col.getValue().getT_id()));
    	TableColumn<TrainingModel, String> col_info = new TableColumn<>("Training Info");
    	col_info.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getInfo()));
        TableColumn<TrainingModel, Date> col_dateStart = new TableColumn<>("From Date");
        col_dateStart.setCellValueFactory(col -> new SimpleObjectProperty<Date>(col.getValue().getStartdate()));
        TableColumn<TrainingModel, Date> col_dateEnd = new TableColumn<>("To Date");
        col_dateEnd.setCellValueFactory(col -> new SimpleObjectProperty<Date>(col.getValue().getEnddate()));
        TableColumn<TrainingModel, String> col_status = new TableColumn<>("Status");
        col_status.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getStatus()));
        TableColumn<TrainingModel, String> col_manager_name = new TableColumn<>("Approved By");
        col_manager_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getIssuedByManager()));
        table.getColumns().addAll(col_id, col_info, col_dateStart, col_dateEnd, col_status, col_manager_name);
        trainingCompleteColumn(table, id);
        pane.getChildren().add(table);
    }
    
    private void trainingCompleteColumn(TableView<TrainingModel> table , int id) {
    	TableColumn<TrainingModel, String> col_btn = new TableColumn<TrainingModel, String>("Action");
    	col_btn.setCellFactory(param -> {
    			final TableCell<TrainingModel, String> cell = new TableCell<TrainingModel, String>() {
    				private final Button issue_btn = new Button("Mark As Completed");
    				String status = "COMPLETED";
    				{
    					issue_btn.setOnAction(e -> {
    						TrainingModel training = getTableView().getItems().get(getIndex());
    						int trainingStatus = EmployeeDao.updateTraining(status, id, training.getT_id());
    						if(trainingStatus > 0) {
    							dialog("Info", "Status Updated.");
    							table.getColumns().clear();
    						} else {
    							dialog("Info", "Status update failed. Please try again later.");
    						}
	                    });
    				}
    				
    				 @Override
                     public void updateItem(String item, boolean empty) {
                         super.updateItem(item, empty);
                         if (empty) {
                             setGraphic(null);
                         } else {
                             setGraphic(issue_btn);
                         }
                     }
    			};
    			return cell;
    		});
    	table.getColumns().add(col_btn);
    }
    
    public void employeeViewSalary(StackPane pane, int id) {
    	pane.getChildren().clear();
    	TableView<MonthlySalaryModel> table = new TableView<>();
    	List<MonthlySalaryModel> salary_list = EmployeeDao.viewSalary(id);
    	
    	for(MonthlySalaryModel salary : salary_list) {
    		table.getItems().add(new MonthlySalaryModel(salary.getMonthlysalary_id(), salary.getCurrent_salary(), salary.getOvertime_pay(), 
    				salary.getDeduction(), salary.getTotal_salary(), salary.getPayment_date(), salary.getApprovedByManager()));
    	}
    	
    	TableColumn<MonthlySalaryModel, Number> col_id = new TableColumn<>("Salary ID");
    	col_id.setCellValueFactory(col -> new SimpleIntegerProperty(col.getValue().getMonthlysalary_id()));
    	TableColumn<MonthlySalaryModel, Number> col_baseSalary = new TableColumn<>("Base Salary");
    	col_baseSalary.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getCurrent_salary()));
        TableColumn<MonthlySalaryModel, Number> col_OTSalary = new TableColumn<>("OverTime Payment");
        col_OTSalary.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getOvertime_pay()));
        TableColumn<MonthlySalaryModel, Number> col_deduction = new TableColumn<>("Deduction");
        col_deduction.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getDeduction()));
        TableColumn<MonthlySalaryModel, Number> col_totalSalary = new TableColumn<>("Total");
        col_totalSalary.setCellValueFactory(col -> new SimpleDoubleProperty(col.getValue().getTotal_salary()));
        TableColumn<MonthlySalaryModel, Date> col_date = new TableColumn<>("Payment Date");
        col_date.setCellValueFactory(col -> new SimpleObjectProperty<Date>(col.getValue().getPayment_date()));
        TableColumn<MonthlySalaryModel, String> col_manager_name = new TableColumn<>("Approved By");
        col_manager_name.setCellValueFactory(col -> new SimpleStringProperty(col.getValue().getApprovedByManager()));
        table.getColumns().addAll(col_id, col_baseSalary, col_OTSalary, col_deduction, col_totalSalary, col_date, col_manager_name);
        pane.getChildren().add(table);
    }
    
    public void employeeIssueLeave(StackPane pane, int id) {
    	pane.getChildren().clear();
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/EmployeeIssueLeaveForm.fxml"));
			VBox vbox = loader.load();
			EmployeeIssueLeaveController controller = loader.getController();
			controller.setUser_id(id);
			pane.getChildren().add(vbox);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void employeeIssueLoan(StackPane pane, int id) {
    	pane.getChildren().clear();
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/EmployeeIssueLoanForm.fxml"));
			VBox vbox = loader.load();
			EmployeeIssueLoanController controller = loader.getController();
			controller.setUser_id(id);
			pane.getChildren().add(vbox);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
