class Solution {
    static int[] F = new int[100001];
    public int solution(int n) {
        F[0] = 0;
        F[1] = 1;
        
        for(int i = 2 ; i <= 100000 ; i++){
            F[i] = (F[i-1] + F[i-2]) % 1234567;
        }
        
        return F[n];
    }
}