class Solution {
    public int solution(int[][] board) {
        int[] dr = {-1,-1,-1,0,1,1,1,0};
        int[] dc = {-1,0,1,1,1,0,-1,-1};
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 1){
                    for(int l=0; l<8; l++){
                        int idr = dr[l] + i;
                        int idc = dc[l] + j;
                        if(idr>=0 && idc>=0 &&idr<board.length && idc<board.length){
                            if(board[idr][idc]!=1){
                                board[idr][idc] = 2;
                            }
                        }
                    }
                }
            }
        }
        int count = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}