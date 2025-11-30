import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] front = new int[topping.length];
        int[] back = new int[topping.length];
        
        Set<Integer> flist = new HashSet<>();
        Set<Integer> elist = new HashSet<>();
        
        for(int i = 0 ; i < topping.length ; i++) {
            flist.add(topping[i]);
            front[i] = flist.size();
        }
        
        for(int i = 0 ; i < topping.length ; i++) {
            elist.add(topping[topping.length - i - 1]);
            back[i] = elist.size();
        }
        
        for(int i = 0 ; i < topping.length - 1; i++) {
            if(front[i] == back[topping.length - i - 2]) answer++;
        }
        
        return answer;
    }
}