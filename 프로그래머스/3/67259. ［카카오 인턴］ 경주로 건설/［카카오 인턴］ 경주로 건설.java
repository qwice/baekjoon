import java.util.*;

class Solution {
    static class Node {
        int x, y, dir, cost;
        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        int INF = Integer.MAX_VALUE;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][][] cost = new int[n][n][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(cost[i][j], INF);

        Queue<Node> q = new LinkedList<>();

        for (int d = 0; d < 4; d++) {
            cost[0][0][d] = 0;
            q.offer(new Node(0, 0, d, 0));
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.cost > cost[cur.x][cur.y][cur.dir]) continue;

            for (int nd = 0; nd < 4; nd++) {
                int nx = cur.x + dx[nd];
                int ny = cur.y + dy[nd];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] == 1) continue;

                int newCost;
                if (cur.dir == nd) {
                    newCost = cur.cost + 100;
                } else {
                    newCost = cur.cost + 600;
                }

                if (cost[nx][ny][nd] > newCost) {
                    cost[nx][ny][nd] = newCost;
                    q.offer(new Node(nx, ny, nd, newCost));
                }
            }
        }

        int answer = INF;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, cost[n-1][n-1][d]);
        }

        return answer;
    }
}
