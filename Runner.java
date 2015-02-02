import java.util.*;
import java.io.*;
/**
* Created by koushikkrishnan on 1/30/15.
*/
public class Runner {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String vars = "";
        String header = "public class Hello { public static void main(String[] args) { ";
        String middle = "";
        String footer = "} }";
        boolean exit = false;

        while (!exit) {
            String line = s.nextLine();
            if (line.equals("q")) {
                System.exit(0);
            }
            else {
                // everything else
                // shove it into a main method
                middle += line;
                try {
                    File file = new File("Hello.java");
                    // if file doesnt exists, then create it
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(header + middle + footer);
                    bw.close();
                    String hi = Command.executeCommand("javac Hello.java");
                    System.out.println("hello: " + hi.length());
                    System.out.println(Command.executeCommand("java Hello"));
                    System.out.println("Done");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
