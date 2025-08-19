import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int lastCameraPosition = Integer.MIN_VALUE;
        
        for(int[] route : routes) {
            if(route[0] > lastCameraPosition) {
                lastCameraPosition = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}