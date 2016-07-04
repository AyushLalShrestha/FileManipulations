package com.leapfrog.dos.entity;

public class Persons {

    int id;
    String firstName, lastName, email, address;

    public Persons() {
    }

    public Persons(int id, String firstName, String lastName, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

   public String getFullInfo()  {
       return (id +"." + firstName + " " + lastName + " lives at " + address + ", Email = " + email  );
   }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Persons(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persons{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address=" + address + '}';
    }

    
}
