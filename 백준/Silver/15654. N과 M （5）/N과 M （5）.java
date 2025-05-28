import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static boolean[] visited;
    static List<Integer> selected = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int num : selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(nums[i]);
                dfs(depth + 1);
                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }
    }
}
