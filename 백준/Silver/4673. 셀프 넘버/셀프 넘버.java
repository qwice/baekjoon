public class Main {
    public static void main(String[] args) {
        int N = 10000;
        boolean[] isSelf = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            int dn = d(i);
            if (dn <= N) {
                isSelf[dn] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!isSelf[i]) {
                System.out.println(i);
            }
        }
    }

    static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}