import java.util.*;

class Solution {

    static class FileInfo {
        String original;
        String head;
        int number;
        int index;

        FileInfo(String original, String head, int number, int index) {
            this.original = original;
            this.head = head;
            this.number = number;
            this.index = index;
        }
    }

    public String[] solution(String[] files) {
        List<FileInfo> list = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            list.add(parse(files[i], i));
        }

        Collections.sort(list, (a, b) -> {
            int headCompare = a.head.compareTo(b.head);
            if (headCompare != 0) return headCompare;

            if (a.number != b.number) {
                return a.number - b.number;
            }

            return a.index - b.index;
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).original;
        }

        return answer;
    }

    private FileInfo parse(String file, int index) {
        int i = 0;
        int len = file.length();

        while (i < len && !Character.isDigit(file.charAt(i))) {
            i++;
        }
        String head = file.substring(0, i).toLowerCase();

        int start = i;
        while (i < len && Character.isDigit(file.charAt(i)) && i - start < 5) {
            i++;
        }
        int number = Integer.parseInt(file.substring(start, i));

        return new FileInfo(file, head, number, index);
    }
}
