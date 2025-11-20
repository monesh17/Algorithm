import java.util.ArrayList;
import java.util.List;

public class MaximumSum {
     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxSum =Integer.MIN_VALUE;

    public int pathTraversal(TreeNode root){
        if(root == null)
            return Integer.MIN_VALUE;
        int leftSum = 0, rightSum =0, totalSum,nodeSum;
        if(root.left != null) {
           leftSum = pathTraversal(root.left);
        }
        if(root.right != null) {
           rightSum = pathTraversal(root.right);
        }

        nodeSum = Math.max((root.val+leftSum), (root.val+rightSum));
        nodeSum = Math.max(nodeSum, root.val);
        totalSum = Math.max(nodeSum, root.val+leftSum+rightSum);
        if(totalSum > maxSum) maxSum = totalSum;
        return nodeSum;
    }

    public int maxPathSum(TreeNode root) {
         pathTraversal(root);
         return maxSum;
    }

    public static void main(String[] args) {
        // construct tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left.left =  new TreeNode(45);
        //root.right.left.right = new TreeNode(-100);

        MaximumSum sum = new MaximumSum();
        int result = sum.maxPathSum(root);
        System.out.println(result);

    }
}
