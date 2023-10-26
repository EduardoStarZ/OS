import java.lang.reflect.Method;

public class Native {
    FileSystem fileSystem = new FileSystem();
    Shell shell = new Shell();


    public Method listItemsInit() throws NoSuchMethodException, SecurityException {
        return Native.class.getMethod("listItems");
    }

    public void listItems() {
        String[] contents = fileSystem.listDirectoryObjects();

        for(int i=0; i<=contents.length-1; i++) {
            shell.write(contents[i] + "  ");

            if((i + 1) % 5 == 0) {
                shell.write("\n");
            }
        }
    }
    
    public Method changeDirectoryInit() throws NoSuchMethodException, SecurityException {
        return Native.class.getMethod("changeDirectory", String.class);
    } 

    public void changeDirectory(String[] args) {
        if(!fileSystem.changeDirectory(args[0])) {
            shell.writeln("\u001B[34m The folder \""+ args[0] + "\" couldn't be found");
        }
        else{
            return;
        }
    }
}
