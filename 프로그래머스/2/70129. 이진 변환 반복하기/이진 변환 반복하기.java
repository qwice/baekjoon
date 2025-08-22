class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        String beforeS = s, afterS;
        
        while(!beforeS.equals("1")) {
            afterS = beforeS.replace("0", "");
            int before = beforeS.length();
            int after = afterS.length();
            
            answer[1] += before - after;
            answer[0]++;
            
            beforeS = "";
            
            while(after / 2 != 0) {
                beforeS += after % 2;
                after /= 2;
            }
            
            beforeS += after % 2;
        }
        
        return answer;
    }
}