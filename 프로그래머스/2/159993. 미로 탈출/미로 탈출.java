import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    sx = i; sy = j;
                } else if (c == 'L') {
                    lx = i; ly = j;
                } else if (c == 'E') {
                    ex = i; ey = j;
                }
            }
        }

        int toLever = bfs(sx, sy, 'L', maps);
        if (toLever == -1) return -1;

        int toExit = bfs(lx, ly, 'E', maps);
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    private int bfs(int sx, int sy, char target, String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (maps[x].charAt(y) == target) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx].charAt(ny) == 'X') continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }
}
