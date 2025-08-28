import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] belt;
	static boolean[] fill;
	
	public static void main(String args[]) throws IOException {
		// BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 1;
		int start = 0, end;
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N];
		fill = new boolean[2 * N];
		end = N - 1;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < 2 * N ; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			start = (start + 2 * N - 1) % (2 * N);
			end = (end + 2 * N - 1) % (2 * N);
			
			fill[end] = false;
			
			for(int i = (end + 2 * N - 1) % (2 * N), j = 0 ; j < N - 2; i = (i + 2 *N - 1) % (2 * N), j++) {
				if(belt[(i + 1) % (2 * N)] >= 1 && !fill[(i + 1) % (2 * N)] && fill[i]) {
					belt[(i + 1) % (2 * N)]--;
					if((i + 1) % (2 * N) == end) fill[i] = false;
					else {
						fill[i] = false;
						fill[(i + 1) % (2 * N)] = true;
					}
				}
			}
			
			if(belt[start] >= 1) {
				belt[start]--;
				fill[start] = true;
			}
			
			if(count()) {
				System.out.print(answer);
				return;
			}
			
			answer++;
		}
	}
	
	static boolean count() {
		int cnt = 0;
		
		for(int i = 0 ; i < 2 * N ; i++) {
			if(belt[i] == 0) cnt++;
		}
		
		if(cnt >= K) return true;
		else return false;
	}
		
}
