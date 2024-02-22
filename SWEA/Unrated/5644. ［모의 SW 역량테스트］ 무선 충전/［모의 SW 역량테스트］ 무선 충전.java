//package jiu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//import jiu.Solution.BcNum;

public class Solution {
	static class Bc{
		int r;
		int c;
		int number;
		
		public Bc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class User{
		int x;
		int y;
		
		public User(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class BcNum{
		int power;
		int number;
		public int getPower() {
			return power;
		}
		
		public int getNumber() {
			return number;
		}

		public BcNum(int power, int number) {
			this.power = power;
			this.number = number;
		}

		@Override
		public String toString() {
			return "BcNum [power=" + power + ", number=" + number + "]";
		}
	}
	

	static BufferedReader br;
	static StringTokenizer st;
	static int  t,m,a,ans;
	static int user_a_idx,user_b_idx; 
	static int size = 10;
	static int[][] go,battery;	// 0번은 a의 이동 1번은 b의 이동
	static ArrayList<BcNum>[][] arr;
	
//							
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("src/jiu/Solution.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()) +1;
			int a = Integer.parseInt(st.nextToken());
			newArr();
			
			go = new int[2][m];
			battery = new int[a][4];
			
//			area = new ArrayList<>();
//			for (int i = 0; i < a; i++) {
//				area.add(i, new ArrayList<>());
//			}
//
////			번호에 따른 배터리의 좌표를 저장할 배열
//			area.get(0).add(new int[] {1,1});
//			System.out.println(area);
//			
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < m; j++) {
					go[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			print2(go);
			
			
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					battery[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			print(battery);
			
//			4 4 1 100
//			7 10 3 40
			
//			6 3 2 70
			Arrays.sort(battery, Comparator.comparingInt((int[] bt) -> bt[3]).reversed());
			for (int i = 0; i < a; i++) {
				int x = battery[i][0];
				int y = battery[i][1];
				int c = battery[i][2];
				int p = battery[i][3];
				flood_fill(y-1,x-1,c,p, i);
			}
//			print(arr);
			
			ans = 0;
			
			User user_a = new User(0,0);
			User user_b = new User(size-1,size-1);
			
			for (int i = 0; i < m; i++) {

				int a_num = 0;
				int b_num = 0;
				int user_a_go = go[0][i];
				int user_b_go = go[1][i];
				
				int nxa = user_a.x + user_dir[user_a_go][0];
				int nya= user_a.y + user_dir[user_a_go][1];
				
				int nxb = user_b.x + user_dir[user_b_go][0];
				int nyb = user_b.y + user_dir[user_b_go][1];
				
//				System.out.println("--------------");
//				System.out.println(nxa + " " + nya);
//				System.out.println();
//				System.out.println(nxb + " " + nyb);
//				System.out.println("--------------");
				
				int a_len = arr[nxa][nya].size();
				int b_len = arr[nxb][nyb].size();
//				둘다 충전이 가능할 경우
//				같은 부분에 있는경우

				if(a_len != 0 && b_len != 0) {
					BcNum abc = arr[nxa][nya].get(0);
					BcNum bbc = arr[nxb][nyb].get(0);
//					신경쓸 부분
//					각자 배터리에 있을경우 배열의 값을 얻어와서 값 누적
//					없을경우 무시
//					하나의 배터리에 두명이 있다면 좌표 비교를 통해 좌표가 같다면
//					[그림 2]에서 T=11일 때, 사용자 A는 BC 1과 3 둘 중 하나에 접속이 가능하다. 
//					같은 시간에 사용자 B는 BC 1에 접속할 수 밖에 없다. 
//					따라서 사용자 A가 같은 BC 1에 접속한다면 충전되는 양를 반씩 나눠 갖게 되어 비효율적이다. 
//					따라서 사용자 A가 BC 3에 접속하는 것이 더 이득이다.
					
					
//					같은 값을 바라보고 있다면 배열의 다음값에 접근
//					값을 두개를 비교해서 같다면 사이즈 체크 후 값 변경
//					만약에 같다면 while문 돌리면 좋을듯
					
//					둘다 사이즈가 하나 이상일때	 -> 어짜피 사람이 2명이니까 바로 다음꺼 ㄱㄱ
//					하나는 하나이고 하나는 둘 이상일때
//					둘다 하나일대
					
//					현재 배열의 0번째 값이 같다면
//					길이가 2개씩 있을때 1번재 값을 비교해서 큰쪽의 값을 넣어줌
//					하나는 길이가 한개이고 나머지는 길이가 많을때
//					번호가 같은 경우
					
//					if(abc.number == bbc.number) {
//						if(a_len && b_len) {
//							ans += abc
//						}
//					}
//					}else {
//					}
					
					
					
					
					if(abc.power == bbc.power) {
//						다른 배터리 인데 파워가 같은경우라면
						if(abc.number != bbc.number) {
							a_num = abc.power;
							b_num = bbc.power;
						}else if(a_len > 1 && b_len == 1) {
							a_num = arr[nxa][nya].get(1).power;
							b_num = arr[nxb][nyb].get(0).power;
						}else if(a_len == 1 && b_len > 1) {
							a_num = arr[nxa][nya].get(0).power;
							b_num = arr[nxb][nyb].get(1).power;
							
//						같은 곳을 바라볼때
						}else if(a_len > 1 && b_len>1) {
							if(arr[nxa][nya].get(1).power > arr[nxb][nyb].get(1).power){
								a_num = arr[nxa][nya].get(1).power;
								b_num = arr[nxb][nyb].get(0).power;
							}else if(arr[nxa][nya].get(1).power <= arr[nxb][nyb].get(1).power){
								a_num = arr[nxa][nya].get(0).power;
								b_num = arr[nxb][nyb].get(1).power;
							}
						}
							else if(abc.number == bbc.number){	// 같은 배터리를 공유하고 있는 경우라면
							ans += abc.power;
						}
					}else {// 하나는 사이즈가 없고 하나는 있을때 ->
						a_num = abc.power;
						b_num = bbc.power; 
					}
					
					
				}else if(a_len == 0 && b_len != 0) {	
					b_num = arr[nxb][nyb].get(0).power;
				}else if(a_len != 0 && b_len == 0) {	
					a_num = arr[nxa][nya].get(0).power;
				}
				
				ans += a_num + b_num;
				user_a = new User(nxa,nya);
				user_b = new User(nxb,nyb);
//				System.out.println("---------");
//				System.out.print(i + " " + a_num + " "  + b_num +"\n");
//				System.out.println("---------");
				
				
			}
//			go[0][1];
			System.out.printf("#%d %d\n",tc,ans);
		}// end
	}
//								0 이동하지 않음, 1 상, 2 우, 3 하, 4 좌	
	static int[][] user_dir = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	
	private static void print2(int[][] go) {
		for (int[] lst : go) {
			System.out.println(Arrays.toString(lst));
		}
		
	}


	@SuppressWarnings("unchecked")
	private static void newArr() {
		arr = new ArrayList[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
	}

//	좌표, 배터리의 범위, 출력
	private static void flood_fill(int x, int y, int c, int p, int i) {
		int tmp[][] = new int[size][size];
		int cnt = 0;
		
		Queue<Bc> q = new LinkedList<>();
		tmp[x][y] = 1;
		arr[x][y].add(new BcNum(p,i));
		q.offer(new Bc(x,y));
		
		
		while(!q.isEmpty()) {
			Bc bc = q.poll();
			if(tmp[bc.r][bc.c] == c+1) {
				break;
			}
			
			for (int[] d : dir) {
				int nx = bc.r + d[0];
				int ny = bc.c + d[1];
				
				if(nx<0 || nx>=size || ny<0 || ny>=size) {
					continue;
				}
				
				if(tmp[nx][ny] != 0) {
					continue;
				}
				
				tmp[nx][ny] = tmp[bc.r][bc.c] + 1;
				arr[nx][ny].add(new BcNum(p,i));
//				area.get(bnum).add(new int[] {nx,ny});
				if(tmp[nx][ny] > cnt) {
					cnt = tmp[nx][ny];
				}
				q.offer(new Bc(nx,ny));
			}
		}
		
//		for (int[] asd : tmp) {
//			System.out.println(Arrays.toString(asd));
//		}
	}
	
	private static void print(ArrayList<BcNum>[][] arr) {
		for (ArrayList<BcNum>[] lst : arr) {
			for (ArrayList<BcNum> l : lst) {
				System.out.print(l + "\t");
			}
			System.out.println();
		}
		
		
	}
}