class Leetcode1234 {
    public int balancedString(String s) {
        int[] count = new int[26];
        int n = s.length(), res = n, i = 0, k = n / 4;
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'A'];
        }
        for (int j = 0; j < n; ++j) {
            --count[s.charAt(j) - 'A'];
            while (i < n && count['Q' - 'A'] <= k && count['W' - 'A'] <= k && count['E' - 'A'] <= k && count['R' - 'A'] <= k) {
                res = Math.min(res, j - i + 1);
                ++count[s.charAt(i++) - 'A'];
            }
        }
        return res;
    }
}