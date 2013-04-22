package lab4;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class TxtCsvReader {
    
    private static final int MIN_RECORD_LENGTH = 1;
    
    public List<LinkedHashMap<String, String>> getAllInput() throws IOException {
        
    }
    
    private String[] decodeInput(String fileRecord) {
        if (fileRecord == null || fileRecord.length() < MIN_RECORD_LENGTH) {
            throw new IllegalArgumentException("file record is null or length "
                    + "is less than " + MIN_RECORD_LENGTH + " characters");
        }
        String[] delimitedRecord = fileRecord.split("'\\,");
        return delimitedRecord;
    }
    
}
