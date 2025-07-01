import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Integer[] a = new Integer[N];
        for(int i = 0 ; i < N ; i++){
          a[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(a);
        
        int result = 0;
        
        for(int i = 0 ; i < N ; i++){
          int temp = a[i] * (N - i);
          result = Math.max(result, temp);
        }
        
        System.out.print(result);
        
    }
}
