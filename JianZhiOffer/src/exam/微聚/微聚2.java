package exam.微聚;

public class 微聚2 {
    //F（i）以第i个字母结尾的最长子串
    public String longestPalindrome (String s) {
        String res = "";
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                String pal = s.substring(j, i);
                if (isPal(pal) && pal.length() > res.length()) {
                    res = pal;
                }
            }
        }
        return res;
    }

    public boolean isPal(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
