class Leetcode1229MeetingSchedul {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int idx1 = 0, idx2 = 0;
        List<Integer> list = new ArrayList<>();
        while (idx1 < slots1.length && idx2 < slots2.length) {
            int start = Math.max(slots1[idx1][0], slots2[idx2][0]);
            int end = Math.min(slots1[idx1][1], slots2[idx2][1]);
            if (start + duration <= end) {
                list.add(start);
                list.add(start + duration);
                return list;
            }
            if (slots1[idx1][1] > slots2[idx2][1]) {
                idx2++;
            } else {
                idx1++;
            }
        }
        return list;
    }
}