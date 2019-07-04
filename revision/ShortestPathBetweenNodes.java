package revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author monesh
 *
 */
public class ShortestPathBetweenNodes {
	public static void bfs(Object[] o,int[] dist,int[] path,boolean[] visited) {
		dist[0]=0;
		path[0]=1;
		Queue<Integer> q=new LinkedList<Integer>();
		visited[0] = true;
		q.add(0);
		while(!q.isEmpty()) {
			int parent = q.poll();
			ArrayList<Integer> neighbours = (ArrayList<Integer>)o[parent];
			if(Objects.nonNull(neighbours)) {
			for(int i=0;i<neighbours.size();i++) {
				int var = neighbours.get(i);
				if(!visited[var]) {
					visited[var] = true;
					q.add(var);
				}
				if(dist[var]>(dist[parent]+1)) {
					dist[var] = dist[parent] +1;
					path[var] = path[parent];
				}
				else if(dist[var] == (dist[parent]+1)) {
					path[var]+=path[parent];
				}
			}
			}
		}
	}
	public static void shortestPath(Object[] o,int n) {
		int[] dist = new int[n];
		int[] path = new int[n];
		boolean[] visited = new boolean[n];
		for(int i=0;i<n;i++)
			dist[i] = Integer.MAX_VALUE;
		bfs(o,dist,path,visited);
		for(int i=0;i<n;i++)
			System.out.println("path is "+path[i]);
	}
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n=in.nextInt();
    int t=in.nextInt();
    Object[] o=new Object[n];
    while(t-->0)
    {
        int var1=in.nextInt();
        int var2=in.nextInt();
        if(o[var1]==null)
            o[var1]=new ArrayList<Integer>();      
        ArrayList<Integer> var = (ArrayList<Integer>)o[var1];
        var.add(var2);
    }
    shortestPath(o,n);
}
}
