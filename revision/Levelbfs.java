package revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author monesh
 */ 
public class Levelbfs 
{
    public static void bfs(Object[] o,boolean[] visit,int[] level,int reqlevel)
    {
        Queue<Integer> place=new LinkedList<Integer>();
        place.add(1);
        level[1]=1;
        visit[1]=true;
        int number=0;
        if(reqlevel==1)
            System.out.println("1");
        else
        {
        while(!place.isEmpty())
        {
            int p=place.peek();
            System.out.println("place is   "+p);
            ArrayList<Integer> a=(ArrayList<Integer>) o[place.remove()];
            int size=a.size();
            System.out.println("size is   "+size);
            for(int i=0;i<size;i++)
            {
               
                if(!visit[a.get(i)])
                {
                     System.out.println("element is   "+a.get(i));
                    place.add(a.get(i));
                    visit[a.get(i)]=true;
                    level[a.get(i)]=level[p]+1;
                    number++;
                }
            }
            if(reqlevel==level[p]+1&&!(level[p]==level[place.peek()]))
            {
                System.out.println(number);
                break;
            }
            if(reqlevel!=level[p]+1)
                number=0;
        }
        }
    }
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Object[] o=new Object[n+1];
        boolean[] visit=new boolean[n+1];
        int[] level=new int[n+1];
        while(n-->1)
        {
            int var1=in.nextInt();
            int var2=in.nextInt();
            if(o[var1]==null)
                o[var1]=new ArrayList<Integer>();
            ArrayList<Integer> first=(ArrayList<Integer>) o[var1];
            first.add(var2);
            if(o[var2]==null)
                o[var2]=new ArrayList<Integer>();
            ArrayList<Integer> second=(ArrayList<Integer>) o[var2];
            second.add(var1);
        }
        ArrayList<Integer> check=(ArrayList<Integer>)o[3];
        for(int i=0;i<check.size();i++)
            System.out.println("3 is"+check.get(i));
        int reqlevel=in.nextInt();
        bfs(o,visit,level,reqlevel);
    }
           
public static void main(String[] args)
{
    input();
}
}
