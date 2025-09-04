import java.io.*;
import java.util.*;

public class Main {
	static int N, X, Y, sum = 0, Ex = 0, Ey = 0;
	static int[][] map;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		X = N / 2;
		Y = N / 2;
		
		StringTokenizer st;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 1;
		while(true) {	
			for(int i = 0 ; i < 2 ; i++) {
				for(int j = 0 ; j < cnt ; j++) {
					move();
					if(X == Ex && Y == Ey) {
						System.out.println(sum);
						return;
					}
				}
				
				rotateMap();
				rotatePoint();
			}
			
			cnt++;
		}
		
		
	}
	
	static void rotateMap() {
		int[][] newMap = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				newMap[j][N - 1 - i] = map[i][j];
			}
		}
		
		map = newMap;
	}
	
	static void rotatePoint() {
		int nx = Y;
		int ny = N - 1 - X;
		int nEx = Ey;
		int nEy = N - 1 - Ex;
		
		X = nx;
		Y = ny;
		Ex = nEx;
		Ey = nEy;
	}
	
	static void move() {
		int one = (int)(map[X][Y - 1] * 0.01);
		int two = (int)(map[X][Y - 1] * 0.02);
		int five = (int)(map[X][Y - 1] * 0.05);
		int seven = (int)(map[X][Y - 1] * 0.07);
		int ten = (int)(map[X][Y - 1] * 0.1);
		int alpha = map[X][Y - 1] - 2 * (one + two + seven + ten) - five;
		
		if(X-1 < 0) sum += one;
		else map[X - 1][Y] += one;
		
		if(X+1 >= N) sum += one;
		else map[X + 1][Y] += one;
		
		if(X - 1 < 0 || Y - 1 < 0) sum += seven;
		else map[X - 1][Y - 1] += seven;
		
		if(X + 1 >= N || Y - 1 < 0 ) sum += seven;
		else map[X + 1][Y - 1] += seven;
		
		if(X - 2 < 0 || Y - 1 < 0) sum += two;
		else map[X - 2][Y - 1] += two;
		
		if(X + 2 >= N || Y - 1 < 0) sum += two;
		else map[X + 2][Y - 1] += two;
		
		if(X - 1 < 0 || Y - 2 < 0) sum += ten;
		else map[X - 1][Y - 2] += ten;
		
		if(X + 1 >= N || Y - 2 < 0) sum += ten;
		else map[X + 1][Y - 2] += ten;
		
		if(Y - 3 < 0) sum += five;
		else map[X][Y - 3] += five;
		
		if(Y - 2 < 0) sum += alpha;
		else map[X][Y - 2] += alpha;
		
		map[X][Y-1] = 0;
		Y = Y - 1;
	}
	
	static boolean checkEnd() {
		if(X == Ex && Y == Ey) return true;
		return false;
	}
}
