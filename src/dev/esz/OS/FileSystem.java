import java.io.File;
import java.util.ArrayList;

public class FileSystem {
    private File folder;
    public ArrayList<File> previousFolders = new ArrayList<>();

    public FileSystem() {
        folder = new File("");
    }

    public String folderDirectory() {
        return folder.getAbsolutePath();
    }

    public boolean changeDirectory(String newDirectory) {
        File testFolder = new File(newDirectory);

        if(testFolder.isDirectory()) {
            previousFolders.add(folder);
            folder = new File(newDirectory);
            return true;
        }
        else{
            return false;
        }
    }

    public String[] listDirectoryObjects() {
        File[] objects = folder.listFiles();
        ArrayList<String> contents = new ArrayList<>();

        for(int i=0; i<=objects.length-1; i++) {
            File object = objects[i];

            if(object.isDirectory()) {
                contents.add("\u001B[34m"+object.getName());
            }

            if(object.isFile()) {
                contents.add("\u001B[32m"+object.getName());
            }

            if(object.isHidden()) {
                contents.add(object.getName());
            }
        }

        return (String[]) contents.toArray();
    }
}