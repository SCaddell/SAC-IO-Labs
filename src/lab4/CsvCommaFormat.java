package lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class is a <code>FormatStrategy</code> implementation. 
 * It's responsible for encloding and decoding to/from the CSV format where
 * commas are delimiters and data values are not quoted.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu (version 1.00)
 * @author  Stuart Caddell, scaddell@my.wctc.edu (upgrades from 1.00 to 1.01)
 * @version 1.01
 */
public class CsvCommaFormat implements FormatStrategy<List<LinkedHashMap<String, String>>,List<String>> {
    private static final String CRLF = "\n";
    private static final String COMMA = ",";
    private static final String DOUBLE_QUOTE = "\"";
    
    private boolean hasHeader;
    
    /**
     * Custom constructor
     * @param hasHeader - indicates if CSV has a header row or not
     */
    public CsvCommaFormat(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    /**
     * Encodes data supplied by a program into the CSV format.
     * 
     * @param dataFromSrc - the raw data from a source, where the
     * key is a real or artificial field name and the value is the data to
     * be stored.
     * @return the formatted data.
     */
    @Override
    public String encode(List<LinkedHashMap<String, String>> dataFromSrc) {
        
        if (dataFromSrc == null  || dataFromSrc.isEmpty()) { 
            throw new IllegalArgumentException("A null or empty list was passed"
                    + " to be encoded.");
        }
        StringBuilder formattedData = new StringBuilder();

        boolean headerNotSet = true;
        boolean hasEmbeddedComma;
        Set<String> fieldNames = null;
        
        // if file to have a header, get keySet from 1st row of HashMap 
        if (hasHeader) {
            fieldNames = dataFromSrc.get(0).keySet();
        }

        // 
        for (int recordNo = 0; recordNo < dataFromSrc.size(); recordNo++) {
            if (fieldNames != null && headerNotSet) {
                for (String fieldName : fieldNames) {
                    // using quoted values to eliminate problems with
                    // embedded commas in a data value
                    hasEmbeddedComma = checkForEmbeddedComma(fieldName);
                    if (hasEmbeddedComma){
                        formattedData.append(DOUBLE_QUOTE);
                        formattedData.append(fieldName); 
                        formattedData.append(DOUBLE_QUOTE);
                    }
                    else {
                        formattedData.append(fieldName);
                    }
                    formattedData.append(COMMA);
                }
                // remove trailing comma
                formattedData.deleteCharAt(formattedData.length() - 1);
                formattedData.append(CRLF);
                addDataValues(dataFromSrc, recordNo, formattedData);
                headerNotSet = false;

            } else {
                addDataValues(dataFromSrc, recordNo, formattedData);
            }
        }

        // Here's the CSV formatted data as a single String that can be
        // saved to a file.
        return formattedData.toString();
    }
    
    /**
     * Decodes CSV data supplied by a source and stores keys and values in
     * a generic data structure that can be used by most any program.
     * 
     * @param dataFromSrc - the raw data from a source, where each entry
     * represents one row in the CSV file.
     * @return the generic data structure used for transport.
     */
    @Override
    public List<LinkedHashMap<String, String>> decode(List<String> dataFromSrc) {
        /*
         * This data structure will be used to store the decoded data
         * in a neutral format that can be used by any program. It's main
         * advantage is that each Map is a record structure with key values
         * that represent field names if present. If not present, artificail
         * field names will be created based on a simple counter.
         */
        List<LinkedHashMap<String, String>> decodedData =
                new ArrayList<LinkedHashMap<String, String>>();

        String[] headerFields = null;
        for (int recordNo = 0; recordNo < dataFromSrc.size(); recordNo++) {
            String firstRow = dataFromSrc.get(recordNo);
            
            String[] fields = dataFromSrc.get(recordNo).split(COMMA);
            if (hasHeader && (recordNo == 0)) { // first record may be header
                headerFields = fields;
//                continue;
            }

            LinkedHashMap<String, String> record =
                    new LinkedHashMap<String, String>();
            for (int i = 0; i < fields.length; i++) {
                if (hasHeader && (recordNo == 0)) { // zero is first record, could be header
                    break; // not a record so skip following code
                    // because it's a header but has no data values

                    // if header included, we store header info as key and data value
                } else if (hasHeader) {
                    record.put(headerFields[i], fields[i]);

                    // if no header we create an artificial key from a counter and add value
                } else {
                    record.put("" + i, fields[i]);
                }
            }

            // Only add the record if it's not the first row (header)
            if (recordNo != 0) {
                decodedData.add(record);
            }
        }

        return decodedData;
    }
    

    private void addDataValues(List<LinkedHashMap<String, String>> dataFromFile, int recordNo, StringBuilder formattedData) {
        // write a normal data row
//        boolean hasEmbeddedComma;
        Collection<String> valueCol = dataFromFile.get(recordNo).values();
        for (String value : valueCol) {
            // using quoted values to eliminate problems with
            // embedded commas in a data value
            boolean hasEmbeddedComma = checkForEmbeddedComma(value);
            if (hasEmbeddedComma){
                formattedData.append(DOUBLE_QUOTE);
                formattedData.append(value); 
                formattedData.append(DOUBLE_QUOTE);
            }
            else {
                formattedData.append(value);
            }
//            formattedData.append(value);
            formattedData.append(COMMA);
        }
        // remove trailing comma
        formattedData.deleteCharAt(formattedData.length() - 1);
        formattedData.append(CRLF);
    }
    
    private boolean checkForEmbeddedComma(String decodedField) {
        boolean hasComma = false;
        String[] fieldParts = decodedField.split(COMMA);
        if (fieldParts.length > 1) 
            hasComma = true;
        return hasComma;
    }

    @Override
    public String toString() {
        return "Csv Comma Formatter";
    }
    
    public static void main(String[] args) {
        FormatStrategy testFormat = new CsvCommaFormat(false);
        List<LinkedHashMap<String, String>> recordMap = 
                new ArrayList<LinkedHashMap<String, String>>();
        LinkedHashMap<String, String> mapField1 = new LinkedHashMap<String, String>();
        mapField1.put("field1", "field1a");
        mapField1.put("field2", "field2a");
        mapField1.put("field3", "field3a");
        mapField1.put("field,4", "field4a");
        
//        System.out.println(mapField1.values());
//        System.out.println(mapField1);
        
        recordMap.add(mapField1);
//        System.out.println(recordMap);
        LinkedHashMap<String, String> mapField2 = new LinkedHashMap<String, String>();
        mapField2.put("field1", "\"field1b\"");
        mapField2.put("field2", "\"field2,b\"");
        mapField2.put("field3", "field3b");
        mapField2.put("field4", "field4b");
        
//        System.out.println(mapField2.values());
//        System.out.println(mapField2);
        
        recordMap.add(mapField2);
//        System.out.println(recordMap);
        
        LinkedHashMap<String, String> mapField3 = new LinkedHashMap<String, String>();
        mapField3.put("field1", "field1c");
        mapField3.put("field2", "field2c");
        mapField3.put("field3", "field3,c");
        mapField3.put("field4", "field4c");
        
//        System.out.println(mapField.values());
//        System.out.println(mapField);
        
        recordMap.add(mapField3);
//        System.out.println(recordMap);
        
        System.out.println("---------------------------------");
        
        String encoded = testFormat.encode(recordMap);
        System.out.println(encoded);
//        recordMap.addAll(mapField);
//        
//        encode(List<LinkedHashMap<String, String>> dataFromSrc) {
//        StringBuilder formattedData = new StringBuilder();
//        testFormat.encode(testFormat);
    }

}
