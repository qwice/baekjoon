import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s);
        int size = st.countTokens();
        
        int[] arr = new int[size];
        
        for(int i = 0 ; i < size ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        answer = arr[0] + " " + arr[size-1];
        
        return answer;
    }
}