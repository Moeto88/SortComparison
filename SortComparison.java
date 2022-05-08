import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){

        //todo: implement the sort
    	
    	double temp;
    	for (int i = 1; i < a.length; i++) 
    	{
    		for(int j = i ; j > 0 ; j--)
    		{
    			if(a[j] < a[j-1])
    			{
    				temp = a[j];
    				a[j] = a[j-1];
    				a[j-1] = temp;
    			}
    		}
    	}
    	return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	
    	//todo: implement the sort
    	
    	for (int i = 0; i < a.length - 1; i++)
    	{
    		int minIndex = i;
    		for (int j = i+1; j < a.length; j++)
    			if (a[j] < a[minIndex])
    				minIndex = j;
    		double temp = a[minIndex];
    		a[minIndex] = a[i];
    		a[i] = temp;
    	}
    	return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){

    	//todo: implement the sort
    	recursiveQuick(a, 0, a.length-1);
    	return a;

    }//end quicksort

    public static void recursiveQuick(double[] a, int lo, int hi) {
    	if(hi <= lo) {
    		return;
    	}
    	int pivotPos = partition(a, lo, hi);
    	recursiveQuick(a, lo, pivotPos-1);
    	recursiveQuick(a, pivotPos+1, hi);
    }
    
    private static int partition(double[] a, int lo, int hi) {
    	int i = lo;
    	int j = hi+1;
    	double pivot = a[lo];
    	while(true) 
    	{
    		while(a[++i] < pivot) 
    		{
    			if(i == hi) 
    				break;
    		}
    		while(a[--j] > pivot) 
    		{
    			if(j == lo)
    				break;
    		}
    		if(i >= j) 
    			break;
    		
    		double temp = a[i];
    		a[i] = a[j];
    		a[j] = temp;
    	}
    	a[lo] = a[j];
    	a[j] = pivot;
    	return j;
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

		 //todo: implement the sort
    	
    	int n = a.length;
    	double[] arr = new double[n];
    	
    	for(int i = 1; i < n; i = i * 2)
    	{
    		for(int lo = 0; lo < n - i; lo = lo + i * 2)
    		{
    			merge(a, arr, lo, lo + i - 1, Math.min(lo + i * 2 - 1, n - 1));
    		}
    	}
    	
    	return a;
	
    }//end mergesortIterative
    
    
    
    private static void merge(double[] a, double[] arr, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
    	for(int k = lo; k <= hi; k++)
    	{
    		arr[k] = a[k];
    	}
		int i = lo; //0
		int j = mid + 1; //1
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid)
			{
				a[k] = arr[j++];
			}
			else if(j > hi)
			{
				a[k] = arr[i++];
			}
			else if(arr[j] < arr[i])
			{
				a[k] = arr[j++];
			}
			else
			{
				a[k] = arr[i++];
			}
		}
	}

	/**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {

    	//todo: implement the sort
    	
    	int n = a.length;
    	double[] arr = new double[n];
    	sort(a, arr, 0, n - 1);
    	return a;
	
   }//end mergeSortRecursive

    private static void sort(double[] a, double[] arr, int lo, int hi) {
		// TODO Auto-generated method stub
		if(hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, arr, lo, mid);
		sort(a, arr, mid + 1, hi);
		merge(a, arr, lo, mid, hi);
	}

	public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
		
    }

 }//end class

