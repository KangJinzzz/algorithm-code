package exam.微聚;


import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class 微聚1 {

    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> postOrderFast (TreeNode root) {
        if (root == null) {
            return list;
        }
//        postOrderFast(root.left);
//        postOrderFast(root.right);
//        list.add(root.val);
        return list;
    }
}
