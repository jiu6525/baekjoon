import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n,m,k;
    static String s;
    static boolean[] bfs_visited;
    static boolean[] dfs_visited;
    static List<List<Integer>> arr;
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs_visited = new boolean[n+1];
        dfs_visited = new boolean[n+1];


        arr = new ArrayList<>();
        for(int i = 0; i<n+1; i++) {
            arr.add(i, new ArrayList<>());
        }

        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);

        }

        // 정점이 여러개인 경우에는 번호가 작은것 먼저
        for(int i = 0; i<n+1; i++) {
            Collections.sort(arr.get(i));
        }


        dfs(k);
        System.out.println();
        bfs(k);





    }
    private static void dfs(int v) {
        dfs_visited[v] = true;
        System.out.print(v + " ");
        for (Integer idx : arr.get(v)) {
            if(!dfs_visited[idx]) {
                dfs(idx);
            }
        }

    }

    private static void bfs(int v) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        bfs_visited[v] = true;
        while(!q.isEmpty()) {
            Integer x = q.poll();
            System.out.print(x + " ");
            for (Integer idx : arr.get(x)) {
                if(!bfs_visited[idx]) {
                    q.offer(idx);
                    bfs_visited[idx] = true;
                }
            }
        }
    }




}