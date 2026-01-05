import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int soldiers = n;

        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            soldiers -= enemy[i];

            if (soldiers < 0) {
                if (k == 0) {
                    return i;
                }

                soldiers += pq.poll();
                k--;
            }
        }

        return enemy.length;
    }
}
