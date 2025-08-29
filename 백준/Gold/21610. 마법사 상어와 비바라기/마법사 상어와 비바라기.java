import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] bCloud, aCloud;
	static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		bCloud = new boolean[N+1][N+1];
		aCloud = new boolean[N+1][N+1];
		
		bCloud[N][1] = true;
		bCloud[N][2] = true;
		bCloud[N-1][1] = true;
		bCloud[N-1][2] = true;
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			for(int x = 1 ; x <= N ; x++) {
				for(int y = 1 ; y <= N ; y++) {
					if(bCloud[x][y]) {
						int nx = (x + (s * dx[d] % N) + N) % N == 0 ? N : (x + (s * dx[d] % N) + N) % N;
						int ny = (y + (s * dy[d] % N) + N) % N == 0 ? N : (y + (s * dy[d] % N) + N) % N;
						
						aCloud[nx][ny] = true;
						map[nx][ny]++;
					}
				}
			}
			
			clearCloud(bCloud);
			
			for(int x = 1 ; x <= N ; x++) {
				for(int y = 1 ; y <= N ; y++) {
					if(aCloud[x][y]) {
						if(x-1 >= 1 && y-1 >= 1 && map[x-1][y-1] > 0) map[x][y]++;
						if(x+1 <= N && y-1 >= 1 && map[x+1][y-1] > 0) map[x][y]++;
						if(x-1 >= 1 && y+1 <= N && map[x-1][y+1] > 0) map[x][y]++;
						if(x+1 <= N && y+1 <= N && map[x+1][y+1] > 0) map[x][y]++;
					}
				}
			}
			
			for(int x = 1 ; x <= N ; x++) {
				for(int y = 1 ; y <= N ; y++) {
					if(map[x][y] >= 2 && !aCloud[x][y]) {
						bCloud[x][y] = true;
						map[x][y] -= 2;
					}
				}
			}
			
			clearCloud(aCloud);
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				sum += map[i][j];
			}
		}
		
		System.out.print(sum);
	}
	
	static void clearCloud(boolean[][] c) {
		for(boolean[] temp : c) {
			Arrays.fill(temp, false);
		}
	}
}
