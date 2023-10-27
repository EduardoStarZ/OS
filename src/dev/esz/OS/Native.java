public class Native {
    FileSystem fileSystem = new FileSystem();
    Shell shell = new Shell();
    public Arguments get = new Arguments();

    public void listItems() {
        String[] contents = fileSystem.listDirectoryObjects();

        for(int i=0; i<=contents.length-1; i++) {
            shell.write(contents[i] + "  ");

            if((i + 1) % 5 == 0) {
                shell.write("\n");
            }
        }
    }

    public void changeDirectory() {
        if(!fileSystem.changeDirectory(get.args[0].toString())) {
            shell.writeln("\u001B[34m The folder \""+ get.args[0] + "\" couldn't be found");
        }
    }

    public void createFile() {
        if(!fileSystem.createFile(get.args[0].toString())) {
            shell.writeln("\u001b[34m The file \""+get.args[0] + "\" couldn't be found");
        }
    }

    public void makeDirectory() {
        if(!fileSystem.makeDirectory(get.args[0].toString())) {
            shell.writeln("\u001b[34m The folder \""+ get.args[0] + "\" couldn't be created");
        }
    }

    public void makeDirectories() {
        if(!fileSystem.makeDirectory(get.args[0].toString())) {
            shell.writeln("\u001b[34m The chain of directories \""+ get.args[0] + "\" couldn't be created");
        }
    }

    public void echo() {
        if(shell.config.echo) {
            shell.config.echo = false;
            return;
        }
        shell.config.echo = true;
    }
}