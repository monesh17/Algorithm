
package revision;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author monesh
 */
class Pair1 implements Comparator<Pair1>
{
    int node;
    int weight;
    public Pair1(int node,int weight)
    {
        this.node=node;
        this.weight=weight;
    }

    Pair1() {
       
    }

    @Override
    public int compare(Pair1 o1, Pair1 o2) {
        if(o1.weight<o2.weight)
            return -1;
        else if(o1.weight>o2.weight)
            return 1;
        else
            return 0;
    }

   
}
public class Dijkstra 
{
     public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int edge=in.nextInt();
        PriorityQueue<Pair1> pq=new PriorityQueue<Pair1>(new Pair1());
        ArrayList[] a=new ArrayList[n+1];
        int[] dis=new int[n+1];
        for(int i=0;i<edge;i++)
        {
            int from=in.nextInt();
            int to=in.nextInt();
            int weight=in.nextInt();
            if(a[from]==null)
                a[from]=new ArrayList<Pair1>();
            a[from].add(new Pair1(to,weight));
        }
        dis[1]=0;
        for(int i=2;i<=n;i++)
        {
            dis[i]=Integer.MAX_VALUE;
        }
        pq.add(new Pair1(1,0));
            while(!pq.isEmpty())
                {
                    Pair1 x=pq.poll();
                    if(a[x.node]!=null)
                    {
                     int size=a[x.node].size();
                    for(int j=0;j<size;j++)
                    {
                        Pair1 p=(Pair1) a[x.node].get(j);
                        if(dis[x.node]+p.weight<dis[p.node])
                        {
                            dis[p.node]=dis[x.node]+p.weight;
                            pq.add(new Pair1(p.node,dis[p.node]));
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
