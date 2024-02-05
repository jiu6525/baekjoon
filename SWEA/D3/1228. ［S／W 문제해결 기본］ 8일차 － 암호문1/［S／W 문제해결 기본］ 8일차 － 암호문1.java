import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	for(int start = 1; start<=10; start++) {
			n = Integer.parseInt(br.readLine());
			List<Integer> arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				String w = st.nextToken();
				
				if(w.equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int m = Integer.parseInt(st.nextToken());
					List<Integer> lst = new ArrayList<>();
					for (int k = 0; k < m; k++) {
						lst.add(Integer.parseInt(st.nextToken()));
					}
					for (Integer val : lst) {
						arr.add(idx++,val);
					}
				}
			}
		
		
			System.out.printf("#%d ",start);
			for(int i = 0; i<10; i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
    	}
    }
}

//11
//449047 855428 425117 532416 358612 929816 313459 311433 472478 589139 568205 
//7
//I 1 5 400905 139831 966064 336948 119288 I 8 6 436704 702451 762737 557561 810021 771706 I 3 8 389953 706628 552108 238749 661021 498160 493414 377808 I 13 4 237017 301569 243869 252994 I 3 4 408347 618608 822798 370982 I 8 2 424216 356268 I 4 10 512816 992679 693002 835918 768525 949227 628969 521945 839380 479976 