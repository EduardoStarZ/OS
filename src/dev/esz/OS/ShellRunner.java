import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ShellRunner{

    String config = Config.getNativeConfigFile();

    public void execute(String command, String[] parameters) {
        String runnableMethod = SearchEngine.configSearch(command, "Native.json");

        try {
            Method method = Native.class.getMethod(runnableMethod);
            run(new ShellRunner(), method);
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
            method.invoke(object);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
