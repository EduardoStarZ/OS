public class Processors {
    public static String jsonConfig(String content) {
        return content.replace("{","")
                .replace("}", "")
                .replace(",", "")
                .replace("\"", "")
                .replace(" ", "");
    }
}
