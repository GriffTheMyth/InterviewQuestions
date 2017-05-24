import java.util.*;
import java.lang.*;
import java.io.*;

class countWaysForDistance {

	/* Dynamic Bottom Up Approach with Array as lookup table, WCRT O(n), Space O(n) */
	public static int SlowRide(int distance){
		int[] lookup = new int[distance + 2]; //Set to two so no out of bounds if user types in one as input
		lookup[0] = 1;
		lookup[1] = 1;
		lookup[2] = 2;

		for(int i = 3; i <= distance; i++){
			lookup[i] = lookup[i - 1] + lookup[i - 2] + lookup[i - 3];
		}

		return lookup[distance];
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Number of ways to cover distance is: " + SlowRide(n));
	}
}