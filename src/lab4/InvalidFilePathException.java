package lab4;

import java.io.IOException;

/**
 *
 * @author Stuart Caddell, scaddell@my.wctc.edu
 */
public class InvalidFilePathException extends IOException {
    
    /**
     * No arg constructor
     */
    public InvalidFilePathException() {
        super("A null or invalid file path was provided!");
    }
    
    /**
     * The following constructor accepts a string for providing additional 
     * information at time of exception.
     */
    public InvalidFilePathException(String additionalInfo) {
        super("A null or invalid file path was provided! " + additionalInfo);
    }
    
    @Override
    public String toString() {
        String str = "InvalidFilePathException";
        return str;
    }
}
