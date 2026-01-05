class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;

        m = convert(m);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");

            int start = toMin(info[0]);
            int end = toMin(info[1]);
            int playTime = end - start;

            String title = info[2];
            String melody = convert(info[3]);

            StringBuilder played = new StringBuilder();
            for (int j = 0; j < playTime; j++) {
                played.append(melody.charAt(j % melody.length()));
            }

            if (played.toString().contains(m)) {
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    private int toMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    private String convert(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("E#", "e")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }
}
