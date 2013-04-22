package lab4;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Stuart Caddell, scaddell@my.wctc.edu
 */
public class TextFileReader {
    
    private String filePath;
    private FormatStrategy textFormatter = new FormatStrategy();
    
    public TextFileReader(String filePath, 
            FormatStrategy<List<LinkedHashMap<String, String>>,
                    List<String>> formatter) {
        this.filePath = filePath;
        this.formatter = formatter;
    } 
    
}
