import aima.core.search.uninformed.BreadthFirstSearch;

public class Main {
    public static void main(String[] args){
        BreadthFirstSearch search = new BreadthFirstSearch();

        System.out.println(search.findActions(new MissCannProblem()));
    }
}
