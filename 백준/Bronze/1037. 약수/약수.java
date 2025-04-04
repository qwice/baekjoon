import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int ans = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
          arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        if(N % 2 == 0) ans = arr[0] * arr[N-1];
        else ans = arr[N/2] * arr[N/2];
        
        System.out.print(ans);
        
    }
}
