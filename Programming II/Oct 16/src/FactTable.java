public class FactTable {
    public static Vector<Vector<Integer>> factTable(int n)
    // pre: n > 0
    // post: returns a table of factors of values 1 through n
    {
        Vector<Vector<Integer>> table = new Vector<Vector<Integer>>();
        for (int i = 1; i <= n; i++)
        {
            Vector<Integer> factors = new Vector<Integer>();
            for (int f = 1; f <= i; f++)
            {
                if ((i % f) == 0) {
                    factors.add(f);
                }
            }
            table.add(factors);
        }
        return table;
    }

    public static void main(String[] args){
        System.out.println(factTable(10));
    }
}
