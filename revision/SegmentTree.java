package revision;

public class SegmentTree {
	public static void build(int node,int start,int end,int[] tree,int[] a) {
		if(start==end)
			tree[node]=a[start];
		else {
			int mid = (start+end)/2; 
			build(2*node,start,mid,tree,a);
			build(2*node+1,mid+1,end,tree,a);
			tree[node]=tree[2*node]+tree[2*node+1];
		}
	}
	public static void update(int node,int start,int end,int[] tree,int[] a, int idx,int val) {
		if(start==end) {
			a[idx]=val;
			tree[node]=val;
		}
		else {
			int mid = (start+end)/2;
			if(start<=idx&&idx<=mid) 
				update(2*node,start,mid,tree,a,idx,val);
			else
				update(2*node+1,mid+1,end,tree,a,idx,val);
			tree[node]=tree[2*node]+tree[2*node+1];
		}
	}
	public static int updateAnInterval(int node,int start,int end,int[] tree,int[] a,int l,int r) {
		if(end<l||start>r)
			return 0;
		if(start>=l&&end<=r)
			return tree[node];
		int mid = (start+end)/2;
		int p1=updateAnInterval(2*node,start,mid,tree,a,l,r);
		int p2=updateAnInterval(2*node+1,mid+1,end,tree,a,l,r);
		return (p1+p2);
	}
	public static void lazyUpdate(int node,int start,int end,int[] tree,int[] a,int l,int r,int val,int[] lazy) {
		if(lazy[node]!=0) {
			tree[node] = (end-start+1)*lazy[node];
			if(start!=end) {
				lazy[2*node]+=lazy[node];
				lazy[2*node+1]+=lazy[node];
			}
			lazy[node]=0;
		}
		if(start>r||end<l)
			return;
		if(start>=l&&end<=r) { 
			tree[node] = (end-start+1)*val;
			if(start!=end) {
				lazy[2*node]+=val;
				lazy[2*node+1]+=val;
			}
			return;
		}
		int mid = (end+start)/2;
		lazyUpdate(2*node, start, mid, tree, a, l, r, val, lazy);
		lazyUpdate(2*node+1, mid+1, end, tree, a, l, r, val, lazy);
		tree[node] = tree[2*node] + tree[2*node+1];
	}
	public static void segmentAddition(int[] a) {
		int[] tree = new int[14];
		int[] lazy = new int[14];
		build(1,0,5,tree,a);
		//update(1,0,5,tree,a,4,2);
		//System.out.println(updateAnInterval(1,0,5,tree,a,1,4));
		lazyUpdate(1,0,5,tree,a,1,4,2,lazy);
		for(int i=0;i<tree.length;i++) {
			System.out.println(i+"    "+tree[i]);
		}
	}
      public static void main(String[] args) {
    	  int[] a = {1,3,5,7,9,11};
    	 segmentAddition(a);
      }
}
