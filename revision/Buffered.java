package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Buffered 
{
    public static double func(double x)
    {
        return ((2*x*x)-(12*x)+7);
    }
public static void main(String args[]) throws IOException
{
     Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] count=new int[101];
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++)
        {
        a[i]=in.nextInt();
        b[i]=a[i];
        count[a[i]]=i+1;
        }
        for(int i=0;i<n;i++)
        {
            int temp=a[i];
            int j=i;
            while(j>0&&temp<a[j-1])
            {
                a[j]=a[j-1];
//                int var=count[temp];
//                count[temp]=count[a[j-1]];
//                count[a[j-1]]=var;
              count[temp]--;
               // System.out.println("j-1 is"+count[a[j-1]]);
               count[a[j-1]]++;
                 //System.out.println("tempis"+count[temp]);
               //                  System.out.println("j-1 is"+count[a[j-1]]);

                j=j-1;
            } 
            a[j]=temp;
        // System.out.println(temp+"tempis"+count[temp]);

          for(int k=0;k<n;k++)
        {
                       System.out.print(count[b[k]]+" ");
        }
                      System.out.println();

        }
      
       
}
}
