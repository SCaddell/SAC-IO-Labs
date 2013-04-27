package lab4;

/**
 *
 * @author Stuart Caddell, scaddell@my.wctc.edu
 */
public class NullFormatterException extends IllegalArgumentException {
    
    /**
     * No arg constructor
     */
    public NullFormatterException() {
        super("A null formatter was provided!");
    }
    
    /**
     * The following constructor accepts a string for providing additional 
     * information at time of exception.
     */
    public NullFormatterException(String additionalInfo) {
        super("A null formatter was provided! " + additionalInfo);
    }
    
    @Override
    public String toString() {
        String str = "NullFormatterException";
        return str;
    }
}
