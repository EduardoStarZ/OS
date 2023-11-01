import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {
    public static String configSearch(String configName, String configFilePathname) throws FileNotFoundException {
            Pattern pattern = Pattern.compile(configName);
            
            File config = new File(configFilePathname);
            String content = "";

            //TODO found out that this method somewhy always returns the last string of the native config file, fix this later

                Scanner scanner = new Scanner(config);
                
                content = Processors.jsonConfig(content);
                
                while(scanner.hasNext()) {
                    content = scanner.nextLine();
                    Matcher matcher = pattern.matcher(content);

                    if(matcher.matches()) {
                        content = content.split(":")[1];
                    }
                }

                scanner.close();
                return content;    
    }

    public static String nativeSearch(String methodName) throws FileNotFoundException {
        File file = new File("Native.commands");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {
            String content = scanner.nextLine();

            int startIndex = content.indexOf("[");
            int endingIndex = content.indexOf("]");

            String target = content.substring(startIndex, endingIndex);

            if(content.equals(methodName)) {
                startIndex = content.indexOf("(");
                endingIndex = content.indexOf(")");
                
                return content.substring(startIndex, endingIndex);
            }
        }
    }
}