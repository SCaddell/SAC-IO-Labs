/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;

/**
 *
 * @author Stuart - HP AMD 10
 */
public interface FileReaderStrategy<T>  {
    
    String getFilePath();

    FormatStrategy getFormatter();

    T readAllFile() throws IOException;

    void setFilePath(String filePath) throws IOException;

    void setFormatter(FormatStrategy formatter) throws Exception;
    
    
}
