import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] arr = new char[m][n];
        
        for(int i = 0 ; i < m ; i++){
            String s = board[i];
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = s.charAt(j);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int answer = 0;
        
        Set<String> ans = new HashSet<>();
        Set<String> temp = new HashSet<>();
        
        boolean check = true;
        
        while(check) {
            check = false;
            for(int i = 0 ; i < m-1 ; i++) {
                for(int j = 0 ; j < n-1 ; j++) {
                    if(arr[i][j] == '0') continue;
                    
                    if(arr[i][j] == arr[i+1][j] && arr[i][j] == arr[i][j+1] && arr[i][j] == arr[i+1][j+1]) {
                        temp.add(i+","+j);
                        temp.add((i+1)+","+j);
                        temp.add(i+","+(j+1));
                        temp.add((i+1)+","+(j+1));
                        
                        check = true;
                    }
                }
            }
            
            answer += temp.size();
            
            for(String st : temp) {
                String[] t = st.split(",");
                int r = Integer.parseInt(t[0]);
                int c = Integer.parseInt(t[1]);
                arr[r][c] = '0';
            }
            
            temp.clear();
            
            for(int i = m-1 ; i > 0 ; i--) {
                for(int j = 0 ; j < n ; j++) {
                    if(arr[i][j] != '0') continue;
                    
                    int r = i-1;
                    
                    while(r != -1 && arr[r][j] == '0') r--;
                    
                    if(r == -1) continue;
                    else {
                        arr[i][j] = arr[r][j];
                        arr[r][j] = '0';
                    }
                }
            }
        }
        
        return answer;
    }
}