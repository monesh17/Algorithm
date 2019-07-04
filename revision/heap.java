package revision;

import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class heap 
{
    public static void heapify(int[] a,int n,int large)
    {
        int check=large;
        int l=(large*2)+1;
        int r=(large*2)+2;
        if(l<n&&a[large]<a[l])
            large=l;
        if(r<n&&a[large]<a[r])
            large=r;
        if(check!=large)
        {
            int temp=a[check];
            a[check]=a[large]; 
            a[large]=temp;
            heapify(a,n,large);
        }
        
    }
    public static void heap(int[] a,int n)
    {
        for(int i=(n/2)-1;i>=0;i--)
            heapify(a,n,i);
        for(int i=n-1;i>=0;i--)
        {
            int temp=a[i];
            a[i]=a[0];
            a[0]=temp;
            heapify(a,i,0);
        }
        
    }
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=in.nextInt();
        heap(a,n);
        for(int i=0;i<n;i++)
            System.out.println(a[i]);
    }
public static void main(String[] args)
{
    input();
}
}
