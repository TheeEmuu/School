import java.util.Random;

public class CoinStrip {
    //region Variables
    Vector coinStrip;
    int totalCoins;
    //endregion

    //region Constructors
    /*
    post: Generates a random strip of coins
     */
    public CoinStrip(){
        coinStrip = new Vector();


    }
    //endregion

    protected boolean probability(int p){
        if((int)Random * 100/p == 1)
            return true;
        else
            return false;
    }
}
