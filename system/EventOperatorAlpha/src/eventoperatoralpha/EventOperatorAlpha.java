/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoperatoralpha;

import javafx.application.Application;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
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
    private final PersonManager personManager = new PersonManager();
    private ObservableList<Person> personObservableList;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.personObservableList = this.personManager.getPersonManagerList();
        
        //create main window
        Scene mainScene = new Scene(new Group());
        primaryStage.setTitle("EventOperator Alpha");
        primaryStage.setWidth(500);
        primaryStage.setHeight(600);
        
        //create cell
        this.mainTable.setEditable(true);
        this.mainTable.setItems(personObservableList);
        this.mainTable.getColumns().addAll(
                this.createPersonNumberCol(), this.createPersonNameCol(), this.createPersonNotesCol());
        
        //set layout
        final VBox mainVbox = new VBox();
        mainVbox.setSpacing(5);
        mainVbox.setPadding(new Insets(0, 0, 0, 0));
        mainVbox.getChildren().addAll(this.createTopMenuHbox(), mainTable);
        
        ((Group) mainScene.getRoot()).getChildren().addAll(mainVbox);
        
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
    }
    
    private HBox createTopMenuHbox() {
        
        //create hbox instance
        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(15, 12, 15, 12));
        topMenu.setSpacing(10);
        topMenu.setStyle("-fx-background-color: #eeeeee;");
        
        //create file import button
        Button importButton = new Button("ロード");
        importButton.setPrefSize(100, 20);
        importButton.setOnAction((ActionEvent e) -> {
            this.mainTable.sort();
        });
        
        //create file save button
        Button saveButton = new Button("セーブ");
        saveButton.setPrefSize(100, 20);
        saveButton.setOnAction((ActionEvent e) -> {
            for(Person p : this.personManager.getPersonManagerList()) {
                System.out.println("name: " + p.getName() + ", note: " + p.getNotes());
            }
        });
        
        //create file export button
        Button exportButton = new Button("PDFに出力");
        exportButton.setPrefSize(100, 20);
        
        topMenu.getChildren().addAll(importButton, saveButton, exportButton);
        
        return topMenu;
    }
    
    private TableColumn createPersonNumberCol() {
        
        TableColumn personNumberCol = new TableColumn("番号");
        personNumberCol.setMinWidth(50);
        personNumberCol.setCellValueFactory(
            new PropertyValueFactory<>("number"));
        
        
        return personNumberCol;
        
    }
    
    private TableColumn createPersonNameCol() {
        
        TableColumn personNameCol = new TableColumn("氏名");
        personNameCol.setMinWidth(100);
        personNameCol.setCellValueFactory(
            new PropertyValueFactory<>("name"));
        
        return personNameCol;
        
    }
    
    private TableColumn createPersonNotesCol() {
        
        TableColumn<Person, String> personNotesCol = new TableColumn<>("備考");
        personNotesCol.setMinWidth(300);
        personNotesCol.setCellValueFactory(
            new PropertyValueFactory<>("notes"));
        personNotesCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        personNotesCol.setOnEditCommit(((event) -> {
            this.personManager.editNotes(event.getTablePosition().getRow(), event.getNewValue());
        }));
        
        return personNotesCol;
        
    }
}

class DebugOut {

    public DebugOut() {
        System.out.println("debug out here");
    }
    
}
