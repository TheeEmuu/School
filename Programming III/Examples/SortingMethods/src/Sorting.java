
public class Sorting {
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	/**
	 * Sorts the given array in ascending order.  
	 * 
	 * @param array
	 * @return The number of comparisons we make
	 */
	public static int bubbleSort(int[] array) {
		int numComps = 0;

		for (int n = array.length; n > 1; --n) {
			for (int i = 1; i < n; ++i) {
				numComps++;
				if (array[i-1] > array[i]) {
					swap(array, i, i-1);
				}
			}
		}
		
		return numComps;
	}
	
	public static void insertionSort(int[] array) {
		for (int n = 1; n < array.length; ++n) {
			// before this starts, elements 0...n-1 should be in order
			// after this iteration is done, elements 0...n will be in order
			int temp = array[n];
			int i;
			for (i= n-1; i >= 0 ; --i) {
				// if array[i] is bigger than temp, move it over to make
				// room to its left
				if (array[i] > temp) 
					array[i+1] = array[i];
				else 
					break;
			}
			// i marks the spot (the last spot vacated by a larger element)
			// into which we should put temp.  Does this work in boundary cases?
			array[i] = temp;
		}
	}
	
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length-1);
	}
	
	private static void quickSort(int[] array, int left, int right) {
		if (left >= right) 
			return;
		
		int pivot = partition(array, left, right);
		quickSort(array, left, pivot-1);
		quickSort(array, pivot+1, right);
	}
	
	
	private static int partition(int[] array, int left, int right) {
		// choose a pivot value, swap it into the leftmost position
		// for now, just choose the leftmost value
		// median of three
		int p = pivot(array, left, right);
		swap(array, left, p);
		int below = left;
		int above = right+1;
		while (true) {
			// step 1: move below up as far as possible.  Why do we have to test for below < above?
			do {
				below++;
			} while (below < above && array[below] < array[left]);
				
			
			// step 2: move above down as far as possible.  Why DON'T we test for above > below?
			do {
				above--;
			} while (array[above] > array[left]);
				
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
		swap(array, left, above);
		return above;
	}

	// choose a pivot entry. The book simply chooses the leftmost element in the
	// range.
	static private int pivot(int[] array, int left, int right) {
		return left;
	}
}
