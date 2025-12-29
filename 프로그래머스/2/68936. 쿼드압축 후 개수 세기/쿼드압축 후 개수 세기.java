class Solution {
    int zero = 0;
    int one = 0;

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return new int[]{zero, one};
    }

    private void compress(int[][] arr, int x, int y, int size) {
        int first = arr[x][y];
        boolean same = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            if (first == 0) zero++;
            else one++;
            return;
        }

        int half = size / 2;
        compress(arr, x, y, half);
        compress(arr, x, y + half, half);
        compress(arr, x + half, y, half);
        compress(arr, x + half, y + half, half);
    }
}
