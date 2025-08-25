class Solution {
    public int solution(int n) {
        int answer = 0;
        String binaryN = Integer.toBinaryString(n);
        int countN = countOne(binaryN);
        
        for(int i = n + 1 ; i <= 1000000 ; i++){
            String nextN = Integer.toBinaryString(i);
            int countNextN = countOne(nextN);
            if(countN == countNextN) return i;
        }
        
        return 0;
    }
    
    static int countOne(String s) {
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '1') count++;
        }
        
        return count;
    }
}