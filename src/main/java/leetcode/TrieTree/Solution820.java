package leetcode.TrieTree;


/**
 * 倒叙字典树
 */
public class Solution820 {

    public class TrieNode {
        //boolean isEnd = false;
        char value;
        TrieNode trieNode[] = new TrieNode[26];

        //public TrieNode(char value) {
        //    this.isEnd = isEnd;
        //this.value = value;
        //}

        public TrieNode(char value) {
            this.value = value;
        }

        public TrieNode() {
        }

        public void add(String str) {
            char[] chars = str.toCharArray();
            TrieNode node = this;
            for (int i = chars.length - 1; i >= 0; i--) {
                char ch = chars[i];
                int index = ch - 'a';
                if (node.trieNode[index] == null) {
                    node.trieNode[index] = new TrieNode(ch);
                }
                node = node.trieNode[index];
            }
        }

    }

    public int minimumLengthEncoding(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        TrieNode root = new TrieNode();

        for (String str : words) {
            root.add(str);
        }

        return length(root, 1);
    }


    private int length(TrieNode trieNode, int leve) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (trieNode.trieNode[i] != null) {
                int len = length(trieNode.trieNode[i], leve + 1);
                sum += len;
            }
        }
        if (sum == 0) {
            return leve;
        }
        return sum;
    }


    public static void main(String[] args) {
        Solution820 solution = new Solution820();
        String[] a = {"time", "mee", "bell","tl"};
        System.out.println(solution.minimumLengthEncoding(a));
    }


}