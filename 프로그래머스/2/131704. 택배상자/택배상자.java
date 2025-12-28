import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        int index = 0;
        
        for(int i = 1 ; i <= order.length ; i++){
            boolean check = false;
            if(i == order[index]) {
                list.add(i);
                index++;
            }
            else check = true;
            
            while(!stack.isEmpty()) {
                if(stack.peekFirst() == order[index]) {
                    list.add(stack.removeFirst());
                    index++;
                }
                else break;
            }
            
            if(check) stack.addFirst(i);
        }
        
        return list.size();
    }
}