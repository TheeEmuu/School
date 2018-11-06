public class PrefixIterator extends AbstractIterator {
    String current, initial;
    public PrefixIterator(String str){
        initial = str;
        reset();
    }

    @Override
    public void reset() {
        current = initial;
    }

    @Override
    public boolean hasNext() {
        return current.length() > 0;
    }

    @Override
    public Object get() {
        return current;
    }

    @Override
    public Object next() {
        if(hasNext())
            current = current.substring(0, current.length() -1);

        return current;
    }

    public static void main(String[] args){
        String string = "hello";

        PrefixIterator i = new PrefixIterator(string);

        System.out.println(i.get());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        i.reset();
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
    }
}
