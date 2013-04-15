/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.IOException;

/**
 *
 * @author Stuart - HP AMD 10
 */
public class Startup {
    public static void main(String[] args) {
        
        int desiredRec = 2;
        String fileRec = null;
        
        TxtReader txtReader = new TxtReader();
        try {
            fileRec = txtReader.getRecordNum(desiredRec);
        } catch (IOException ioe) {
                System.out.println("Had a TxtReader problem with input file");
        }
        TxtDecoder decoder = new TxtDecoder();
        String[] tokens = decoder.decodeInputString(fileRec);
        Contact2 contact = new Contact2(tokens);
        displayContactInfo(contact);  
    }
    
    private static void displayContactInfo(Contact2 contact) {
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
