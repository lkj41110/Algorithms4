package leetcode.TrieTree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words) trie.insert(word);
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row<board.length; row++){
            for(int col = 0; col<board[row].length; col++){
                recursion(row,col,sb,trie,board,list);
            }
        }
        return list;
    }

    private void recursion(int row, int col, StringBuilder sb, Trie trie, char[][] board, List<String> list){
        char c = board[row][col];
        if(c == '.') return;

        int index = c - 'a';
        if(trie.childs[index] == null) return;
        board[row][col] = '.';
        sb.append(String.valueOf(c));
        if(trie.childs[index].isWord){
            list.add(sb.toString());
            trie.childs[index].isWord = false;
        }

        if(col < board[row].length-1) recursion(row,col+1,sb,trie.childs[index],board,list);
        if(row > 0) recursion(row-1,col,sb,trie.childs[index],board,list);
        if(col > 0) recursion(row,col-1,sb,trie.childs[index],board,list);
        if(row < board.length-1) recursion(row+1,col,sb,trie.childs[index],board,list);

        board[row][col] = c;
        sb.deleteCharAt(sb.length()-1);
    }
}

class Trie {

    Trie[] childs = new Trie[26];
    boolean isWord;

    public Trie() {}

    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        char[] chars = word.toCharArray();
        Trie node = this;
        for(char c : chars){
            int index = c - 'a';
            if(node.childs[index] == null){
                node.childs[index] = new Trie();
                node = node.childs[index];
            }else {
                node = node.childs[index];
            }
        }
        node.isWord = true;
    }

}