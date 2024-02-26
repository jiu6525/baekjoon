//package jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
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
	static List<List<Node>> adjList;
	public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/jiu/Main.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        
        adjList = new ArrayList<>();
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < V; i++) {
        	adjList.add(i, new ArrayList<>());
		}
        
        for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(new Node(from,to,weight));
			adjList.get(to).add(new Node(to,from,weight));
		}
        
        //print(adjList);
        prim(adjList);
//        Collections.sort(edgeList);
        
	}


	private static void prim(List<List<Node>> adjList) {
		boolean[] v = new boolean[V];
		int[] minEdge = new int[V];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(0, minEdge[0]));
		
		int c = 0;
		int ans = 0;
		while(!q.isEmpty()) {
			Node minVertex = q.poll();
			
			if(v[minVertex.to]) {
				continue;
			}
			
			ans += minVertex.weight;
			v[minVertex.to] = true;
			
			if(++c == V) {
				break;
			}
			
			List<Node> nodes = adjList.get(minVertex.to);
			for (int i = 0; i < nodes.size(); i++) {
				if(!v[nodes.get(i).to] && nodes.get(i).weight < minEdge[nodes.get(i).to]) {
					minEdge[nodes.get(i).to] = nodes.get(i).weight;
					q.offer(new Node(nodes.get(i).to,minEdge[nodes.get(i).to]));
				}
			}
		}
		
		System.out.println(ans);
	}


	private static void print(List<List<Node>> edgeList2) {
		for (List<Node> list : edgeList2) {
			System.out.println(list);
		}
	}
}