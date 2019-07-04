/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
class Pair2 implements Comparator<Pair2>
{
    int node;
    int weight;
    public Pair2(int node,int weight)
    {
        this.node=node;
        this.weight=weight;
    }

    Pair2() {
       
    }

    @Override
    public int compare(Pair2 o1, Pair2 o2) {
        if(o1.weight<o2.weight)
            return -1;
        else if(o1.weight>o2.weight)
            return 1;
        else
            return 0;
    }

   
}
public class TestClass
{
     public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int edge=in.nextInt();
        PriorityQueue<Pair2> pq=new PriorityQueue<Pair2>(1000,new Pair2());
        ArrayList[] a=new ArrayList[n+1];
        int[] dis=new int[n+1];
        boolean[] visited=new boolean[n+1];
        for(int i=2;i<=n;i++)
            dis[i]=Integer.MAX_VALUE;
        for(int i=0;i<edge;i++)
        {
            int from=in.nextInt();
            int to=in.nextInt();
            int weight=in.nextInt();
            if(a[from]==null)
                a[from]=new ArrayList<Pair2>();
            a[from].add(new Pair2(to,weight));
        }
         pq.add(new Pair2(1,0));
            while(!pq.isEmpty())
                {
                    Pair2 x=pq.poll();
                    if(visited[x.node])
                       continue;
                    visited[x.node]=true;
                    if(a[x.node]!=null)
                    {
                     int size=a[x.node].size();
                    for(int j=0;j<size;j++)
                    {
                        Pair2 p=(Pair2) a[x.node].get(j);
                        if(dis[p.node]>(dis[x.node]+p.weight))
                        {
                            dis[p.node]=dis[x.node]+p.weight;
                            pq.add(new Pair2(p.node,dis[p.node]));
                        }
                    }
                    }      
                }
        for(int i=2;i<=n;i++)
                        System.out.print(dis[i]+" ");
    }
public static void main(String[] args)
{
    input();
}
    
}
