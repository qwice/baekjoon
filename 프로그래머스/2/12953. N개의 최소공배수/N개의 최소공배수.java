class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        while(true) {
            boolean check = true;
            for(int i = 0 ; i < arr.length ; i++) {
                if(answer % arr[i] != 0) {
                    check = false;
                    break;
                }
            }
            if(check) {
                return answer;
            }
            answer++;
        }
    }
}