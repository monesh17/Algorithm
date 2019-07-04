package revision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author monesh
 */
public class BreadthFirstSearch 
{
    static class Node
    {
        int num;
        Node right;
        Node left;
        boolean visit=false;
        public Node(int num)
        {
            this.num=num;
            this.right=this.left=null;
        }
    }
    public static Node bst(int var,Node root)
    {
        if(root==null||root.num==var)
            return new Node(var);
        else if(var<root.num)
            root.left=bst(var,root.left);
        else if(var>root.num)
            root.right=bst(var,root.right);
        return root;
        
    }
    public static void print(Node root)
    {
        if(root!=null)
        {
            if(root.left!=null)
               print(root.left);
             if(root.right!=null)
                 print(root.right);
             System.out.println(root.num);
        }
    }
    public static void bfs(Node root,int n)
    {
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        root.visit=true;
        while(!q.isEmpty())
        {
            System.out.println(q.peek().num);
            Node curr=q.remove();
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
        
        
    }
    public static void input()
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Node root=null;
        while(n-->0)
        {
            int var=in.nextInt();
            root=bst(var,root);
        }
       // print(root);
        bfs(root,n);
    }
public static void main(String[] args)
{
    input();
}
}
