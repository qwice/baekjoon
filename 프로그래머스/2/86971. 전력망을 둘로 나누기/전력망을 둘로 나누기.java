import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int count;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
            }

            visited = new boolean[n + 1];
            count = 0;
            dfs(1);

            int diff = Math.abs(n - 2 * count);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    void dfs(int node) {
        visited[node] = true;
        count++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
