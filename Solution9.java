import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 *
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 *
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution9 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 用于记录每个人的组（颜色），-1 表示未分组
        int[] fa = new int[n + 1];
        Arrays.fill(fa, -1);
        
         // 创建一个邻接表来表示图
        List<Integer>[] g = new List[n + 1];

        for (int i = 0; i <= n; ++i) {
            g[i] = new ArrayList<>();
        }

        // 构建图
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        for (int i = 1; i <= n; ++i) {
            if (fa[i] == -1) {
                if (!dfs(i, 0, fa, g)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int color, int[] fa, List<Integer>[] g) {
        fa[node] = color;

        for (int neighbor : g[node]) {
            if (fa[neighbor] == -1) {
                if (!dfs(neighbor, 1 - color, fa, g)) {
                    return false;
                }
            } else if (fa[neighbor] == color) {
                return false;
            }
        }
        return true;
    }
}
