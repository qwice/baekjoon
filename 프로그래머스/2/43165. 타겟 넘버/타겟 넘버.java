import java.util.*;

class Solution {
    static Queue<int[]> q = new LinkedList<>();
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        q.add(new int[]{0, numbers[0] * 1});
        q.add(new int[]{0, numbers[0] * -1});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int index = cur[0];
            int sum = cur[1];
            
            if(index == numbers.length - 1 && sum == target) answer++;
            
            if(index < numbers.length - 1) {
                q.add(new int[]{index + 1, sum + numbers[index+1] * 1});
                q.add(new int[]{index + 1, sum + numbers[index+1] * -1});
            }
        }
        
        return answer;
    }
}