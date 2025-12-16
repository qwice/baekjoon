import java.util.*;

class Solution {

    class Point {
        int val;
        int cnt;

        Point(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    public int solution(int x, int y, int n) {
        Deque<Point> q = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];

        q.add(new Point(x, 0));
        visited[x] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.val == y) return cur.cnt;

            int[] nexts = {
                cur.val + n,
                cur.val * 2,
                cur.val * 3
            };

            for (int next : nexts) {
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    q.add(new Point(next, cur.cnt + 1));
                }
            }
        }

        return -1;
    }
}
