import java.util.*;

class Solution {
    static int[][] map;
    static List<Integer> list = new ArrayList<>();  
    
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];

        int num = 1;
        
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                map[i][j] = num++;
            }
        }
        
        for(int i = 0 ; i < queries.length ; i++){
            int sx = queries[i][0] - 1;
            int sy = queries[i][1] - 1;
            int ex = queries[i][2] - 1;
            int ey = queries[i][3] - 1;
            
            rotate(sx, sy, ex, ey);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static void rotate(int sx, int sy, int ex, int ey) {
        int min = Integer.MAX_VALUE;
        int temp = map[sx][sy];
        min = Math.min(min, temp);
        
        for(int i = sx + 1 ; i <= ex ; i++){
            map[i-1][sy] = map[i][sy];
            min = Math.min(min, map[i][sy]);
        }
        
        for(int i = sy + 1 ; i <= ey ; i++){
            map[ex][i-1] = map[ex][i];
            min = Math.min(min, map[ex][i]);
        }
        
        for(int i = ex - 1 ; i >= sx ; i--){
            map[i+1][ey] = map[i][ey];
            min = Math.min(min, map[i][ey]);
        }
        
        for(int i = ey - 1 ; i > sy ; i--){
            map[sx][i+1] = map[sx][i];
            min = Math.min(min, map[sx][i]);
        }
        
        map[sx][sy+1] = temp;
        
        list.add(min);
    }
}