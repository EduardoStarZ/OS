public class Processors {
    public static String jsonConfig(String content) {
        return content.replace("{","")
                .replace("}", "")
                .replace(",", "")
                .replace('"', ' ')
                .replace(" ", "");
    }

    public static String removeCommand(String content) {
        String[] splitter = content.split(" ");
        for(int i=1; i<=splitter.length-1; i++) {
            content += splitter[i];
        }

        return content;
    }

    public static String getCommand(String content) {
        return content.split(" ")[0];
    }

    public static String[] args(String content) {
        return content.split(" ");
    }

    public static String pathname(String content) {
        return content.replace("/", "\\\\")
        .replace("\"", "");
    }
}