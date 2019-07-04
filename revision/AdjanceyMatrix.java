
package revision;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class AdjanceyMatrix 
{
    public static Scanner in=new Scanner(System.in);
    public static void check(Object[] b)
    {
        
        int q=in.nextInt();
        while(q-->0)
        {
            int var1=in.nextInt();
            int var2=in.nextInt();
            ArrayList<Integer> ch=(ArrayList<Integer>) b[var1];
            if(ch.contains(var2))
            System.out.println("YES");
            else
            System.out.println("NO");
            
        }
    }
    public static void input()
    {
       
        int n=in.nextInt();
        int m=in.nextInt();
       // boolean[][] b=new boolean[n+1][n+1];
       Object[] b=new Object[n];
        while(m-->0)
        {
            int var1=in.nextInt();
            int var2=in.nextInt();
           if(b[var1]==null)
               b[var1]=new ArrayList<Integer>();
           ArrayList<Integer> first=(ArrayList<Integer>) b[var1];
           first.add(var2);
           if(b[var2]==null)
               b[var2]=new ArrayList<Integer>();
            ArrayList<Integer> second=(ArrayList<Integer>) b[var2];
           second.add(var2);
        }
        check(b);
    }
    public static void main(String[] args)
    {
        input();
    }
}
