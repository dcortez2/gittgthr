package edu.csus.csc130.spring2017.assignment2;

public class BinaryHeapSort {

	public static <T extends Comparable<T>> void sort(T[] a) {
		int n = a.length-1;
		// Start building initial heap
		for (int k = n/2; k >= 1; k--) {
			sink(a, k, n);
		}

		// Start Sorting 
		while (n > 1) {
			// swap the largest element and element at index n, decrement n
			SortUtils.swap(a, 1, n--);
			// restore heap (from a[1] to a[n] ) order
			sink(a, 1, n);
		}
	}
	
	private static <T extends Comparable<T>> void sink(T[] a, int k, int lastIndex) {
		while (2 * k <= lastIndex) {
			int j = 2 * k;
			if (j < lastIndex && SortUtils.isLessThan(a[j], a[j + 1]))
				j++;
			if (!SortUtils.isLessThan(a[k], a[j]))
				break;
			SortUtils.swap(a, k, j);
			k = j;
		}
	}	

}
