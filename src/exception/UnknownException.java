package exception;

import com.oracle.tools.packager.Log;

public class UnknownException extends Exception {

    public UnknownException(){
        super("[EXCEPTION] - Unknown exception.");
    }
}
