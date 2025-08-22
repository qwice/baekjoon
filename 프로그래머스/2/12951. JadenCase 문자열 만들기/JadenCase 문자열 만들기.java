import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        
        s = s.toLowerCase();
        answer.append(Character.toUpperCase(s.charAt(0)));
        
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == ' ') list.add(i);
        }
        
        for(int i = 1 ; i < s.length() ; i++) {
            if(list.contains(i - 1)) answer.append(Character.toUpperCase(s.charAt(i)));
            else answer.append(s.charAt(i));
        }
        
        return answer.toString();
    }
}