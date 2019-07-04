package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class FloodFill 
{
    public static boolean flood(int[][] a,int pos1,int pos2,int n,int m,boolean[][] visit)
    {
        System.out.println("pos1 is" +" "+pos1+" "+"pos2 is"+" "+pos2);
        if(pos1==n&&pos2==m)
            return true;
        if(pos1>n||pos2>m)
            return false;
        if(pos1<1||pos2<1)
            return false;
        if(visit[pos1][pos2])
            return false;
        visit[pos1][pos2]=true;
        if(a[pos1][pos2]!=1)
        {
            System.out.println("came here");
            return false;
        }
        if(flood(a,pos1+1,pos2,n,m,visit))
            return true;
        if(flood(a,pos1,pos2+1,n,m,visit))
            return true;
        if(flood(a,pos1-1,pos2,n,m,visit))
            return true;
        if(flood(a,pos1,pos2-1,n,m,visit))
            return true;
        return false;
    }
    public static void input() throws IOException
    {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m= Integer.parseInt(arr[1]);
        int[][] a=new int[n+1][m+1];
        boolean[][] visit=new boolean[n+1][m+1];
       String s;
       int i=1;
       while(true)
       {
           s=br.readLine();
           if(s==null||s.equals(" "))
              break; 
           arr=s.split(" ");
           System.out.println("arr is"+" "+arr);
           for(int j=0;j<arr.length;j++)
               a[i][j+1]=Integer.parseInt(arr[j]);
           i++;
       }
       for(int k=1;k<=n;k++)
       {
           for(int j=1;j<=m;j++)
               System.out.print(a[k][j]+" ");
           System.out.println();
               
       }
       
        if(flood(a,1,1,n,m,visit))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
public static void main(String args[]) throws IOException
{
    input();
}
}
