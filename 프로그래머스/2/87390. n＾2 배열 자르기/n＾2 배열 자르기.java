import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];
        
        for(long i = left ; i <= right ; i++){
            int div = (int)(i / n);
            int mod = (int)(i % n);
            if(mod <= div) answer[(int)(i - left)] = div + 1;
            else answer[(int)(i - left)] = 1 + mod;
        }
        
        return answer;
    }
}