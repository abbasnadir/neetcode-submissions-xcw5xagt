class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] block = new int[9];

        for(int i = 0; i<9;i++){
            for(int j = 0; j<9; j++){
                if(board[i][j] == '.') continue;
                int curr = board[i][j] - '1';
                int pos =  ((int)(i / 3)) * 3 + ((int)(j / 3));
                int mask = 1<<curr;

                if((row[i] & mask) != 0 || (col[j] & mask) != 0 || (block[pos] & mask) != 0 )  return false;
                else {
                    row[i] |= mask;
                    col[j] |= mask;
                    block[pos] |= mask;
                }
            }
        }
        return true;
    }
}
