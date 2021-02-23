class Trie {
    TrieNode root ;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode(c);
            }
            current = current.children[idx];
        }

        current.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }
        return current.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            current = current.children[idx];
        }
        return true;
    }
    class TrieNode {
        char c;
        TrieNode[] children;
        boolean isWord;
        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */