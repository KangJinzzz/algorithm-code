package exam;

import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = m;
            int sum = m;
            for (int i = 0; i < 3 * n - 1; i++) {
                count += m;
                sum += count;
            }
            System.out.println(sum);
        }
    }
}
