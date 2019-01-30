package exception;

public class FormatNotFoundException extends Exception{

    public FormatNotFoundException(){
        super("[EXCEPTION] - Format not found. Skipped.");
    }
}
