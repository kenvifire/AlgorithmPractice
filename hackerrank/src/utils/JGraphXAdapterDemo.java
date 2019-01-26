package utils;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import lib.Node;
import lib.TreeNode;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;

import javax.swing.JApplet;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.ArrayDeque;
import java.util.Queue;

public class JGraphXAdapterDemo
        extends
        JApplet
{
    private static final long serialVersionUID = 2202072534703043194L;

    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);

    private JGraphXAdapter<String, DefaultEdge> jgxAdapter;

    private Node root;

    public JGraphXAdapterDemo(Node root) {
        this.root = root;
    }


    public void showGraph() {
        init();

        JFrame frame = new JFrame();
        frame.getContentPane().add(this);
        frame.setTitle("JGraphT Adapter to JGraphX Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void init()
    {
        // create a JGraphT graph
        ListenableGraph<String, DefaultEdge> g =
                new DefaultListenableGraph<>(new DefaultDirectedGraph<>(DefaultEdge.class));

        // create a visualization using JGraph, via an adapter
        jgxAdapter = new JGraphXAdapter<>(g);

        setPreferredSize(DEFAULT_SIZE);
        mxGraphComponent component = new mxGraphComponent(jgxAdapter);
        component.setConnectable(false);
        component.getGraph().setAllowDanglingEdges(false);
        getContentPane().add(component);
        resize(DEFAULT_SIZE);


        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);
        int index = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            g.addVertex(current.toString());

            if(current.children != null && current.children.size() > 0) {
                queue.addAll(current.children);
                for (Node c : current.children) {
                    g.addVertex(c.toString());
                    g.addEdge(current.toString(), c.toString());
                }
            }
        }


        // positioning via jgraphx layouts
        mxCircleLayout layout = new mxCircleLayout(jgxAdapter);

        // center the circle
        int radius = 100;
        layout.setX0((DEFAULT_SIZE.width / 2.0) - radius);
        layout.setY0((DEFAULT_SIZE.height / 2.0) - radius);
        layout.setRadius(radius);
        layout.setMoveCircle(true);

        layout.execute(jgxAdapter.getDefaultParent());
        // that's all there is to it!...
    }
}
