import static java.lang.System.out;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>A java class to create a shell experience within your terminal</p>
 * 
 * @author EduardoStarZ
 * 
 * @since 1.0.0
*/
public class Shell {
    
    private static Scanner scanner = new Scanner(System.in);
    private final String[] info = new String[2];
    private boolean echo = true;
    private String displayFolder = "~";
    private ArrayList<String> folderPathname = new ArrayList<>();

    /**
     * <p>A initializer to the Shell Class</p>
     * 
     * @param user used to display the user of the shell program
     * @param system used to display the system name
     * 
     * @since 1.0.0
     */
    public Shell(String user, String system) {
        this.info[0] = user;
        this.info[1] = system;
    }

    /**
     * <p>A initializer to the Shell Class</p>
     * 
     * @param user used to display the user of the shell program
     * @param system used to display the system name
     * @param echo a boolean that determines if the above options and the directory display will show up
     * 
     * @since 1.0.0
     */
    public Shell(String user, String system, boolean echo) {
        this.echo = echo;
        this.info[0] = user;
        this.info[1] = system;
    }

    /**
     * 
     * @param folder a pathname that points to a directory location
     * 
     * @since 1.0.0
     */
    private void changeFolder(String folder) {
        this.displayFolder = folder;

        folder = folder.replace("/", "\\\\");

        folderPathname.add(folder);
    }

    /**
     * <p>A subclass of Shell that contains every method related to user input</p>
     * 
     * @since 1.0.0
     */
    class Input{

        /**
         * <p>A method that receives user input
         * 
         * @return An array of strings containing the arguments inputed
         */
        public String[] read() {
            if(echo) {
                out.print("\u001B[34m"+ info[0] + "@" + info[1] + ":\u001B[32m" + displayFolder + "> $"+" \u001B[37m");
            }

            String input = scanner.nextLine();

            out.print("\n");
            return input.split(" ");
        }   
    }

    /**
     * <p>A subclass of Shell that contains every method related to user output</p>
     * 
     * @since 1.0.0
     */
    class Output{

        /**
         * <p>A method that uses the string parameter to print the information
         * 
         * @param information a string containing the information to be displayed
         * 
         * @since 1.0.0
         */
        public void write(String information) {
            out.print(information);
        }

        /**
         * <p>A method that uses the string parameter to print the information in a different line than the previous, if there's any
         * 
         * @param information a string containing the information to be displayed
         * 
         * @since 1.0.0
         */
        public void writeln(String information) {
            out.println(information);
        }
        
        /**
         * <p>A method that resets the info in the current line of the shell
         * 
         * @since 1.0.0
         */
        public void restartLine() {
            out.print("\r");
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell("EduardoStarZ", "debianLinux");

        try {
            Method method = Shell.class.getMethod("read");
            Command.execute(shell, method);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }
}

/**
 * <p>A class external to shell that will be used for modularly executing Java code
 * 
 * @since 1.0.0
 */
class Command {
   
    /**
     * <p>A method that gets another method and runs it through the use of the reflection library
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

//"\u001B[31mRed text"