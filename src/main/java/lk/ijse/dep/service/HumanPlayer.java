package lk.ijse.dep.service;

public class HumanPlayer extends Player {

    public HumanPlayer(Board board) {
        super(board);
    }

    public void movePiece(int col) {
        if (this.board.isLegalMove(col)) {
            this.board.updateMove(col, Piece.BLUE);
            // this.board.updateMove(col,row,Piece.BLUE);
            this.board.getBordUI().update(col, true);
            Winner winner = this.board.findWinner();
            if (winner.getWinningPiece() != Piece.EMPTY) {
                this.board.getBordUI().notifyWinner(winner);
            } else if (!this.board.existLegalMove()) {
                this.board.getBordUI().notifyWinner(new Winner(Piece.EMPTY));
            }
        }
    }

}
