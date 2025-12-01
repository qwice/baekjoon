import java.util.*;

class Solution {
    static boolean[][] visited;
    static int row, col, answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();
    
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        row = maps.length - 1;
        col = maps[0].length - 1;
        
        visited = new boolean[row+1][col+1];
        
        
        visited[0][0] = true;
        q.add(new int[]{0, 0, 1});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int val = cur[2];
            
            if(x == col && y == row && val < answer) answer = val;
            
            for(int dir = 0 ; dir < 4 ; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if(nx < 0 || nx > col || ny < 0 || ny > row || visited[ny][nx] || maps[ny][nx] == 0) continue;
                q.add(new int[]{nx, ny, val+1});
                visited[ny][nx] = true;
            }
        }
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
}