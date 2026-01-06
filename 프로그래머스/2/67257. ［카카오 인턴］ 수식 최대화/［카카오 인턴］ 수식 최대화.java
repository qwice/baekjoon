import java.util.*;

class Solution {
    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                numbers.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                ops.add(c);
            } else {
                sb.append(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));

        char[][] orders = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'}
        };

        long answer = 0;
        for (char[] order : orders) {
            answer = Math.max(answer, calc(numbers, ops, order));
        }

        return answer;
    }

    long calc(List<Long> nums, List<Character> ops, char[] order) {
        List<Long> n = new ArrayList<>(nums);
        List<Character> o = new ArrayList<>(ops);

        for (char op : order) {
            for (int i = 0; i < o.size(); ) {
                if (o.get(i) == op) {
                    long a = n.remove(i);
                    long b = n.remove(i);
                    long res = operate(a, b, op);
                    n.add(i, res);
                    o.remove(i);
                } else i++;
            }
        }
        return Math.abs(n.get(0));
    }

    long operate(long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }
}
