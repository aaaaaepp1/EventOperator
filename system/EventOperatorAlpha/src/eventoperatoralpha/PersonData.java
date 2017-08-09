/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoperatoralpha;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author okamotonaoki
 */
public class PersonData {
    private final ObservableList<Person> data = FXCollections.observableArrayList();
    
    public PersonData() {
        
        for(int i = 0; i < 20; i++) {
            data.add(new Person(i, "tmptmp", ""));
        }
        
    }
    
    public ObservableList<Person> getPersonDataList() {
        return this.data;
    }
    
}
