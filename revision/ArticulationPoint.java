package revision;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 *
 * @author monesh
 */
class Pair implements Comparator<Pair>
{
    int start;
    int end;
    public Pair(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
    public Pair()
    {
    }
    @Override
    public int compare(Pair o1,Pair o2) {
        if(o1.start!=o2.start)
        {
        if(o1.start<o2.start)
            return -1;
        else if(o1.start>o2.start)
            return 1;
        else
            return 0;
        }
        else
        {
            if(o1.end<o2.end)
            return -1;
        else if(o1.end>o2.end)
            return 1;
        else
            return 0;
        }
    }
    
}
public class ArticulationPoint 
{
    public static int count=1;
    public static int[] low=new int[12];
    public static int[] tym=new int[12];
    public static int[] child=new int[12];
    public static int[] parent=new int[12];
    public static boolean[] seen=new boolean[12];
    public static boolean[] iscut=new boolean[12];
    public static PriorityQueue<Integer> point=new PriorityQueue<Integer>();
    public static PriorityQueue<Pair> edge=new PriorityQueue<Pair>(new Pair());
    public static void dfs(int start,Object[] b)
    {
        seen[start]=true;
        low[start]=tym[start]=count++;
        ArrayList<Integer> check=(ArrayList<Integer>) b[start];
        for(int i=0;i<check.size();i++)
        {
        int var=check.get(i);
        if(var==parent[start])
            continue;
        if(!seen[var])
        {
            child[start]++;
            parent[var]=start;
            dfs(var,b);
            low[start]=Math.min(low[start],low[var]);
                            System.out.println("notseen vertex is"+var +"  "+start+" ");
            if(low[var]>=tym[start])
            {
                
                System.out.println("entered vertex is"+start +"  "+var+" ");
                 if(start!=0)
                point.add(start);
                if(low[var]>tym[start])
                {
                if(start<var)
                 edge.add(new Pair(start,var));
                else
                    edge.add(new Pair(var,start));
                }
            }
        }
        else
        {
            System.out.println("seen vertex is"+var +"  "+start+" ");
            low[start]=Math.min(low[start],tym[var]);
        }
        }
    }
    public static void input()
    {
        Scanner in=new Scanner(System.in);
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
        dfs(0,b);
        if(child[0]>1)
           point.add(0);
        for(int i=0;i<n;i++)
        {
            System.out.println("i is "+i);
            System.out.println("parent of "+parent[i]);
            System.out.println("low is"+"  "+low[i]+"  "+"tym is"+" "+tym[i]);
        }
        System.out.println(point.size());
        Iterator<Integer> i1=point.iterator();
        while(i1.hasNext())
            System.out.println(i1.next());
        System.out.println(edge.size());
        Iterator<Pair> i2=edge.iterator();
        while(i2.hasNext())
        {
            Pair p=i2.next();
            System.out.println(p.start+" "+p.end);
        }   
          
    }
public static void main(String args[])
{
    input();
}
}
