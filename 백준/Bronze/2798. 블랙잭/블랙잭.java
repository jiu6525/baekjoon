import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


//5 21
//5 6 7 8 9

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        List<List<Integer>> combinations = combination(arr, 3);
        List<Integer> ansLst = new ArrayList<>(); 
        
        for (List<Integer> combination : combinations) {
        	int sum = combination.stream().mapToInt(Integer::intValue).sum();
        	ansLst.add(sum);
        }
        Collections.sort(ansLst, Collections.reverseOrder());
        
        for (Integer ans : ansLst) {
			if(ans<=m) {
				System.out.println(ans);
				break;
			}
		}
    }

    private static List<List<Integer>> combination(int[] arr, int r) {
        List<List<Integer>> result = new ArrayList<>();
        combinationHelper(arr, 0, new ArrayList<>(), r, result);
        return result;
    }

    private static void combinationHelper(int[] arr, int start, List<Integer> current, int r, List<List<Integer>> result) {
        if (r == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            combinationHelper(arr, i + 1, current, r - 1, result);
            current.remove(current.size() - 1);
        }
    }
}