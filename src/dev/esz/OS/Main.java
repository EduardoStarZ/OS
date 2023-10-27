public class Main {
    public static void main(String[] args) {
        Shell shell = new Shell();
        ShellRunner run = new ShellRunner();
        
        while(true) {
            String arguments = shell.read();

            run.execute(Processors.getCommand(arguments), Processors.args(Processors.removeCommand(arguments)));
        }
    }
}
