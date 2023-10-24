import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Config {
    private final String user = " ";
    private final String system = System.getProperty("os.name");
    protected boolean echo;

    /**
     * <p>
     * A initializer to the Shell Class
     * </p>
     * 
     * @param user   used to display the user of the shell program
     * 
     * @since 1.0.0
     */
    public Config() {

        File config = new File("config.json");
        try {
            Scanner scanner = new Scanner(config);
            String content = "";
            
            while(scanner.hasNext()) {
                content += scanner.nextLine();
            }

            content = content
            .replace("{","")
            .replace("}", "")
            .replace(",", "")
            .replace("\"", "");

            String user = " ";
            echo = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * <p>
     * A initializer to the Shell Class
     * </p>
     * 
     * @param user   used to display the user of the shell program
     * @param echo   a boolean that determines if the above options and the
     *               directory display will show up
     * 
     * @since 1.0.0
     */
    public Config(boolean echo) {
        this.echo = echo;
    }

    public String getUser() {
        return user;
    }

    public String getSystem() {
        return system;
    }

    public String getDefaultStartingDirectory() {
        return " ";
    }
}