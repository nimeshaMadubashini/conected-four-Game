package lk.ijse.dep.service;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_GREENPeer;

public class AiPlayer extends Player {
    public AiPlayer(Board board) {
        super(board);
    }

    public void movePiece(int col) {
        do {
            col = (int) Math.floor(Math.random() * 6.0D);
        } while (!this.board.isLegalMove(col));
        // System.out.println("1hiiiiiiidad " + col);
        //col = this.minimax(col, true);
        //System.out.println("2hiiiiiiidad " + col);
        this.board.updateMove(col, Piece.GREEN);
        this.board.getBordUI().update(col, false);
        Winner winner = this.board.findWinner();
        if (winner.getWinningPiece() != Piece.EMPTY) {
            this.board.getBordUI().notifyWinner(winner);
        } else if (!this.board.existLegalMove()) {
            this.board.getBordUI().notifyWinner(new Winner(Piece.EMPTY));
        }
    }

  /*  private int minimax(int depth, boolean maximizingPlayer) {
        System.out.println(board.findWinner().getCol1() + 3);
        if (depth == board.findWinner().getCol1() +3 || depth == board.findWinner().getRow1() + 3) {
            System.out.println(depth + "depth");
            return depth;
        }
        if (maximizingPlayer) {
            var maxEval = Double.NEGATIVE_INFINITY;

            for (int i = 0; i < Board.Num_Of_Col; ++i) {
                int heuristicVal = this.minimax(depth + 1, false);
                System.out.println("heuristicVal" + heuristicVal);
                maxEval = Math.max(maxEval, heuristicVal);
            }
            System.out.println("maxEval" + maxEval);
            return (int) maxEval;

        } else {
            var minEval = Double.POSITIVE_INFINITY;
            for (int i = 0; i < Board.Num_Of_Col; ++i) {
                int heuristicVal = this.minimax(depth + 1, true);
                minEval = Math.min(minEval, heuristicVal);
            }
            return (int) minEval;
        }*/

   /* private int minmax(int depth,boolean isMaximizing) {
        depth = 0;
        if (board.findWinner() != null) {
            depth++;
            return depth;
        }
        if (isMaximizing) {
            int bestScore = (int) Double.POSITIVE_INFINITY;
            for (int i=0;i<Board.Num_Of_Row;i++){
                for (int j = 0; j < Board.Num_Of_Col; j++) {
                    if(board.existLegalMove()){
                        int heuristicVal = this.minmax(depth + 1, false);
                        if(heuristicVal>bestScore){
                            bestScore=heuristicVal;
                        }
                    }
                }

                }
            return bestScore;
            }else {
            int bestScore = (int) Double.NEGATIVE_INFINITY;
            for (int i=0;i<Board.Num_Of_Row;i++){
                for (int j = 0; j < Board.Num_Of_Col; j++) {
                    if(board.existLegalMove()){
                        int heuristicVal = this.minmax(depth + 1, true);
                        if(heuristicVal<bestScore){
                            bestScore=heuristicVal;
                        }
                    }
                }

            }
            return bestScore;
        }
    }*/

}


