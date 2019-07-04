package revision;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 *
 * @author monesh
 */
 class Weight implements Comparator<Weight>
    { 
        int node;
        int weight;
        public Weight()
        {
            
        }
        public Weight(int node,int weight)
        {
            this.node=node;
            this.weight=weight;
        }
    @Override
    public int compare(Weight o1, Weight o2) {
        
        if(o1.weight<o2.weight)
            return -1;
        else if(o1.weight>o2.weight)
            return 1;
        else
            return 0;
    }
    }
public class Prims 
{
    public static int path(ArrayList[] o,int n,int start)
    {
        boolean[] b=new boolean[n+1];
        PriorityQueue<Weight> p=new PriorityQueue<Weight>(new Weight());
        p.add(new Weight(start,0));
        int mc=0;
        while(!p.isEmpty())
        {
            Weight var=p.poll();
            if(b[var.node])
                continue;
            b[var.node]=true;
            mc+=var.weight;
//            if(mc>=610000)
//            {
//                System.out.println("mc   is"+ mc);
//                System.out.println("node1 is" + var.node);
//                System.out.println("weight is" + var.weight);
//            }
            ArrayList<Weight> next=o[var.node];
            int size=next.size();
            for(int i=0;i<size;i++)
            {
                if(!b[next.get(i).node])
                     p.add(new Weight(next.get(i).node,next.get(i).weight));
            }
            
        }
        return mc;
    }
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int rel=in.nextInt();
        ArrayList<Weight>[] o=new ArrayList[n+1];
        while(rel-->0)
        {
         //  System.out.println("count is"+rel);
            int var1=in.nextInt();
            int var2=in.nextInt();
            int w=in.nextInt();
            if(o[var1]==null)
                o[var1]=new ArrayList<Weight>();                
             o[var1].add(new Weight(var2,w));
            if(o[var2]==null)
                o[var2]=new ArrayList<Weight>();
            o[var2].add(new Weight(var1,w));
         }
        System.out.println(path(o,n,1));
    }
    public static void main(String[] args)
    {
        input();
    }
}
//        Comparator<Weight> comp=new Weight();
