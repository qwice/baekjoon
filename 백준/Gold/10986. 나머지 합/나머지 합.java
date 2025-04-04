import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] prefixModCount = new long[m];
        
        long sum = 0;
        long result = 0;

        prefixModCount[0] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            sum = (sum + num) % m;

            result += prefixModCount[(int) sum];

            prefixModCount[(int) sum]++;
        }

        System.out.println(result);
    }
}
//어렵다 ..