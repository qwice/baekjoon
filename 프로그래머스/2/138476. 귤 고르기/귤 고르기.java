import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> list = new HashMap<>();
        
        for(int target : tangerine) {
            Integer value = list.getOrDefault(target, 0) + 1;
            list.put(target, value);
        }
        
        List<Map.Entry<Integer, Integer>> sortList = new ArrayList<>(list.entrySet());
        
        sortList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        for(Map.Entry<Integer, Integer> entry : sortList) {
            int val = entry.getValue();
            k -= val;
            answer++;
            if(k <= 0) return answer;
        }
        
        return answer;
    }
}