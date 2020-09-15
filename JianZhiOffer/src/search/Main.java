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
