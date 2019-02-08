package exception;

public class FormatNotFoundException extends Exception{

    public FormatNotFoundException(){
        super("Format not found. Skipped.");
    }
}
