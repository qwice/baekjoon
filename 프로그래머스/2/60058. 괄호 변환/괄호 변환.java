class Solution {

    public String solution(String p) {
        if (p.isEmpty()) return "";

        int balance = 0;
        int idx = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') balance++;
            else balance--;

            if (balance == 0) {
                idx = i;
                break;
            }
        }

        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);

        if (isCorrect(u)) {
            return u + solution(v);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }

        return sb.toString();
    }

    private boolean isCorrect(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') cnt++;
            else cnt--;

            if (cnt < 0) return false;
        }
        return cnt == 0;
    }
}
