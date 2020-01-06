package leetcode.TrieTree;

class Trie {

    private TrieNode root;

    private class TrieNode {
        boolean isEnd = false;
        char value;
        TrieNode trieNode[] = new TrieNode[26];

        public TrieNode(boolean isEnd, char value) {
            this.isEnd = isEnd;
            this.value = value;
        }

        public TrieNode(char value) {
            this.value = value;
        }

        public TrieNode() {
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (int i = 0, len = word.length(); i < len; i++) {
            int index = letters[i] - 'a';
            if (node.trieNode[index] == null) {
                node.trieNode[index] = new TrieNode(letters[i]);
            }
            node = node.trieNode[index];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode node = findNode(word);
        if (node != null && node.isEnd == true) {
            return true;
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode node = findNode(prefix);
        if (node != null) {
            return true;
        }
        return false;
    }

    private TrieNode findNode(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (int i = 0, len = word.length(); i < len; i++) {
            int index = letters[i] - 'a';
            if (node.trieNode[index] == null) {
                return null;
            }
            node = node.trieNode[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */