/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.io.IOException;

/**
 *
 * @author Stuart - HP AMD 10
 */
public class Startup {
    
    enum ContactFields {
        FIRST_NAME,
        LAST_NAME,
        ADDRESS,
        CITY,
        STATE,
        ZIP,
        EMAIL,
        PHONE_NUM;
    }
    
    public static void main(String[] args) {
        
        int desiredRec = 2;
        int desiredField = ContactFields.CITY.ordinal();
        
        String fileRec = null;
        
        TxtReader txtReader = new TxtReader();
        try {
            fileRec = txtReader.getRecordNum(desiredRec);
        } catch (IOException ioe) {
                System.out.println("Had a TxtReader problem with input file");
        }
        TxtDecoder decoder = new TxtDecoder();
        String[] tokens = decoder.decodeInputString(fileRec);
        
        System.out.println("The requested data is: " + tokens[desiredField]);
    }
    
}
