import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class L2022211904_9_Test {

    /*
     * 测试用例设计的总体原则：
     * 1. 等价类划分：将输入数据分为有效和无效类，确保测试覆盖这两类。
     * 2. 边界值分析：关注输入的边界情况，如最小和最大值。
     * 3. 组合测试：考虑不同情况下的组合，确保各类输入的全面性。
     * 4. 功能测试：验证函数的基本功能，确保其逻辑正确性。
     */

    @Test
    void testPossibleBipartition1() {
        // 测试目的：验证在给定的 dislikes 下，能否成功将 4 个人分成两组。
        // 用到的测试用例：n = 4, dislikes = [[1, 2], [1, 3], [2, 4]]
        Solution9 solution = new Solution9();
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        assertTrue(solution.possibleBipartition(n, dislikes));
    }

    @Test
    void testPossibleBipartition2() {
        // 测试目的：验证在给定的 dislikes 下，是否无法将 3 个人分成两组。
        // 用到的测试用例：n = 3, dislikes = [[1, 2], [1, 3], [2, 3]]
        Solution9 solution = new Solution9();
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        assertFalse(solution.possibleBipartition(n, dislikes));
    }

    @Test
    void testPossibleBipartition3() {
        // 测试目的：验证在给定的 dislikes 下，是否无法将 5 个人分成两组。
        // 用到的测试用例：n = 5, dislikes = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]]
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        assertFalse(solution.possibleBipartition(n, dislikes));
    }
}
