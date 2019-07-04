package revision;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class bucket 
{
    public static void swap(Object[] arr,int pos1,int pos2)
    {
        Object temp=arr[pos1];
        arr[pos1]=arr[pos2];
        arr[pos2]=temp;
    }
    public static int sort(Object[] arr,int start,int end)
    {
        int i=start+1;
        int piv=(int)arr[start];
        for(int j=start+1;j<=end;j++)
        {
            if((int)arr[j]<piv)
            {
                swap(arr,j,i);
                i+=1;
            }
        }
        swap(arr,start,i-1);
        return i-1;
    }
    public static void pos(Object[] arr,int start,int end)
    {
        if(start<end)
        {
            int pivpos=sort(arr,start,end);
            pos(arr,start,pivpos-1);
            pos(arr,pivpos+1,end);
        }
    }
    public static void quick(Object[] arr)
    {
        pos(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static int setbits(int var)
    {
        int count=0;
        while(var>0)
        {
            count+=var&1;
            var>>=1;
        }
        return count;
    }
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Object[] o=new Object[16];
        int max=0;
        while(n-->0)
        {
            int var=in.nextInt();
            int count= setbits(var);
            if(o[count]==null)
            {
                o[count]=new ArrayList<Integer>();
            }
            ArrayList<Integer> a=(ArrayList<Integer>)o[count];
            a.add(var);
            if(max<count)
                max=count;
        }
        for(int i=1;i<=max;i++)
        {
            if(o[i]!=null)
            {
                ArrayList<Integer> b=(ArrayList<Integer>)o[i];
                 quick(b.toArray());
            }
        }
    }
   public static void main(String args[])
   {
       input();
       
   }
}
