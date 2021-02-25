class WordFilter {
    Trie root = new Trie();
    Map<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        for (int i = words.length - 1; i >= 0; i--) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], i);
                root.add(words[i]);
            }
        }
    }

    public int f(String prefix, String suffix) {
        List<String> words = add(prefix);
        if (words == null) {
            return -1;
        }
        for (String word : words) {
            if (word.endsWith(suffix)) {
                return map.get(word);
            }
        }
        return -1;
    }

    private List<String> add(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return root.words;
        }
        Trie cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                return null;
            }
            cur = cur.children[ch - 'a'];
        }
        return cur.words;
    }
}

class Trie {
    Trie[] children;
    List<String> words;

    public Trie() {
        children = new Trie[26];
        words = new ArrayList<>();
    }

    public void add(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            cur.words.add(word);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie();
            }
            cur = cur.children[c - 'a'];
        }
        cur.words.add(word);
    }
}
