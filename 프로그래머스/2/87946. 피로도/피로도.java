class Solution {
    static boolean[] visited;
    static int K, size, answer;
    static int[][] clone;
    
    public int solution(int k, int[][] dungeons) {
        size = dungeons.length;
        K = k;
        clone = dungeons;
        visited = new boolean[size];
        
        answer = -1;
        
        dfs(0);
        
        return answer;
    }
    
    public void dfs(int cnt) {
        if(check()) {
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int i = 0 ; i < size ; i++){
            int need = clone[i][0];
            int spend = clone[i][1];
            
            if(!visited[i]) {
                visited[i] = true;
                if(K >= need) {
                    K -= clone[i][1];
                    dfs(cnt+1);
                    K += clone[i][1];
                } else dfs(cnt);
                visited[i] = false;
            }
        }
    }
    
    public boolean check() {
        for(int i = 0 ; i < size ; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}