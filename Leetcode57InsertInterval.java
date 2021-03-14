class Leetcode57InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int[] current = newInterval;
        for (int i = 0; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            int v = i;
            if (hasOverlap(current, intervals[i])) {
                current[0] = Math.min(current[0], intervals[i][0]);
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                if (current[1] < intervals[i][0]) {
                    result.add(current);
                    current = intervals[i];
                } else {
                    result.add(intervals[i]);
                }
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][2]);
    }
    private boolean hasOverlap(int[] a, int[] b) {
        int start = Math.max(a[0], b[0]);
        int end = Math.min(a[1], b[1]);
        return start <= end;
    }
}