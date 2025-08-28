import java.io.*;
import java.util.*;

public class Main {
	static int[] dices = new int[6];
	static int N, M, x, y, K;
	static int[][] map;
	
	public static void main(String args[]) throws IOException{
		// BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < K ; i++) {
			int num = Integer.parseInt(st.nextToken());

			switch(num) {
			case 1:
				if(y + 1 >= M) continue;
				y++;
				east();
				if(map[x][y] == 0) map[x][y] = dices[3];
				else {
					dices[3] = map[x][y];
					map[x][y] = 0;
				}
				sb.append(dices[1]);
				sb.append("\n");
				break;
			
			case 2:
				if(y - 1 < 0) continue;
				y--;
				west();
				if(map[x][y] == 0) map[x][y] = dices[3];
				else {
					dices[3] = map[x][y];
					map[x][y] = 0;
				}
				sb.append(dices[1]);
				sb.append("\n");
				break;
				
			case 3:
				if(x - 1 < 0) continue;
				x--;
				south();
				if(map[x][y] == 0) map[x][y] = dices[3];
				else {
					dices[3] = map[x][y];
					map[x][y] = 0;
				}
				sb.append(dices[1]);
				sb.append("\n");
				break;
				
			case 4:
				if(x + 1 >= N) continue;
				x++;
				north();
				if(map[x][y] == 0) map[x][y] = dices[3];
				else {
					dices[3] = map[x][y];
					map[x][y] = 0;
				}
				sb.append(dices[1]);
				sb.append("\n");
				break;
				
			default: 
				break;
			}
		}
		System.out.print(sb.toString());
	}
	
	
	static void east() {
		int temp = dices[5];
		dices[5] = dices[1];
		dices[1] = dices[4];
		dices[4] = dices[3];
		dices[3] = temp;
	}
	
	static void west() {
		int temp = dices[1];
		dices[1] = dices[5];
		dices[5] = dices[3];
		dices[3] = dices[4];
		dices[4] = temp;
	}
	
	static void south() {
		int temp = dices[1];
		dices[1] = dices[0];
		dices[0] = dices[3];
		dices[3] = dices[2];
		dices[2] = temp;
	}
	
	static void north() {
		int temp = dices[1];
		dices[1] = dices[2];
		dices[2] = dices[3];
		dices[3] = dices[0];
		dices[0] = temp;
	}
}
