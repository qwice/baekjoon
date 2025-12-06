import java.util.*;

class Solution {
    public int solution(String word) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        
        for(int i = 0 ; i < word.length() ; i++){
            answer += 1 + (int)(Math.pow(5, 5 - i) / 4) * map.get(word.charAt(i));
        }
        return answer;
    }
}