
package revision;

import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class counting 
{
    public static void sort(int[] a,int[] aux,int n,int[] sortarr)
    {
        for(int i=0;i<n;i++)
            aux[a[i]]++;
        int k=0;
        for(int j=0;j<aux.length;j++)
        {
            if(aux[j]!=0)
            {
                int temp=aux[j];
                while(temp-->0)
                    sortarr[k++]=j;
            }
        }
        for(int i=0;i<n;)
        {
            System.out.println(sortarr[i]+" "+aux[sortarr[i]]);
            if(aux[sortarr[i]]!=0)
                i+=aux[sortarr[i]];
            else
                i++;
        }
    }
public static void main(String[] args)
{
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    int[] a=new int[n];
    int[] sortarr=new int[n];
    int max=0;
    for(int i=0;i<n;i++)
    {
        a[i]=in.nextInt();
        if(a[i]>max)
            max=a[i];
    }
    int[] aux=new int[max+1];
    sort(a,aux,n,sortarr);
}
}
