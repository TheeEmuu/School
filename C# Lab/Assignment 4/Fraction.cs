public class Fraction{
    private int numerator, denominator;

    public Fraction(int num, int dem){
        numerator = num;
        denominator = dem;
    }

    public int Numerator{
        get{return numerator;}
        set{numerator = value;}
    }
    public int Denominator{
        get{return denominator;}
        set{denominator = value;}
    }

    private void reduce(){
        int a = this.Numerator;
        int b = this.Denominator;

        while(b != 0){
            int t = b;
            b = a % b;
            a = t;
        }

        if(this.Denominator < 0){
            this.Denominator = this.Denominator * -1;
            this.Numerator = this.Numerator * -1;
        }

        this.Numerator = this.Numerator / a;
        this.Denominator = this.Denominator / a;
    }

    public static Fraction operator +(Fraction me, Fraction other){
        Fraction n = new Fraction(0, 0);

        n.Numerator = me.Numerator * other.Denominator + other.Numerator * me.Denominator;
        n.Denominator = me.Denominator * other.Denominator;
        n.reduce();       

        return n;
    }

    public static Fraction operator -(Fraction me, Fraction other){
        Fraction n = new Fraction(0, 0);

        n.Numerator = me.Numerator * other.Denominator - other.Numerator * me.Denominator;
        n.Denominator = me.Denominator * other.Denominator;
        n.reduce();

        return n;
    }

    public static Fraction operator *(Fraction me, Fraction other){
        Fraction n = new Fraction(0, 0);

        n.Numerator = me.Numerator * other.Numerator;
        n.Denominator = me.Denominator * other.Denominator;
        n.reduce();

        return n;
    }

    public static Fraction operator /(Fraction me, Fraction other){
        Fraction n = new Fraction(0, 0);

        n.Numerator = me.Numerator * other.Denominator;
        n.Denominator = me.Denominator * other.Numerator;
        n.reduce();

        return n;
    }

    public string toString(){
        return Numerator + "/" + Denominator;
    }
}