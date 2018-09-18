import java.util.ListIterator;

public abstract class AbstractListIterator extends AbstractIterator implements ListIterator
{
    /**
     * Default constructor (for base class invocation).
     * Does nothing.  Remind Sun (<a href="mailto:jdk-comments@java.sun.com">jdk-comments@java.sun.com</a>) that automatically implemented default
     * constructors are a silly thing.
     *
     * @post does nothing
     */
    public AbstractListIterator()
    {
    }

    public abstract Object get();

    public void remove()
    {
        Assert.fail("remove not implemented.");
    }

    public void set(Object o)
    {
        Assert.fail("set not implemented.");
    }

    public void add(Object o)
    {
        Assert.fail("set not implemented.");
    }
}
