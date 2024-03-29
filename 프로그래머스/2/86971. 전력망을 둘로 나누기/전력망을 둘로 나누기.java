import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
		List<List<Integer>> arr = new ArrayList<>();
		int size = n+1;
		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < wires.length; i++) {
			arr = idj(arr, size);
			for (int j = 0; j < wires.length; j++) {
				if(i!=j) {
					int[] l = wires[j];
					arr.get(l[0]).add(l[1]);
					arr.get(l[1]).add(l[0]);
				}
			}
			Set<Integer> set = new HashSet<>();
			
			for (int k = 1; k < size; k++) {
				if(set.size() == 2) {
			        Integer[] diff = set.toArray(new Integer[0]);
			        ans = Math.min(ans, Math.abs(diff[0] - diff[1]));
					break;
				}
				int dfs = dfs(arr,k,new boolean[arr.size()]);
				set.add(dfs);
			}
            if(set.size() == 1) {
				ans = 0;
			}
		}
		System.out.println(ans);
        return ans;
	}


	private static List<List<Integer>> idj(List<List<Integer>> arr, int size) {
		arr.clear();
		for (int i = 0; i < size; i++) {
			arr.add(i,new ArrayList<>());
		}
		return arr;
	}
	
	
	private static int dfs(List<List<Integer>> graph, int v, boolean[] visited) {
		visited[v] = true;
		int cnt = 1;
		for (Integer i : graph.get(v)) {
			if(!visited[i]) {
				cnt += dfs(graph,i,visited);
			}
		}
		return cnt;
		
	}
}