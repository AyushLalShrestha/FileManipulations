package com.leapfrog.dos.daoimpl;

import com.leapfrog.dos.dao.PersonsDAO;
import com.leapfrog.dos.entity.Persons;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonsDAOImpl implements PersonsDAO {

     public ArrayList<Persons> personsList = new ArrayList<>();
    static int id;
    static Scanner sc = new Scanner(System.in);
    
    
    @Override
    public void insert(Persons p) {
        this.personsList.add(p);

    }
    
    @Override
    public boolean delete(int id) {
        for (int i = 0; i < personsList.size(); i++) {
            Persons p = personsList.get(i);
            if (p != null && p.getId() == id) {
                personsList.remove(i);
                for (int j = 0; j < personsList.size(); j++) {
                    personsList.get(j).setId(j + 1);
                }

                return true;

            }

        }
        return false;

    }

    @Override
    public boolean update(int id) {
        for (int i = 0; i < personsList.size(); i++) {
            if ((personsList.get(i)).getId() == id) {
                personsList.remove(i);
                System.out.print("Enter the first name : ");
                String fstNme = sc.next();
                System.out.print("Enter the last name : ");
                String lstNme = sc.next();
                System.out.print("Enter the email address : ");
                String eml;
                while (true) {
                    eml = sc.next();
                    if (!this.doesEmailExists(eml)) {
                        break;
                    }
                    System.out.print("Not valid, already registered, Enter a new Email address : ");
                }

                System.out.print("Enter the address : ");
                String add = sc.next();

                personsList.add(i, new Persons(id, fstNme, lstNme, eml, add));
                return true;
            }

        }
        return false;
    }

    @Override
    public Persons getById(int id) {
        for (int i = 0; i < personsList.size(); i++) {
            Persons p = personsList.get(i);
            if (p != null && p.getId() == id) {
                return p;

            }
        }
        return null;
    }

    @Override
    public void getByAny(String s) {
        int count = 0;
        for (int i = 0; i < personsList.size(); i++) {
            Persons p = personsList.get(i);
            if (p != null && ((p.getAddress().equalsIgnoreCase(s)) || (p.getEmail().equalsIgnoreCase(s)) || (p.getFirstName().equalsIgnoreCase(s)) || (p.getLastName().equalsIgnoreCase(s)))) {
                System.out.println(p.getFullInfo());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No such Record exist ");
        }
    }

    @Override
    public ArrayList<Persons> getAll() {
        return personsList;
    }

    @Override
    public boolean doesEmailExists(String email) {
        for (Persons p : personsList) {
            if (p.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getID() {
        id = ((this.personsList).size() + 1);
        return id;
    }

   
}


