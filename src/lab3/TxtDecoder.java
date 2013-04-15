package lab3;

import lab2.*;
import java.util.StringTokenizer;

public class TxtDecoder {
    
    public String[] decodeInputString(String inStr) {
        
        StringTokenizer strTokens = new StringTokenizer(inStr, "|");
        String[] token = new String[strTokens.countTokens()];
        int i = 0;
        while (strTokens.hasMoreTokens()) {
            token[i] = strTokens.nextToken();
            i++;
        }
        return token;
    }
}
