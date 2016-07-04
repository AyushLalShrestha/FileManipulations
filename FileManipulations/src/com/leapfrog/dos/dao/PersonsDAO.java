
package com.leapfrog.dos.dao;

import com.leapfrog.dos.entity.Persons;
import java.util.ArrayList;


public interface PersonsDAO {
    
    void insert(Persons p);
    
    boolean delete(int id);
    
    boolean update(int id);
    
    Persons getById(int id);
    
    void getByAny(String s);
    
    ArrayList<Persons> getAll();
    
    int getID(); 
    
    boolean doesEmailExists(String email);
    
    
}
