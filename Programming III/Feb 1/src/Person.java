public class Person {
    private String first, last;

    public Person(String first, String last){
        this.first = first;
        this.last = last;
    }

    public int compareTo(Person a){
        if(!last.equals(a.getLast()))
            return last.compareTo(a.getLast());
        else
            return first.compareTo(a.getFirst());
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}

class PersonSort{
    public static void main(String[] args){
        Person jim = new Person("Jim", "Jones");
        Person bob = new Person("Bob", "Bobbertson");
        Person robbert = new Person("Robbert", "Robbertson");

        System.out.println(jim.compareTo(bob));
        System.out.println(bob.compareTo(robbert));
        System.out.println(robbert.compareTo(jim));
    }
}