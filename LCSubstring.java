import java.util.*;
import java.lang.*;
import java.io.*;

public class LCSubstring {

		public static int max(int x, int y){
			
			return (x <= y) ? y : x;
		}
		
		public static int findLCS(char[] s1, char[] s2, int n, int m){
			int result = 0;
			int[][] table = new int[n + 1][m + 1];
			
			for(int i =0; i <= n; i++){

				for(int j =0; j <= m; j++) {
					
					if (i == 0 || j == 0) {
						table[i][j] = 0;
					}
					
					else if (s1[i - 1] == s2[j - 1]) {
						table[i][j] = table[i - 1][j - 1] + 1;
						result = max(result, table[i][j]);
					}
					
					else {
						table[i][j] = 0;
					}
				}
			}
			
			return result;
		}
		
		public static void main (String[] args){
		
			Scanner sc = new Scanner(System.in);
			String a = sc.nextLine();
			String b = sc.nextLine();
			char[] s1 = a.toCharArray();
			char[] s2 = b.toCharArray();
			int n = a.length();
			int m = b.length();
			System.out.println(findLCS(s1, s2, n, m));
			
		}
}