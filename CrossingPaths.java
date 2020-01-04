import java.util.Arrays;
/*
 * 
 * Crossing Paths
A non-empty zero-indexed array A consisting of N integers is given. The elements of array A
represent hikers traveling either up or down a trail.
Array A contains only 0s and/or 1s:
● 0 represents a hiker going up the trail.
● 1 represents a hiker going down the trail.
We want to know how many times a pair of hikers will cross paths on the trail.
For example, consider array A such that:
A[0] = 0
A[1] = 1
A[2] = 0
A[3] = 1
A[4] = 1
We have five pairs of hikers crossing paths: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
Write a function called solution in your preferred language that takes the integer array A
as an argument and returns the total number of crossing pairs as an int.
The function should return −1 if the number of pairs of crossing exceeds 1,000,000,000.
Assume that:
● N is an integer within the range [1..100,000];
● Each element of array A is an integer that has the values 0 or 1.
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is:
(storage required for reading in arguments) + O(1)
Elements of input arrays can be modified.
 */

public class CrossingPaths {
	
	private static int solution(int [] A) {
		
		int sum = Arrays.stream(A).sum();
		int noOfCrossingPairs = 0;
		for(int i = 0; i < A.length && sum > 0; i++) {
			sum -= A[i];
			if(A[i] == 0)
				noOfCrossingPairs += sum;
			
		}
		return noOfCrossingPairs > 1000000000 ? -1: noOfCrossingPairs;
		
	}
	
	public static void main(String[] args) {
		
		int A[] = {1,1,1,0,1};
		System.out.println("No. of Crossing Pairs=> "+solution(A));
		
	}

}
