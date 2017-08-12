/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoperatoralpha;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author okamotonaoki
 */
public class Person {
    private Integer number;
    private final SimpleStringProperty name;
    private final SimpleStringProperty notes;
    
    public Person(int number, String name, String notes) {
        this.number = number;
        this.name = new SimpleStringProperty(name);
        this.notes = new SimpleStringProperty(notes);
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public String getName() {
        return this.name.get();
    }
    
    public String getNotes() {
        return this.notes.get();
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public void setName(String name) {
        this.name.set(name);
    }
    
    public void setNotes(String notes) {
        this.name.set(notes);
    }
}
