package revision;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SqrtDecomMo {
	public static void basicImp() {
		int[] a = {1,2,3,4,5,6,7,8,9};
		int len = (int)(Math.sqrt(a.length))+1;
		int[] b = new int[len];
		for(int i=0;i<a.length;i++) {
			b[i/len]+=a[i];
		}
		int l=0,r=0;
		Scanner in =new Scanner(System.in);
		do {
			int sum =0;
			l = in.nextInt();
			r = in.nextInt();
			for(int i=l;i<=r;) {
				if((i%len)==0&&i+len-1<=r) {
					sum+=b[i/len];
					i+=len;
				}
				else {
					sum+=a[i];
				     i++;
				}
			}
			System.out.println(sum);
		}while(!(l==0&&r==0));
	}
	public static void modifiedImp() {
		int[] a = {1,2,3,4,5,6,7,8,9};
		int len = (int)(Math.sqrt(a.length))+1;
		int[] b = new int[len];
		for(int i=0;i<a.length;i++) {
			b[i/len]+=a[i];
		}
		int l=0,r=0;
		Scanner in =new Scanner(System.in);
		do {
			int sum =0;
			l = in.nextInt();
			r = in.nextInt();
			int cl = l/len, cr = r/len;
			if(cl==cr) {
			  for(int i=l;i<=r;i++)
				  sum+=a[i];
			}
			else {
			for(int i=l,j=(cl+1)*len-1;i<=j;i++)
				sum+=a[i];
			for(int i=cl+1;i<=cr-1;i++)
				sum+=b[i];
			for(int i=cr*len;i<=r;i++)
				sum+=a[i];
			}
			System.out.println(sum);
		}while(!(l==0&&r==0));
	}
	public static void moImpl() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] a = {1, 1, 2, 1, 3, 4, 5, 2, 8};
		int n = (int)Math.sqrt(a.length)+1;
		Query[] q = new Query[t];
		for(int i=0;i<t;i++)
			q[i]  = new Query(in.nextInt(),in.nextInt());
	     Arrays.sort(q,new Comparator<Query>() {
			@Override
			public int compare(Query o1, Query o2) {
				if(((o1.l/n)-(o2.l/n))!=0)
					return (o1.l/n)-(o2.l/n);
				else
			       return o1.r-o2.r;
			}
		});
	     int sum =0;
		 int left =0, right =0;
	     for(int i=0;i<t;i++)
	    	 System.out.println(q[i].l+"   "+q[i].r);
	     for(Query qu : q) {
				while(left<qu.l) {
					sum-=a[left];
					left++;
				}
				while(left>qu.l) {
					sum+=a[left-1];
					left--;
					
				}
				while(right<=qu.r) {
					sum+=a[right];
					right++;
					
				}
				while(right>(qu.r+1)) {
					sum-=a[right];
					right--;
					
				}
				System.out.println("sum is "+sum);
	     }
	}
 public static void main(String[] args) {
	 //basicImp();
	// modifiedImp();
	 moImpl();
 }
}
class Query{
	public int l;
	public int r;
	public Query(int l,int r) {
		this.l= l;
		this.r= r;
	}
}
