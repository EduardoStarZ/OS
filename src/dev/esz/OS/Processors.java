public class Processors {
    public static String jsonConfig(String content) {
        return content.replace("{","")
                .replace("}", "")
                .replace(",", "")
                .replace("\"", "")
                .replace(" ", "");
    }

    public static String[] args(String content) {
        return content.split(" ");
    }
}