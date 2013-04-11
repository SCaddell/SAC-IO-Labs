package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Lab1 {

    public static void main(String[] args) throws IOException {

        int fieldCntr = 0;
        int recCntr = 0;
                
        String fName = null;
        String lName = null;
        String address = null;
        String city = null;
        String state = null;
        String zipcode = null;
        String email = null;
        String phoneNum = null;



        File data = new File(File.separatorChar + "temp" + File.separatorChar
                + "class20Lab.txt");
        if (data.exists()) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(data));
                String line = in.readLine();
                while (line != null) {
                    fieldCntr++;
                    switch (fieldCntr) {
                        case 1:
                            recCntr++;
                            fName = line;
                            break;
                        case 2:
                            lName = line;
                            break;
                        case 3:
                            address = line;
                            break;
                        case 4:
                            city = line;
                            break;
                        case 5:
                            state = line;
                            break;
                        case 6:
                            zipcode = line;
                            break;
                        case 7:
                            email = line;
                            break;
                        case 8:
                            phoneNum = line;
                            System.out.println(fName + " " + lName);
                            System.out.println(address);
                            System.out.println(city + ", " + state + " "
                                    + zipcode);
                            System.out.println(email);
                            System.out.println(phoneNum + "\n");
                            fieldCntr = 0;
                            break;
                    }
//                    System.out.println(line);
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

        System.out.println("-------------------------------------------");
        recCntr = 0;
        fieldCntr = 0;

//        File data = new File(File.separatorChar + "temp" + File.separatorChar
//                + "class20Lab.txt");
        if (data.exists()) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(data));
                String line = in.readLine();
                while (line != null) {
                    fieldCntr++;
                    if (fieldCntr >= 9 && fieldCntr <= 16) {
                        System.out.println(line);
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
        
        System.out.println("-------------------------------------------");
        
        boolean append = true;   
        
        PrintWriter out = new PrintWriter(
                                new BufferedWriter(
				new FileWriter(data, append)));
        
        fName = "It";
        lName = "Works";
        address = "1234 Washington Blvd";
        city = "Pewaukee";
        state = "WI";
        zipcode = "12345";
        email = "ItWorks@it.Hard";
        phoneNum = "414-444-5555";
        
        out.print("\n");
        out.println(fName);
        out.println(lName);
        out.println(address);
        out.println(city);
        out.println(state);
        out.println(zipcode);
        out.println(email);
        out.println(phoneNum);
        
        out.close();  // be sure you close your streams when done!!
	
	System.out.println("Wrote file to: " + data.getAbsolutePath());  
        
        recCntr = 0;
        fieldCntr = 0;
        
        if (data.exists()) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(data));
                String line = in.readLine();
                while (line != null) {
                    fieldCntr++;
                    switch (fieldCntr) {
                        case 1:
                            recCntr++;
                            fName = line;
                            break;
                        case 2:
                            lName = line;
                            break;
                        case 3:
                            address = line;
                            break;
                        case 4:
                            city = line;
                            break;
                        case 5:
                            state = line;
                            break;
                        case 6:
                            zipcode = line;
                            break;
                        case 7:
                            email = line;
                            break;
                        case 8:
                            phoneNum = line;
                            System.out.println(fName + " " + lName);
                            System.out.println(address);
                            System.out.println(city + ", " + state + " "
                                    + zipcode);
                            System.out.println(email);
                            System.out.println(phoneNum + "\n");
                            fieldCntr = 0;
                            break;
                    }
//                    System.out.println(line);
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

    }
}