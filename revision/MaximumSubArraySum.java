package revision;

import java.util.Scanner;

public class MaximumSubArraySum {
	public static int midMaxSum(int[] arr,int l,int r,int mid) {
		int sum = 0; 
        int left_sum = Integer.MIN_VALUE; 
        for (int i = mid; i >= l; i--) 
        { 
            sum = sum + arr[i]; 
            if (sum > left_sum) 
            left_sum = sum; 
        } 
  
        // Include elements on right of mid 
        sum = 0; 
        int right_sum = Integer.MIN_VALUE; 
        for (int i = mid + 1; i <= r; i++) 
        { 
            sum = sum + arr[i]; 
            if (sum > right_sum) 
            right_sum = sum; 
        } 
  
        // Return sum of elements on left 
        // and right of mid 
        return left_sum + right_sum; 
	}
	public static int maxSubArraySum(int[] arr,int l,int r) {
		if(l==r)
			return arr[l];
		int mid = (l+r)/2;
		return Math.max(Math.max(maxSubArraySum(arr,l,mid),maxSubArraySum(arr,mid+1,r)),midMaxSum(arr,l,r,mid));
	}
   public static void main(String[] args) {
	   Scanner in = new Scanner(System.in);
	   int n = in.nextInt();
	   int[] arr = new int [n];
	   for(int i=0;i<n;i++)
		   arr[i]=in.nextInt();
	   System.out.println(maxSubArraySum(arr,0,n-1));
   }
}
