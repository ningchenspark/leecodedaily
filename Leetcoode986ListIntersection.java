class Leetcode986IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;
        List<int[]> result = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        while(idx1 < len1 && idx2 < len2) {
            int start = Math.max(firstList[idx1][0], secondList[idx2][0]);
            int end   = Math.min(firstList[idx1][1], secondList[idx2][1]);
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            if (firstList[idx1][1] < secondList[idx2][1]) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}