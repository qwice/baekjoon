import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, D = 0, X = 0, Y = 0, sum = 0, cnt = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dice = {2, 1, 5, 6, 4, 3};
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(K-- > 0) {
			move();
			dfs(X, Y);
			
			sum += cnt * map[X][Y];
			
			for(boolean[] visit : visited) {
				Arrays.fill(visit, false);
			}
			cnt = 0;
			
			if(dice[3] > map[X][Y]) D = (D + 3) % 4;
			else if(dice[3] < map[X][Y]) D = (D + 1) % 4;
		}
		
		System.out.print(sum);
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt++;
		
		for(int dir = 0 ; dir < 4 ; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
			if(!visited[nx][ny] && map[x][y] == map[nx][ny]) dfs(nx, ny);
		}
	}
	
	static void move() {
		int temp = 0;
		
		if(D == 0) {
			if(Y + 1 >= M) {
				D = 2;
				move();
				return;
			}
			Y++;
			temp = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[3];
			dice[3] = temp;
		} else if(D == 1) {
			if(X - 1 < 0) {
				D = 3;
				move();
				return;
			}
			X--;
			temp = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[2];
			dice[2] = temp;
		} else if(D == 2) {
			if(Y - 1 < 0) {
				D = 0;
				move();
				return;
			}
			Y--;
			temp = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
		} else if(D == 3) {
			if(X + 1 >= N) {
				D = 1;
				move();
				return;
			}
			X++;
			temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[2];
			dice[2] = dice[1];
			dice[1] = temp;
		}
	}
	
}
