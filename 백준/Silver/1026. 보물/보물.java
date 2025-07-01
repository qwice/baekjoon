import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
          A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
          B[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        
        int result = 0;
        for(int i = 0 ; i < N ; i++){
          result += A[i]*B[i];
        }
        
        System.out.print(result);
    }
}
