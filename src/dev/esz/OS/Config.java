public class Config {
    private final String user;
    private final String system;
    protected boolean echo;

    /**
     * <p>
     * A initializer to the Shell Class
     * </p>
     * 
     * @param user   used to display the user of the shell program
     * 
     * @since 1.0.0
     */
    public Config(String user) {
        this.user = user;
        this.system = System.getProperty("os.name");
        echo = true;
    }

    /**
     * <p>
     * A initializer to the Shell Class
     * </p>
     * 
     * @param user   used to display the user of the shell program
     * @param echo   a boolean that determines if the above options and the
     *               directory display will show up
     * 
     * @since 1.0.0
     */
    public Config(String user, boolean echo) {
        this.user = user;
        this.echo = echo;
        this.system = System.getProperty("os.name");
    }

    public String getUser() {
        return user;
    }

    public String getSystem() {
        return system;
    }
}