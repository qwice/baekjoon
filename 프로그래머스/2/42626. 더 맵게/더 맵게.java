import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0 ; i < scoville.length ; i++){
            queue.add(scoville[i]);
        }
        
        while(!queue.isEmpty()) {
            int first = queue.poll();
            
            if(first >= K) break;
            if(queue.isEmpty()) {
                answer = -1;
                break;
            }
            
            int second = queue.poll();
            
            int mix = first + second * 2;
            queue.add(mix);
            answer++;
        }
        
        return answer;
    }
}