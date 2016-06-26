package contest.june_world_codesprint;


import java.util.*;

/**
 * Created by hannahzhang on 16/6/26.
 */
public class JohnLand {
    public static void main(String[] args) {
        int N, M;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        AdjMatrixEdgeWeightedDigraph G = new AdjMatrixEdgeWeightedDigraph(N);
        int a, b, c;
        for (int i = 0; i < M; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            G.addEdge(new DirectedEdge(a-1, b-1, Math.pow(2, c)));
            G.addEdge(new DirectedEdge(b-1, a-1, Math.pow(2, c)));
        }

        FloydWarshall floydWarshall = new FloydWarshall(G);
        long total = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {

              total += (long)floydWarshall.dist(i, j);

            }
        }
        System.out.println(Long.toBinaryString(total));


    }


    static class FloydWarshall {
        private double[][] distTo;  // distTo[v][w] = length of shortest v->w path
        private DirectedEdge[][] edgeTo;  // edgeTo[v][w] = last edge on shortest v->w path

        /**
         * Computes a shortest paths tree from each vertex to to every other vertex in
         * the edge-weighted digraph <tt>G</tt>. If no such shortest path exists for
         * some pair of vertices, it computes a negative cycle.
         * @param G the edge-weighted digraph
         */
        public FloydWarshall(AdjMatrixEdgeWeightedDigraph G) {
            int V = G.V();
            distTo = new double[V][V];
            edgeTo = new DirectedEdge[V][V];

            // initialize distances to infinity
            for (int v = 0; v < V; v++) {
                for (int w = 0; w < V; w++) {
                    distTo[v][w] = Double.POSITIVE_INFINITY;
                }
            }

            // initialize distances using edge-weighted digraph's
            for (int v = 0; v < G.V(); v++) {
                for (DirectedEdge e : G.adj(v)) {
                    distTo[e.from()][e.to()] = e.weight();
                    edgeTo[e.from()][e.to()] = e;
                }
                // in case of self-loops
                if (distTo[v][v] >= 0.0) {
                    distTo[v][v] = 0.0;
                    edgeTo[v][v] = null;
                }
            }

            // Floyd-Warshall updates
            for (int i = 0; i < V; i++) {
                // compute shortest paths using only 0, 1, ..., i as intermediate vertices
                for (int v = 0; v < V; v++) {
                    if (edgeTo[v][i] == null) continue;  // optimization
                    for (int w = 0; w < V; w++) {
                        if (distTo[v][w] > distTo[v][i] + distTo[i][w]) {
                            distTo[v][w] = distTo[v][i] + distTo[i][w];
                            edgeTo[v][w] = edgeTo[i][w];
                        }
                    }
                }
            }
        }


        /**
         * Is there a path from the vertex <tt>s</tt> to vertex <tt>t</tt>?
         * @param s the source vertex
         * @param t the destination vertex
         * @return <tt>true</tt> if there is a path from vertex <tt>s</tt>
         * to vertex <tt>t</tt>, and <tt>false</tt> otherwise
         */
        public boolean hasPath(int s, int t) {
            return distTo[s][t] < Double.POSITIVE_INFINITY;
        }

        /**
         * Returns the length of a shortest path from vertex <tt>s</tt> to vertex <tt>t</tt>.
         * @param s the source vertex
         * @param t the destination vertex
         * @return the length of a shortest path from vertex <tt>s</tt> to vertex <tt>t</tt>;
         * <tt>Double.POSITIVE_INFINITY</tt> if no such path
         * @throws UnsupportedOperationException if there is a negative cost cycle
         */
        public double dist(int s, int t) {
            return distTo[s][t];
        }

        /**
         * Returns a shortest path from vertex <tt>s</tt> to vertex <tt>t</tt>.
         * @param s the source vertex
         * @param t the destination vertex
         * @return a shortest path from vertex <tt>s</tt> to vertex <tt>t</tt>
         * as an iterable of edges, and <tt>null</tt> if no such path
         * @throws UnsupportedOperationException if there is a negative cost cycle
         */
        public Iterable<DirectedEdge> path(int s, int t) {
            if (!hasPath(s, t)) return null;
            Stack<DirectedEdge> path = new Stack<DirectedEdge>();
            for (DirectedEdge e = edgeTo[s][t]; e != null; e = edgeTo[s][e.from()]) {
                path.push(e);
            }
            return path;
        }


    }

    static class AdjMatrixEdgeWeightedDigraph {
        private static final String NEWLINE = System.getProperty("line.separator");

        private int V;
        private int E;
        private DirectedEdge[][] adj;

        /**
         * Initializes an empty edge-weighted digraph with <tt>V</tt> vertices and 0 edges.
         * param V the number of vertices
         * @throws java.lang.IllegalArgumentException if <tt>V</tt> < 0
         */
        public AdjMatrixEdgeWeightedDigraph(int V) {
            if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
            this.V = V;
            this.E = 0;
            this.adj = new DirectedEdge[V][V];
        }


        /**
         * Returns the number of vertices in the edge-weighted digraph.
         * @return the number of vertices in the edge-weighted digraph
         */
        public int V() {
            return V;
        }

        /**
         * Returns the number of edges in the edge-weighted digraph.
         * @return the number of edges in the edge-weighted digraph
         */
        public int E() {
            return E;
        }

        /**
         * Adds the directed edge <tt>e</tt> to the edge-weighted digraph (if there
         * is not already an edge with the same endpoints).
         * @param e the edge
         */
        public void addEdge(DirectedEdge e) {
            int v = e.from();
            int w = e.to();
            if (adj[v][w] == null) {
                E++;
                adj[v][w] = e;
            }
        }

        /**
         * Returns the directed edges incident from vertex <tt>v</tt>.
         * @param v the vertex
         * @return the directed edges incident from vertex <tt>v</tt> as an Iterable
         * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
         */
        public Iterable<DirectedEdge> adj(int v) {
            return new AdjMatrixEdgeWeightedDigraph.AdjIterator(v);
        }

        // support iteration over graph vertices
        private class AdjIterator implements Iterator<DirectedEdge>, Iterable<DirectedEdge> {
            private int v;
            private int w = 0;

            public AdjIterator(int v) {
                this.v = v;
            }

            public Iterator<DirectedEdge> iterator() {
                return this;
            }

            public boolean hasNext() {
                while (w < V) {
                    if (adj[v][w] != null) return true;
                    w++;
                }
                return false;
            }

            public DirectedEdge next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return adj[v][w++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /**
         * Returns a string representation of the edge-weighted digraph. This method takes
         * time proportional to <em>V</em><sup>2</sup>.
         * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
         *   followed by the <em>V</em> adjacency lists of edges
         */
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(V + " " + E + NEWLINE);
            for (int v = 0; v < V; v++) {
                s.append(v + ": ");
                for (DirectedEdge e : adj(v)) {
                    s.append(e + "  ");
                }
                s.append(NEWLINE);
            }
            return s.toString();
        }


    }

    static class DirectedEdge {
        private final int v;
        private final int w;
        private final double weight;

        /**
         * Initializes a directed edge from vertex <tt>v</tt> to vertex <tt>w</tt> with
         * the given <tt>weight</tt>.
         * @param v the tail vertex
         * @param w the head vertex
         * @param weight the weight of the directed edge
         * @throws IndexOutOfBoundsException if either <tt>v</tt> or <tt>w</tt>
         *    is a negative integer
         * @throws IllegalArgumentException if <tt>weight</tt> is <tt>NaN</tt>
         */
        public DirectedEdge(int v, int w, double weight) {
            if (v < 0) throw new IndexOutOfBoundsException("Vertex names must be nonnegative integers");
            if (w < 0) throw new IndexOutOfBoundsException("Vertex names must be nonnegative integers");
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        /**
         * Returns the tail vertex of the directed edge.
         * @return the tail vertex of the directed edge
         */
        public int from() {
            return v;
        }

        /**
         * Returns the head vertex of the directed edge.
         * @return the head vertex of the directed edge
         */
        public int to() {
            return w;
        }

        /**
         * Returns the weight of the directed edge.
         * @return the weight of the directed edge
         */
        public double weight() {
            return weight;
        }

        /**
         * Returns a string representation of the directed edge.
         * @return a string representation of the directed edge
         */
        public String toString() {
            return v + "->" + w + " " + String.format("%5.2f", weight);
        }
    }


    }

