import structure.Vector;

public class CoinStrip {
    //region Variables
    private Vector coinStrip;
    private int totalCoins;
    //endregion

    //region Constructors

    //Generates a random strip of coins
    public CoinStrip(){
        totalCoins = 3;
        double probability = 50;

        //Generate coins with a decreasing probability each time
        while(probability(probability)){
            probability = probability / 2;
            totalCoins++;
        }

        coinStrip = new Vector(totalCoins);

        //Randomly place the coins up to 10 places away from the previous coin
        coinStrip.add((int)(Math.random() * 9 + 1));
        for(int i = 1; i < totalCoins; i++){
            int num = (int)(Math.random() * 9 + 1);
            num = num + (int)coinStrip.get(i-1);
            coinStrip.add(num);
        }


    }
    //endregion

    protected boolean probability(double p){
        return(int)(Math.random() * 100/p) == 1;
    }

    //region Get
    public Vector getCoinStrip(){return coinStrip;}
    public int getCoin(int coin){return (int)coinStrip.get(coin);}
    public int getTotalCoins(){return totalCoins;}
    //endregion

    /*
    Checks to see if move is legal before moving
    If it's legal, the move is made

    return: whether the move was legal or not
     */
    public boolean move(int coinNumber, int moves){
        if(isLegalMove(coinNumber, moves)){
            coinStrip.set(coinNumber, (int) coinStrip.get(coinNumber) - moves);
            return true;
        }

        return false;
    }

    /*
    Checks if coinNumber is out of bounds
    Checks if the coin would pass another

    return: Whether or not the move is legal
     */
    private boolean isLegalMove(int coinNumber, int moves){
        if(coinNumber >= totalCoins)
            return false;

        if(coinNumber > 0) {
            int newPosition = (int) coinStrip.get(coinNumber) - moves;

            return newPosition > (int)coinStrip.get(coinNumber - 1);
        }
        else{
            return 0 <= (int)coinStrip.get(coinNumber) - moves;
        }
    }
}
