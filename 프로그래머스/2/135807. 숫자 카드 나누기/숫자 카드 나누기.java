class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = gcdArray(arrayA);
        int gcdB = gcdArray(arrayB);

        int answer = 0;

        if (isValid(gcdA, arrayB)) {
            answer = Math.max(answer, gcdA);
        }

        if (isValid(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    private int gcdArray(int[] arr) {
        int g = arr[0];
        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, arr[i]);
        }
        return g;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private boolean isValid(int g, int[] other) {
        for (int x : other) {
            if (x % g == 0) return false;
        }
        return true;
    }
}
