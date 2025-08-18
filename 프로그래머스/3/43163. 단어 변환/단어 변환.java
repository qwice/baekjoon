class Solution {
    static int answer = Integer.MAX_VALUE;
    static String[] word;
    static boolean[] visited;
    static String start, end;
    
    public int solution(String begin, String target, String[] words) {
        word = words;
        start = begin;
        end = target;
        visited = new boolean[words.length];
        
        dfs(start, 0);
        
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
    
    static void dfs(String input ,int count) {
        if(input.equals(end)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i = 0 ; i < word.length ; i++){
            if(canChange(word[i], input) && !visited[i]) {
                visited[i] = true;
                dfs(word[i], count+1);
                visited[i] = false;
            }
        }
    }
    
    static boolean canChange(String a, String b) {
        int cnt = 0;
        
        for(int i = 0 ; i < a.length() ; i++) {
            if(a.charAt(i) != b.charAt(i)) cnt++;
            if(cnt >= 2) return false;
        }
        return true;
    }
}