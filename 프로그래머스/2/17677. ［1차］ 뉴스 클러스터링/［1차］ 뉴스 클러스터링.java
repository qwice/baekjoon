import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i = 0 ; i+1 < str1.length() ; i++) {
            String s = str1.substring(i, i+2);
            if(check(s)) s1.add(s);
        }
        
        for(int i = 0 ; i+1 < str2.length() ; i++) {
            String s = str2.substring(i, i+2);
            if(check(s)) s2.add(s);
        }
        
        int sum = 0;
        int diff = 0;
        
        for(String s : s1) {
            if(s2.contains(s)) {
                diff++;
                s2.remove(s);
            }
            sum++;
        }
        sum += s2.size();
        
        if(sum == 0 && diff == 0) answer = 65536;
        else {
            answer = (int)((double)diff / sum * 65536);
        }

        return answer;
    }
    
    public static boolean check(String s) {
        if(s.charAt(0) < 'a' || s.charAt(0) > 'z') return false;
        if(s.charAt(1) < 'a' || s.charAt(1) > 'z') return false;
        return true;
    }
}