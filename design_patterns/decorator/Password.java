package design_patterns.decorator;

/**
 * Abstract base class that forces children to implement the abstract method
 * @author Danielle Higgins
 */
public abstract class Password {
    protected String password;

    /**
     * Abstract method which the children has to implement
     * @return The password
     */
    public abstract String getPassword();
}
