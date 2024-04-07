import java.io.*;
import java.util.*;

public class Solution {
    static class Node implements Comparable<Node> {
        int x, y,weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static BufferedReader br;
    static StringTokenizer st;
    static int t,r,c,k;
    static int[][] arr, distance;
    static int ans;
    static final int INF = Integer.MAX_VALUE;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            r = Integer.parseInt(br.readLine());

            arr = new int[r][r];
            distance = new int[r][r];

            for (int i = 0; i < r; i++) {
                String word = br.readLine();
                Arrays.fill(distance[i], INF);
                for (int j = 0; j < r; j++) {
                    arr[i][j] = Integer.parseInt(String.valueOf(word.charAt(j)));
                }
            }
//            print(arr);
            dijkstra();
            System.out.printf("#%d %d\n",tc,distance[r-1][r-1]);
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

                if(dx<0 || dx>=r || dy<0 || dy>=r){
                    continue;
                }

                if(distance[dx][dy] > distance[p.x][p.y] + arr[dx][dy]){
                    distance[dx][dy] = distance[p.x][p.y] + arr[dx][dy];
                    pq.offer(new Node(dx,dy,distance[dx][dy]));
                }
            }
        }
}

    private static void print(int[][] map) {
        for (int[] lst : map) {
            System.out.println(Arrays.toString(lst));
        }

    }
}