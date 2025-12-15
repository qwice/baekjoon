import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        
        for( ; idx <= 26 ; idx++){
            int mid = 64;
            char c = (char)(mid + idx);
            map.put(Character.toString(c), idx);
        }
        
        String now = "";
        String next = "";
        
        for(int i = 0 ; i < msg.length() ; i++){
            now += msg.charAt(i);
            if(i+1 < msg.length()) {
                next = now + msg.charAt(i+1);
                if(map.containsKey(next)) continue;
            }
            list.add(map.get(now));
            map.put(next, idx++);
            now = "";
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}