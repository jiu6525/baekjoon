import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {

        int x, y,weight;

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", weight=" + weight +
                    '}';
        }
    }

    static BufferedReader br;
    static StringTokenizer st;
    static int n = -1,cnt = 1;
    static int[][] arr;
    static int[][] distance;
    static final int INF = Integer.MAX_VALUE;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            n = Integer.parseInt(br.readLine());

            if(n == 0){
                break;
            }

            arr = new int[n][n];
            distance = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(distance[i], INF);
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            print();

            dijkstra();
            System.out.printf("Problem %d: %d\n",cnt++, distance[n-1][n-1]);

        }

    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[0][0] = arr[0][0];
        pq.offer(new Node(0,0,arr[0][0]));

        while (!pq.isEmpty()){
            Node p = pq.poll();
            for (int[] d : dir) {
                int dx = p.x + d[0];
                int dy = p.y + d[1];

                if(dx<0 || dx>=n || dy<0 || dy>=n){
                    continue;
                }

                if(distance[dx][dy] > distance[p.x][p.y] + arr[dx][dy]){
                    distance[dx][dy] = distance[p.x][p.y] + arr[dx][dy];
                    pq.offer(new Node(dx,dy,distance[dx][dy]));
                }
            }
        }
    }
}