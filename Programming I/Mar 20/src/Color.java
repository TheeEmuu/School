public class Color {
    private int red;
    private int green;
    private int blue;
    private int alpha;

    //region Constructors
    Color(){
        red = 0;
        green = 0;
        blue = 0;
        alpha = 255;
    }

    Color(int red, int green, int blue){
        red = red;
        green = green;
        blue = blue;
        alpha = 255;
    }

    Color(int red, int green, int blue, int alpha){
        red = red;
        green = green;
        blue = blue;
        alpha = alpha;
    }

    Color(double red, double green, double blue){
        red = (int)(red * 255);
        green = (int)(green * 255);
        blue = (int)(blue * 255);
        alpha = 255;
    }

    Color(double red, double green, double blue, double alpha){
        red = (int)(red * 255);
        green = (int)(green * 255);
        blue = (int)(blue * 255);
        alpha = (int)(alpha * 255);
    }

    //endregion
}
