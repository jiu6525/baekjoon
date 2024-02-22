import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 17471 게리멘더링
// 구역을 2개로 나뉘어서 부분집합 사용하기
// 부분집합을 0 과 마지막 꺼(Math.pow(2,n))랑 하면 2개의 지역
// 나눈 구역에 대해 bfs 로 연결확인 -> 인접리스트를 구현
// 연결이 가능한 지역이라면 사람이 들어있는 배열의 값을통해 인구차 계산
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int max_cnt, ans = Integer.MAX_VALUE;
    static int n;
    static List<int[]> ward;
    static boolean[] v;
    static List<List<Integer>> arr;
    static int[] people,subset,node;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ward = new ArrayList<>();
        n = Integer.parseInt(br.readLine());


//      0 개부터 6개 까지의 부분집합을 구하기
//      node = { 1, 2, 3,4,5,6 };
        node = new int[n];
        for (int i = 0; i < n; i++) {
            node[i] = i+1;
        }
        for (int i = 0; i <= n; i++) {
            max_cnt = i;
            subset = new int[i];
            getWard(0, 0);
        }

        // 1부터 시작하는 인구수를 저장
        people = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        // 연결이 되어있는지 확인을 위한 인접리스트 생성
        arr = new ArrayList<>();
        for(int i = 0; i<n+1; i++) {
            arr.add(i, new ArrayList<>());
        }

        for(int i = 1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr.get(i).add(a);
            }
        }

//        for (int[] ints : ward) {
//            System.out.print(Arrays.toString(ints));
//        }
        getSolve();
        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
    }

    private static void getSolve() {
        //      Math.pow(2,n) 만큼의 부분집합 생성
//      ex) 64/2 만큼의 짝을 지어줌
        int start = 0;
        int end = (int)Math.pow(2,n) - 1;

        while(start<end){
            start++;
            end--;
            int[] a = ward.get(start);      // a 그룹
            int[] b = ward.get(end);        // b 그룹

            if(check(a) && check(b)){
                // 연결된 그룹이라면 인구수의 최고값을 구함
//                System.out.println(Arrays.toString(a));
//                System.out.println(Arrays.toString(b));
                int a_cnt = getPeopleCount(a);
                int b_cnt = getPeopleCount(b);
                ans = Math.min(ans,Math.abs(a_cnt-b_cnt));
            }
        }
    }

    private static int getPeopleCount(int[] a) {
        int cnt = 0;
        for (int i : a) {
            cnt += people[i];
        }
        return cnt;
    }

//  그룹사람들이 연결되어 있는지 확인하는 메서드
//  백준 dfs bfs 문제처럼
    static boolean check(int[] group) {
        Queue<Integer> queue = new LinkedList<>();
        v = new boolean[n + 1];
        v[group[0]] = true;         //첫번째 값을 넣어서 연결된지 확인 0번째 인덱스 부터 쭉
        queue.offer(group[0]);

        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            for (int i : arr.get(p)) {
                if (!v[i] && checkContains(group,i)) {
                    v[i] = true;
                    queue.offer(i);
                }
            }
        }

        // 방문배열 확인해서 안간곳이있으면
//      따른 그룹
        for (int k : group) {
            if (!v[k]) {
                return false;
            }
        }
        return true;
    }

//  i의 값이 있는지 확인하는 메서드 있어야 연결이지
    private static boolean checkContains(int[] group, int i) {
            for (int g : group) {
                if(g == i){
                    return true;
            }
        }
        return false;
    }

    private static void getWard(int cnt, int k) {
        if (cnt == max_cnt) {
//            System.out.println(Arrays.toString(subset));
            ward.add(Arrays.copyOf(subset, subset.length));     //배열 참조로 복사해서 넣어야 함,,
            return;
        }

        for (int i = k; i < node.length; i++) {
            subset[cnt] = node[i];
            getWard(cnt + 1, i + 1);
        }
    }
}