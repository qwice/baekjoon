import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < size ; i++){
            int deploy = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) deploy++;
            
            queue.addLast(deploy);
        }
        
        while(!queue.isEmpty()) {
            Integer cur = queue.pollFirst();
            int cnt = 1;
            
            while(!queue.isEmpty() && queue.peekFirst() <= cur){
                queue.pollFirst();
                cnt++;  
            } 
            
            list.add(cnt);
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}