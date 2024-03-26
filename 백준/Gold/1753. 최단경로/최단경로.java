import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int from,to,weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node [from=" + from + ", to=" + to + ", weight=" + weight + "]";
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }

    }

    static BufferedReader br;
    static StringTokenizer st;
    static int V,E;
    static int k;
    static List<List<Node>> lst;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        lst = new ArrayList<>();

        for (int i = 0; i < V+1; i++) {
            lst.add(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lst.get(from).add(new Node(from, to, weight));
        }

//        print();
        prim();
    }
    private static void prim() {
        boolean[] v = new boolean[V+1];
        int[] minEdge = new int[V+1];

        Arrays.fill(minEdge, INF);
        minEdge[k] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(k, minEdge[k]));

        int c = 0;
        int min = 0;
        while(!q.isEmpty()) {
            Node minVertex = q.poll();

            if(v[minVertex.to]) {
                continue;
            }

            min = minVertex.weight;
            v[minVertex.to] = true;

            if(++c == V) {
                break;
            }

            List<Node> nodes = lst.get(minVertex.to);
            for (int i = 0; i < nodes.size(); i++) {
                if(!v[nodes.get(i).to] && min+nodes.get(i).weight < minEdge[nodes.get(i).to]) {
                    minEdge[nodes.get(i).to] = min+nodes.get(i).weight;
                    q.offer(new Node(nodes.get(i).to,minEdge[nodes.get(i).to]));
                }
            }


        }

        for (int i = 1; i < minEdge.length; i++) {
            System.out.println(minEdge[i] == INF? "INF" : minEdge[i]);
        }

    }
    private static void print() {
        for (List<Node> list : lst) {
            System.out.println(list);
        }
    }
}