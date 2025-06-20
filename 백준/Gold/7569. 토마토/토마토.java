import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static class Point {
        int x, y, z;
        Point(int z, int y, int x) { this.z = z; this.y = y; this.x = x; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        Queue<Point> queue = new ArrayDeque<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.add(new Point(h, n, m));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int d = 0; d < 6; d++) {
                int nz = p.z + dz[d];
                int ny = p.y + dy[d];
                int nx = p.x + dx[d];
                if (0 <= nz && nz < H && 0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = box[p.z][p.y][p.x] + 1;
                        queue.add(new Point(nz, ny, nx));
                    }
                }
            }
        }

        int ans = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, box[h][n][m]);
                }
            }
        }
        System.out.println(ans == 1 ? 0 : ans - 1);
    }
}
