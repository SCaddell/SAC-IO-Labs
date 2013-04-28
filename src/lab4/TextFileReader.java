package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Stuart Caddell, scaddell@my.wctc.edu
 */
public class TextFileReader implements FileReaderStrategy
        <List<LinkedHashMap<String, String>>> {
    
    private final static String CLASS_NAME = "TextFileReader";
    private final static int    MIN_PATH_LENGTH = 5; // x.txt or x.csv
    
    private FormatStrategy
            <List<LinkedHashMap<String, String>>,List<String>> formatter;
    private String filePath;
    
    public TextFileReader(
            String filePath, 
            FormatStrategy<List<LinkedHashMap<String, String>>,List<String>>
                    formatter) throws Exception {
        setFilePath(filePath);
        setFormatter(formatter);
    } 
    
    @Override
    public List<LinkedHashMap<String, String>> readAllFile() throws 
            IOException {

        // do acutal file read
        List<String> rawDataFromFile = new ArrayList<String>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new FileReader(filePath));
            String line = in.readLine();
            while (line != null) {
                rawDataFromFile.add(line);
                line = in.readLine();
            }
        } catch(IOException ioe){
            throw ioe;
        }finally{
            if(in != null){
                in.close();
            }
        }
        
        return formatter.decode(rawDataFromFile);
    }

    @Override
    public FormatStrategy getFormatter() {
        return formatter;
    }

    @Override
    public final void setFormatter(FormatStrategy formatter) throws Exception {
        if (formatter == null) {
            throw new NullFormatterException(CLASS_NAME);
        }
        else {
            this.formatter = formatter;
        }
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public final void setFilePath(String filePath) throws IOException {
        if (filePath == null || filePath.length() < MIN_PATH_LENGTH) {
            throw new InvalidFilePathException(CLASS_NAME);
        }
        else {
            this.filePath = filePath;
        }
    }

//    // For testing only...
//    public static void main(String[] args) throws IOException, Exception {
//        TextFileReader app = 
//                new TextFileReader("C:\\Temp\\TestCsv2.csv", 
//                new CsvCommaFormat(true));
////        TextFileReader app = 
////                new TextFileReader("src/custom_garage_format.txt", new CustomGarageFormat());
//
//        System.out.println("Reading and Decoding data ...");
//        
//        List<LinkedHashMap<String, String>> returnData =
//                app.readAllFile();
//        
//        System.out.println(returnData);            
//    }

}
