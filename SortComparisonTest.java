/*
 *  |                     |   Insert  | Selection |  Quick  | Merge Rec | Merge It |
 	|---------------------|-----------|-----------|---------|-----------|----------|
 	|     1000 random     |     5     |     2     |    2    |     0     |    0     |
 	|---------------------|-----------|-----------|---------|-----------|----------|
 	|   1000 few unique   |     0     |     1     |    0    |     0     |    0     |
 	|---------------------|-----------|-----------|---------|-----------|----------|
 	| 1000 nearly ordered |     0     |     2     |    2    |     0     |    0     |
 	|---------------------|-----------|-----------|---------|-----------|----------|
 	| 1000 reverse order  |     0     |     2     |    0    |     0     |    0     |
 	|---------------------|-----------|-----------|---------|-----------|----------|
 	|     1000 sorted     |     0     |     1     |    0    |     0     |    0     |
 	|---------------------|-----------|-----------|---------|-----------|----------|
 	|     10000 random    |     26    |     17    |    20   |     1     |    0     |
 	|---------------------|-----------|-----------|---------|-----------|----------|
 	
 	Questions
 	a) By looking at the rows of 1000 random, 1000 nearly ordered, 1000 reverse order, and 1000 sorted,
 	   the running time of insertion sort, selection sort, and quick sort is varied and this is why the order 
 	   of input have the impact on these algorithms. 
 	
 	b) Insertion sort has the biggest difference between the best and worst performance, which is 5 and greater
 	   than 1 for selection sort and 2 for quick sort.
 	   
 	c) By looking at the running time of 1000 random and 10000 random, insertion sort has the worst scalability 
 	   because the difference of performances is 21 which is the biggest number, and iterative merge sort has the 
 	   best scalability because the difference of performances is 0 which is the smallest number.
 	   
 	d) Iterative merge sort seems to be little bit better than iterative merge sort because the running time of 
 	   all files is nearly 0.
 	   
 	e) Iterative merge sort is the fastest because the running time of all files is nearly 0.
 */





import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testInserionSort()
    {
    	double a[] = {5, 4, 3, 2, 1};
    	double expectedResult[] = {1, 2, 3, 4, 5};
    	assertEquals(Arrays.toString(expectedResult), Arrays.toString(SortComparison.insertionSort(a)));
    }
    
    @Test
    public void testSelectionSort()
    {
    	double a[] = {5, 4, 3, 2, 1};
    	double expectedResult[] = {1, 2, 3, 4, 5};
    	assertEquals(Arrays.toString(expectedResult), Arrays.toString(SortComparison.selectionSort(a)));
    }
    
    @Test
    public void testQuickSort()
    {
    	double a[] = {3, 5, 7, 5, 1, 6, 2, 8, 4};
    	double expectedResult[] = {1, 2, 3, 4, 5, 5, 6, 7, 8};
    	assertEquals(Arrays.toString(expectedResult), Arrays.toString(SortComparison.quickSort(a)));
    }
    
    @Test
    public void testMergeSortIterative()
    {
    	double a[] = {5, 3, 7, 10, 1, 12, 6, 2, 8, 11, 4, 9};
    	double expectedResult[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    	assertEquals(Arrays.toString(expectedResult), Arrays.toString(SortComparison.mergeSortIterative(a)));
    }
    
    @Test
    public void testMergeSortRecursive()
    {
    	double a[] = { 2, 11, 7, 8, 3, 19, 13, 5 };
    	double expectedResult[] = {2, 3, 5, 7, 8, 11, 13, 19};
    	assertEquals(Arrays.toString(expectedResult), Arrays.toString(SortComparison.mergeSortRecursive(a)));
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws IOException 
     *
     */
    public static void main(String[] args) throws IOException
    {
        //TODO: implement this method
    	
    	String file1 = "numbers1000.txt";
        double a[] = readFile(file1);
        long rand1000[] = makeArrayForTime(a);
        
        
    	String file2 = "numbers1000Duplicates.txt";
        double b[] = readFile(file2);
        long fewUniq1000[] = makeArrayForTime(b);
        
        
        
    	String file3 = "numbersNearlyOrdered1000.txt";
        double c[] = readFile(file3);
        long nearOrd1000[] = makeArrayForTime(c);
        
        
        
    	String file4 = "numbersReverse1000.txt";
        double d[] = readFile(file4);
        long revOrd1000[] = makeArrayForTime(d);
        
        
        
    	String file5 = "numbersSorted1000.txt";
        double e[] = readFile(file5);
        long sorted1000[] = makeArrayForTime(e);
        
        
        
    	String file6 = "numbers10000.txt";
        double f[] = readFile(file6);
        long rand10000[] = makeArrayForTime(f);
        
        System.out.println(" Insertion " + " Selection " + " Quick " + " Merge Rec " + " Merge It \n");
        System.out.println("    1000 random     " + Arrays.toString(rand1000));
        System.out.println("  1000 few unique   " + Arrays.toString(fewUniq1000));
        System.out.println("1000 nearly ordered " + Arrays.toString(nearOrd1000));
        System.out.println("1000 reverse order  " + Arrays.toString(revOrd1000));
        System.out.println("    1000 sorted     " + Arrays.toString(sorted1000));
        System.out.println("    10000 random    " + Arrays.toString(rand10000));
    
        
	}

	private static long[] makeArrayForTime(double[] a) {
		long arr[] = new long[5];
		long avg = 0;
		avg = avgInsertion(a);
        arr[0] = avg;
        avg = avgSelection(a);
        arr[1] = avg;
        avg = avgQuick(a);
        arr[2] = avg;
        avg = avgMergeRec(a);
        arr[3] = avg;
        avg = avgMergeIt(a);
        arr[4] = avg;
        return arr;
	}

	private static long avgMergeIt(double[] a) {
		long duration = 0;
        for(int i = 0; i < 3; i++)
        {
        	long start = System.currentTimeMillis();
        	SortComparison.mergeSortIterative(a);
        	long end = System.currentTimeMillis();
        	duration = duration + (end - start);
        }
        long avg = duration / 3;
		return avg;
	}

	private static long avgMergeRec(double[] a) {
		long duration = 0;
        for(int i = 0; i < 3; i++)
        {
        	long start = System.currentTimeMillis();
        	SortComparison.mergeSortRecursive(a);
        	long end = System.currentTimeMillis();
        	duration = duration + (end - start);
        }
        long avg = duration / 3;
		return avg;
	}

	private static long avgQuick(double[] a) {
		long duration = 0;
        for(int i = 0; i < 3; i++)
        {
        	long start = System.currentTimeMillis();
        	SortComparison.quickSort(a);
        	long end = System.currentTimeMillis();
        	duration = duration + (end - start);
        }
        long avg = duration / 3;
		return avg;
	}

	private static long avgSelection(double[] a) {
		long duration = 0;
        for(int i = 0; i < 3; i++)
        {
        	long start = System.currentTimeMillis();
        	SortComparison.selectionSort(a);
        	long end = System.currentTimeMillis();
        	duration = duration + (end - start);
        }
        long avg = duration / 3;
		return avg;
	}

	private static long avgInsertion(double[] a) {
		long duration = 0;
        for(int i = 0; i < 3; i++)
        {
        	long start = System.currentTimeMillis();
        	SortComparison.insertionSort(a);
        	long end = System.currentTimeMillis();
        	duration = duration + (end - start);
        }
        long avg = duration / 3;
		return avg;
	}

	private static double[] readFile(String file1) throws IOException {
		File file = new File(file1);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int count = 0;
		while ((line = br.readLine()) != null)
		{
			count++;
		}
		double a[] = new double[count];
		br = new BufferedReader(new FileReader(file));
		int i = 0;
		while ((line = br.readLine()) != null)
		{
			double num = Double.parseDouble(line);
			a[i] = num;
			i++;
		}
		return a;
	} 
	
	
}

 