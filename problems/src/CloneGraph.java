import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    Map<Integer, Node> reference = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(reference.containsKey(node.val)){
            return reference.get(node.val);
        }
        Node temp = new Node(node.val);
        reference.put(node.val, temp);
        for(Node neighbour: node.neighbors) {
            temp.neighbors.add(cloneGraph(neighbour));
        }
        return temp;
    }

}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
