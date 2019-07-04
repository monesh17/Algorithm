package revision;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;


/**
 *
 * @author monesh
 */
class Pairnode
{
    int node1;
    int node2;
    int storeindex;
    public Pairnode(int node1,int node2,int store)
    {
        this.node1=node1;
        this.node2=node2;
        this.storeindex=store;
    }
}
public class Biconnected 
{
    public static int count=1;
    public static int[] low=new int[12];
    public static int[] tym=new int[12];
    public static int[] child=new int[12];
    public static int[] parent=new int[12];
    public static boolean[] seen=new boolean[12];
    public static Stack<Pairnode> s=new Stack<Pairnode>();
    public static int even=0;
    public static int odd=0;
    public static int storeindex=0;
    public static void dfs(int start,Object[] b)
    {
        seen[start]=true;
        low[start]=tym[start]=count++;
        ArrayList<Integer> check=(ArrayList<Integer>) b[start];
        for(int i=0;i<check.size();i++)
        {
            int var=check.get(i);
            Pairnode p=new Pairnode(start,var,storeindex++);
            if(parent[start]==var)
                continue;
            if(!seen[var])
            {
                s.push(p);
                child[start]++;
                parent[var]=start;
                 dfs(var,b);
                 low[start]=Math.min(low[start],low[var]);
                 if(low[var]>=tym[start]||(tym[start]==1&&child[start]>1))
                 {
                     int element=0;
                     int size=s.size()-1;
                     Iterator x=s.iterator();
                       while(x.hasNext())
                       {
                           Pairnode z=(Pairnode) x.next();
                           System.out.println("size is"+size+" "+p.storeindex);
                           System.out.println("ele2 is"+" "+z.node1+" "+z.node2);
                       } 
                       for(int k=size;k>=p.storeindex;k--)
                    {
                         Pairnode c=s.pop();
                        System.out.println("element2 is"+c.node1+" "+c.node2);
                        element++;
                    }
                    if((element)%2==0)
                    {
                        even++;
                    }
                    else
                    {
                        System.out.println("odd"+" "+start+" "+var);
                        odd++;
                    }
                       
                 }
            }
            else 
            { 
                low[start]=Math.min(low[start],tym[var]);
                s.push(p);
            }
        }
        
    }
    
public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
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
           second.add(var1);
        }
        for(int i=0;i<n;i++)
        {
       if(!seen[i])
       {
          storeindex=0;
        while(!s.isEmpty())
        {
         s.pop();
        } 
        dfs(i,b);
       }
        }
        System.out.println(odd+" "+even);
            
    }
public static void main(String args[])
{
    input();
}    
}
