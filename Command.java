import java.io.*;
import java.util.*;
/**
* Created by koushikkrishnan on 1/30/15.
*/
public class Command implements Runnable {
    String[] args;
    Process  process;

    public Command(String... args) {
        this.args = args;
    }

    @Override
    public void run(){
        try {
            process =  Runtime.getRuntime().exec(args);
            System.out.println(process);
        } catch (Exception e ) {}
    }

    public Process getProcess() {
        return process;
    }

    public static String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
            new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}
