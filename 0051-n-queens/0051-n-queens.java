class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if(n == 1){
            temp.add("Q");
            answer.add(temp);
            return answer;
        }
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        helper(answer , board , 0 , n);
        return answer;
    }

    public void helper(List<List<String>> answer , String[][] board , int row , int n){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i= 0 ; i<board.length ; i++){
                StringBuilder str = new StringBuilder(n);
                for(int j = 0 ; j<board.length ; j++){
                    str.append(board[i][j]);    
                }
                list.add(str.toString());
            }
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int j = 0 ; j < board.length ; j++){
            if(isSafe(board, row , j , n)){
                board[row][j] = "Q";
                helper(answer , board , row+1 , n);
                board[row][j] = ".";
            }
        }
    }

    public boolean isSafe(String[][] board , int row , int col , int n){
        //horizontal
        for(int j= 0  ; j<n ; j++){
            if(board[row][j] == "Q"){
                return false;
            }
        }

        //vertical
        for(int i=0  ; i<n ; i++){
            if(board[i][col] == "Q"){
                return false;
            }
        }
         // 2. Upper-Left Diagonal (decrement i and j TOGETHER)
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j].equals("Q")) {
            return false;
        }
    }

    // 3. Upper-Right Diagonal (decrement i, increment j TOGETHER)
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
        if (board[i][j].equals("Q")) {
            return false;
        }
    }
        return true;
    }
}