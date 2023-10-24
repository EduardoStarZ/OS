import static java.lang.System.out;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.File;

/**
 * <p>
 * A java class to create a shell experience within your terminal
 * </p>
 * 
 * @author EduardoStarZ
 * 
 * @since 1.0.0
 */
public class Shell {

    private Config config = new Config("EduardoStarZ");
    private static Scanner scanner = new Scanner(System.in);
    private String displayFolder = "~";
    private ArrayList<File> folders = new ArrayList<>();

    /**
     * <p>
     * A initializer to the Shell Class
     * </p>
     * 
     * @param user   used to display the user of the shell program
     * @param system used to display the system name
     * 
     * @since 1.0.0
     */
    public Shell() {}

    /**
     * 
     * @param folder a pathname that points to a directory location
     * 
     * @since 1.0.0
     */
    private void changeFolder(File folder) {
        this.displayFolder = "~\\" + folder.getAbsolutePath();

        folders.add(folder);
    }

    /**
     * <p>
     * A subclass of Shell that contains every method related to user input
     * </p>
     * 
     * @since 1.0.0
     */

    /**
     * <p>
     * A method that receives user input
     * 
     * @return An array of strings containing the arguments inputed
     */
    public String[] read() {
        if (config.echo) {
            out.print("\u001B[34m" + config.getUser() + "@" + config.getSystem() + ":\u001B[32m" + displayFolder + "> $" + " \u001B[37m");
        }

        String input = scanner.nextLine();

        out.print("\n");
        return input.split(" ");
    }

    /**
     * <p>
     * A method that uses the string parameter to print the information
     * 
     * @param information a string containing the information to be displayed
     * 
     * @since 1.0.0
     */
    public void write(String information) {
        out.print(information);
    }

    /**
     * <p>
     * A method that uses the string parameter to print the information in a
     * different line than the previous, if there's any
     * 
     * @param information a string containing the information to be displayed
     * 
     * @since 1.0.0
     */
    public void writeln(String information) {
        out.println(information);
    }

    /**
     * <p>
     * A method that resets the info in the current line of the shell
     * 
     * @since 1.0.0
     */
    public void restartLine() {
        out.print("\r");
    }

    public void processArguments(String[] args) {
        
    }

    public static void main(String[] args) {
        // Shell shell = new Shell();

        // try {
        // Method method = Shell.class.getMethod("read");
        // Command.execute(shell, method);
        // } catch (NoSuchMethodException | SecurityException e) {
        // e.printStackTrace();

        // }
    }
}

/**
 * <p>
 * A class external to shell that will be used for modularly executing Java code
 * 
 * @since 1.0.0
 */
class Command {

    /**
     * <p>
     * A method that gets another method and runs it through the use of the
     * reflection library
     * 
     * @param object an object to be used in the method
     * @param method the actual method being ran
     */
    static void execute(Object object, Method method) {
        try {
            method.invoke(object);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

// "\u001B[31mRed text"