class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int col2 = arr2[0].length;
        
        int[][] answer = new int[row1][col2];
        
        for(int i = 0 ; i < row1 ; i++){
            for(int j = 0 ; j < col1 ; j++){
                for(int k = 0 ; k < col2 ; k++){
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        
        return answer;
    }
}