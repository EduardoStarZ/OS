import static java.lang.System.out;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Shell {
    
    private static Scanner scanner = new Scanner(System.in);
    private final String[] info = new String[2];
    private boolean echo = true;
    private String displayFolder = "~";
    private ArrayList<String> folderPathname = new ArrayList<>();

    public Shell(String user, String system) {
        this.info[0] = user;
        this.info[1] = system;
    }

    public Shell(String user, String system, boolean echo) {
        this.echo = echo;
        this.info[0] = user;
        this.info[1] = system;
    }

    private String[] read() {
        if(echo) {
            out.print("\u001B[34m"+ info[0] + "@" + info[1] + ":\u001B[32m" + displayFolder + "> $\u001B[37 ");
        }

        String input = scanner.nextLine();

        return input.split(" ");
    }

    private void changeFolder(String folder) {
        this.displayFolder = folder;

        folder = folder.replace("/", "\\\\");

        folderPathname.add(folder);
    }

    public static void main(String[] args) {
        Shell shell = new Shell("ESZ", "debianLinux");

        shell.read();
    }
}

class Command {
    static void execute(Object object, Method method, Object[] parameters) {
        try {
            method.invoke(object, parameters);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

//"\u001B[31mRed text"
