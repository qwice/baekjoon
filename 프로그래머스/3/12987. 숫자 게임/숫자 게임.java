import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIndex = 0, bIndex = 0;
        
        while(bIndex < B.length){
            if(B[bIndex++] > A[aIndex]) aIndex++;
        }
        
        return aIndex;
    }
}