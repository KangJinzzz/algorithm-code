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


//下厨房  错误！未通过
class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            Set<String> set = new HashSet<>();
            String material = scanner.next();
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < material.length(); i++) {
                if(material.charAt(i) != ' ') {
                    stringBuilder.append(material.charAt(i));
                }
                else {
                    set.add(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
            }
            System.out.println(set.size());
        }

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
