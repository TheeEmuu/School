//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class BalanceBudgetInit {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        ArrayList<Transaction> statement = new ArrayList<Transaction>();
//
//        in.next();
//        double initial = in.nextDouble();
//        while (in.hasNext()){
//            String type = in.next();
//            if (type.equals("balance"))
//                break;
//            int id = in.nextInt();
//            double amount = in.nextDouble();
//
//            statement.add(new Transaction(type, id, amount));
//        }
//        double end = in.nextDouble();
//
//
//        double registerB = in.nextDouble();
//        while(in.hasNext()){
//            String type = in.next();
//            int id = in.nextInt();
//            double amount = in.nextDouble();
//
//            Transaction test = new Transaction(type, id, amount);
//            for (int i = 0; i < statement.size(); i++) {
//                if (test.equals(statement.get(i))
//
//            }
//
//            registerB = registerB - amount;
//        }
//    }
//}
//
//class Transaction{
//    String type;
//    int id;
//    double amount;
//
//    public Transaction(String type, int id, double amount){
//        this.type = type;
//        this.id = id;
//        this.amount = amount;
//    }
//
//    public String type() {
//        return type;
//    }
//    public int id() {
//        return id;
//    }
//    public double amount() {
//        return amount;
//    }
//
//    public boolean equals(Transaction t) {
//        return type.equals(t.type()) && id==t.id() && amount.equals(t.amount());
//    }
//
//}