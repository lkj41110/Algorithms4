package leetcode.TrieTree;//package leetcode.TrieTree;
//
//import java.util.LinkedList;
//
//class MagicDictionary {
//
//    private TrieNode root;
//
//    private class TrieNode {
//        boolean isEnd = false;
//        char key;
//
//        TrieNode trieNode[] = new TrieNode[26];
//
//        public TrieNode(boolean isEnd, char key) {
//            this.isEnd = isEnd;
//            this.key = key;
//        }
//
//        public TrieNode(char key) {
//            this.key = key;
//        }
//
//        public TrieNode() {
//        }
//    }
//
//    private void insert(String word) {
//        if (word == null || word.length() == 0) {
//            return;
//        }
//        TrieNode node = root;
//        char[] letters = word.toCharArray();
//        for (int i = 0, len = word.length(); i < len; i++) {
//            int index = letters[i] - 'a';
//            if (node.trieNode[index] == null) {
//                node.trieNode[index] = new TrieNode(letters[i]);
//            }
//            node = node.trieNode[index];
//        }
//        node.isEnd = true;
//    }
//
//    private class Mapper{
//        TrieNode trieNode;
//        boolean flag;
//        int index=0;
//
//        public Mapper(TrieNode trieNode, boolean flag,int index) {
//            this.trieNode = trieNode;
//            this.flag = flag;
//            this.index = index;
//        }
//    }
//    /**
//     * Initialize your data structure here.
//     */
//    public MagicDictionary() {
//        root = new TrieNode();
//    }
//
//    /**
//     * Build a dictionary through a list of words
//     */
//    public void buildDict(String[] dict) {
//        for (int i = 0; i < dict.length; i++) {
//            insert(dict[i]);
//        }
//    }
//
//    /**
//     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
//     */
//    public boolean search(String word) {
//        //return findNode(word, root, false);
//        if (word == null || word.length() == 0) {
//            return false;
//        }
//        char[] letters = word.toCharArray();
//        LinkedList<Mapper> queue = new LinkedList();
//        queue.offer(new Mapper(root, false, -1));
//        while (queue.size() > 0) {
//            Mapper mapper = queue.pop();
//            TrieNode node = mapper.trieNode;
//            if (mapper.index == word.length() - 1) {
//                if (node.key == letters[mapper.index] && mapper.flag) {
//                    return true;
//                }
//                if (node.key != letters[mapper.index] && !mapper.flag) {
//                    return true;
//                }
//            } else{
//a
//                if((mapper.index >= 0)){
//
//                }
//                for (int j = 0; j < 26; j++) {
//                    if (node.trieNode[j] == null) {
//                        continue;
//                    }
//                    queue.offer(new Mapper())
//                }
//
//            }
//
//        }
//        return false;
//    }
//
//    private boolean findNode(String word, TrieNode trie, boolean flag) {
//        if (word == null || word.length() == 0) {
//            return false;
//        }
//        TrieNode node = trie;
//        //对应的参数
//        //int index = word.charAt(0) - 'a';
//        //if (node.trieNode[index] != null) {
//        //    if (word.length() == 1 && node.trieNode[index].isEnd) {
//        //        return true;
//        //    } else if (findNode(word.substring(1), node.trieNode[index], flag)) {
//        //        return true;
//        //    }
//        //}
//        //不存在对应的参数
//        for (int j = 0; j < 26; j++) {
//            if (node.trieNode[j] == null) {
//                continue;
//            }
//            if (node.trieNode[j].key == word.charAt(0)) {
//                if (word.length() == 1 && node.trieNode[j].isEnd && flag) {
//                    return flag;
//                }
//                if (findNode(word.substring(1), node.trieNode[j], flag)) {
//                    return true;
//                }
//            } else if (!flag) {
//                if (word.length() == 1 && node.trieNode[j].isEnd) {
//                    return true;
//                } else if (findNode(word.substring(1), node.trieNode[j], true)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        MagicDictionary obj = new MagicDictionary();
//        obj.buildDict(new String[]{"judgg","judge"});
//        boolean param_2 = obj.search("judge");
//        System.out.println(param_2);
//    }
//}
//
///**
// * Your MagicDictionary object will be instantiated and called as such:
// * MagicDictionary obj = new MagicDictionary();
// * obj.buildDict(dict);
// * boolean param_2 = obj.search(word);
// */