import java.util.*;

public class WordSearch {
    static class TrieNode {
        public TrieNode[] node = new TrieNode[26];
        public String word;
    }

    public void wordLadder(char[][] board, int rows, int columns, int currentRow,int currentColumn, boolean[][] visited,TrieNode wordCombo,List<String> result){
        int idx = board[currentRow][currentColumn] - 'a';
        TrieNode next = wordCombo.node[idx];
        if(next==null)
            return;
        if(next.word != null) {
            result.add(next.word);
            next.word = null;
        }
        visited[currentRow][currentColumn] = true;
        if(currentRow+1 < rows && !visited[currentRow+1][currentColumn]){
            wordLadder(board,rows,columns,currentRow+1,currentColumn,visited,next,result);
        }
        if(currentRow-1 >= 0 && !visited[currentRow-1][currentColumn]){
            wordLadder(board,rows,columns,currentRow-1,currentColumn,visited,next,result);
        }
        if(currentColumn+1 < columns && !visited[currentRow][currentColumn+1]){
            wordLadder(board,rows,columns,currentRow,currentColumn+1,visited,next,result);
        }
        if(currentColumn-1 >= 0 && !visited[currentRow][currentColumn-1]){
            wordLadder(board,rows,columns,currentRow,currentColumn-1,visited,next,result);
        }
        visited[currentRow][currentColumn] = false;
    }

    public TrieNode combinations(HashSet<String> dict){
        TrieNode root = new TrieNode();
        for(String word : dict){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                if(curr.node[c-'a'] == null)
                    curr.node[c-'a'] = new TrieNode();
                curr = curr.node[c-'a'];
            }
            curr.word = word;
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(Arrays.asList(words));;
        int rows = board.length;
        int columns = board[0].length;
        TrieNode wordCombo = combinations(dict);
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                boolean[][] visited = new boolean[rows][columns];
               wordLadder(board,rows,columns,i,j,visited, wordCombo, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> result= wordSearch.findWords(board, words);
        for(String word : result) {
            System.out.println(word);
        }
    }
}
