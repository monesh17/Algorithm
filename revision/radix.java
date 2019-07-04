package revision;

import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class radix 
{
    public static void count(long[] a,int n,int place)
    {
        int[] fre=new int[10];
        long[] out=new long[n];
        for(int i=0;i<n;i++)
            fre[(int)(a[i]/place)%10]++;
        for(int i=1;i<10;i++)
            fre[i]+=fre[i-1];
        for(int i=n-1;i>=0;i--)
        {
            out[fre[(int)(a[i]/place)%10]-1]=a[i];
            fre[(int)(a[i]/place)%10]--;
        }
        for(int i=0;i<n;i++)
        {
            a[i]=out[i];
            System.out.print(a[i]+" ");
        }
        System.out.println();
            
    }
    public static void radix(long[] a,int n,long max)
    {
        int place=1;
        while(max>0)
        {
            count(a,n,place);
            place*=10;
            max/=10;
        }
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long max=0;
        long[] a=new long[n];
        for(int i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            if(a[i]>max)
                max=a[i];
        }
        radix(a,n,max);
    }
}
