package revision;

import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class quick 
{
    public static void swap(long[] a,int x,int y)
    {
        long temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }
    public static int sort(long[] a,int start,int end)
    {
        int i=start+1;
        long piv=a[start];
        for(int j=start+1;j<=end;j++)
        {
            if(a[j]<piv)
            {
                swap(a,j,i);
                i+=1;
            }
        }
        swap(a,start,i-1);
        return i-1;
    }
    public static void pos(long[] a,int start,int end)
    {
        if(start<end)
        {
            select(a,start,end);
            int pivpos=sort(a,start,end);
            pos(a,start,pivpos-1);
            pos(a,pivpos+1,end);
        }
    }
    public static void select(long[] a,int start,int end)
    {
        int rand=start+(int)((Math.random()*100)%(end-start+1));
        swap(a,start,rand);
    }
public static void main(String args[])
{
    Scanner in=new Scanner(System.in); 
    int n=in.nextInt();
    long[] a=new long[n];
    for(int i=0;i<n;i++)
        a[i]=in.nextLong();
    pos(a,0,n-1);
    for(int i=0;i<n;i++)
        System.out.println(a[i]);
    
}
}
