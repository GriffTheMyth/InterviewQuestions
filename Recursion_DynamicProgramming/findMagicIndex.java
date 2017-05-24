import java.util.*;
import java.lang.*;
import java.io.*;

class magicIndex {

	/* Slow but still trivial solution */

	static int magicIndexSlow(int[] array){
		for(int i =0; i < array.length; i++){
			if(array[i] == i){
				return i;
			}
		}

		return -1;
	}


	/* Better option, using binary search because of the array being sorted WCRT(log n), space O(n)  */

	static int magicFast(int[] array, int start, int end){
		if(end < start || end >= array.length || start < 0){
			return -1;
		}

		int mid = (start + end) / 2;
		if(array[mid] == mid){
			return mid;
		}

		else if(array[mid] < mid){
			return magicFast(array, mid + 1, end);
		}

		else {
			return magicFast(array, start, mid - 1);
		}

	}

	/* Function for printing the array */

	static String printer(int[] cache){
		return Arrays.toString(cache);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[] cache = new int[N];

		for(int w = 0; w < N; w++){
			cache[w] = sc.nextInt();

		}
		sc.nextLine();

		System.out.println(printer(cache) + "\n" + magicIndexSlow(cache) + "\n" + magicFast(cache, 0, cache.length - 1));


	}



		

}