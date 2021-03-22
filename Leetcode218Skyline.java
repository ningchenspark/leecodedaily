class Leetcode218Skyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int rightPos = 0;
        SegmentTree tree = new SegmentTree(0, Integer.MAX_VALUE, 0, null, null);
        for(int[] b : buildings) {
            tree.setStatus(b[0], b[1], b[2]);//add each build to the tree
            rightPos = Math.max(rightPos, b[1]);
        }//rightPos: rightmost x of all building's right x
        LinkedList<List<Integer>> res = new LinkedList<>();
        tree.getSkyline(res, rightPos);
        if(rightPos == Integer.MAX_VALUE)
            res.add(Arrays.asList(new Integer[]{Integer.MAX_VALUE, 0}));
        return res;
    }
}
class SegmentTree {
    int start, end;//initially: start = 0, end = MAX_VALUE
    int status;//initially: status = 0;
    SegmentTree left, right;//left and right child;

    public SegmentTree(int s, int e, int stu, SegmentTree l, SegmentTree r) {
        start = s;
        end = e;
        status = stu;
        left = l;
        right = r;
    }

    //a:left x, b: right x, s: height
    public void setStatus(int a, int b, int s) {
        if (start >= b || end <= a) {//[a,b]与[start,end]不交叉
            return;
        }
        if (a <= start && end <= b && left == null) {//[a, start,end, b]
            left = null;
            right = null;
            status = Math.max(status, s);
            return;
        }
        if (left == null) {
            int mid = start + (end - start) / 2;
            left = new SegmentTree(start, mid, status, null, null);
            right = new SegmentTree(mid, end, status, null, null);
        }//set child if not set

        //add rectangle to left child
        left.setStatus(a, b, s);
        //add rectangle to right child
        right.setStatus(a, b, s);
        status = Math.max(left.status, right.status);
    }

    public void getSkyline(LinkedList<List<Integer>> res, int rightPos) {
        if(start > rightPos) return;
        if(left == null) {
            Integer[] temp = new Integer[]{start, status};
            if(res.isEmpty() && temp[1] == 0)
                return;
            if( res.isEmpty() || (int)res.getLast().get(1) != (int)temp[1] )
                res.add(Arrays.asList(temp));
            return;
        }
        left.getSkyline(res, rightPos);
        right.getSkyline(res, rightPos);
    }
}