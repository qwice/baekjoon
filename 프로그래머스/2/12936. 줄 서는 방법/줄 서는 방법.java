import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        int[] answer = new int[n];
        k--;

        for (int i = 0; i < n; i++) {
            long block = fact[n - 1 - i];
            int idx = (int)(k / block);

            answer[i] = numbers.get(idx);
            numbers.remove(idx);

            k %= block;
        }

        return answer;
    }
}
