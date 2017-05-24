import java.util.*;
import java.lang.*;
import java.io.*;

class SubsetSum {

	public static boolean isSubsetSum(int[] array, int arrSize, int sum){
		if(sum == 0){
			return true;
		}
		if(arrSize == 0 && sum != 0){
			return false;
		}
		if(array[arrSize - 1] > sum){
			return isSubsetSum(array, arrSize - 1, sum);
		}

		return isSubsetSum (array, arrSize - 1, sum) || isSubsetSum(array, arrSize - 1, sum - array[arrSize - 1]);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] nums = new int[n];

		for(int i =0; i < n; i++){
			int temp = sc.nextInt();
			nums[i] = temp;

		}
		sc.nextLine();
		int sum = sc.nextInt();
		sc.nextLine();

		if(isSubsetSum(nums, nums.length, sum))
			System.out.println("YES, there is a subset that adds up to the sum: " + sum);
		else 
			System.out.println("NO, there is no subset that adds up to the sum: " + sum);
	}

}