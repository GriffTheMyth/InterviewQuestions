import java.util.*;
import java.lang.*;
import java.io.*;

class minimumOperationsOnString {

	static int min(int insert, int remove, int replace){
		if(x < y && x < z)
			return x;
		if(y < x && y < z)
			return y;
		else
			return z;
	}

	/* RT O(3^m), worst case when no characters match */
	static int findMinOpSlow(String s1, String s2, int s1Size, int s2Size){
		if(s1Size == 0){
			return s2Size;
		}

		if(s2Size == 0){
			return s1Size;
		}

		if(s1.charAt(s1Size - 1) == s2.charAt(s2Size - 1)){
			return findMinOpSlow(s1, s2, s1Size - 1, s2Size - 1);
		}
		return 1 + min ( findMinOpSlow(s1, s2, s1Size, s2Size - 1), //Insert
							findMinOpSlow(s1, s2, s1Size - 1, s2Size), //Remove
							findMinOpSlow(s1, s2, s1Size - 1, s2Size - 1)); //Replace

	}

	/*  Time Complexity: O(m x n)
		Auxiliary Space: O(m x n)	*/

	static int findMinOp(String s1, String s2, int s1Size, int s2Size){
		int[][] cache = new int[n + 1][m + 1];

		for(int i =0; i <= s1Size; i++){

			for(int k = 0; k <= s2Size; k++){
				if(i == 0)
					cache[i][j] = j;
				else if(j == 0)
					cache[i][j] = i;
				else if(s1.charAt(i - 1) == s2.charAt(j - 1)) //Check if the last characters are the same, ignore and get next count
					cache[i][j] = cache[i - 1][j - 1];
				else
					cache[i][j] = 1 + min(cache[i][j - 1], cache[i - 1][j], cache[i - 1][j - 1]); //Insert, Remove, Replace Operations
									 	
			}
		}
		return cache[i][j];
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int n = s1.length();
		int m = s2.length();
		System.out.println("Minimum number of edits (operations) is: " + findMinOp(s1, s2, n, m));
	}

}