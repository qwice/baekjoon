import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int min = 0;
        int max = citations[citations.length-1];
        
        while(min <= max) {
            int mid = (min + max) / 2;
            int cnt1 = 0;
            
            for(int i = 0 ; i < citations.length ; i++){
                if(citations[i] >= mid) cnt1++;
            }
            
            if(cnt1 >= mid) {
                answer = mid;
                min = mid + 1;
            }
            else max = mid - 1;
        }
        
        return answer;
    }
}