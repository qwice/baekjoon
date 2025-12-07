import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            int now = numbers[i];

            while (!stack.isEmpty() && stack.peek() <= now) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(now);
        }

        return answer;
    }
}
