class Solution {
    public int solution(int n) {
        int answer = 0;
        int sIndex = 1;
        int eIndex = 1;
        int sum = 1;
        
        while(!(sIndex > n || eIndex > n)) {
            if(sum > n) {
                sum -= sIndex;
                sIndex++;
            } else if(sum < n) {
                eIndex++;
                sum += eIndex;
            } else {
                answer++;
                eIndex++;
                sum += eIndex;
            }
        }
        
        
        
        return answer;
    }
}