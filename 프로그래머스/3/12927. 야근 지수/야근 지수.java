import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : works) {
            q.add(num);
        }
        
        for(int i = 1 ; i <= n ; i++){
            if(q.isEmpty()) return 0;
            
            int num = q.poll();
            if(num > 0) q.add(num - 1);
        }
        
        while(!q.isEmpty()) {
            answer += Math.pow(q.poll(), 2);
        }
        
        return answer;
    }
}