package revision;

import java.util.ArrayList;
import java.util.Scanner;

public class DFSRecursion {
	public static void traverse(Object[] o,int start,boolean[] visit) {
		System.out.println(start);
		visit[start]=true;
		 ArrayList<Integer> neighbour = (ArrayList<Integer>) o[start];
		 for(int i=0;i<neighbour.size();i++) {
			 if(!visit[neighbour.get(i)]) {
				 traverse(o,neighbour.get(i),visit);
			 }
		 }
	}
	public static void dfs(Object[] o,int n) {
		boolean[] visit = new boolean[n+1];
		traverse(o,1,visit);
	}
	public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int rel=n-1;
        Object[] o=new Object[n+1];
        while(rel-->0)
        {
            int var1=in.nextInt();
            int var2=in.nextInt();
            if(o[var1]==null)
                o[var1]=new ArrayList<Integer>();
            ArrayList<Integer> v1 = (ArrayList<Integer>) o[var1];
            v1.add(var2);
            
        }
        dfs(o,n);
    }
 public static void main(String args[])
 {
     input();
 }
}
