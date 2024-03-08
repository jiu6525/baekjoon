import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int x;

		public Node(int x) {
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + "]";
		}

		@Override
		public int compareTo(Node o) {
			
			return -Integer.compare(Math.abs(this.x), Math.abs(o.x));
		}
	}
    static BufferedReader br;
    static StringTokenizer st;
    static int n,ans;
    static Integer[] arr;
    static PriorityQueue<Node> pq;
    static PriorityQueue<Node> mq;
//	양수와 음수를 다로 입력받자
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Integer[n];
        pq = new PriorityQueue<>();
        mq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	if(num > 0) {
        		pq.add(new Node(num));
        	}else {
        		mq.add(new Node(num));
        	}
			
		}
//        print();
//        while(!mq.isEmpty()) {
//        	System.out.println(mq.poll());
//        }
        cal(pq);
        cal(mq);
        
        int tmp1 = 0;
        int tmp2 = 0;
        if(!pq.isEmpty()) {
        	tmp1 = pq.poll().x;
        }
        
        if(!mq.isEmpty()) {
        	tmp2 = mq.poll().x;
        }
        
        ans += tmp1 + tmp2;
        System.out.println(ans);
    }
private static void cal(PriorityQueue<Node> q) {
	while(q.size()>1) {
		Node p1 = q.poll();
		Node p2 = q.poll();
		if(p1.x==1||p2.x==1) {
			ans += p1.x+p2.x;
		}else {
			ans += p1.x*p2.x;
		}
	}
}
	private static void print() {
		for (Node n: pq) {
			System.out.println(n);
		}
		System.out.println();
		for (Node n: mq) {
			System.out.println(n);
		}
		System.out.println();
	}
}