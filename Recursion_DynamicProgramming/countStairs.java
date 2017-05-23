import java.util.*;
import java.lang.*;
import java.io.*;

class countStairs {

	/* Naive: O(3^n) time, O(n) space */
	public static int countWays(int n){
		if(n < 0) {
			return 0;
		}
		
		else if(n == 0) {
			return 1;
		}
		
		else {
			return countWays(n - 1) + countWays(n - 2) +
				countWays(n - 3);
		}
	}
	
	/* Top Down DP (Memoization) O(n) time, O(n) space */
	public static int countWaysMemo(int n){
		int[] cache = new int[n + 1];
		
		if(n < 0){
			return 0;
		}
		
		if(n == 0){
			return 1;
		}
		
		if(cache[n] == 0){
			cache[n] = countWaysMemo(n - 1) + countWaysMemo(n - 2)
				+ countWaysMemo(n - 3);
		}
		
		return cache[n];
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int i =0; i < T; i++){
			int temp = sc.nextInt();
			sc.nextLine();
			System.out.println("Number of ways for " + temp + " stairs: " + countWays(temp));
			System.out.println("Number of ways for " + temp + " stairs: " + countWaysMemo(temp));
		}
	}
}
