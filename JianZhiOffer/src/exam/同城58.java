package exam;

import java.util.ArrayList;
import java.util.List;

public class 同城58 {
    public static void main(String[] args) {
        System.out.println(calculate("1 + 5"));
    }

    public static int calculate (String input) {
        String[] strs = input.split(" ");
        List<String> list = new ArrayList<>();
        int jia = 0;
        int cheng = 0;
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
//            if (s.equals(" ")) {
//                list.remove(list.size() - 1);
//                list.add(strs[i - 1] + strs[i]);
//            } else
            if (s.equals("+") || s.equals("-")) {
                jia++;
            } else if (s.equals("*") || s.equals("/")) {
                cheng++;
            }
        }
        //先算乘除
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("*")) {
                int v1 = Integer.valueOf(list.get(i - 1));
                int v2 = Integer.valueOf(list.get(i + 1));
                for (int j = 0; j < 3; j++) {
                    list.remove(i - 1);
                }
                String ss = String.valueOf(v1 * v2);
                list.add(i - 1, ss);
            } else if (s.equals("/")){
                int v1 = Integer.valueOf(list.get(i - 1));
                int v2 = Integer.valueOf(list.get(i + 1));
                for (int j = 0; j < 3; j++) {
                    list.remove(i - 1);
                }
                String ss = String.valueOf(v1 / v2);
                list.add(i - 1, ss);
            }
        }
        //加减
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("+")) {
                int v1 = Integer.valueOf(list.get(i - 1));
                int v2 = Integer.valueOf(list.get(i + 1));
                for (int j = 0; j < 3; j++) {
                    list.remove(i - 1);
                }
                String ss = String.valueOf(v1 + v2);
                list.add(i - 1, ss);
            } else if (s.equals("-")){
                int v1 = Integer.valueOf(list.get(i - 1));
                int v2 = Integer.valueOf(list.get(i + 1));
                for (int j = 0; j < 3; j++) {
                    list.remove(i - 1);
                }
                String ss = String.valueOf(v1 - v2);
                list.add(i - 1, ss);
            }
        }
        return Integer.valueOf(list.get(0));
    }

}
