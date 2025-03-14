package com.company.payroll.interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("HR Management System");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/views/Login.fxml"));
			GridPane grid = loader.load();
			Scene scene = new Scene(grid);
			scene.getStylesheets().add(getClass().getResource("/resources/bootstrapFX.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}