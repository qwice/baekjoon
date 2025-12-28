class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;

        long sum1 = 0, sum2 = 0;
        for (int x : queue1) sum1 += x;
        for (int x : queue2) sum2 += x;

        long total = sum1 + sum2;
        if (total % 2 != 0) return -1;

        long target = total / 2;

        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = queue1[i];
            arr[i + n] = queue2[i];
        }

        int left = 0;
        int right = n;
        int count = 0;

        while (count <= 3 * n) {
            if (sum1 == target) return count;

            if (sum1 > target) {
                sum1 -= arr[left];
                left++;
            } else {
                if (right == 2 * n) break;
                sum1 += arr[right];
                right++;
            }

            count++;
        }

        return -1;
    }
}
