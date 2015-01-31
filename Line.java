public class Line {

    private String data;
    private LineType type;
    private String[] prims = {"char","byte","float","double","int","long","boolean","short"};

    public Line(String data) {
        this.data = data;
        parseLine();
    }

    public void parseLine() {
        // look a primitive reserve word
        boolean done = false;
        for (int i = 0; i < primitive.length && !done; i++) {
            if (data.indexOf(prims[i]) != -1) {
                // found a reserve word
                // this means that this line is instatiating a variable
                type = LineType.INSTATION;
                done = true;
            }
        }
        if (!done) {
            type = LineType.INVOCATION;
        }
    }

}
