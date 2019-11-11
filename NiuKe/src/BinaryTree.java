import java.util.Scanner;

//二叉树遍历
//    编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
//    例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。建立起此二叉树以后，
//    再对二叉树进行中序遍历，输出遍历结果。

class TreeNode {
    public char val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(char val) {
        this.val = val;
    }
}
public class BinaryTree {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.next();
            TreeNode root = buildTree(str);
            inOrder(root);
            System.out.println();
        }
    }

    static int index = 0;
    public static TreeNode buildTree(String str) {
        index = 0;
        return creatTree(str);
    }
    public static TreeNode creatTree(String str) {
        char c = str.charAt(index);
        if(c == '#') {
            return null;
        }
        TreeNode root = new TreeNode(c);
        index++;
        root.left = creatTree(str);
        index++;
        root.right = creatTree(str);
        return root;
    }
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

}
