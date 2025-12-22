import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> car = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        List<Integer> priceL = new ArrayList<>();
        
        for(int i = 0 ; i < records.length ; i++){
            String[] record = records[i].split(" ");
            if(record[2].equals("IN")) {
                car.put(record[1], record[0]);
            } else {
                String[] inTime = car.remove(record[1]).split(":");
                String[] outTime = record[0].split(":");
                
                int totalM = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60 + Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
                
                int tt = totalTime.getOrDefault(record[1], 0) + totalM;
                totalTime.put(record[1], tt);
            }
        }
        
        for(String s : car.keySet()){
            String[] inTime = car.get(s).split(":");
            String[] outTime = new String[]{"23", "59"};
                
                int totalM = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60 + Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
                
                int tt = totalTime.getOrDefault(s, 0) + totalM;
                totalTime.put(s, tt);
        }
        
        Set<String> key = new TreeSet<>(totalTime.keySet());
        
        for(String s : key) {
            int totalM = totalTime.get(s);
            int price = fees[1];
            if (totalM > fees[0]) {
                int extra = totalM - fees[0];
                int unit = (int) Math.ceil(extra / (double) fees[2]);
                price += unit * fees[3];
            }
            priceL.add(price);
        }
        
        int[] answer = new int[priceL.size()];
        
        for(int i = 0 ; i < priceL.size() ; i++){
            answer[i] = priceL.get(i);
        }
        
        return answer;
    }
}