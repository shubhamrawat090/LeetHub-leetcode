class Solution {
    // ORIGINAL || NEW || STATE
    //    0         0      0
    //    1         0      1
    //    0         1      2
    //    1         1      3
    
    //we have made a map where if originally a block is 0 and then it changes to 1 it means we'll mark it 2 and this 2 can be used to referred to it's original(when comparing for other blocks) as well as new state(when making changes in the array after processing) 
    
    public void gameOfLife(int[][] board) {
        int r = board.length, c=board[0].length;
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int neighbours = countNeighbour(board, i, j);
                
                if(board[i][j] == 1){
                    if(neighbours == 2 || neighbours == 3){
                        //if board was originally 1 and it changed to 1 due to exact no. of neighbours allowed then we call it 3 according to our table
                        board[i][j] = 3;
                    }
                    
                    //for originally 1 that changes to 0 we call it 1 only so we don't need to make any changes
                }else{//if block was originally 0
                    if(neighbours == 3){
                        //originally 0 changes to 1 we call it 2
                        board[i][j] = 2;
                    }
                    
                    //for 0 that changes to 0 we call it 0 so we don't need to make any changes
                }
            }
        }
        
        //traverse once again to convert it to new state
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == 2 || board[i][j] == 3){
                    //for states 2 & 3 new state is 1 according to our table
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }
    
    public int countNeighbour(int[][] board, int r, int c){
        int row = board.length, col = board[0].length;
        int neighbour = 0;
        //WE CHECK IN THE BOX CONTAINING OUR 8 DIRECTIONS
        //        X X X
        //        X O X
        //        X X X
        // O is our element and X is the box we are checking in
        for(int i=r-1; i<=r+1; i++){
            for(int j=c-1; j<=c+1; j++){
                //skip our block
                if(i==r && j==c)
                    continue;
                //skip out of bounds block
                if(i<0 || j<0 || i==row || j == col)
                    continue;
                //in our table 1 and 3 we originally 1 so count them for neighbours
                if(board[i][j] == 1 || board[i][j] == 3){
                    neighbour++;
                }
            }
        }
        
        return neighbour;
    }
}