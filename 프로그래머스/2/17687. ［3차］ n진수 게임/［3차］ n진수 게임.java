class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String s = "ABCDEF";
        int gVal = 0;
        int cnt = 1;
        
        while(answer.length() != t) {
        // while(gVal <= 10 && answer.length() < t){
            String nVal = "";
            int val = gVal++;
            if(val == 0) nVal += "0";
            else {
                while(val != 0){
                    if(val % n >= 10) nVal = s.charAt(val % n - 10) + nVal;
                    else nVal = val % n + nVal;
                    val /= n;
                }
            }
            
            for(int i = 0 ; i < nVal.length() ; i++) {
                if(answer.length() == t) break;
                if(cnt++ % (m+1) == p) {
                    System.out.println(cnt + " " + i + " " + p);
                    answer += nVal.charAt(i);
                }
                cnt %= (m+1);
                if(cnt == 0) cnt++;
            }
        }
        
        return answer;
    }
}