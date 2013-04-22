package lab4;

/**
 * The "system variable" which can change from company to company are all 
 * retained in a parking facility class.  At system startup, and with each 
 * vehicle entry and exit they are extracted and loaded to a system information
 * Map (sysInfo).  The keys to the map variables are the enum values below.
 * 
 * The classes only know about the existence of, and structure of the keys and
 * variables they need to use.  The using class casts the object back to the 
 * proper structure as part of the retrieval.   
 * 
 * @author Stuart Caddell, scaddell@my.wctc.edu
 */
public interface FileServiceKeys {
    
    /**
     * SysVariables contains the valid list of keys to be used in the sysInfo
     * map.  Any new keys should be added to this enum.
     */
    public enum FileFunction {
        READ, 
        WRITE_REPLACE,
        WRITE_APPEND;
    }
    
    public enum FileType {
        PLAIN_TEXT,
        CSV_COMMA_FORMAT_TEXT;
        // BIN;
    }
    
    public enum HeaderInfo {
        HAS_HEADERS,
        NO_HEADERS;
    }
    
}
