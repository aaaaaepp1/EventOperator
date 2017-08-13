/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoperatoralpha;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author okamotonaoki
 */
public class PersonManager {
    private final ObservableList<Person> data = FXCollections.observableArrayList();
    
    public PersonManager() {
        
        for(int i = 0; i < 20; i++) {
            data.add(new Person(i, "tmptmp" + i, ""));
        }
        
    }
    
    public void editNotes(int number, String note) {
        this.data.get(number).setNotes(note);
    }
    
    public void add(Person person) {
        data.add(person);
    }
    
    public ObservableList<Person> getPersonManagerList() {
        return this.data;
    }
    
}
