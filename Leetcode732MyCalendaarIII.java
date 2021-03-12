class Leetcode732MyCalendarIII {
    TreeMap<Integer, Integer> timeline = new TreeMap<>();
    public MyCalendarThree() {

    }

    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        int max = 0, ongoing = 0;
        for (int v : timeline.values()) {
            max = Math.max(max, ongoing += v);
        }
        return max;
    }
}