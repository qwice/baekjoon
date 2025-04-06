import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
          A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        long count = 0;
        for(int i = 0 ; i < N ; i++){
          if(A[i] <= B) {
            count++;
          } else {
            count++;
            int div = (A[i] - B) / C;
            int mod = (A[i] - B) % C;
            if(mod == 0){
              count += div;
            } else {
              count += div + 1;
            }
          }
        }
        System.out.print(count);
    }
}
