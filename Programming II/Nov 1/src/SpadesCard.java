public class SpadesCard extends AbstractCard {
    public SpadesCard(int face, int suit){
        set(suit * 13+face-1);
    }

    public SpadesCard(){}

    public int value(){
        if(face() == ACE) return suit() * 13 + KING + 1;
        return get();
    }

    public int compareTo(Object other){
        SpadesCard that = (SpadesCard)other;
        return value() - that.value();
    }

    public static void main(String[] args){
        SpadesCard c = new SpadesCard();
        System.out.println(c);
        SpadesCard d = new SpadesCard(KING, HEARTS);

        if (c.compareTo(d) < 0)
        {
            System.out.println("Less than King of Hearts.");
        } else if (c.compareTo(d) == 0)
        {
            System.out.println("Equal to King of Hearts.");
        } else {
            System.out.println("More than King of Hearts.");
        }
    }
}
