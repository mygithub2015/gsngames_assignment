import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * Road Work Project
A construction company is paving a road and the township wants to know when the work will be
done. The road has X segments to be paved.
A is a zero-indexed integer array of length N that provides work estimates for the project.
The index of A represents the months since the project began.
The values of A represent the segment of the road that can be completed that month.
The project will be completed when all the segments up to and including X are complete.
The goal is to find the earliest month that the project can be completed.
For example, you are given integer X = 5 and array A such that:
A[0] = 5 // in month 0 the contractor can pave segment 5
A[1] = 3 // in month 1 the contractor can pave segment 3
A[2] = 4 // in month 2 the contractor can pave segment 4
A[3] = 4 // in month 3 the contractor can pave segment 4
A[4] = 2 // in month 4 the contractor can pave segment 2
A[5] = 3 // in month 5 the contractor can pave segment 3
A[6] = 1 // in month 6 the contractor can pave segment 1
A[7] = 4 // in month 7 the contractor can pave segment 4
In this example, the correct answer to the earliest month that the contractor can finish paving all
5 segments of the road is month 6
Given a non-empty zero-indexed array A consisting of N integers and integer X, write a function
in your preferred language that returns the earliest time the contractor can finish paving the
road.
If the contractor will never be able to completely pave the road, the function should return −1.
For example, given X = 5 and array A such that:
A[0] = 5
A[1] = 3
A[2] = 4
A[3] = 4
A[4] = 2
A[5] = 3
A[6] = 1
A[7] = 4
the function should return 6, as explained above.
Assume that:
N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
Complexity:
expected worst-case time complexity is: O(N)
expected worst-case space complexity is:
(storage required for reading in arguments) + O(X)
Elements of the input array can be modified.
 */
public class RoadWorkProject {

	private static int earlierTimeToPaveAllSegments(int[] A, int X) {
		// finding minimum number of months to complete all the X segments
		int sum = 0;
		for (int i = 0; i < X; i++) {
			sum += i + 1;
		}
		int arr[] = new int[X + 1];
		int i = 0;
		boolean canBePaved = false;
		for (; i < A.length; i++) {
			if (arr[A[i]] == 0) { // check if the segment is already paved
				sum -= A[i];
				if (sum == 0) {
					canBePaved = true;
					break;
				}
				arr[A[i]]++;
			}

		}

		return (canBePaved) ? i : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter no. of segments to be paved: ");
		int X = inp.nextInt();
		// month-segment array
		int A[] = { 5, 3, 4, 4, 2, 3, 1, 4 };
		System.out.println(
				"Earlies time to finish paving all the " + X + " segments=" + earlierTimeToPaveAllSegments(A, X));

	}

}
