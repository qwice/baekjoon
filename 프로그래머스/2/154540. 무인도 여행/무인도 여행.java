import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] map;
    static List<Integer> list = new ArrayList<>();
    static int cnt = 0, n = 0, m = 0;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    cnt = map[i][j] - '0';
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        
        if(list.size() == 0) return new int[]{-1};
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static void dfs(int x, int y) {
        for(int dir = 0 ; dir < 4 ; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
            if(map[nx][ny] == 'X') continue;
            
            visited[nx][ny] = true;
            cnt += map[nx][ny] - '0';
            dfs(nx, ny);
        }
    }
}