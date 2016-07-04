package com.leapfrog.dos;

import com.leapfrog.dos.daoimpl.PersonsDAOImpl;
import com.leapfrog.dos.entity.Persons;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PersonsDAOImpl pdao = new PersonsDAOImpl();
        try {

            BufferedReader reader = new BufferedReader(new FileReader("d:/databases.txt"));
            
            String line = "";
           // StringBuilder builder = new StringBuilder();

            while ((line = reader.readLine()) != null) {

                String tokens[] = line.split(",");
                Persons p = new Persons();
                p.setId(Integer.parseInt(tokens[0]));
                p.setFirstName(tokens[1]);
                p.setLastName(tokens[2]);
                p.setEmail(tokens[3]);
                p.setAddress(tokens[4]);
                pdao.insert(p);

            }

            reader.close();
            ArrayList<Persons> hold = pdao.getAll();
            for (int i = 0; i < hold.size(); i++) {
                System.out.println(hold.get(i).getFullInfo());
              
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

        System.out.println("Lets start the procedure ");
        while (true) {
            System.out.println("1. Add new Record \n2. Delete a record \n3. Update \n4. Search by ID \n5 .Search by any (first, last, full name, email, address ) \n6. Print all datas \n7. Exit the Program");
            System.out.print("Now please enter one of the options : ");
            int input = sc.nextInt();
            System.out.println("- - - - - - - - - -");

            switch (input) {
                case 1: {
                    while (true) {
                        int idd = pdao.getID();
                        System.out.print("Enter the first name : ");
                        String fstNme = sc.next();
                        System.out.print("Enter the last name : ");
                        String lstNme = sc.next();
                        System.out.print("Enter the email address : ");
                        String eml;
                        while (true) {
                            eml = sc.next();
                            if (!pdao.doesEmailExists(eml)) {
                                break;
                            }
                            System.out.print("Not valid, already registered, Enter a new Email address : ");
                        }

                        System.out.print("Enter the address : ");
                        String add = sc.next();
                        pdao.insert(new Persons(idd, fstNme, lstNme, eml, add));
                        System.out.println("- - - - - - - - - - - - - - - - - - - - ");
                        System.out.println("Do you Want to add more datas [y/n] ? : ");
                        String yon = sc.next();
                        if (yon.equalsIgnoreCase("n")) {
                            break;
                        }

                    }
                    break;
                }

                case 2: {
                    while (true) {
                        System.out.println("Enter the id to be deleted : ");
                        int id = sc.nextInt();
                        System.out.print("Are you sure you want to delete the " + id + " ID [y/n] ? :  ");
                        String yon = sc.next();
                        if (yon.equalsIgnoreCase("y")) {
                            System.out.println(pdao.delete(id));
                            System.out.println("- - - - - - - - - - - - - - - - - - - - ");

                        }
                        System.out.print("Do you want to continue deleting records [Y/N] ? : ");
                        String yon2 = sc.next();
                        if (yon2.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    break;

                }

                case 3: {
                    System.out.println("Enter the id to be updated : ");
                    int idd = sc.nextInt();
                    System.out.println(pdao.update(idd));
                    System.out.println("- - - - - - - - - - - - - - - - - - - - ");
                    break;
                }

                case 4: {
                    System.out.print("Enter the id to be searched : ");
                    int id = sc.nextInt();
                    if (pdao.getById(id) != null) {
                        System.out.println((pdao.getById(id)).getFullInfo());
                    } else {
                        System.out.println("Record does not exist");
                    }
                    System.out.println("- - - - - - - - - - - - - - - - - - - - ");

                    break;

                }

                case 5: {
                    System.out.print("Enter any field's string to be searched by : ");
                    String s = sc.next();
                    pdao.getByAny(s);
                    System.out.println("- - - - - - - - - - - - - - - - - - - - ");

                    break;
                }

                case 6: {
                    ArrayList<Persons> plist = pdao.getAll();
                    for (Persons p : plist) {
                        System.out.println(p.getFullInfo());

                    }

                    System.out.println("- - - - - - - - - - - - - - - - - - - - ");

                    break;
                }

                case 7: {
                    try {
                        FileWriter writer = new FileWriter("d:/databases.txt");
                         ArrayList<Persons> hold1 = pdao.getAll();
            for (int i = 0; i < hold1.size(); i++) {
               writer.write(hold1.get(i).getId() +","+ hold1.get(i).getFirstName()+","+ hold1.get(i).getLastName() +","+ hold1.get(i).getEmail() +"," +  hold1.get(i).getAddress());
               writer.write("\n");
            }
                        writer.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    
                    System.exit(0);

                }

                default:
                    System.out.println("you entered the wrong choice :) ");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - ");

            }

        }

    }

}
