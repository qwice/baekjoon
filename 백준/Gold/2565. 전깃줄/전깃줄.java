import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] wires = new int[N][2];
        
        for(int i = 0 ; i < N ; i++){
          wires[i][0] = sc.nextInt();
          wires[i][1] = sc.nextInt();
        }
        
        Arrays.sort(wires, Comparator.comparingInt(a -> a[0]));
        
        int[] dp = new int[N];
        int length = 0;
        
        for(int i = 0 ; i < N ; i++){
          int b = wires[i][1];
          
          int pos = Arrays.binarySearch(dp, 0, length, b);
          if(pos < 0) pos = -(pos + 1);
          dp[pos] = b;
          if(pos == length) length++;
        }
        
        System.out.print(N-length);
    }
}
