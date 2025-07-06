import java.io.*;
import java.util.*;

public class Main {
  static int N, M, cnt;
  static int[] A;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    cnt = 0;
    
    A = new int[N];
    
    st = new StringTokenizer(br.readLine());
    for(int i = 0 ; i < N ; i++){
      A[i] = Integer.parseInt(st.nextToken());
    }
    
    int count = 0;
    int sum = 0;
    int start = 0;
    int end = 0;

    while (true) {
        if (sum >= M) {
            sum -= A[start++];
        } else if (end == N) {
            break;
        } else {
            sum += A[end++];
        }

        if (sum == M) {
            count++;
        }
    }

    System.out.println(count);
  }
}
