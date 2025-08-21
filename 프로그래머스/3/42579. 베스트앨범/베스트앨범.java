import java.util.*;

class Solution {
    class Music implements Comparable<Music>{
        String genre;
        int total;
        int first;
        int second;
        
        public Music(String genre, int total, int first, int second) {
            this.genre = genre;
            this.total = total;
            this.first = first;
            this.second = second;
        }
        
        @Override
        public int compareTo(Music o) {
            // return this.total - o.total;
            return o.total - this.total;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Music> mList = new ArrayList<>();
        
        for(int i = 0 ; i < genres.length ; i++) {
            if(map.containsKey(genres[i])) {
                int total = map.get(genres[i]).get(0);
                int first = map.get(genres[i]).get(1);
                int firstCnt = map.get(genres[i]).get(2);
                int second = map.get(genres[i]).get(3);
                int secondCnt = map.get(genres[i]).get(4);
                
                total += plays[i];
                
                if(firstCnt < plays[i]) {
                    second = first;
                    secondCnt = firstCnt;
                    first = i;
                    firstCnt = plays[i];
                } else if(secondCnt < plays[i]) {
                    second = i;
                    secondCnt = plays[i];
                }
                
                List<Integer> list = Arrays.asList(total, first, firstCnt, second, secondCnt);
                
                map.put(genres[i], list);
            } else {
                int total = plays[i];
                int first = i;
                int firstCnt = plays[i];
                int second = -1;
                int secondCnt = 0;
                
                List<Integer> list = Arrays.asList(total, first, firstCnt, second, secondCnt);
                
                map.put(genres[i], list);
            }
        }
        
        for(String key : map.keySet()) {
            List<Integer> list = map.get(key);
            
            Music music = new Music(key, list.get(0), list.get(1), list.get(3));
            mList.add(music);
        }
        
        Collections.sort(mList);
        
        List<Integer> ans = new ArrayList<>();
        
        for(Music m : mList) {
            ans.add(m.first);
            if(m.second != -1) ans.add(m.second);
        }
        
        System.out.print(ans);
        
        int[] answer = ans.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}