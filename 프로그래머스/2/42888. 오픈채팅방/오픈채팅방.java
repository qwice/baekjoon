import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int n = 0;
        Map<String, String> name = new HashMap<>();
        for(String st : record) {
            if(st.contains("Enter") || st.contains("Leave")) n++;
            if(!(st.contains("Enter") || st.contains("Change"))) continue;
            String[] line = st.split(" ");
            name.put(line[1], line[2]);
        }
        
        String[] answer = new String[n];
        n = 0;
        
        for(String st : record){
            if(st.contains("Change")) continue;
            String[] line = st.split(" ");
            if(line[0].equals("Enter")) {
                answer[n++] = name.get(line[1]) + "님이 들어왔습니다.";
            } else {
                answer[n++] = name.get(line[1]) + "님이 나갔습니다.";
            } 
        }
        return answer;
    }
}