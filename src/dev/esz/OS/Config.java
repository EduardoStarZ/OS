import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Config {
    private String user;
    private final String system = System.getProperty("os.name");
    private final String parameter = SearchEngine.configSearch("ParameterDeclaration", "config.json");
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
    public Config() {}

    /**
     * <p>
     * A initializer to the Config Class
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

    public static String getNativeConfigFile() {
        File config = new File("Native.json");
        String content = "";
        try {
            Scanner scanner = new Scanner(config);

            while(scanner.hasNextLine()) {
                content += scanner.nextLine(); 
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return content;
    }
}