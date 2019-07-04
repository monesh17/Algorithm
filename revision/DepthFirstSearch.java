package revision;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author monesh
 */
public class DepthFirstSearch

{
    public static void dfs(Object[] o,int n)
    {
     boolean[] visit=new boolean[n+1];
     Stack<Integer> s=new Stack<Integer>();
     s.add(1);
     visit[1]=true;
     int connected=0;
     boolean connect=false;
     while(!s.isEmpty())
     {
         ArrayList<Integer> a=(ArrayList<Integer>) o[s.pop()];
         int size=a.size();
         for(int i=0;i<size;i++)
         {
             int var=a.get(i);
             if(!visit[var])
             {
             s.push(var);
             visit[var]=true;
             connect=true;
             }
         }
         if(connect)
         {
             connected++;
             connect=false;
         }
     }
     System.out.println("the number of connected componenent is  "+connected);
    }
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int rel=n-1;
        Object[] o=new Object[n+1];
        while(rel-->0)
        {
            int var1=in.nextInt();
            int var2=in.nextInt();
            if(o[var1]==null)
                o[var1]=new ArrayList<Integer>();
            ArrayList<Integer> v1 = (ArrayList<Integer>) o[var1];
            v1.add(var2);
            
        }
        dfs(o,n);
    }
 public static void main(String args[])
 {
     input();
 }
}
