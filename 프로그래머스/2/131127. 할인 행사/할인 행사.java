import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer>[] arr = new HashMap[discount.length + 1];
        for(int i = 0 ; i <= discount.length ; i++) arr[i] = new HashMap<>();
        
        for(int i = discount.length - 1 ; i >= 0 ; i--){
            Map<String, Integer> map = arr[i];
            for(String s : arr[i+1].keySet()) {
                map.put(s, arr[i+1].get(s));
            }
            
            if(discount.length - i > 10) map.put(discount[i+10], map.get(discount[i+10])-1);
            map.put(discount[i], map.getOrDefault(discount[i], 0)+1);
        }
        
        int answer = 0;
        
        for(int i = 0 ; i < discount.length - 9 ; i++){
            boolean check = true;
            for(int j = 0 ; j < want.length ; j++){
                if(arr[i].getOrDefault(want[j], 0) != number[j]) {
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        
        
        return answer;
    }
}