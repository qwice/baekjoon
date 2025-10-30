import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        int answer = 1;
        
        for(int i = 0 ; i < clothes.length ; i++){
            String cloth = clothes[i][0];
            String type = clothes[i][1];
            
            List<String> list = map.getOrDefault(type, new ArrayList<>());
            list.add(cloth);
            map.put(type, list);
        }
        
        for(String key : map.keySet()) {
            answer *= map.get(key).size() + 1;
            
        }
        
        answer--;
        
        return answer;
    }
}