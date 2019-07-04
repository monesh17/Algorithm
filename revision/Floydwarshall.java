package revision;

import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class Floydwarshall 
{
    public static void operation()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[][] arr=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==j)
                {
                   
                    arr[i][j]=0;
                }
                else
                    arr[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<m;i++)
        {
            int first=in.nextInt();
            int second=in.nextInt();
            int val=in.nextInt();
            arr[first][second]=val;
            arr[second][first]=val;

        }
//         for(int i=1;i<=n;i++)
//            {
//                for(int j=1;j<=n;j++)
//                {
//                   System.out.println("i is"+ i+ " j is"+ j+ "value up is"+ arr[i][j]);
//                }
//            }
        for(int k=1;k<=n;k++)
        {
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(arr[i][j]>arr[i][k]+arr[k][j])
                        arr[i][j]=arr[i][k]+arr[k][j];
                }
            }
        }
        for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                   System.out.println("i is"+ i+ " j is"+ j+ "value is"+ arr[i][j]);
                }
            }
        
    }
public static void main(String args[])
{
    operation();
}
}
