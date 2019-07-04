package revision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node1{
	Node1 right;
	Node1 left;
	int value;
	public Node1(int value) {
		value = this.value;
		right = null;
		left = null;
	}
}
public class RevisionOfAlgo {
	public static Node1 insert(Node1 root,int value) {
		if(root==null)
			return new Node1(value);
		if(value<root.value)
			root.left = insert(root.left,value);
		else
			root.right = insert(root.right,value);
		return root;
	}
	public static void preorder(Node1 root) {
		if(root!=null) {
			System.out.println(root.value);
			preorder(root.left);
			preorder(root.right);
		}
	}
	public static void postorder(Node1 root) {
		if(root!=null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.value);
		}
	}
	public static int height(Node1 root) {
		if(root!=null) {
			return Math.max(1+height(root.left), 1+height(root.right));	
		}
		return 0;
	}
	public static void bfs(Node1 root) {
		Queue<Node1> q = new LinkedList<Node1>();
		if(root!=null) {
			q.add(root);
		}
		while(!q.isEmpty()) {
			System.out.println(q.peek().value);
			Node1 ref = q.remove();
			if(ref.left!=null)
				q.add(ref.left);
			if(ref.right!=null)
				q.add(ref.right);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		Node1 root = null;
		while(t-->0) {
			int value = in.nextInt();
			root = insert(root,value);
		}
		preorder(root);
		height(root);
	}

}
