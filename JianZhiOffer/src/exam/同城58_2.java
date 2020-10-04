package exam;

public class 同城58_2 {
    public int[] countBits (int num) {
        int[] res = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            int count = 0;
            for (int j = 0; j < 32; j++) {
                if (((i >> j) & 1) == 1) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

}
