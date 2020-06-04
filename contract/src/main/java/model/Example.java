package model;

/**
 * <h1>The Class Example.</h1>
 *
 * @version 1.0
 */
public class Example {

    /** The id. */
    private final int id;

    /** The name. */
    private String    name;

    /**
     * @author ARISTIDE KOLOKO 
     * Instantiates a new example.
     *
     * @param id
     *            the id
     * @param name
     *            the name
     */
    public Example(final int id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * @author ARISTIDE KOLOKO
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @author ARISTIDE KOLOKO
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @author ARISTIDE KOLOKO
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @author ARISTIDE KOLOKO
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
