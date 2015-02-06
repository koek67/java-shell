
/**
 * This is a super class for the type of input a user can
 * give.
 *
 * Inputs are structured to have a header, a footer, and a body.
 * The body could be a two things:
 *  - more LineNodes
 *  - another Input
 *
 * When adding LineNodes to an Input, call addToBody(LineNode).
 * This will
 * All inputs must have a method to validate a string to
 * see if a String matches its input.
 *
 * All inputs must have a method to describe how to add itself
 * to the main file.
 *
 * All inputs must have a name.
 *
 * All inputs must have a flag indicating if it is a multi-line
 * input.
 *
 * @author Koushik Krishnan
 */
public abstract class Input {

    protected String name;
    protected boolean isMultiLine;
    protected LineNode head, tail;

    public Input(String _name, boolean _isMultiLine) {
        name = _name;
        isMultiLine = _isMultiLine;
    }

    public abstract boolean validate(String input);

    public abstract void addToFile();

    public String get_name() { return name; }

    public boolean is_multi_line() { return isMultiLine; }

    public abstract void addToBody(LineNode l);

    public abstract void addToBody(Input in);
}
