package revision;

import java.util.LinkedList;
import java.util.Scanner;

public class MaximumFlowDinic {
	public static int[] level;
	public static boolean bfs(Edge[][] graph,int s,int t) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int length = graph.length;
		boolean[] visited = new boolean[length];
		level = new int[length];
		queue.add(s);
		visited[s] = true;
		while(!queue.isEmpty()) {
			int pnode = queue.poll();
				for(int i=0;i<length;i++) {
					Edge e = graph[pnode][i];
					if(!visited[i]&&e.flow<e.capacity) {
					queue.add(i);
					level[i] = level[pnode]+1;
					visited[i] = true;
					}
				}
			}
		return (visited[t]==true);
	}
	public static int flow(Edge[][] graph,int s,int t,int flow) {
		if(s==t) 
			return flow;
		int length = graph.length;
		for(int i=0;i<length;i++) {
			Edge e = graph[s][i];
			if(level[i]==level[s]+1&&e.flow<e.capacity) {
				int curr = Math.min(flow, e.capacity-e.flow);
				int temp = flow(graph,i,t,curr);
				if(temp>0) {
					e.flow+=temp;
					graph[i][s].flow-=temp;
					return temp;
				}
			}
		}
		return 0;
	}
	public static int dinic(Edge[][] graph,int s,int t) {
		int maxFlow = 0;
		int temp =0;
		while(bfs(graph,s,t)) {
			temp = flow(graph,s,t,Integer.MAX_VALUE);
			while(temp!=0) {
				maxFlow+=temp;
				temp = flow(graph,s,t,Integer.MAX_VALUE);
			}
		}
		return maxFlow;
	}
	public static void input() {
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		Edge[][] graph = new Edge[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				graph[i][j] = new Edge(0);
		int path = in.nextInt();
		while(path-->0) {
			graph[in.nextInt()][in.nextInt()] = new Edge(in.nextInt());
		}
		System.out.println(dinic(graph,0,n-1));
		in.close();
	}
  public static void main(String[] args) {
	  input();
  }
}
class Edge{
	public int flow;
	public int capacity;
	public Edge(int capacity) {
		this.capacity = capacity;
	}
}
