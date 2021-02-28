//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 333 👎 0


import java.util.ArrayList;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class TrieNode{
        HashMap<Character,TrieNode> children =new HashMap<>();
        String word =null;
        public TrieNode(){}
    }
    char[][] _board = null;
    ArrayList<String> _result =new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root =new TrieNode();
        //构建字典树
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children.containsKey(c)){
                    node = node.children.get(c);
                } else  {
                    TrieNode newNode =new TrieNode();
                    node.children.put(c,newNode);
                    node = newNode;
                }
            }
            node.word =word;
        }

        //回溯
        this._board =board;
        for (int row = 0; row < _board.length; ++row) {
            for (int col = 0; col < _board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])){
                    backtracking(row,col,root);
                }
            }
        }
        return _result;
    }

    private void  backtracking(int row,int col, TrieNode parent){
        Character letter = this._board[row][col];
        TrieNode currNode =parent.children.get(letter);

        if (currNode.word != null){
            this._result.add(currNode.word);
            currNode.word =null;
        }
        //这一步标记其已经使用过了
        this._board[row][col] ='#';
        //往上下左右方向走
        int[] rowOffset = {-1,0,1,0};
        int[] colOffset = {0,1,0,-1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length
                    || newCol < 0 || newCol >= this._board[0].length){
                continue;
            }
            //向下层走去
            if (currNode.children.containsKey(this._board[newRow][newCol])){
                backtracking(newRow,newCol,currNode);
            }
        }
        //还原回去
        this._board[row][col] =letter;
        //剪枝
        if (currNode.children.isEmpty()){
            parent.children.remove(letter);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
