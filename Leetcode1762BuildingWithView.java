class Leetcode1762BuildingWithView {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = heights.length -1; i >= 0; i--) {
            // if (!deque.isEmpty())
            //     System.out.println(heights[deque.peekLast()] + "<" + heights[i]);
            if (deque.isEmpty() || heights[deque.peekLast()] < heights[i]) {
                deque.addLast(i);
            }
        }
        int size = deque.size();
        int[] result = new int[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            result[count++] = deque.pollLast();
        }
        return result;
    }
}