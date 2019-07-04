package revision;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class BellmanAlg 
{
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int edge=in.nextInt();
        ArrayList[] a=new ArrayList[n+1];
        int[] dis=new int[n+1];
        for(int i=0;i<edge;i++)
        {
            int from=in.nextInt();
            int to=in.nextInt();
            int weight=in.nextInt();
            if(a[from]==null)
                a[from]=new ArrayList<pair>();
            a[from].add(new pair(to,weight));
        }
        dis[1]=0;
        for(int i=2;i<=n;i++)
        {
            dis[i]=Integer.MAX_VALUE;
        }
        for(int i=1;i<=n;i++)
                {
                    if(a[i]!=null)
                    for(int j=0;j<a[i].size();j++)
                    {
                        pair p=(pair) a[i].get(j);
                        if(dis[i]+p.weight<dis[p.node])
                        {
                            dis[p.node]=dis[i]+p.weight;
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
static class pair
{
    int node;
    int weight;
    public pair(int node,int weight)
    {
        this.node=node;
        this.weight=weight;
    }
}

}
