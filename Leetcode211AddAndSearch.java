class Leetcode211AddAndSearch {
    TrieNode root = new TrieNode('/');
    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode(word.charAt(i));
            }
            current = current.children[idx];
        }
        current.word = word;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
    private boolean search(String word, int idx, TrieNode current) {
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : current.children) {
                    if (child != null && search(word, i + 1, child)){
                        return true;
                    }
                }
                return false;
            } else {
                if (current.children[c - 'a'] == null) {
                    return false;
                }
                current = current.children[c - 'a'];
            }
        }
        return current.word != null;
    }
    class TrieNode {
        char c;
        TrieNode[] children;
        String word;
        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */