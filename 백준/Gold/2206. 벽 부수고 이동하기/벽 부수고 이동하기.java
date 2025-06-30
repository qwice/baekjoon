import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Point {
        int x, y, count;
        boolean isBroken;
        public Point(int x, int y, boolean isBroken, int count) {
            this.x = x;
            this.y = y;
            this.isBroken = isBroken;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        boolean[][][] visited = new boolean[N+1][M+1][2];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, false, 1));
        visited[1][1][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == N && cur.y == M) {
                System.out.print(cur.count);
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx > 0 && ny > 0 && nx <= N && ny <= M) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][cur.isBroken ? 1 : 0]) {
                        visited[nx][ny][cur.isBroken ? 1 : 0] = true;
                        q.add(new Point(nx, ny, cur.isBroken, cur.count + 1));
                    } else if (map[nx][ny] == 1 && !cur.isBroken && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.add(new Point(nx, ny, true, cur.count + 1));
                    }
                }
            }
        }
        System.out.print(-1);
    }
}
