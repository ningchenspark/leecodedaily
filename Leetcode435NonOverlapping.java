class Leetcode435NonOverlapping {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] current = intervals[0];
        int num = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (overlapped(current, intervals[i])) {
                if (current[1] > intervals[i][1]) {
                    current = intervals[i];
                }
                num++;
            } else {
                current = intervals[i];
            }
        }
        return num;
    }
    private boolean overlapped(int[] a, int[] b) {
        int start = Math.max(a[0], b[0]);
        int end = Math.min(a[1], b[1]);
        return start < end;
    }
}