class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = "";
        int div = 1;
        
        while(n != 0) {
            s = n%k + s;
            n = n / k;
        }
        
        String[] val = s.split("0");
        
        for(String v : val) {
            if(!v.isEmpty() && isPrime(v)) answer++;
        }
        
        return answer;
    }
    
    public static boolean isPrime(String str) {
        long val = Long.parseLong(str);
        long root = (long)Math.sqrt(val);
        int ans = 0;
        
        if(val <= 1) return false;
        if(val == 2) return true;
        if(val % 2 == 0) return false;
        
        for(int i = 1 ; i <= root ; i++){
            if(val % i == 0) ans++;
        }
        
        if(ans == 1) return true;
        return false;
    }
}