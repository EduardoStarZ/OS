import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Shell shell = new Shell();
        ShellRunner run = new ShellRunner();
        
        while(true) {
            String arguments = shell.read();

            run.execute(Processors.getCommand(arguments), Processors.args(Processors.removeCommand(arguments)));
            
        }

            // File file = new File("Native.json");
            // System.out.println(file.canRead());
            // Scanner scanner = new Scanner(file);
            // String content = "";

            // while(scanner.hasNextLine()) {
            //     content += scanner.nextLine() + "\n";
            // }

            // System.out.println(content);

            // scanner.close();
    }
}