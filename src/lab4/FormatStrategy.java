package lab4;

/**
 * This interface represents the general contract for all Format 
 * Strategy implementations. The return type and parameters are generic so 
 * that future implementations and use whatever data type is necessary.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public interface FormatStrategy<T,E> {

    T decode(E dataFromFile);

    StringBuilder encode(T dataToFile);
    
}
