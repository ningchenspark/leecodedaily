class Leetcode323wordbreak {
    int[][] delta = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (exists(board, word)) {
                result.add(word);
            }
        }
        return result;
    }
    private boolean exists(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board , int i, int j, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (!inBoundary(board, i, j) || word.charAt(idx) != board[i][j]){
            return false;
        }
        char old = board[i][j];
        board[i][j] = '#';
        boolean found = false;
        for (int k = 0; k < 4; k++) {
            int dx = i + delta[k][0];
            int dy = j + delta[k][1];
            if (dfs(board, dx, dy, word, idx + 1)) {
                found =  true;
                break;
            }
        }
        board[i][j] = old;
        return found;
    }
    private boolean inBoundary(char[][] board, int x, int y) {
        int rows = board.length;
        int cols = board[0].length;
        return x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] != '#';
    }
}