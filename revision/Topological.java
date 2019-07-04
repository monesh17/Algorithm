package revision;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author monesh
 */
class LexiComparator implements Comparator<Integer>
{

    @Override
    public int compare(Integer o1, Integer o2) {
       if(o1<o2)
            return 1;
        else if(o1>o2)
            return -1;
        else
            return 0;
    }
    
}
public class Topological {
    public static Stack<Integer> q=new Stack<>();
    public static void dfs(Object[] o,int start,boolean[] visit)
    {
       visit[start]=true;
       PriorityQueue<Integer> temp=(PriorityQueue<Integer>) o[start];
       if(temp!=null)
       {
       while(!temp.isEmpty())
       {
           int var=temp.poll();
           if(!visit[var])
           dfs(o,var,visit);
       }
       }
       q.add(start);
    }
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int edge=in.nextInt();
        boolean[] visit=new boolean[n+1];
        Object[] o=new Object[n+1];
        while(edge-->0)
        {
            int var1=in.nextInt();
            int var2=in.nextInt();
            if(o[var1]==null)
                o[var1]=new PriorityQueue<Integer>(21,new LexiComparator());  
          PriorityQueue<Integer> temp=(PriorityQueue<Integer>) o[var1];
          temp.add(var2);
        }
        for(int i=n;i>=1;i--)
        {
        if(!visit[i])
        dfs(o,i,visit);
        }
        while(!q.isEmpty())
        {
            System.out.println(q.pop());
        }
    }
    public static void main(String args[])
    {
        input();
    }

    
}
