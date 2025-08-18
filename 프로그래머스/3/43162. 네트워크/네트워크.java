class Solution {
    static boolean[] visited;
    static int N;
    static int[][] computer;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        N = n;
        computer = computers;
        
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }
    
    static void dfs(int node) {
        visited[node] = true;
        
        for(int i = 0 ; i < N ; i++) {
            if(computer[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}