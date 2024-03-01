import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static class Corner {
        int x, y, num;

        public Corner(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static BufferedReader br;
    static StringTokenizer st;
    static int n, m, V, E, ans, nodeCnt;
    static int[][] arr, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    ;
    static int cnt = 2;
    static int[] set;
    static boolean[][] v;
    static List<Corner> corner_lst;
    static List<Node> edgeList;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        v = new boolean[n][m];
        corner_lst = new ArrayList<>();
        edgeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0 && !v[i][j]) {
                    cornerCheck(i, j);
                }
            }
        }

        makeEdgeList();
        Collections.sort(edgeList);
        V = cnt - 2;
        E = edgeList.size();
        makeSet();
        ans = kruskal();
        System.out.println(nodeCnt != V - 1 ? -1 : (ans == 0 ? -1 : ans));
    }

    private static void makeEdgeList() {
        for (int i = 0; i < corner_lst.size(); i++) {
            for (int j = i + 1; j < corner_lst.size(); j++) {
                Corner island1 = corner_lst.get(i);
                Corner island2 = corner_lst.get(j);
                getDistance(island1.x, island2.x, Math.min(island1.y, island2.y), Math.max(island1.y, island2.y),
                        island1.num - 2, island2.num - 2, true);
                getDistance(island1.y, island2.y, Math.min(island1.x, island2.x), Math.max(island1.x, island2.x),
                        island1.num - 2, island2.num - 2, false);
            }
        }
    }

    private static void getDistance(int x, int nx, int y, int ny, int num1, int num2, boolean ck) {
        if (x == nx && num1 != num2) {
            if (bridgeCheck(x, y, ny, ck)) {
                int dis = Math.abs(y - ny) - 1;
                if (dis >= 2) {
                    edgeList.add(new Node(num1, num2, dis));
                }
            }
        }
    }

    private static boolean bridgeCheck(int x, int dy, int ny, boolean direction) {
        for (int i = dy + 1; i < ny; i++) {
            if (direction) {
                if (arr[x][i] != 0) {
                    return false;
                }
            } else {
                if (arr[i][x] != 0) {
                    return false;
                }
            }
        }
        return true;

    }

    private static void cornerCheck(int i, int j) {
        for (int[] d : dir) {
            int nx = i + d[0];
            int ny = j + d[1];

            if (!check(nx, ny)) {
                continue;
            }

            if (arr[nx][ny] == 0 && !v[i][j]) {
                v[i][j] = true;
                corner_lst.add(new Corner(i, j, arr[i][j]));
            }
        }
    }

    private static void dfs(int i, int j) {
        if (check(i, j)) {
            if (arr[i][j] == 1) {
                arr[i][j] = cnt;

                dfs(i, j + 1);
                dfs(i + 1, j);
                dfs(i, j - 1);
                dfs(i - 1, j);
            }
        }
    }

    private static boolean check(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }

    private static int kruskal() {
        makeSet();
        nodeCnt = 0;
        int ans = 0;
        for (Node node : edgeList) {
            if(!union(node.from, node.to)){
                continue;
            }

            ans += node.weight;

            if(++nodeCnt == V-1){
                break;
            }
        }
        return ans;
    }

    private static boolean union(int from, int to) {
        int a = find(from);
        int b = find(to);
        if(a == b){
            return false;
        }

        set[a] = b;
        return true;
    }

    private static void makeSet() {
        set = new int[V+1];
        for (int i = 0; i < V+1; i++) {
            set[i] = i;
        }
    }

    private static int find(int from) {
        if(set[from] == from){
            return set[from];
        }
        return set[from] = find(set[from]);
    }
}