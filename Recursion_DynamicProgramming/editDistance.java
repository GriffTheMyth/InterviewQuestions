import java.util.*;
import java.lang.*;
import java.io.*;

class minimumOperationsOnString {

	static int min(int insert, int remove, int replace){
		if(insert < remove && insert < replace)
			return insert;
		if(remove < insert && remove < replace)
			return remove;
		else
			return replace;
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
		int[][] cache = new int[s1Size + 1][s2Size + 1];

		for(int i =0; i <= s1Size; i++){

			for(int k = 0; k <= s2Size; k++){
				if(i == 0)
					cache[i][k] = k;
				else if(k == 0)
					cache[i][k] = i;
				else if(s1.charAt(i - 1) == s2.charAt(k - 1)) //Check if the last characters are the same, ignore and get next count
					cache[i][k] = cache[i - 1][k - 1];
				else
					cache[i][k] = 1 + min(cache[i][k - 1], cache[i - 1][k], cache[i - 1][k - 1]); //Insert, Remove, Replace Operations
									 	
			}
		}
		return cache[s1Size][s2Size];
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int n = s1.length();
		int m = s2.length();
		System.out.println("Minimum number of edits (operations) is: " + findMinOp(s1, s2, n, m) + "\tSlower version: " + findMinOpSlow(s1, s2, n, m));
	}

}