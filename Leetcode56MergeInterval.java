class Leetcode56MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] current = intervals[0];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] < intervals[i][0]) {
                result.add(current);
                current = intervals[i];
            } else {
                current[1] = Math.max(current[1], intervals[i][1]);
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][2]);
    }
}