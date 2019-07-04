package revision;

import java.util.Scanner;
class Node{
	int data;
	Node right;
	Node left;
	public Node(int data) {
		this.data = data;
		right = null;
		left = null;
	}
}
public class BinarySearchTree {
	public static Node insert(Node root,int data) {
		if(root == null)
			return new Node(data);
		else {
			if(data<root.data)
				root.left = insert(root.left,data);
			else
				root.right = insert(root.right,data);
		}
		return root;
	}
	public static void preorder(Node root) {
		if(root==null)
			return;
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
	}
	public static void postorder(Node root) {
		if(root.left!=null)
			postorder(root.left);
		if(root.right!=null)
			postorder(root.right);
		System.out.println(root.data);
	}
	public static int height(Node root) {
		int maxLeft=0,maxRight=0;
		if(root!=null) {
			if(root.left!=null)
				maxLeft = 1+height(root.left);
			if(root.right!=null)
				maxRight = 1+height(root.right);
			return Math.max(maxLeft, maxRight);
		}
		return 0;
	}
	public static boolean isBinarySearchTree(Node root,int min,int max) {
		if(root!=null) {
			if(root.data<min||root.data>max)
				return false;
			return isBinarySearchTree(root.left,min,root.data)&&isBinarySearchTree(root.right,root.data,max);
		}
		return true;
	}
  public static void main(String[] args) {
	  Scanner in = new Scanner(System.in);
	  int t = in.nextInt();
	  Node root = null;
	  while(t-->0) {
		  int data = in.nextInt();
		  root = insert(root,data);
		  preorder(root);
		  postorder(root);
		  int value = height(root);
		  isBinarySearchTree(root,0,1000);
	  }
  }
}
