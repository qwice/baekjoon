import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] table = new int[N+1][N+1];
        int[][] prefix = new int[N+1][N+1];
        int[] x = new int[2];
        int[] y = new int[2];
        
        for(int i = 1 ; i <= N ; i++){
          st = new StringTokenizer(br.readLine());
          for(int j = 1 ; j <= N ; j++){
            table[i][j] = Integer.parseInt(st.nextToken());
            prefix[i][j] = table[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
          }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < M ; i++){
          st = new StringTokenizer(br.readLine());
          x[0] = Integer.parseInt(st.nextToken());
          y[0] = Integer.parseInt(st.nextToken());
          x[1] = Integer.parseInt(st.nextToken());
          y[1] = Integer.parseInt(st.nextToken());
          
          int ans = prefix[x[1]][y[1]] - prefix[x[1]][y[0]-1] - prefix[x[0]-1][y[1]] + prefix[x[0]-1][y[0]-1];
          
          sb.append(ans).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
