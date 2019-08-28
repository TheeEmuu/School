import lvc.cds.trees.InOrderIterator;
import lvc.cds.trees.RandomTree;
import lvc.cds.trees.SearchTree;
import lvc.cds.trees.TreeIterator;

public class Main {

public static void randomTreeTest() {
    RandomTree<Integer> tree = new RandomTree<>();

    tree.insert(43);
    tree.insert(12);
    tree.insert(34);
    tree.insert(430);
    tree.insert(120);
    tree.insert(340);
    tree.insert(434);
    tree.insert(124);
    tree.insert(344);

    tree.makePic("tree.png");

    if (tree.contains(340))
        System.out.println("340 in tree");

    System.out.println("num leaves: " + tree.numLeaves());
    System.out.println("num full: " + tree.numFull());


}


    public static void searchTreeTest() {
        SearchTree<String> search = new SearchTree<>();
        search.insert("Wuzza");
//        search.makePic("search1.png");
        search.insert("Foo");
//        search.makePic("search2.png");
        search.insert("BAZ");
//        search.makePic("search3.png");
        search.insert("Gimble");
//        search.makePic("search4.png");
        search.insert("wabe");
//        search.makePic("search5.png");
        search.insert("Monk");
//        search.makePic("search6.png");
        search.insert("Frazzle");
//        search.makePic("search7.png");
        search.insert("bar");
//        search.makePic("search8.png");

        if (search.contains("wabe"))
            System.out.println("found wabe");
        else
            System.out.println("didn't find wabe");

        if (search.contains("wuzza"))
            System.out.println("found wuzza");
        else
            System.out.println("wuzza not found");

        TreeIterator itt = search.iterator();
        while(itt.hasNext()){
            System.out.println(itt.next());
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.max(0,-1));
        searchTreeTest();
    }
}
