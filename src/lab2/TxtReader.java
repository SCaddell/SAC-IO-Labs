
package lab2;
    
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TxtReader {

    //public static void main(String[] args) throws IOException {
        
    public String getRecordNum(int desiredRec) throws IOException {
        
        String rtnString = null;

        File data = new File(File.separatorChar + "temp" + File.separatorChar
                + "class20Lab1a.txt");
        
        int recCntr = 0;
        
        if (data.exists()) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(data));
                String line = in.readLine();
                while (line != null && recCntr < desiredRec) {
                    recCntr++;
                    if (recCntr == desiredRec) {
                        rtnString = line;
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
        return rtnString;
    }   
}
