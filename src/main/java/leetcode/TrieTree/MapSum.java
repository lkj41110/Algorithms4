package leetcode.TrieTree;

public class MapSum {
    private TrieNode root;

    private class TrieNode {
        boolean isEnd = false;
        char key;
        int value = 0;

        TrieNode trieNode[] = new TrieNode[26];

        public TrieNode(boolean isEnd, char key, int value) {
            this.isEnd = isEnd;
            this.key = key;
            this.value = value;
        }

        public TrieNode(char key) {
            this.key = key;
        }

        public TrieNode() {
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String word, int val) {
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
        node.value = val;
    }

    public int sum(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return 0;
        }
        TrieNode node = findNode(prefix);
        if (node != null) {
            return sumVal(node);
        }
        return 0;
    }

    private int sumVal(TrieNode node) {
        if (node == null)
            return 0;
        int sum = node.value;
        for (int i = 0; i < 26; i++) {
            sum += sumVal(node.trieNode[i]);
        }
        return sum;
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
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */