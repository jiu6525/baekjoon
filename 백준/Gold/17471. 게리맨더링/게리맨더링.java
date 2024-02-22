import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 17471 게리멘더링
// 구역을 2개로 나뉘어서 파워셋 사용하기
// 부분집합을 0 과 마지막 꺼(Math.pow(2,n))랑 하면 2개의 지역
// 나눈 구역에 대해 bfs 로 연결확인 인접리스트를 구현
// 연결이 가능한 지역이라면 사람이 들어있는 배열의 값을통해 인구차 계산
public class Main {
    static int[] nums;
    static BufferedReader br;
    static StringTokenizer st;
    // 최대 원소의 개수
    static int max_cnt, ans = Integer.MAX_VALUE;
    // 각 부분 집합을 저장할 배열
    static int[] subset;
    static List<int[]> ward;
    static int n;
    static boolean[] v;
    static List<List<Integer>> arr;
    static int[] people;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ward = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
//        nums = { 1, 2, 3,4,5,6 };
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        for (int i = 0; i <= n; i++) {
            max_cnt = i;
            subset = new int[i];
            getWard(0, 0);      //0 개부터 6개 까지의 부분집합을 구하기
        }

        people = new int[n+1];      // 1부터 시작하는 인구수를 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        arr = new ArrayList<>();
        for(int i = 0; i<n+1; i++) {
            arr.add(i, new ArrayList<>());
        }

        // 연결이 되어있는지 확인을 위한 인접리스트 생성
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

        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
    }

    private static int getPeopleCount(int[] a) {
        int cnt = 0;
        for (int i : a) {
            cnt += people[i];
        }
        return cnt;
    }

    static boolean check(int[] group) {
        Queue<Integer> queue = new ArrayDeque<>();
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

        for (int g : group) {
            if (!v[g]) {
                return false;
            }
        }

        return true;
    }

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
        for (int i = k; i < nums.length; i++) {
            subset[cnt] = nums[i];
            getWard(cnt + 1, i + 1);
        }

    }
}