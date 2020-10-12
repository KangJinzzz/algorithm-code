package exam;

import java.util.Map;
import java.util.Scanner;

public class Main1 {
    static int min = Integer.MAX_VALUE;
    static int[][] position = new int[][] {{0, 1}, {0, -1},{1, 0}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.nextLine();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = sc.nextLine();
            }
            int[][] used = new int[n][n];
            char[][] chars = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chars[i][j] = strs[i].charAt(j);
                    if (chars[i][j] == '1') {
                        used[i][j] = 1;
                    }
                }
            }
            dfs(chars, used, 0, 0, n, k, -1);
            System.out.println(min);
            min = Integer.MAX_VALUE;
        }
    }

    private static void dfs(char[][] chars, int[][] used, int x, int y, int n, int k, int res) {

        res++;
        if (chars[x][y] == '#') {
            res += k;
        }
        if (x == n - 1 && y == n - 1) {
            if (min > res) {
                min = res;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + position[i][0];
            int ny = y + position[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            if (used[nx][ny] == 0 && chars[nx][ny] != '1') {
                used[nx][ny] = 1;
                dfs(chars, used, nx, ny, n, k, res);
                used[nx][ny] = 0;
            }
        }
    }
}
