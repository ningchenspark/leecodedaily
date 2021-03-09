class Leetcode253MeetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length] ;
        int[] end = new int[intervals.length];
        int count = 0;
        for (int[] interval : intervals) {
            start[count] = interval[0];
            end[count] = interval[1];
            count++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endIdx = 0;
        int room = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[endIdx]) {
                room++;
            } else {
                endIdx++;
            }
        }
        return room;
    }
}