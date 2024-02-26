//package jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int weight;
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static BufferedReader br;
	static StringTokenizer st;
	static int V,E;
	static List<Node> edgeList;
	static int[] set;
	public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        
        edgeList = new ArrayList<>();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Node(from-1, to-1, weight));
		}
        
        //print(edgeList);
        
        Collections.sort(edgeList);
        makeSet();
        int c = 0;
        int ans = 0;
        for (Node node : edgeList) {
			if(!union(node.from, node.to)) {
				continue;
			}
			
			ans += node.weight;
			if(++c == V) {
				break;
			}
		}
        
        System.out.println(ans);
	}
	private static boolean union(int from, int to) {
		int a = find(from);
		int b = find(to);
		if(a==b) {
			return false;
		}
		set[b] = a;
		return true;
	}
	private static int find(int to) {
		if(set[to] == to) {
			return set[to];
		}
		return set[to] = find(set[to]);
	}
	private static void makeSet() {
		set = new int[V];
		for (int i = 0; i < V; i++) {
			set[i] = i;
		}
		
	}
	private static void print(List<Node> edgeList2) {
		for (Node node : edgeList2) {
			System.out.println(node);
		}
		
	}
}