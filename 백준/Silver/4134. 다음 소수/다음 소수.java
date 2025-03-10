import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            System.out.println(findNextPrime(num));
        }
    }

    public static long findNextPrime(long a) {
        if (a <= 1) return 2;
        
        while (true) {
            if (isPrime(a)) return a;
            a++;
        }
    }

    public static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        for (long i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}