/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoperatoralpha;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 *
 * @author okamotonaoki
 */
public class EventOperatorAlpha extends Application {
    
    private final TableView<Person> mainTable = new TableView<>();
    private final PersonData personData = new PersonData();
    private ObservableList<Person> data;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        data = this.personData.getPersonDataList();
        
        //create main window
        Scene mainScene = new Scene(new Group());
        primaryStage.setTitle("EventOperator Alpha");
        primaryStage.setWidth(500);
        primaryStage.setHeight(600);
        
        
        //create title label
        final Label titleLabel = new Label("EventOperator Alpha");
        titleLabel.setFont(new Font("Arial", 20));
        
        
        //create cell
        mainTable.setEditable(true);
        
        TableColumn personNumberCol = new TableColumn("番号");
        personNumberCol.setMinWidth(50);
        personNumberCol.setCellValueFactory(
            new PropertyValueFactory<>("number"));
        
        TableColumn personNameCol = new TableColumn("氏名");
        personNameCol.setMinWidth(100);
        personNameCol.setCellValueFactory(
            new PropertyValueFactory<>("name"));
        
        TableColumn<Person, String> personNotesCol = new TableColumn<>("備考");
        personNotesCol.setMinWidth(300);
        personNotesCol.setCellValueFactory(
            new PropertyValueFactory<>("notes"));
        personNotesCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        personNameCol.setOnEditCommit(
            null
        );
        
        mainTable.setItems(data);
        mainTable.getColumns().addAll(
                personNumberCol, personNameCol, personNotesCol);
        
        
        //set layout
        final VBox mainVbox = new VBox();
        mainVbox.setSpacing(5);
        mainVbox.setPadding(new Insets(10, 0, 0, 10));
        mainVbox.getChildren().addAll(titleLabel, mainTable);
        
        ((Group) mainScene.getRoot()).getChildren().addAll(mainVbox);
        
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
    }
}

class DebugOut {

    public DebugOut() {
        System.out.println("debug out here");
    }
    
}
