package revision;

import java.util.LinkedList;
import java.util.Scanner;

public class MaximumFlow {
	public static boolean bfs(int[][] graph,int s,int t,int[] parent) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int length = graph.length;
		boolean[] visited = new boolean[length];
		queue.add(s);
		visited[s] = true;
		while(!queue.isEmpty()) {
			int pnode = queue.poll();
				for(int i=0;i<length;i++) {
					if(!visited[i]&&graph[pnode][i]!=0) {
					queue.add(i);
					parent[i] = pnode;
					visited[i] = true;
					}
				}
			}
		return (visited[t]==true);
	}
	public static int fordFulkerson(int[][] graph,int s,int t) {
		int maxFlow = 0;
		int[] parent = new int[graph.length];
		while(bfs(graph,s,t,parent)) {
			int min =graph[parent[t]][t];
			for(int v=t;v!=s;v=parent[v]) {
				 if(graph[parent[v]][v]<min)
					 min = graph[parent[v]][v];
			}
			for(int v=t;v!=s;v=parent[v]) {
				graph[parent[v]][v]-=min;
				graph[v][parent[v]]+=min;
			}
			maxFlow+=min;
		}
		return maxFlow;
	}
	public static void input() {
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		int[][] graph = new int[n][n];
		int path = in.nextInt();
		while(path-->0) {
			graph[in.nextInt()][in.nextInt()] = in.nextInt();
		}
		System.out.println(fordFulkerson(graph,0,n-1));
		in.close();
	}
  public static void main(String[] args) {
	  input();
  }
}
