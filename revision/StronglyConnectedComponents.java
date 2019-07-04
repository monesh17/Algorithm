package revision;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author monesh
 */
public class StronglyConnectedComponents 
{
    public static Stack<Integer> stack = new Stack<Integer>();
    public static int even=0;
    public static int odd=0;
    public static int components=0;
    public static void dfs(Object[] o,int start,boolean[] visited)
    {
           visited[start]=true;
           ArrayList<Integer> check=(ArrayList<Integer>) o[start];
             if(Objects.nonNull(check))
            {
           int size=check.size();
           for(int i=0;i<size;i++)
           {
               int var=check.get(i);
//               System.out.println("element to be called for dfs is"+var);
               if(!visited[var])
               {
                   dfs(o,var,visited);
               }
           }
           }
             System.out.println("element added to stack is"+start);
           stack.add(start);
    }
    public static void revDfs(Object[] rev,int start,boolean[] visited)
    {
          System.out.println("component is "+start);
          components++;
          visited[start]=true;
           ArrayList<Integer> check=(ArrayList<Integer>) rev[start];
             if(Objects.nonNull(check))
            {
           int size=check.size();
           for(int i=0;i<size;i++)
           {
               int var=check.get(i);
               if(!visited[var])
               {
                   revDfs(rev,var,visited);
               }
           }
           }
    }
    public static void reverseEdges(Object[] rev,Object[] o)
    {
        int size=o.length;
        for(int i=0;i<size;i++)
        {
            ArrayList<Integer> temp=(ArrayList<Integer>) o[i];
            if(Objects.nonNull(temp))
            {
            int length=temp.size();
            for(int j=0;j<length;j++)
            {
                int var1=i;
                int var2=temp.get(j);
                if(rev[var2]==null)
                    rev[var2]=new ArrayList<Integer>();
                 ArrayList<Integer> reverse=(ArrayList<Integer>) rev[var2];
                 reverse.add(var1);
            }
            }
        }
    }
    
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int edge=in.nextInt();
        Object[] o=new Object[n+1];
        Object[] rev=new Object[n+1];
        boolean[] visited=new boolean[n+1];
        boolean[] revVisited=new boolean[n+1];
        while(edge-->0)
        {
            int var1=in.nextInt();
            int var2=in.nextInt();
            if(o[var1]==null)
                o[var1]=new ArrayList<Integer>();  
          ArrayList<Integer> temp=(ArrayList<Integer>) o[var1];
          temp.add(var2);
        }
        for(int i=1;i<=n;i++)
        {
         if(!visited[i])
         {
        dfs(o,i,visited);
         }
        }
        reverseEdges(rev,o);
         while(!stack.empty())
        {
         int var=stack.pop();
         if(!revVisited[var])
         {
         System.out.println("came here");
        revDfs(rev,var,revVisited);
        if(components%2==0)
            even+=components;
        else
            odd+=components;
        components=0;
        
         }
        }
         System.out.println("odd is"+odd);
         System.out.println("even is"+even);
        System.out.println(odd-even);
    }
 public static void main(String[] args)
 {
     input();
 }
}
