package exam;

import java.util.*;

public class 老虎1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int W = sc.nextInt();
            int K = sc.nextInt();
            int[] costs = new int[N];
            int[] profits = new int[N];
            for (int i = 0; i < N; i++) {
                costs[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                profits[i] = sc.nextInt();
            }
            List<Projec> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new Projec(costs[i], profits[i]));
            }
            Collections.sort(list, new Compare());
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < list.size(); j++) {
                    Projec p = list.get(j);
                    if (p.cost > W) {
                        continue;
                    } else {
                        W += p.profit;
                        list.remove(j);
                        break;
                    }
                }
            }
            System.out.println(W);
        }
    }
}

class Projec implements Comparator<Projec> {
    public int cost = 0;
    public int profit = 0;
    public Projec (int cost, int profit) {
        this.cost = cost;
        this.profit = profit;
    }


    @Override
    public int compare(Projec o1, Projec o2) {
        if (o1.profit == o2.profit) {
            return o1.cost - o2.cost;
        }
        return o2.profit - o1.profit;
    }
}

class Compare implements Comparator<Projec> {

    @Override
    public int compare(Projec o1, Projec o2) {
        if (o1.profit == o2.profit) {
            return o1.cost - o2.cost;
        }
        return o2.profit - o1.profit;
    }
}