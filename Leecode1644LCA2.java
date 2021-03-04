class Leecode1644LCA2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] result = new TreeNode[1];
        lca(root, p, q, result);
        return result[0];
    }
    private boolean[] lca(TreeNode root, TreeNode p, TreeNode q, TreeNode[] result) {
        if (root == null) {
            return new boolean[]{false, false};
        }
        boolean hasP = root.val == p.val ? true : false;
        boolean hasQ = root.val == q.val ? true : false;
        boolean[] left = lca(root.left, p, q, result);
        boolean[] right = lca(root.right, p, q, result);
        hasP = hasP || left[0] || right[0];
        hasQ = hasQ || left[1] || right[1];
        if (hasP && hasQ && result[0] == null) {
            result[0] = root;
        }
        return new boolean[] {hasP, hasQ};
    }
}