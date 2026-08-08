import java.util.*;

class Solution {
    public int countTrustedServers(int n, int k, int[] key, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] parent = new int[n];
        int[] pathXor = new int[n];

        Arrays.fill(parent, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        parent[0] = 0;
        pathXor[0] = key[0];

        int ans = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (pathXor[u] >= k)
                ans++;

            for (int v : graph[u]) {
                if (v == parent[u])
                    continue;

                parent[v] = u;
                pathXor[v] = pathXor[u] ^ key[v];

                stack.push(v);
            }
        }
        return ans;
    }
}

public class trust {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] key = new int[n];

        for (int i = 0; i < n; i++)
            key[i] = sc.nextInt();

        int[][] edges = new int[n - 1][2];

        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        Solution solution = new Solution();
        System.out.println(
                solution.countTrustedServers(n, k, key, edges)
        );
        sc.close();
    }
}