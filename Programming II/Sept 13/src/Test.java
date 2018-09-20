public class Test {
    public static void main(String[] args) {
        Vector test = new Vector();
        test.add(1);
        test.add(2);
        System.out.println(test.capacity());

        test.trimToSize();
        System.out.println(test.capacity());
    }
}
