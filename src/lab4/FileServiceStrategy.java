package lab4;

/**
 *
 * @author Stuart Caddell, scaddell@my.wctc.edu
 */
public interface FileServiceStrategy {
    // Marker/tag interface for File Services
    String getFilePath();
    
    void setFilePath(String filePath);
    
    FormatStrategy getFormatter();
    
    void setFormatter(FormatStrategy formatter);
    
}
