import java.io.File;

public class Functions {
    File file;
    private String user;
    private String system;

    public Functions(String directory, String user, String system) {
        file = new File(directory);
        this.user = user;
        this.system = system;
    }

    public void listItems() {
        String[] items = file.list();
        Shell shell = new Shell(user, system, false);

        for(int i=0; i<=items.length-1; i++) {
            shell.write(items[i]);
            if(i != items.length-1) {
                shell.write(", ");
            }
        }
    }
}