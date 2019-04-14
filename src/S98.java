public class S98 {
    // https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.val >= root.val) return false;
        if (root.right != null && root.right.val <= root.val) return false;
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValid(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.left != null && (root.left.val <= min || root.left.val >= root.val)) return false;
        if (root.right != null && (root.right.val <= root.val || root.right.val >= max)) return false;
        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        S98 tester = new S98();

        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        System.out.println(tester.isValidBST(root));
    }

}
