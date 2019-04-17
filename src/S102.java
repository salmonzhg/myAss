import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S102 {
    // https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> cacheQueue = new LinkedList<>();
        List<Integer> current = null;

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                if (current == null) {
                    current = new ArrayList<>();
                    result.add(current);
                }
                current.add(node.val);
                cacheQueue.add(node.left);
                cacheQueue.add(node.right);
            }

            // transfer
            if (queue.isEmpty() && !cacheQueue.isEmpty()) {
                int size = cacheQueue.size();
                for (int i = 0; i < size; i++) {
                    queue.add(cacheQueue.remove());
                }
                current = null;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
