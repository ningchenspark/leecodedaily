class Leetcode131ParlindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s.toCharArray(), result, new ArrayList<>(), 0);
        return result;
    }
    private void dfs(char[] chars, List<List<String>> result, List<String> curList, int idx) {
        if (idx == chars.length) {
            result.add(new ArrayList<>(curList));
        }
        for (int i = idx; i < chars.length; i++) {
            if (isParlindrome(chars, idx, i)) {
                curList.add(new String(chars, idx, i - idx + 1));
                dfs(chars, result, curList, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }
    private boolean isParlindrome(char[] chars, int start, int end) {
        while(start <= end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }
}