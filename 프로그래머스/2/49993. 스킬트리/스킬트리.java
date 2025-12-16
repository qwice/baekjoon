import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        int answer = 0;
        
        for(int i = 0 ; i < skill.length() ; i++){
            Character c = skill.charAt(i);
            
            map.put(c, i);
            list.add(c);
        }
        
        for(String s : skill_trees){
            boolean isCan = true;
            char[] arr = s.toCharArray();
            List<Character> copy = new ArrayList<>(list);
            for(Character c : arr){
                System.out.println(c);
                if(map.containsKey(c)) {
                    if(copy.get(0) != c){
                        isCan = false;
                        break;
                    } else copy.remove(0);
                }
            }
            if(isCan) answer++;
        }
        
        return answer;
    }
}