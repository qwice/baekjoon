class Solution {
    boolean solution(String s) {
        int a = 0, b = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            char k = s.charAt(i);
            
            if(k == '(') a++;
            else {
                if(a <= b) return false;
                b++;
            }
        }
        
        
        return a == b ? true : false;
    }
}