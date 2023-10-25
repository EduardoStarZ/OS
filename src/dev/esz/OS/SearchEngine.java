import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {
    public static String configSearch(String configName, String configFilePathname) {
            Pattern pattern = Pattern.compile(configName);
            
            File config = new File(configFilePathname);

            try {
                Scanner scanner = new Scanner(config);
                String content = "";
                
                content = Processors.jsonConfig(content);
                
                while(scanner.hasNext()) {
                    content = scanner.nextLine();
                    Matcher matcher = pattern.matcher(content);
                    scanner.close();

                    if(matcher.matches()) {
                        return content.split(":")[1];
                    }
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
                return "\\";    
    }
}