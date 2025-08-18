import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int l = s / n;
        int r = s % n;
        
        int i = 0;
        
        if(l == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        for(i = 0 ; i < r ; i++){
            answer[i] = l + 1;
        }
        
        for(; i < n ; i++){
            answer[i] = l;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}