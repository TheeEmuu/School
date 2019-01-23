import java.util.Arrays;
import java.util.Random;

public class TestSorts {

	// generate an array of size size, with entries from 0...hi-1
	static int[] randomArray(int size, int hi) {
		Random r = new Random();
		
		int[] arr = new int[size];
		for (int i=0; i<arr.length; ++i) {
			arr[i] = r.nextInt(hi);
		}
		return arr;
	}
	

	static int[] sortedArray(int size) {
		int[] arr = new int[size];
		for (int i=0; i<arr.length; ++i) {
			arr[i] = i;
		}
		return arr;
	}
	
	static int[] reverseSortedArray(int size) {
		int[] arr = new int[size];
		for (int i=0; i<arr.length; ++i) {
			arr[i] = arr.length - i;
		}
		return arr;
	}
	
	
	static int[] allEqualArray(int size) {
		int[] arr = new int[size];
		for (int i=0; i<arr.length; ++i) {
			arr[i] = 42;
		}
		return arr;
	}
	
	
	static boolean isSorted(int[] arr) {
		for (int i=1; i<arr.length; ++i) 
			if (arr[i] < arr[i-1])
				return false;
		return true;
	}
	
	
	public static void main(String[] args) {
		final double CONVERT = 1_000_000.0;
		final int SIZE = 100_000;
		final int TRIALS = 10; 

		
		System.out.printf("%12s %12s %12s\n", "Size", "Bubble", "Quick");
		for (int sz=10; sz<SIZE; sz *= 2) {
			int[] a = sortedArray(sz);
			int[] b = Arrays.copyOf(a, a.length);
			
			long time1 = System.nanoTime();
			Sorting.bubbleSort(b);
			long time2 = System.nanoTime();
			Sorting.quickSort(a);
			long time3 = System.nanoTime();
			if (!isSorted(b))
				System.out.println("Bubble Sort failed!");
			if (!isSorted(a))
				System.out.println("Quick Sort failed!");
			
			System.out.printf("%,12d %,12.1f %,12.1f\n", sz, (time2 - time1)/CONVERT, (time3 - time2)/CONVERT);
			
		}
	}
}
