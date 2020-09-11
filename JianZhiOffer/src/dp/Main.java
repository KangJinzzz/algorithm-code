package dp;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Main {


}

class Solution1 {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}


class Solution2 {
    // 状态：F(n):还剩n阶台阶的跳法数
    // 转移方程：跳1阶，还剩n - 1阶，F(n - 1)
    //          跳2阶，还剩n - 2阶，F(n - 2)
    // ....
    //          跳n阶，还剩n - n阶，F(0)
    //  F(n) = F(n - 1) + F(n - 2) + ... + F(0)
    //  F(n - 1) = F(n - 2) + f(n - 3) + .. +F(0)
    //  F(n) = 2 * F(n - 1)
    public int JumpFloorII(int target) {
        int ways = 1;
        for (int i = 2; i <= target; i++) {
            ways *= 2;
        }
        return ways;
    }
}

class Solution3 {
    // 状态：F(i):以第 i 个数字结尾的最大连续和
    // 转移方程：F(i - 1) > 0: F(i) = arr[i] + F(i - 1)
    //          F(i - 1) <= 0: F(i) = arr[i];
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int x : array) {
            if (sum < 0) {
                sum = x;
            } else {
                sum += x;
            }
            max = sum > max ? sum : max;
        }
        return max;
    }
}


class Solution4 {
    // 状态：F(i):前i个字符是否可以被分割
    // 转移方程：true：F(j) && s.substring(j, i), j = 0, 1, 2, ..., i - 1
    //         否则为：false
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                }
            }
        }
        return canBreak[s.length()];
    }
}

class Solution5 {
    // 状态：F(i, j):从 i + 1 行到 (i, j) 的最短路径
    // 转移方程：F(i, j) = min(F(i + 1, j), F(i + 1, j + 1)) + triangle[i][j];
    // 因为只需保存要求当前行的下一行，只需一维数组
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int len = triangle.get(triangle.size() - 1).size();
        int[] min = new int[len];
        //初始化
        for (int i = 0; i < len; i++) {
            min[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            int col = triangle.get(i).size();
            for (int j = 0; j < col; j++) {
                min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
            }
        }
        return min[0];
    }
}


class Solution6 {
    // 状态：F(i, j):走到（i，j）的方法数
    // 转移方程：F（i，j）= F（i - 1, j) + F(i, j - 1)
    /**
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        int[][] ways = new int[m][n];
        // 初始化
        ways[0][0] = 1;
        for (int i = 1; i < m; i++) {
            ways[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            ways[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[m - 1][n - 1];
    }
}


class Solution7 {
    /**
     *
     * @param obstacleGrid int整型二维数组
     * @return int整型
     */
    public int uniquePathsWithObstacles (int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] ways = new int[m][n];
        ways[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            ways[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            ways[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[m - 1][n - 1];
    }
}



class Solution8 {
    /**
     *
     * @param grid int整型二维数组
     * @return int整型
     */
    public int minPathSum (int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] min = new int[m][n];
        min[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            min[i][0] = min[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            min[0][j] = min[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j];
            }
        }
        return min[m - 1][n - 1];
    }
}

class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int v = sc.nextInt();
            int[][] goods = new int[n][2];
            for (int i = 0; i < n; i++) {
                goods[i][0] = sc.nextInt();
                goods[i][1] = sc.nextInt();
            }
            int max = dp(goods, v);
            System.out.println(max);
        }
    }
    //状态：F(i, j):背包大小为j时，前i间物品可获得的最大价值
    public static int dp(int[][] goods, int v) {
        int[][] maxVal = new int[goods.length + 1][v + 1];
        for (int i = 1; i <= goods.length; i++) {
            for (int j = 1; j <= v; j++) {
                if (goods[i - 1][1] > j) {
                    maxVal[i][j] = maxVal[i - 1][j];
                } else {
                    maxVal[i][j] = Math.max(maxVal[i - 1][j], goods[i - 1][0] + maxVal[i - 2][j - goods[i - 1][1]]);
                }
            }
        }
        return maxVal[goods.length][v];
    }
}