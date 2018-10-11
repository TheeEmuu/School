public class test {
    public static void main(String[] args){
        Matrix<String> m = new Matrix<String>(2,2);

        m.set(0,0, "a");
        m.set(0,1, "b");
        m.set(1,0, "c");
        m.set(1,1, "d");

        System.out.println(m);

        System.out.println(m.transpose());
    }
}
