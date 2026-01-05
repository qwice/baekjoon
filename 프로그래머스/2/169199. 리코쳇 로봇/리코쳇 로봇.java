import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] map;
    static int n, m;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        int sx = -1, sy = -1;
        
        Queue<int[]> q = new ArrayDeque<>();
        
        visited = new boolean[n][m];
        map = new char[n][m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R') {
                    sx = i;
                    sy = j;
                }
            }
        }
        
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(map[cur[0]][cur[1]] == 'G') return cur[2];
            
            for(int dir = 0 ; dir < 4 ; dir++){
                boolean canMove = false;
                int x = cur[0];
                int y = cur[1];
                while(true) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
                    if(map[nx][ny] == 'D') break;
                    
                    x = nx;
                    y = ny;
                    canMove = true;
                }
                
                if(canMove && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y, cur[2] + 1});
                }
            }
        }
        
        return -1;
    }
}