import static java.lang.System.out;

public class Terminal{
    public void write(String information) {
        out.print(information);
    }

    public void restartLine() {
        out.print("\r");
    }

    public static void main(String[] args) {
        Terminal terminal = new Terminal();

        terminal.write("This is a line");
        terminal.restartLine();
        terminal.write("This is another line");
    }
}