import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

class TreeQueue {
    int level;
    int parent;

    public TreeQueue(int level, int parent) {
        this.level = level;
        this.parent = parent;
    }
}
public class Cousin {

    public boolean isCousins(TreeNode root, int a, int b) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        Map<Integer,TreeQueue> parentReference = new HashMap<>();
        parentReference.put(root.val,new TreeQueue(0,-1));

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            int parent = temp.val;
            queue.add(temp.left);
            queue.add(temp.right);
            parentReference.put(temp.left.val, new TreeQueue(parentReference.get(parent).level+1,parent) );
            parentReference.put(temp.right.val, new TreeQueue(parentReference.get(parent).level+1,parent) );
        }


        TreeQueue aQueue = parentReference.get(a);
        TreeQueue bQueue = parentReference.get(b);

        return (aQueue.level == bQueue.level) && (aQueue.parent!=bQueue.parent);
    }
    public static void main(String[] args) {

    }
}
