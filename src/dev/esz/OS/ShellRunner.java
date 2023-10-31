import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ShellRunner{

    String config = Config.getNativeConfigFile();
    Native nat = new Native(); 

    public void execute(String command, Object[] parameters) throws FileNotFoundException {
        String runnableMethod = SearchEngine.configSearch(command, "Native.commands");
        //TODO find why the method happens to only return "/"

        System.out.println(runnableMethod);

        nat.get.args = parameters;

        try {
            Method method = Native.class.getMethod(runnableMethod);
            run(nat, method);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * A method that gets another method and runs it through the use of the
     * reflection library
     * 
     * @param object an object to be used in the method
     * @param method the actual method being ran
     */
    private void run(Object object, Method method) {
        try {
            Object[] param = new Object[1];
            param[0] = null; 
            method.invoke(object, param);

            //TODO find cause of argument number mismatch
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}