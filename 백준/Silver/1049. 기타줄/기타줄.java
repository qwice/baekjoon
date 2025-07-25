import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] A, B;

    public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      int result = 0;
      
      A = new int[M];
      B = new int[M];
      
      for(int i = 0 ; i < M ; i++){
        st = new StringTokenizer(br.readLine());
        A[i] = Integer.parseInt(st.nextToken());
        B[i] = Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(A);
      Arrays.sort(B);
      while(true) {
        if(N <= 0) {
          System.out.println(result);
          return;
        }
        
        int i, j = 0;
        if(N >= 6) {
          result += Math.min(A[0], B[0] * 6);
          N -= 6;
        } else {
          result += Math.min(A[0], B[0] * N);
          N = 0;
        }
      }
    }
}