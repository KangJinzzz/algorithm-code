package exam;

public class 最右2 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * func getTriggerTime(increase [][]int, requirements [][]int) []int
     * @param increase int整型二维数组 属性增加值
     * @param requirements int整型二维数组 剧情触发要求
     * @return int整型一维数组
     */
    public int[] getTriggerTime (int[][] increase, int[][] requirements) {
        int c = 0;
        int r = 0;
        int h = 0;
        int[] res = new int[requirements.length];
        int[] used = new int[requirements.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < requirements.length; i++) {
            if (requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2] == 0) {
                res[i] = 0;
                used[i] = 1;
            }
        }
        for (int i = 0; i < increase.length; i++) {
            c += increase[i][0];
            r += increase[i][1];
            h += increase[i][2];
            check(c, r, h, requirements, res, i + 1, used);
        }
        return res;
    }

    public void check(int c, int r, int h, int[][] req, int[] res, int day, int[] used) {
        for (int i = 0; i < req.length; i++) {
            if (used[i] == 0 && c >= req[i][0] && r >= req[i][1] && h >= req[i][2]) {
                used[i] = 1;
                res[i] = day;
            }
        }
    }
}
