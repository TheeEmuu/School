public class ImplementClass implements ExampleInterface {
    double i;

    ImplementClass(double i){
        this.i = i;
    }

    public double method1(){
        return Math.pow(i, 2.0);
    }
}
