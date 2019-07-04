/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class bfs01 
{
    public static void optimum(Object[] o,int[][] w,int n)
    {
      Deque<Integer> q=new ArrayDeque<Integer>();
      int[][] distance=new int[n+1][n+1];
          Arrays.fill(distance[0],Integer.MAX_VALUE);
      q.add(0);
      distance[0][0]=0;
      while(!q.isEmpty())
      {
          int p=q.removeFirst();
          ArrayList<Integer> check=(ArrayList<Integer>) o[p];
          System.out.println("size is  "+check.size());
          for(int i=0;i<check.size();i++)
          {
              int num=check.get(i); 
              if(distance[0][num]>(distance[0][p]+w[p][num]))
              {
                  distance[0][num]=(distance[0][p]+w[p][num]);
                  System.out.println("added number is  "+ num);
                  if(w[p][num]==0)
                      q.addFirst(num);
                  else
                      q.addLast(num);
              }
          }
          Iterator a=q.iterator();
          while(a.hasNext())
              System.out.println(a.next());
      }
//      for(int i=0;i<n+1;i++)
//      {
//          for(int j=0;j<n+1;j++)
//              System.out.println(i+"   "+j+"   "+"distance is"+distance[i][j]);
//      }
      
    }
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int rel=in.nextInt();
        Object[] o=new Object[n+1];
        int[][] weight=new int[n+1][n+1];
        while(rel-->0)
        {
            int var1=in.nextInt();
            int var2=in.nextInt();
            if(o[var1]==null)
                o[var1]=new ArrayList<Integer>();
            ArrayList<Integer> first=(ArrayList<Integer>) o[var1];
            first.add(var2);
            int w=in.nextInt();
            weight[var1][var2]=w;
            if(o[var2]==null)
                o[var2]=new ArrayList<Integer>();
            ArrayList<Integer> second=(ArrayList<Integer>) o[var2];
            second.add(var1);
            weight[var1][var2]=w;
        }
        optimum(o,weight,n);
        
    }
public static void main(String[] args)
{
    input();
}
}
