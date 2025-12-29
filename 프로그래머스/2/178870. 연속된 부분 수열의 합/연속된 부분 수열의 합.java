class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        int lIdx = 0, rIdx = 0;
        int len = 1000001;
        int sum = sequence[0];
        
        while(left <= right) {
            if(sum == k) {
                if(len > right - left + 1) {
                    len = right - left + 1;
                    lIdx = left;
                    rIdx = right;
                }
            }
            
            if(sum < k) {
                right++;
                if(right == sequence.length) break;
                sum += sequence[right];
            }
            else if(sum >= k) {
                left++;
                if(left == sequence.length) break;
                sum -= sequence[left-1];
            }
        }
        
        return new int[]{lIdx, rIdx};
    }
}