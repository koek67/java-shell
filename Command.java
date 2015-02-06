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

    public static void printLines(String name, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
        new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(name + " " + line);
        }
    }

    public static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
    }

    public static void doTheThing(String file) {
        try {
            runProcess("javac "+ file +".java");
            runProcess("java " + file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
