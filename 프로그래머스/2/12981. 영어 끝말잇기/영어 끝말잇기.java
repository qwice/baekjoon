import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        
        int[] answer = new int[2];
        int cnt = 1;
        boolean check = false;
        char lastChar = 0;
        
        for(int i = 0 ; i < words.length ; i++) {
            if(set.contains(words[i]) || (lastChar != words[i].charAt(0) && lastChar != 0)) {
                check = true;
                cnt = i;
                break;
            } else {
                lastChar = words[i].charAt(words[i].length() - 1);
                set.add(words[i]);
            }
            cnt++;
        }
        
        if(check) {
            answer[0] = cnt%n + 1;
            answer[1] = cnt/n + 1;
        }

        return answer;
    }
}