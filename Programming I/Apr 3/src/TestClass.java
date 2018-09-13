public class TestClass {
    public static void main(String[] args) {
        ImplementClass class1 = new ImplementClass(2.0);
        ImplementClass class2 = new ImplementClass(5.0);

        NoImplementClass class3 = new NoImplementClass(3.0);
        NoImplementClass class4 = new NoImplementClass(4.0);

        try{
            ImplementTest(class1);
        }
        catch(IllegalArgumentException e){
            System.out.println("ERROR, INCORRECT OBJECT TYPE PASSED");
        }

        try{
            ImplementTest(class2);
        }
        catch(IllegalArgumentException e){
            System.out.println("ERROR, INCORRECT OBJECT TYPE PASSED");
        }

        try{
            ImplementTest(class3); // Intellij marks them as not passable because they do not implement ExampleInterface
        }
        catch(IllegalArgumentException e){
            System.out.println("ERROR, INCORRECT OBJECT TYPE PASSED");
        }

        try{
            ImplementTest(class4); // So I guess I didn't even need the try statements, but I'm leaving them here anyways.
        }
        catch(IllegalArgumentException e){
            System.out.println("ERROR, INCORRECT OBJECT TYPE PASSED");
        }
    }

    private static void ImplementTest(ExampleInterface i){
        System.out.println(i.method1());
    }
}
