package lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Stuart Caddell, scaddell@my,wctc.edu
 */
public class TextFileWriter implements 
        FileWriterStrategy<List<LinkedHashMap<String, String>>> {

    private final static String CLASS_NAME = "TextFileWriter";
    private final static int    MIN_PATH_LENGTH = 5; // x.txt or x.csv
    
    private FormatStrategy
            <List<LinkedHashMap<String, String>>,List<String>> formatter;
    private String filePath;
    private boolean appendIndicator = false;
    
    public TextFileWriter(
            String filePath, 
            FormatStrategy<List<LinkedHashMap<String, String>>,List<String>>
                    formatter) throws Exception {
        setFilePath(filePath);
        setFormatter(formatter);
    } 
    
    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public boolean getAppendIndicator() {
        return appendIndicator;
    }

    @Override
    public void writeFile(List<LinkedHashMap<String, String>> textOut) 
            throws IOException {
        
        StringBuilder formattedOutput = formatter.encode(textOut);
        System.out.println(formattedOutput);
        
        
        // do acutal file read
        try {
            FileWriter fWriter = new FileWriter(filePath, appendIndicator);
            PrintWriter outputFile = new PrintWriter(fWriter);
            outputFile.print(formattedOutput);
            outputFile.close();
        } catch(IOException ioe){
            throw ioe;
//        }finally{
//            outputFile.close();
        }
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

    @Override
    public void setAppendIndicator(boolean appendIndicator) {
        this.appendIndicator = appendIndicator;
    }

    @Override
    public FormatStrategy getFormatter() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public final void setFormatter(FormatStrategy formatter) throws
            NullFormatterException {
        if (formatter == null) {
            throw new NullFormatterException(CLASS_NAME);
        }
        else {
            this.formatter = formatter;
        }
    }
    
}
