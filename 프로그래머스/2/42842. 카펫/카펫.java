import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int col = (int)Math.floor((float)(brown + 4) / 4);
        int row = (int)Math.ceil((float)(brown + 4) / 4);
        
        while(true){
            if(col * 2 + row * 2 - 4 == brown && (col-2) * (row-2) == yellow) return new int[]{row, col};
            else {
                col--;
                row++;
            }
        }
    }
}