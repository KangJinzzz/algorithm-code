package exam;

public class 微步1 {


    public int indexOf (String s, String pattern) {
        if (pattern.length() == 0) {
            return 0;
        }
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            if (pattern.charAt(0) == s.charAt(i)) {
                if (func(s, pattern, i)) {
                    res = i;
                    break;
                }
            }
        }
        return res;
    }

    public boolean func(String s, String pattern, int start) {
        for (int i = 0; i < pattern.length(); i++) {
            if (i + start >= s.length() || pattern.charAt(i) != s.charAt(i + start)) {
                return false;
            }
        }
        return true;
    }
}
