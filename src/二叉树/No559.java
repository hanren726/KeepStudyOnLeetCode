package 二叉树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class No559 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.isEmpty()) {
            return 1;
        }
        List<Integer> heights = new LinkedList<>();
        for (Node child : root.children) {
            heights.add(maxDepth(child));
        }
        return Collections.max(heights) + 1;
    }
}
