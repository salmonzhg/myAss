public class S235 {
    // https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;

        TreeNode smaller = p.val < q.val ? p : q;
        TreeNode bigger = p.val > q.val ? p : q;

        return find(root, smaller, bigger);
    }

    private TreeNode find(TreeNode root, TreeNode smaller, TreeNode bigger) {
        if (root == null) return root;

        if (bigger.val < root.val) {
            return find(root.left, smaller, bigger);
        } else if (smaller.val > root.val) {
            return find(root.right, smaller, bigger);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {

    }
}
