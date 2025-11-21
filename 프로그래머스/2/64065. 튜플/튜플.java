import java.util.*;

class Solution {
    // public int solution(String s) {
    public int[] solution(String s) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        s = s.substring(2, s.length() - 1);
        List<Integer> subList = new ArrayList<>();
        int st = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '{' || s.charAt(i) == ',') continue;
            if(s.charAt(i) == '}') {
                list.add(subList);
                subList = new ArrayList<>();
                continue;
            }
            st = st*10 + s.charAt(i) - '0';
            if(i != s.length() - 1 && s.charAt(i+1) != ',' && s.charAt(i+1) != '}') {
                continue;
            }
            subList.add(st);
            st = 0;
        }
        
        Collections.sort(list, (a,b) -> a.size() - b.size());
        
        for(List<Integer> l : list) {
            for(Integer i : l) {
                if(ans.contains(i)) continue;
                ans.add(i);
            }
        }
        
        int[] answer = new int[ans.size()];
        int t = 0;
        for(Integer i : ans) {
            answer[t++] = i;
        }
        return answer;
    }
}