package revision;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence1 {
	public static void input() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int [n];
		int[] tmp = new int[n];
		int max =0;
		for(int i=0;i<n;i++)
			arr[i]=in.nextInt();
		Arrays.fill(tmp, 1);
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
				   tmp[i]=Math.max(tmp[i], tmp[j]+1);	
				   if(tmp[i]>max)
					   max=tmp[i];
				}
			}
		}
		System.out.println("max is "+max);
	}
  public static void main(String[] args) {
	  input();
  }
}
