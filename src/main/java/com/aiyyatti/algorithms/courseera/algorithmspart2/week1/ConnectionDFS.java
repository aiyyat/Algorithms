package com.aiyyatti.algorithms.courseera.algorithmspart2.week1;

/**
 * TODO: 1) TIPS Instead of returning connection path the path can be found by back tracking an array
 *          each element represents a link to its parent.
 *       2) can answer the question in O(1) if you do a preprocessing and create a structure similar to
 *          union find.
 */
public class ConnectionDFS {
    private Graph graph;
    private boolean[] visiteds;

    public ConnectionDFS(Graph graph) {
        this.graph = graph;
        visiteds = new boolean[graph.E];
    }

    /**
     * Time Complexity: O(V)
     * Space Complexity: O(V)
     *
     * @param start
     * @param end
     * @return
     */
    public ConnectionPath getConnectionPath(int start, int end) {
        if (!visiteds[start]) {
            visiteds[start] = true;
            if (start == end) return new ConnectionPath(end, null);
            for (Integer neighbour : graph.neighboursOf(start)) {
                ConnectionPath path = getConnectionPath(neighbour, end);
                if (path != null) return new ConnectionPath(start, path);
            }
        }
        return null;
    }

    class ConnectionPath {
        int data;
        ConnectionPath connection;

        public ConnectionPath(int data, ConnectionPath connection) {
            this.data = data;
            this.connection = connection;
        }

        @Override
        public String toString() {
            return data + " " + (connection != null ? connection.toString() : "").trim();
        }
    }
}
