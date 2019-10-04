import java.util.List;

// By Garrett Santis
public abstract class SteepestAscentSearch<S,A> implements OptimizationProblem<S,A>{
    public S sahc(OptimizationProblem<S,A> problem){
        S cur=getInitialState();

        while(true){
            double cost=getObjective(cur);
            double temp=cost;

            List<A> list=problem.getActions(cur);

            while(!list.isEmpty()) {
                A move = list.remove(0);
                S child = problem.getResult(cur,move);
                double num=problem.getObjective(child);
                if(num>temp) {
                    temp=num;
                    cur=child;
                }
            }


            System.out.println("\n----------------\n");

            System.out.println(cur);
            System.out.println();
            System.out.println(getObjective(cur));

            if(cost==temp) return cur;
        }
    }
}
