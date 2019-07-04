package revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LowestCommonAncestor {
	public static void getParentNode(Object[] o,int[] parent,int node) {
		 ArrayList<Integer> tree=(ArrayList<Integer>) o[node];
		if(tree!=null)
		for(int i=0;i<tree.size();i++) {
			parent[tree.get(i)] = node;
			getParentNode(o,parent,tree.get(i));
		}
	}
	
	public static int getLca(int u,int v,int[] parent) {
		int lca =0;
		boolean[] visited = new boolean[parent.length];
		while(true) {
			visited[u]=true;
			if(u==0)
				break;
			u = parent[u];
		}
		while(true) {
			if(visited[v]) {
				lca = v;
				break;
			}
			v= parent[v];
		}
		return lca;
	}
	public static void navie(Object[] o,int n) {
		int[] parent = new int[n];
		getParentNode(o,parent,0);
		System.out.println(getLca(6,2,parent));
	}
	public static void getLevelArray(Object[] o,int[] parent,int[] level,int node) {
		ArrayList<Integer> tree = (ArrayList<Integer>)o[node];
		if(tree!=null)
		for(int i=0;i<tree.size();i++) {
			int child = tree.get(i);
			level[child]=level[parent[child]]+1;
			getLevelArray(o,parent,level,child);
		}
	}
	public static void traverse(Object[] o,int[] parent,int[] level,int[] p,int previous,int node,int height) {
		if(level[node]%height==0)
			p[node] = parent[node];
		else {
			p[node] = p[previous];
		}
		ArrayList<Integer> tree = (ArrayList<Integer>)o[node];
		if(tree!=null)
		for(int i=0;i<tree.size();i++) {
			traverse(o,parent,level,p,node,tree.get(i),height);
		}
	}
	public static int lcanavie(int u,int v,int distance,int[] level,int[] parent) {
		while(u!=v) {
			if(level[u]>level[v]) {
			    u = u+v-u;
			    v = u+v-v;
			}
			v= parent[v];
			distance++;
		}
		return distance;
	}
	public static int lcasqrt(int u,int v,int[] p,int distance,int height,int[] level,int[] parent) {
		while(p[u]!=p[v]) {
			if(level[u]>level[v]) {
			    u = u+v-u;
			    v = u+v-v;
			}
			v=p[v];
			distance+=height;
		}
		return lcanavie(u,v,distance,level,parent);
	}
	public static void sqrt(Object[] o,int n) {
		int[] level = new int[n];
		int[] parent = new int[n];
		parent[1]=1;
		getParentNode(o,parent,1);
		level[1]=0;
		getLevelArray(o,parent,level,1);
		int height = level[1];
		for(int i=2;i<level.length;i++)
			if(height<level[i])
				height = level[i];
		height=(int)Math.sqrt(height);
		int[] p = new int[n];
		traverse(o,parent,level,p,0,1,height);
		for(int i=0;i<n;i++)
			System.out.println("i is "+i+" p is "+p[i]);
		int distance =0;
		System.out.println(lcasqrt(1,5,p,distance,height,level,parent));
	}
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	int n = in.nextInt();
	Object[] o=new Object[n];
	while(t-->0) {
		int var1 = in.nextInt();
		int var2 = in.nextInt();
		 if(o[var1]==null)
             o[var1]=new ArrayList<Integer>();
         ArrayList<Integer> first=(ArrayList<Integer>) o[var1];
         first.add(var2);
	}
//	navie(o,n);
	sqrt(o,n);
}
}
