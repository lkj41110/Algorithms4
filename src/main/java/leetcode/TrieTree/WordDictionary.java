package leetcode.TrieTree;

class WordDictionary {

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
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return find(root, word);
    }

    private boolean find(TrieNode trieNode, String word) {
        if (word == null || word.length() == 0) {
            return trieNode.isEnd;
        }
        TrieNode node = trieNode;
        char[] letters = word.toCharArray();
        for (int i = 0, len = word.length(); i < len; i++) {
            if (letters[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.trieNode[j] == null) {
                        continue;
                    }
                    if (find(node.trieNode[j], word.substring(i + 1)))
                        return true;
                }
                return false;
            } else {
                int index = letters[i] - 'a';
                if (node.trieNode[index] == null) {
                    return false;
                }
                node = node.trieNode[index];
            }
        }
        if (node != null && node.isEnd == true) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("addword");
        wordDictionary.addWord("c");
        //System.out.println(wordDictionary.search("bad"));
        //System.out.println(wordDictionary.search("pad"));
        //System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".."));
        System.out.println(wordDictionary.search("b.d"));
        System.out.println(wordDictionary.search("a."));
        System.out.println(wordDictionary.search("b.."));
        System.out.println(wordDictionary.search("."));

        //search("pad") -> false
        //search("bad") -> true
        //search(".ad") -> true
        //search("b..") -> true
    }

}