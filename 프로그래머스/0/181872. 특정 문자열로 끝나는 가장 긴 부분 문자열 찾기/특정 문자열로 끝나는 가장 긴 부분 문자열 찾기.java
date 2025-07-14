class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        int idx = myString.lastIndexOf(pat);
        if (idx == -1) return "";
        answer = myString.substring(0, idx + pat.length());
        
        return answer;
    }
}