package revision;

import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class Merge
{
    public static long merging(long[] a,int start,int mid,int end,long count)
    {
        long[] arr=new long[end-start+1];
        int p=start;
        int q=mid+1;
        int k=0;
        for(int i=start;i<=end;i++)
        {
            if(p>mid)
                arr[k++]=a[q++];
            else if(q>end)
                arr[k++]=a[p++];
            else if(a[p]<a[q])
                arr[k++]=a[p++];
            else
            {
                count+=mid-p+1;
                arr[k++]=a[q++];
            }
        }
        for(int i=0;i<k;i++)
        {
            a[start++]=arr[i];
        }
        return count;
    }
    public static long mergesort(long[] a,int start,int end)
    {
        long count=0;
        if(start<end)
        {
            int mid=(start+end)/2;
            count=mergesort(a,start,mid)+mergesort(a,mid+1,end);
            count=merging(a,start,mid,end,count);
        }
        return count;
    }
public static void main(String[] args)
{
    Scanner in=new Scanner(System.in);
    int size=in.nextInt();
    long[] a=new long[size];
    for(int i=0;i<size;i++)
        a[i]=in.nextLong();
    System.out.println(mergesort(a,0,size-1));
//    for(int i=0;i<size;i++)
//       System.out.print(a[i]+" ");
}
}
