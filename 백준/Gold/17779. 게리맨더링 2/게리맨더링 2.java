import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] A, map;
	static List<int[]> V = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	
	public static void main(String args[]) throws IOException{
//		BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new int[N][N];
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				for(int d1 = 1 ; d1 < N ; d1++) {
					for(int d2 = 1 ; d2 < N ; d2++) {
						if(vaild(i, j, d1, d2)) {
							V.add(new int[] {i, j, d1, d2});
						}
					}
				}
			}
		}
		
		for(int[] cv : V) {
			int x = cv[0];
			int y = cv[1];
			int d1 = cv[2];
			int d2 = cv[3];
			int fifth = 0;
			
			for(int i = x, j = y ; i <= x + d1 && j >= y - d1 ; i++, j--) {
				map[i][j] = 5;
			}
			
			for(int i = x, j = y ; i <= x + d2 && j <= y + d2 ; i++, j++) {
				map[i][j] = 5;
			}
			
			for(int i = x + d1, j = y - d1 ; i <= x + d1 + d2 && j <= y - d1 + d2 ; i++, j++) {
				map[i][j] = 5;
			}
			
			for(int i = x + d2, j = y + d2 ; i <= x + d1 + d2 && j >= y + d2 - d1 ; i++, j--) {
				map[i][j] = 5;
			}
			
			
			
			maxQ.add(first(x, y, d1));
			maxQ.add(second(x, y, d2));
			maxQ.add(third(x, y, d1, d2));
			maxQ.add(fourth(x, y, d1, d2));
			
			minQ.add(first(x, y, d1));
			minQ.add(second(x, y, d2));
			minQ.add(third(x, y, d1, d2));
			minQ.add(fourth(x, y, d1, d2));
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(map[i][j] == 0 || map[i][j] == 5) fifth += A[i][j];
				}
			}
			
			maxQ.add(fifth);
			
			minQ.add(fifth);
			
			result = Math.min(result, maxQ.poll() - minQ.poll());
			
			maxQ.clear();
			minQ.clear();
			
			for(int[] m : map) {
				Arrays.fill(m, 0);
			}
		}
		
		System.out.print(result);
	}
	
	static boolean vaild(int x, int y, int d1, int d2) {
		if(x < 0 || y < 0 || x >= N || y >= N) return false;
		if(x + d1 < 0 || y - d1 < 0 || x + d1 >= N || y - d1 >= N) return false;
		if(x + d2 < 0 || y + d2 < 0 || x + d2 >= N || y + d2 >= N) return false;
		if(x + d1 + d2 < 0 || y - d1 + d2 < 0 || x + d1 + d2 >= N || y - d1 + d2 >= N) return false;
		if(d1 < 1 || d2 < 1) return false;
		return true;
	}
	
	static int first(int x, int y, int d1) {
		int sum = 0;
		
		for(int i = 0; i < x + d1 ; i++) {
			for(int j = 0 ; j <= y ; j++) {
				if(map[i][j] != 5) {
					sum += A[i][j];
					map[i][j] = 1;
				} else {
					y--;
					break;
				}
			}
		}
		
		return sum;
	}
	
	static int second(int x, int y, int d2) {
		int sum = 0;
		
		for(int i = 0; i <= x + d2 ; i++) {
			for(int j = y + 1 ; j < N ; j++) {
				if(map[i][j] != 5) {
					sum += A[i][j];
					map[i][j] = 2;
				} else {
					y++;
					continue;
				}
			}
		}
		
		return sum;
	}
	
	static int third(int x, int y, int d1, int d2) {
		int sum = 0;
		
		for(int i = N - 1 ; i >= x + d1 ; i--) {
			for(int j = 0 ; j < y - d1 + d2 ; j++) {
				if(map[i][j] != 5) {
					sum += A[i][j];
					map[i][j] = 3;
				} else {
					y--;
					break;
				}
			}
		}
		
		return sum;
	}
	
	static int fourth(int x, int y, int d1, int d2) {
		int sum = 0;
		
		for(int i = N - 1 ; i > x + d2 ; i--) {
			for(int j = y - d1 + d2 ; j < N ; j++) {
				if(map[i][j] != 5) {
					sum += A[i][j];
					map[i][j] = 4;
				} else {
					y++;
					continue;
				}
			}
		}
		
		return sum;
	}
}
