


import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Button optional;
	Label label;
	TextField text;
	//  declare two HBoxes
	HBox hBox1;
	HBox hBox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager data;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		 b1 = new Button("Hello");
		 b1.setOnAction(new ButtonHandler());
		 
		 b2 = new Button("Howdy");
		 b2.setOnAction(new ButtonHandler());
		 
		 b3 = new Button("Chinese");
		 b3.setOnAction(new ButtonHandler());
		 
		 optional = new Button("Spanish");
		 optional.setOnAction(new ButtonHandler());
		 
		 b4 = new Button("Clear");
		 b4.setOnAction(new ButtonHandler());
		 
		 b5 = new Button("Exit");
		 b5.setOnAction(new ButtonHandler());
		 
		 
		 
		label = new Label("Feedback");
		 text = new TextField();
		//  instantiate the HBoxes
		 hBox1 = new HBox(10);
		 hBox2 = new HBox(10);
	
		//student Task #4:
		//  instantiate the DataManager instance
		data = new DataManager();
		Insets inset = new Insets(10);
		//  set margins and set alignment of the components
		HBox.setMargin(b1, inset);
		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.BOTTOM_CENTER);
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hBox2.getChildren().addAll(label, text);
		//  add the buttons to the other HBox
		hBox1.getChildren().addAll(b1, b2, b3, optional, b4, b5);
		
		
		//  add the HBoxes to this FXMainPanel (a VBox)
		 getChildren().addAll(hBox1, hBox2);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{
		//DataManager data = new DataManager();
		@Override
		public void handle(ActionEvent event) {
			EventTarget button = event.getTarget();
			
			
			if(button == b1) {
				
				text.setText(data.getHello());
			}
			else if(button == b2) {
				text.setText(data.getHowdy());
			}
			else if(button == b3) {
				text.setText(data.getChinese());
			}
			else if(button == optional) {
				text.setText(data.getSpanish());
			}
			else if(button == b4) {
				text.setText("");
			}
			else if(button == b5) {
				Platform.exit();
				System.exit(0);
			}
			
			
			
		
		
		
		
		
		
	}
}}
	