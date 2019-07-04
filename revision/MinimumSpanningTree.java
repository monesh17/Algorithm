package revision;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class MinimumSpanningTree 
{
    public static void swap(int[] arr,int x,int y)
    {
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    public static int quick(int[] arr,int start,int end)
    {
        int i=start+1;
        int piv=arr[start];
        for(int j=start+1;j<=end;j++)
        {
            if(arr[j]<piv)
            {
                swap(arr,j,i);
                i+=1;
            }
        }
        swap(arr,start,i-1);
        return i-1;
    }
    public static void position(int[] arr,int start,int end)
    {
        if(start<end)
        {
            //rand(arr,start,end);
            int pivpos=quick(arr,start,end);
            position(arr,start,pivpos-1);
            position(arr,pivpos+1,end);
        }
    }
    public static void rand(int[] arr,int start,int end)
    {
        int r=start+(int)((Math.random()*100)%(end-start+1));
        swap(arr,start,r);
    }
    public static int[] sort(int[] arr)
    {
        int n=arr.length;
        System.out.println("before sort");
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
        position(arr,0,n-1);
        System.out.println("after sort");
         for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
                return arr;
    }
    public static void initialize(int[] id)
    {
        int length=20;
        for(int i=0;i<length;i++)
        {
            id[i]=i;
        }
    }
    public static int root(int var,int[] id)
    {
        while(id[var]!=var)
        {
            id[var]=id[id[var]];
            var=id[var];
        }
        return var;
    }
    public static void union(int j,int k,int[] id)
    {
        int p=root(j,id);
        int q=root(k,id);
        id[p]=id[q];
    }
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int nodes=in.nextInt();
        int edges=in.nextInt();
        int[] id=new int[20];
        int[][] weight=new int[nodes+1][nodes+1];
        int[] arr=new int[edges];
        for(int i=0;i<edges;i++)
        {
            int x=in.nextInt();
            int y=in.nextInt();
            int w=in.nextInt();
            weight[x][y]=w;
            arr[i]=w;
        }
      // Arrays.sort(arr);
      initialize(id);
      int minimumcost=0;
         arr=sort(arr);
         int j=0,k=0;
         for(int i=0;i<arr.length;i++)
         {
             boolean found=false;
             for(j=0;j<nodes+1;j++)
             {
                 for(k=0;k<nodes+1;k++)
                 {
                     if(weight[j][k]==arr[i])
                     {
                       found=true;
                       break;
                     }
                 }
                 if(found)
                     break;
             }
             if(root(j,id)!=root(k,id))
             {
                 minimumcost+=weight[j][k];
                 weight[j][k]=0;
                 union(j,k,id);
             }
         }
         System.out.println("minimum cost is "+ minimumcost);
         
      
    }
 public static void main(String[] args)
 {
     input();
 }
}
