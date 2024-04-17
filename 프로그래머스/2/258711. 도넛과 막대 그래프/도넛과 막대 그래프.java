import java.util.*;

class Solution {
    static List<List<Integer>> idjList;
    static int[] outList;
    static int graphSize;
    static int[] ans = new int[4];;
    static int graphCnt;
    static Set<Integer> s = new HashSet<>();
    public int[] solution(int[][] edges) {
        makeGraph(edges);
        return ans;
    }
    
    private static void makeGraph(int[][] edges) {
        int mx = 0;
        for (int[] edge : edges) {
            mx = Math.max(edge[0], edge[1]);
            s.add(edge[0]);
            s.add(edge[1]);
            graphSize = Math.max(mx,graphSize);
        }
//        System.out.println(graphSize);

        idjList = new ArrayList<>();
        for (int i = 0; i <= graphSize; i++) {
            idjList.add(i, new ArrayList<>());
        }

        outList = new int[graphSize+1];
        
        for (int[] edge : edges) {
            idjList.get(edge[0]).add(edge[1]);
            outList[edge[1]]++;
        }
        
        // 나가는 얘 만들고 시작 정점 없애고 나가는 리스트 재탕
        ans[0] = findStartVertex();
//        System.out.println(Arrays.toString(ans));

        outList = new int[graphSize+1];
        for (int i = 1; i <= graphSize; i++) {
            for (Integer v : idjList.get(i)) {
                outList[v]++;
            }
        }


//        System.out.println(idjList);
//        System.out.println(Arrays.toString(outList));

        cal();
//        System.out.println(Arrays.toString(ans));

    }
    
    // [시작, 도넛, 막대, 8자]
// 막대 -> 나가는게 없고 들어오는게 없는 정점의 수
// 8자 -> 들어오는 간선 2개 나가는 간선 2개인 정점의 수
// 도넛 -> 그래프의 개수에서 - 막대 - 8자
    private static void cal() {
        ans[2] = findBar();
        ans[3] = findEight();
        ans[1] = graphCnt - ans[2] - ans[3];
    }

    private static int findEight() {
        int eight = 0;
        for (int i = 1; i <= graphSize; i++) {
            if(idjList.get(i).size() == 2 && outList[i] == 2){
                eight++;
            }
        }

//        System.out.println(eight);
        return eight;
    }

        private static int findBar() {
        int bar = 0;
        for (int i = 1; i <= graphSize; i++) {
            if(i == ans[0]){
                continue;
            }
            
//          size 1 일때
            if(idjList.get(i).size() == 0 && outList[i] == 0 && s.contains(i)){
                bar++;
            }

            if(idjList.get(i).size() == 1 && outList[i] == 0){
                bar++;
            }
        }

//        System.out.println(bar);
        return bar;
    }


    private static int findStartVertex() {
        int startVertex = 0;
        // 시작정점은 나가는 간선이 2개 이상이고 들어오는 간선이 없어야함
        for (int i = 1; i <= graphSize; i++) {
            if(idjList.get(i).size() >= 2 && outList[i] == 0){
                startVertex =  i;
            }
        }

        // 그래프 개수 구하기
        graphCnt = idjList.get(startVertex).size();

        // 찾으면 리스트에서 시작정점 제거
        idjList.set(startVertex, new ArrayList<>());

        return startVertex;
    }
}