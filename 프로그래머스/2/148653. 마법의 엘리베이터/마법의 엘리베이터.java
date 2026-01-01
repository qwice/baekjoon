class Solution {
    int answer = Integer.MAX_VALUE;
    
    public int solution(int storey) {
        
        dfs(storey, 0);
        
        return answer;
    }
    
    public void dfs(int num, int cnt) {
        if(num <= 5) {
            cnt += num;
            if(cnt < answer) answer = cnt;
            return;
        }
        
        int div = num / 10;
        int mod = num % 10;
        
        dfs(div + 1, cnt + 10 - mod);
        dfs(div, cnt + mod);
    }
}