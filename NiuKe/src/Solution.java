import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution {

    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right== null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if(left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left != null ? left : pRootOfTree;

    }



}

//[编程题]旧键盘 (20)
class Main0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Character> actual = new HashSet<>();
        Set<Character> print = new HashSet<>();
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            s1 = s1.toUpperCase();
            s2 = s2.toUpperCase();
            for(int i = 0; i < s2.length(); i++) {
                actual.add(s2.charAt(i));
            }
            for(int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                //
                if(actual.contains(c)) {
                    continue;
                }
                if(print.contains(c)) {
                    continue;
                }
                System.out.print(c);
                print.add(c);
            }
        }
    }
}


//下厨房
class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();

        while(scanner.hasNext()) {
            String material = scanner.next();

            String[] arr = material.split(" ");
            for (String str : arr) {
                set.add(str);
            }
        }
        System.out.println(set.size());
    }
}

//Fibonacci数列
class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int a = 0;
            int b = 1;
            int c = a + b;
            while (true) {
                if(n == c) {
                    System.out.println(0);
                    return;
                } else if(n > c) {
                    a = b;
                    b = c;
                    c = a + b;
                } else {
                    int min = n - b;
                    if((c - n) < min) {
                        min = c - n;
                    }
                    System.out.println(min);
                    return;
                }
            }

        }
    }
}

//字符串中找出连续最长的数字串
class Main3 {
    public static void fun(String str) {
        StringBuilder sb = new StringBuilder();
        String print = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sb.append(str.charAt(i));
            } else {
                if (sb.toString().length() > print.length()) {
                    print = sb.toString();
                } else if (sb.length() > 0) {
                    sb.delete(0, sb.length());
                }
            }
            if (i == str.length() - 1) {
                if (sb.toString().length() > print.length()) {
                    print = sb.toString();
                }
            }
        }
        System.out.println(print);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            fun(str);
        }
    }
}

//统计回文
class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A;
        String B;
        int ret = 0;
        while (!sc.hasNext("0")) {
            A = sc.nextLine();
            B = sc.nextLine();
            for (int i = 0; i <= A.length(); i++) {
                StringBuilder builder = new StringBuilder(A);
                builder.insert(i, B);
                if (fun(builder.toString())) {
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }
    public static Boolean fun(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right)  {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}

//寻找第k大
class Finder {
    public int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, n - 1, K);
    }

    public int quickSort(int[] a, int left, int right, int K) {
        int pivotIndex = partion(a, left, right);
        if (pivotIndex + 1== K) {
            return a[pivotIndex];
        }
        if (pivotIndex + 1 > K) {
            return quickSort(a, left, pivotIndex - 1, K);
        }
        return quickSort(a, pivotIndex + 1, right, K);
    }

    public int partion(int[] a, int left, int right) {
        int i = left;
        int j = right;
        int pivot = a[left];
        while (i < j) {
            while (i < j && a[j] <= pivot) {
                j--;
            }
            while (i < j && a[i] >= pivot) {
                i++;
            }
            swap(a, i, j);
        }
        swap(a, i, left);
        return i;
    }

    public void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}


class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())) {
            int drink = 0;
            int blank = 0;
            blank = sc.nextInt();
            if (blank > 0 && blank <= 100) {
                while (blank >= 3) {
                    drink += blank / 3;
                    blank = blank / 3 + blank % 3;
                }
                if (blank == 2) {
                    drink++;
                }
                System.out.println(drink);
            }

        }
    }
}