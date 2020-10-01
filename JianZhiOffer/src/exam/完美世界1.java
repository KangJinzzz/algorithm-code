package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 完美世界1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int lenA = sc.nextInt();
            int lenB = sc.nextInt();
            List<Integer> lista = new ArrayList<>();
            List<Integer> listb = new ArrayList<>();
            for (int i = 0; i < lenA; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                for (int j = 0; j < y; j++) {
                    lista.add(x);
                }
            }
            for (int i = 0; i < lenB; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                for (int j = 0; j < y; j++) {
                    listb.add(x);
                }
            }
            int res = 0;
            for (int x : lista) {
                for (int y : listb) {
                    if (x > y) {
                       res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
