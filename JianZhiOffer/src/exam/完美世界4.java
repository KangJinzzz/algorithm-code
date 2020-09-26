package exam;

import java.util.Scanner;

public class 完美世界4 {
    int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                dp[i][1] = 1;
            }
            for (int i = 1; i <= n; i++) {
                dp[1][i] = 1;
            }
            for (int i = 2; i <= m; i++) {
                for (int j = 2; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            System.out.println(dp[m][n]);
        }
        sc.close();
    }


}
