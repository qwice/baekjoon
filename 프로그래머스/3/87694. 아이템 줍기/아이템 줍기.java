class Solution {
    static boolean[][] map = new boolean[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] point : rectangle) {
            int lbx = point[0] * 2;
            int lby = point[1] * 2;
            int rtx = point[2] * 2;
            int rty = point[3] * 2;
            
            for(int i = lbx ; i <= rtx ; i++){
                map[lby][i] = true;
                map[rty][i] = true;
            }
            
            for(int i = lby ; i <= rty ; i++){
                map[i][lbx] = true;
                map[i][rtx] = true;
            }
        }
        
        for(int[] remove : rectangle) {
            int lbx = remove[0] * 2;
            int lby = remove[1] * 2;
            int rtx = remove[2] * 2;
            int rty = remove[3] * 2;
            
            for(int i = lbx + 1 ; i < rtx; i++){
                for(int j = lby + 1 ; j < rty  ; j++){
                    if(map[j][i]) map[j][i] = false;
                }
            }
        }
        
        visited[characterY * 2][characterX * 2] = true;
        dfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2, 0);
        
        return answer/2;
    }
    
    static void dfs(int cy, int cx, int iy, int ix, int cnt){
        if(cx == ix && cy == iy) {
            answer = Math.min(answer, cnt);
        }
        
        for(int dir = 0 ; dir < 4 ; dir++){
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];
            
            if(nx <= 0 || ny <= 0 || nx > 100 || ny > 100 || !map[ny][nx] || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            dfs(ny, nx, iy, ix, cnt + 1);
            visited[ny][nx] = false;
        }
    }
}