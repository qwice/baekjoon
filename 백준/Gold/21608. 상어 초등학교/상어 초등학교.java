import java.io.*;
import java.util.*;

public class Main {
	static Map<Integer, List<Integer>> friends = new HashMap<>();
	static int[][] map;
	static int[] arr;
	static int N;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		arr = new int[N*N];
		
		for(int i = 0 ; i < N * N ; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			arr[i] = key;
			List<Integer> values = new ArrayList<>();
			
			for(int j = 0 ; j < 4 ; j++) {
				values.add(Integer.parseInt(st.nextToken()));
			}
			
			friends.put(key, values);
		}
		
		for(int i = 0 ; i < N * N ; i++) {
			int x = -1, y =  -1, empty = -1, like = -1;
			
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < N ; k++) {
					if(map[j][k] != 0) continue;
					
					int[] cnt = cntLike(arr[i], j, k);
					if(cnt[0] > like) {
						x = j;
						y = k;
						like = cnt[0];
						empty = cnt[1];
					} else if(cnt[0] == like && cnt[1] > empty) {
						x = j;
						y = k;
						like = cnt[0];
						empty = cnt[1];
					}
				}
			}
			
			map[x][y] = arr[i];
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				int cnt = cntLike(map[i][j], i, j)[0];
				if(cnt == 0) continue;
				else if(cnt == 1) result += 1;
				else if(cnt == 2) result += 10;
				else if(cnt == 3) result += 100;
				else if(cnt == 4) result += 1000;
			}
		}
		
		System.out.print(result);
	}
	
	static int[] cntLike(int a, int b, int c) {
		int cnt = 0;
		int empty = 0;
		
		for(int dir = 0 ; dir < 4 ; dir++) {
			int nx = b + dx[dir];
			int ny = c + dy[dir];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(friends.get(a).contains(map[nx][ny])) cnt++;
			if(map[nx][ny] == 0) empty++;
		}
		
		return new int[] {cnt, empty};
	}
}
