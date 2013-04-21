package lab4;

public class TxtCSVReader {
    
    private static final int MIN_RECORD_LENGTH = 1;
    
    public String[] getAllInput() {
        
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
