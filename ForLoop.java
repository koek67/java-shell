/**
 * ForLoop is a type of input that handles for loops. This class
 * will be able to recognize standard for loops as well as
 * for-each loops.
 */
public class ForLoop extends Input {

    public ForLoop() {
        super("for-loop", true);
    }

    public boolean validate(String input) {
        return true;
    }

    public void addToFile() {
        
    }

}
