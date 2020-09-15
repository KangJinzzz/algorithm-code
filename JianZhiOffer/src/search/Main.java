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
