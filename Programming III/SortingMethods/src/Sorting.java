import java.util.Random;

public class Sorting {

	private static Random r = new Random();

	private static <T> swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	/**
	 * Sorts the given array in ascending order.  
	 * 
	 * @param array
	 * @return The number of comparisons we make
	 */
	public static <T extends Comparable<T>> bubbleSort(T[] array) {
		int numComps = 0;

		for (int n = array.length; n > 1; --n) {
			boolean swapped = false;
			for (int i = 1; i < n; ++i) {
				numComps++;
				if (array[i-1].compareTo(array[i]) > 0) {
					swapped = true;
					swap(array, i, i-1);
				}
			}
			if (!swapped) break;
		}
		
		return numComps;
	}
	
	public static void insertionSort(int[] array, int left, int right) {
		for (int n = left + 1; n <= right; ++n) {
			// before this starts, elements left...n-1 should be in order
			// after this iteration is done, elements left...n will be in order
			int temp = array[n];
			int i;
			for (i= n-1; i >= left ; --i) {
				// if array[i] is bigger than temp, move it over to make
				// room to its left
				if (array[i] > temp) 
					array[i+1] = array[i];
				else 
					break;
			}
			// i marks the spot (the last spot vacated by a larger element)
			// into which we should put temp.  Does this work in boundary cases?
			if (i >= left)
				array[i] = temp;
			else
				array[left] = temp;
		}
	}
	
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length-1);
	}
	
	private static void quickSort(int[] array, int left, int right) {
		if (right - left <= 20) {
			insertionSort(array, left, right);
			return;
		}
		
		int pivot = partition(array, left, right);
		quickSort(array, left, pivot-1);
		quickSort(array, pivot+1, right);
	}
	
	
	private static int partition(int[] array, int left, int right) {
		// choose a pivot value using median of three. Don't use this with < 4 entries.
		int p = pivot(array, left, right);
		// at this point, the entries in left and right are correct, and the pivot is in
		// position right-1.
		int below = left;
		int above = right-1;
		while (true) {
			// step 1: move below up as far as possible.  Why do we have to test for below < above?
			do {
				below++;
			} while (below < above && array[below] < array[p]);
				
			
			// step 2: move above down as far as possible.  Why DON'T we test for above > below?
			do {
				above--;
			} while (below < above && array[above] > array[p]);
				
			// if there is space between above and below, we have found two elements that
			// we should swap.  If above and below have met, then we are done, there are 
			// no more items out of position.
			if (below < above)
				swap(array, below, above);
			else
				break;
			
			// post: above and below are closer together.  Halt when above >= below			
		}
		
		// finally, put the pivot into position.  Note that above always points at a
		// valid spot for the pivot, since it went down past all larger elements.
		swap(array, p, below);
		return below;
	}

	// use median-of-three to find a pivot, but along the way, go ahead and put
	// these three elements in the "right" positions.
	static private int pivot(int[] array, int left, int right) {
		int mid = (left + right)/2;
		if (array[left] > array[mid])
			swap(array, left, mid);
		if (array[left] > array[right])
			swap(array, left, right);
		if (array[mid] > array[right])
			swap(array, mid, right);
		swap(array, right-1, mid);
		return right-1;
	}
}
