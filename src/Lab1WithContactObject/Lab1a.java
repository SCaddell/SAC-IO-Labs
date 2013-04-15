package Lab1WithContactObject;

import lab1.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Lab1a {

    public static void main(String[] args) throws IOException {

        File data = new File(File.separatorChar + "temp" + File.separatorChar
                + "class20Lab1a.txt");
        if (data.exists()) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(data));
                String line = in.readLine();
                while (line != null) {
                    StringTokenizer lineST = new StringTokenizer(line, "|");
                    String[] contactFields = new String[lineST.countTokens()];
                    //System.out.println(lineST.countTokens());
                    int i = 0;
                    while (lineST.hasMoreTokens()) {
                        contactFields[i] = lineST.nextToken();
                        i++;
                    }
                    line = in.readLine();  // strips out any carriage return chars
                    Contact1 contact = new Contact1(contactFields);
                    //System.out.println(contact.toString());
                    displayContactInfo(contact);
                }

            } catch (IOException ioe) {
                System.out.println("Houston, we have a problem! reading this file");
            } finally {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        } else {
            System.out.println("File not found: test.txt");
        }

        System.out.println("-------------------------------------------\n");
        
        int recCntr = 0;
        int desiredRec = 2;
        
//        File data = new File(File.separatorChar + "temp" + File.separatorChar
//                + "class20Lab.txt");
        if (data.exists()) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(data));
                String line = in.readLine();
                while (line != null && recCntr < desiredRec) {
                    recCntr++;
                    if (recCntr == desiredRec) {
                        StringTokenizer lineST = new StringTokenizer(line, "|");
                        String[] contactFields = new String[lineST.countTokens()];
                        //System.out.println(lineST.countTokens());
                        int i = 0;
                        while (lineST.hasMoreTokens()) {
                            contactFields[i] = lineST.nextToken();
                            i++;
                        }
                        line = in.readLine();  // strips out any carriage return chars
                        Contact1 contact = new Contact1(contactFields);
                        //System.out.println(contact.toString());
                        displayContactInfo(contact);
                    }
                    line = in.readLine();  // strips out any carriage return chars
                }
                
            } catch (IOException ioe) {
                System.out.println("Houston, we have a problem! reading this file");
            } finally {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        } else {
            System.out.println("File not found: test.txt");
        }
        
        System.out.println("-------------------------------------------\n");
        
        boolean append = true;   
        
        PrintWriter out = new PrintWriter(
                                new BufferedWriter(
				new FileWriter(data, append)));
        
        Contact1 newContact = new Contact1();
        
        newContact.setfName("It");
        newContact.setlName("Works");
        newContact.setAddress("1234 Washington Blvd");
        newContact.setCity("Pewaukee");
        newContact.setState("WI");
        newContact.setZipcode("12345");
        newContact.setEmail("ItWorks@it.Hard");
        newContact.setPhoneNum("414-444-5555");
        
        //out.print("");
        out.println(newContact.toString("|"));
        
        out.close();  // be sure you close your streams when done!!
	
	System.out.println("Wrote file to: " + data.getAbsolutePath());  
        
        if (data.exists()) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(data));
                String line = in.readLine();
                while (line != null) {
                    StringTokenizer lineST = new StringTokenizer(line, "|");
                    String[] contactFields = new String[lineST.countTokens()];
                    //System.out.println(lineST.countTokens());
                    int i = 0;
                    while (lineST.hasMoreTokens()) {
                        contactFields[i] = lineST.nextToken();
                        i++;
                    }
                    line = in.readLine();  // strips out any carriage return chars
                    Contact1 contact = new Contact1(contactFields);
                    //System.out.println(contact.toString());
                    displayContactInfo(contact);
                }

            } catch (IOException ioe) {
                System.out.println("Houston, we have a problem! reading this file");
            } finally {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        } else {
            System.out.println("File not found: test.txt");
        }
    }
    
    public static void displayContactInfo(Contact1 contact) {
        System.out.println(contact.getfName() + " " 
                + contact.getlName());
        System.out.println(contact.getAddress());
        System.out.println(contact.getCity() + ", " 
                + contact.getState() + " "
                + contact.getZipcode());
        System.out.println(contact.getEmail());
        System.out.println(contact.getPhoneNum() + "\n");
    }
}
