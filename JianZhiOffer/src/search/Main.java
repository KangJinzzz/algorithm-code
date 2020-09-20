package search;

import java.util.*;

public class Main {
}

class Solution1 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int sum = 0;
        while (!queue.isEmpty()) {
            Employee em = map.get(queue.poll());
            sum += em.importance;
            for (int x : em.subordinates) {
                queue.offer(x);
            }
        }
        return sum;
    }
}

//733. 图像渲染
class Solution2 {
    int[][] position = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}} ;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor, oldColor);
        return image;
    }

    public void dfs(int[][] image, int x, int y, int newColor, int oldColor) {
        if (x <0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if (image[x][y] !=oldColor  || image[x][y] == newColor) {
            return;
        }
        image[x][y] = newColor;
        for (int i = 0; i < 4; i++) {
            dfs(image, x + position[i][0], y + position[i][1], newColor, oldColor);
        }
    }
}

//130. 被围绕的区域
class Solution3 {
    int[][] position = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        int[][] flag = new int[row][col];
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[row - 1][i] == 'O') {
                dfs(board, row - 1, i);
            }
        }
        for (int i = 1; i < row - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (board[x][y] != 'O') {
            return;
        }
        board[x][y] = '1';
        for (int i = 0; i < 4; i++) {
            dfs(board, x + position[i][0], y + position[i][1]);
        }
    }
}

//39. 组合总和
class Solution9 {
    List<List<Integer>> solutions = new ArrayList<>();
    List<Integer> solution = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return solutions;
        }
        int curSum = 0;
        dfs(candidates, target, curSum, 0);
        return solutions;
    }

    public void dfs(int[] candidates, int target, int curSum, int preIndex) {
        if (curSum >= target) {
            if (curSum == target) {
                List<Integer> tmp = new ArrayList<>(solution);
                solutions.add(tmp);
            }
            return;
        }
        for (int i = preIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            solution.add(candidates[i]);
            dfs(candidates, target, curSum + candidates[i], i);
            solution.remove(solution.size() - 1);
        }
    }

}