import lvc.cds.DS.ArraySet;
import lvc.cds.DS.Set;

import java.util.Comparator;
import java.util.Random;

class Foo implements Comparable<Foo> {
    private int x;
    private String s;

    Foo(String s, int x) {
        this.s = s;
        this.x = x;
    }

    @Override
    public int compareTo(Foo o) {
        return this.x - o.x;
    }

    public static class CompareS implements Comparator<Foo> {
        @Override
        public int compare(Foo o1, Foo o2) {
            return o1.s.compareTo(o2.s);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        ArraySet<Foo> set = new ArraySet<Foo>();

        ArraySet<Foo> set2 = new ArraySet<>(new Foo.CompareS());

        set.add(new Foo("a", 10));
        set.add(new Foo("b", 3));
        set.add(new Foo("c", 1));
        set.add(new Foo("d", 54));
        set.add(new Foo("e", 6));


        if (set.contains(new Foo("d", 6)))
            System.out.println("yes");


        set2.add(new Foo("a", 10));
        set2.add(new Foo("b", 3));
        set2.add(new Foo("c", 1));
        set2.add(new Foo("d", 54));
        set2.add(new Foo("e", 6));

    }
}
