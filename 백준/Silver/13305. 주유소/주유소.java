import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N - 1];
        long[] price = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = 0;
        long minPrice = price[0];

        for (int i = 0; i < N - 1; i++) {
            totalCost += minPrice * dist[i];

            if (price[i + 1] < minPrice) {
                minPrice = price[i + 1];
            }
        }

        System.out.println(totalCost);
    }
}
