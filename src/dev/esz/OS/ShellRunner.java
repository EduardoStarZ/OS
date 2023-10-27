import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ShellRunner{

    String config = Config.getNativeConfigFile();

    public void execute(String command, Object[] parameters) {
        String runnableMethod = SearchEngine.configSearch(command, "Native.json");

        try {
            Method method = Native.class.getMethod(runnableMethod);
            run(new ShellRunner(), method, parameters);
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
    private void run(Object object, Method method, Object[] args) {
        try {
            method.invoke(object, args[0], args[1], args[2]);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}