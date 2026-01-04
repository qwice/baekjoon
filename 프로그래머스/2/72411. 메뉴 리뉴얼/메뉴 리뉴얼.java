import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for (int len : course) {
            map.clear();

            for (String order : orders) {
                if (order.length() >= len) {
                    comb(order, "", 0, len);
                }
            }

            int max = 0;
            for (int cnt : map.values()) {
                max = Math.max(max, cnt);
            }

            if (max >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == max) {
                        answer.add(key);
                    }
                }
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }

    private void comb(String order, String cur, int idx, int len) {
        if (cur.length() == len) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            comb(order, cur + order.charAt(i), i + 1, len);
        }
    }
}
