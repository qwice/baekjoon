import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Point {
        int x, y, day;
        Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        Queue<Point> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new Point(i, j, 0));
                }
            }
        }

        int answer = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            answer = Math.max(answer, cur.day);

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    q.offer(new Point(nx, ny, cur.day + 1));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }
}
