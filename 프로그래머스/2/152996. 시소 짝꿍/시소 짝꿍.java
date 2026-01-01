import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Long> map = new HashMap<>();
        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0L) + 1);
        }

        for (long cnt : map.values()) {
            if (cnt >= 2) {
                answer += cnt * (cnt - 1) / 2;
            }
        }

        int[][] ratios = {
            {2, 3},
            {2, 4},
            {3, 4}
        };

        for (int w : map.keySet()) {
            for (int[] r : ratios) {
                int d1 = r[0];
                int d2 = r[1];

                if ((long) w * d1 % d2 != 0) continue;

                int other = (int) ((long) w * d1 / d2);
                if (map.containsKey(other)) {
                    answer += map.get(w) * map.get(other);
                }
            }
        }

        return answer;
    }
}
