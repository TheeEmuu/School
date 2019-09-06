using System;

class Banking{
    static void Main(String[] args){
        Account account = new Account(5000);

        account.TransactionMade += account_Transaction;

        account.Withdraw(100);
        account.Deposit(20);
        account.Withdraw(10000);
        account.Withdraw(30);
    }

    static void account_Transaction(object sender, TransactionEventArgs e){
        Console.WriteLine("{0} of ${1} made", e.Type, e.Ammount);
    }
}

class Account{
    private int balance;

    public Account(int principal){
        balance = principal;
    }

    private TransactionEventArgs Transaction(String s, int a){
        TransactionEventArgs args = new TransactionEventArgs();
        args.Type = s;
        args.Ammount = a;

        return args;
    }

    public void Deposit(int ammount){
        balance += ammount;

        OnTransaction(Transaction("Deposit", ammount));
    }

    public void Withdraw(int ammount){
        if(ammount < balance){
            balance -= ammount;

            OnTransaction(Transaction("Withdraw", ammount));
        }
    }

    protected virtual void OnTransaction(TransactionEventArgs e){
        EventHandler<TransactionEventArgs> handler = TransactionMade;
        if(handler != null)
            handler(this, e);
    }

    public event EventHandler<TransactionEventArgs> TransactionMade;
}

public class TransactionEventArgs : EventArgs{
    public String Type { get; set; }
    public int Ammount { get; set; }
}