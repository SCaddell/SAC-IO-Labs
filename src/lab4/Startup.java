/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Stuart - HP AMD 10
 */
public class Startup {
    
    public static void main(String[] args) throws IOException, Exception {
        TextFileReader app = 
                new TextFileReader("C:\\Temp\\TestCsv2.csv", 
                new CsvCommaFormat(true));
//        TextFileReader app = 
//                new TextFileReader("src/custom_garage_format.txt", new CustomGarageFormat());

        System.out.println("Reading and Decoding data ...");
        
        List<LinkedHashMap<String, String>> returnData =
                app.readAllFile();
        
        System.out.println(returnData); 
        
        TextFileWriter out = 
                new TextFileWriter("C:\\Temp\\TestCsv3.csv", 
                new CsvCommaFormat(false));
        
        out.setAppendIndicator(true);
        
        out.writeFile(returnData);
    }
}
