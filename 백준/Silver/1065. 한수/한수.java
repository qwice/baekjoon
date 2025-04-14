import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (i < 100) {
                count++;
            } else {
                int hundred = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if ((hundred - ten) == (ten - one)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
