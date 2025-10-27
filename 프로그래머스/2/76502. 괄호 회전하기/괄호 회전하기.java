import java.util.*;

class Solution {
    static Deque<Character> q = new LinkedList<>();
    static int n;
    
    public int solution(String s) {
        int answer = 0;
        n = s.length();
        
        for(int i = 0 ; i < n ; i++){
            q.clear();
            if(rotate(s, i)) answer++;
        }
        
        return answer;
    }
    
    public boolean rotate(String s, int idx) {
        for(int i = idx ; i < idx + n ; i++) {
            char c = s.charAt(i%n);
            if(c == '{' || c == '(' || c == '[') q.addFirst(c);
            else if(!q.isEmpty() && c == '}' && q.peekFirst() == '{') q.pollFirst();
            else if(!q.isEmpty() && c == ']' && q.peekFirst() == '[') q.pollFirst();
            else if(!q.isEmpty() && c == ')' && q.peekFirst() == '(') q.pollFirst();
            else return false;
        }
        
        if(q.isEmpty()) return true;
        return false;
    }
}