import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Map<String, Set<Character>> route = new HashMap<>();
        int x = 5, y = 5;
        
        
        for(int i = 0 ; i < dirs.length() ; i++) {
            char dir = dirs.charAt(i);
            int nx = 0, ny = 0;
            
            if(dir == 'U') {
                nx = x - 1;
                ny = y;
                
                if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
                String now = nx + "," + ny;
                
                if(route.containsKey(now)) {
                    Set<Character> nowSet = route.get(now);
                    nowSet.add('D');
                    route.put(now, nowSet);
                } else {
                    Set<Character> nowSet = new HashSet<>();
                    nowSet.add('D');
                    route.put(now, nowSet);
                }
                
                String before = x + "," + y;
                
                if(route.containsKey(before)) {
                    Set<Character> nowSet = route.get(before);
                    nowSet.add('U');
                    route.put(before, nowSet);
                } else {
                    Set<Character> nowSet = new HashSet<>();
                    nowSet.add('U');
                    route.put(before, nowSet);
                }
                
                x = nx;
                y = ny;
            } else if(dir == 'D') {
                nx = x + 1;
                ny = y;
                
                if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
                String now = nx + "," + ny;
                
                if(route.containsKey(now)) {
                    Set<Character> nowSet = route.get(now);
                    nowSet.add('U');
                    route.put(now, nowSet);
                } else {
                    Set<Character> nowSet = new HashSet<>();
                    nowSet.add('U');
                    route.put(now, nowSet);
                }
                
                String before = x + "," + y;
                
                if(route.containsKey(before)) {
                    Set<Character> nowSet = route.get(before);
                    nowSet.add('D');
                    route.put(before, nowSet);
                } else {
                    Set<Character> nowSet = new HashSet<>();
                    nowSet.add('D');
                    route.put(before, nowSet);
                }
                
                x = nx;
                y = ny;
            } else if(dir == 'R') {
                nx = x;
                ny = y + 1;
                
                if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
                String now = nx + "," + ny;
                
                if(route.containsKey(now)) {
                    Set<Character> nowSet = route.get(now);
                    nowSet.add('L');
                    route.put(now, nowSet);
                } else {
                    Set<Character> nowSet = new HashSet<>();
                    nowSet.add('L');
                    route.put(now, nowSet);
                }
                
                String before = x + "," + y;
                
                if(route.containsKey(before)) {
                    Set<Character> nowSet = route.get(before);
                    nowSet.add('R');
                    route.put(before, nowSet);
                } else {
                    Set<Character> nowSet = new HashSet<>();
                    nowSet.add('R');
                    route.put(before, nowSet);
                }
                
                x = nx;
                y = ny;
            } else if(dir == 'L') {
                nx = x;
                ny = y - 1;
                
                if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
                String now = nx + "," + ny;
                
                if(route.containsKey(now)) {
                    Set<Character> nowSet = route.get(now);
                    nowSet.add('R');
                    route.put(now, nowSet);
                } else {
                    Set<Character> nowSet = new HashSet<>();
                    nowSet.add('R');
                    route.put(now, nowSet);
                }
                
                String before = x + "," + y;
                
                if(route.containsKey(before)) {
                    Set<Character> nowSet = route.get(before);
                    nowSet.add('L');
                    route.put(before, nowSet);
                } else {
                    Set<Character> nowSet = new HashSet<>();
                    nowSet.add('L');
                    route.put(before, nowSet);
                }
                
                x = nx;
                y = ny;
            }
        }
        
        for(String cur : route.keySet()) {
                System.out.println(cur + " " + route.get(cur));
                answer += route.get(cur).size();
        }
        
        return answer / 2;
    }
}