package revision;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence2 {
	public static int ceilIndex(int[] input,int[] t,int len,int value) {
		int start=0;
		int end = len;
		while(start<=end) {
			int middle = (start+end)/2;
			if(input[t[middle]]<value&&value<input[t[middle+1]])
				return middle+1;
			else if(value<input[t[middle]])
				end = middle-1;
			else
				start = middle+1; 
		}
		return -1;
	}
	public static void increasingSubSequence(int[] input,int n) {
		int[] r = new int[n];
		Arrays.fill(r,-1);
		int len =0;
		int[] t = new int[n];
		t[0]=0;
		for(int i=1;i<n;i++) {
			if(input[i]<input[t[0]])
				t[0]=i;
		    else if(input[t[len]]<input[i]) {
				len++;
				t[len]=i;
				r[t[len]]=t[len-1];
			}
			else {
				int index = ceilIndex(input,t,len,input[i]);
				t[index]=i;
				r[t[index]]=t[index-1];
			}
		}
	}
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int[] input = new int[n];
	increasingSubSequence(input,n);
}
}
