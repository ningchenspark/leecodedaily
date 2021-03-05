class Leetcode1560LCA3 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node c1 = p, c2 = q;
        while (c1 != c2) {
            if (c1.parent != null) {
                c1 = c1.parent;
            } else {
                c1 = q;
            }
            if (c2.parent != null) {
                c2 = c2.parent;
            } else {
                c2 = p;
            }
        }
        return c1;
    }
}