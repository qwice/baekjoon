import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0 ; i < priorities.length ; i++){
            q.add(new int[]{i, priorities[i]});
        }
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            boolean trigger = false;
            
            for(int[] temp : q) {
                if(now[1] < temp[1]) {
                    trigger = true;
                    break;
                }
            }
            
            if(trigger) q.add(now);
            else {
                answer++;
                if(now[0] == location) break;
            }
        }
        
        
        return answer;
    }
}