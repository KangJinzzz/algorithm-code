package dp;

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