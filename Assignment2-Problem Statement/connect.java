import java.util.*;

class Solution1 {
    public int countReachableCities(int n, int m, int d, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;

        int ans = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (dist[u] == d)
                continue;

            for (int v : graph[u]) {
                if (dist[v] != -1)
                    continue;

                dist[v] = dist[u] + 1;
                ans++;
                queue.add(v);
            }
        }
        return ans;
    }
}

public class connect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        Solution1 solution = new Solution1();
        System.out.println(
                solution.countReachableCities(n, m, d, edges)
        );
        sc.close();
    }
}