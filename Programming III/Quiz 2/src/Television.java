import java.util.Comparator;
import java.util.Scanner;

public class Television {
    private String manufacturer;
    private String model;
    private int size;   // diagonal inches
    private double weight;
    private double price;
    private int x_res;  // horizontal resolution
    private int y_res;  // vertical resolution
    private int brightness;  // measured in "nits" -- bigger is better?

    //region Getters
    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    //endregion
    //region Setters
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //endregion

    public static <T> void insertionSort(T data[], Comparator<T> c)
    // pre: c compares objects found in data
    // post: values in data[0..n-1] are in ascending order
    {
        int numSorted = 1; // number of values in place
        int index; // general index
        int n = data.length; // length of the array
        while (numSorted < n)
        {
            // take the first unsorted value
            T temp = data[numSorted];
            // ...and insert it among the sorted:
            for (index = numSorted; index > 0; index--)
            {
                if (c.compare(temp,data[index-1]) < 0)
                {
                    data[index] = data[index-1];
                } else {
                    break;
                }
            }
            // reinsert value
            data[index] = temp;
            numSorted++;
        }
    }

    public String toString(){
        return this.manufacturer + " " + this.model;
    }


    public static void main(String[] args){
        Television[] array = new Television[]{
                makeTelevision(32, 158.90, "Samsung", "J4000"),
                makeTelevision(43, 297.99, "Samsung", "NU6900"),
                makeTelevision(75, 1099.99, "Samsung", "UN75MU63000FXZA"),
                makeTelevision(43, 349.99, "Samsung", "UN43M5300AF"),
                makeTelevision(32, 189.99, "VIZIO", "D32F-F1"),
                makeTelevision(77, 5247.00, "LG", "OLED77C8PUA"),
                makeTelevision(50, 397.99, "Samsung", "M5300"),
                makeTelevision(65, 647.99, "Samsung", "NU6900")
        };

        System.out.println("Please choose what to sort by: \n" +
                "1: Size\n" +
                "2: Price\n" +
                "3: Manufacturer");

        Scanner input = new Scanner(System.in);
        int mode = input.nextInt();

        System.out.println("Unsorted");
        for(Television x : array){
            System.out.println(x);
        }
        System.out.println();

        switch(mode){
            case(1):
                insertionSort(array, new sortBySize());
                System.out.println("Sorted by size");
                break;
            case(2):
                insertionSort(array, new sortByPrice());
                System.out.println("Sorted by price");
                break;
            case(3):
                insertionSort(array, new sortByManufacturer());
                System.out.println("Sorted by Manufacturer");
                break;
        }

        for(Television x : array){
            System.out.println(x);
        }
    }

    private static Television makeTelevision(int size, double price, String manufacturer, String model) {
        Television n = new Television();

        n.setSize(size);
        n.setPrice(price);
        n.setManufacturer(manufacturer);
        n.setModel(model);

        return n;
    }
}

class sortBySize implements Comparator<Television>{
    public int compare(Television a, Television b){
        return a.getSize() - b.getSize();
    }
}

class sortByPrice implements Comparator<Television>{
    public int compare(Television a, Television b){
        double n = a.getPrice() - b.getPrice();

        if(n < 0) return -1;
        if(n > 0) return 1;
        return 0;
    }
}

class sortByManufacturer implements Comparator<Television>{
    public int compare(Television a, Television b){
        if(!a.getManufacturer().equals(b.getManufacturer()))
            return a.getManufacturer().compareTo(b.getManufacturer());
        else
            return a.getModel().compareTo(b.getModel());
    }
}