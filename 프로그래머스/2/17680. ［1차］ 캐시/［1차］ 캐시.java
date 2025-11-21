import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
        
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return cities.length * 5;
        
        for(int i = 0 ; i < cities.length ; i++) {
            String city = cities[i].toLowerCase();
            if(list.contains(city)){
                list.remove(list.indexOf(city));
                list.add(city);
                answer++;
            } else {
                if(list.size() >= cacheSize) list.remove(0);
                list.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}