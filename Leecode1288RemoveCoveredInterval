class Leecode1288RemoveCoverdInterval {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            List<int[]> cResult = checkCovered(current, intervals[i]);
            if (cResult.size() == 1) {
                current = cResult.get(0);
            } else {
                merged.add(cResult.get(0));
                current = cResult.get(1);
            }
        }
        merged.add(current);
        return merged.size();
    }
    private List<int[]> checkCovered(int[] i1, int[] i2) {
        List<int[]> result = new ArrayList<>();

        if (i1[0] <= i2[0] && i1[1] >= i2[1]) {
            result.add(i1);
        } else if (i1[0] >= i2[0] && i1[1] <= i2[1]){
            result.add(i2);
        } else {
            result.add(i1);
            result.add(i2);
        }
        return result;
    }
}