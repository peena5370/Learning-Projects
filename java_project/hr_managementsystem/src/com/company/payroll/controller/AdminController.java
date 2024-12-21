package com.company.payroll.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.company.payroll.interfaces.InterfaceElements;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * Admin Controller
 * */
public class AdminController implements Initializable {
	@FXML
    private Label user_tag;

    @FXML
    private TreeView<String> admin_list;
    
    @FXML
    private StackPane output_pane;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TreeItem<String> root_tree = new TreeItem<>();

        TreeItem<String> manager_tree = new TreeItem<>("Manager Section");
        manager_tree.getChildren().add(new TreeItem<>("View Manager"));
        manager_tree.getChildren().add(new TreeItem<>("Add New Manager"));
        root_tree.getChildren().add(manager_tree);

        TreeItem<String> employee_tree = new TreeItem<>("Employee Section");
        employee_tree.getChildren().add(new TreeItem<>("View Employee"));
        employee_tree.getChildren().add(new TreeItem<>("Add New Employee"));
        root_tree.getChildren().add(employee_tree);
        admin_list.setRoot(root_tree);
        admin_list.setShowRoot(false);
        admin_list.setOnMouseClicked(e -> {
        	getPane(e);
        });
	}

	/**
	 * 
	 * */
    public void getPane(MouseEvent event) {
    	if(event.getClickCount() == 2)
        {
            TreeItem<String> item = admin_list.getSelectionModel().getSelectedItem();
            String getValue = item.getValue();
            
            switch(getValue) {
	            case "View Manager":
	            	new InterfaceElements().viewManager(output_pane);
	            	break;
	            case "Add New Manager":
	            	new InterfaceElements().addManager(output_pane);
	            	break;
	            case "View Employee":
	            	new InterfaceElements().viewEmployee(output_pane);
	            	break;
	            case "Add New Employee":
	            	new InterfaceElements().addEmployee(output_pane);
	            	break;
            default:
            	break;
            }
        }
    }
    
	public void setLabel(String username) {
    	user_tag.setText("Welcome back, " + username);
    }
}
