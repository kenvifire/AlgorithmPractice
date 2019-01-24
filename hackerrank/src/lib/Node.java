package lib;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int _val) {
        this(_val, Collections.emptyList());
    }

    public Node(int _val, Node ... nodes) {
        this(_val, Arrays.asList(nodes));
    }


}
