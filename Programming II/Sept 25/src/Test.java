import structure.Matrix;

public class Test {
    public static void main(String[] args){
        Matrix m = new Matrix(2,3);

        m.set(0,0,1);
        m.set(0,1,2);
        m.set(0,2,3);
        m.set(1,0,4);
        m.set(1,1,5);
        m.set(1,2,6);
        
        System.out.println(m);
        System.out.println(m.transpose());

    }
}
