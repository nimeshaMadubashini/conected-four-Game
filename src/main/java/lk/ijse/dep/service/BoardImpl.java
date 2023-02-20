package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private final Piece[][] pieces = new Piece[Num_Of_Row][Num_Of_Col];
    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        for (int i = 0; i < Num_Of_Col; ++i) {
            for (int j = 0; j < Num_Of_Row; ++j) {
                this.pieces[j][i] = Piece.EMPTY;
            }
        }
        this.boardUI = boardUI;
    }


    @Override
    public BoardUI getBordUI() {
        return this.boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for (int i = 0; i < Num_Of_Row; ++i) {
            if (this.pieces[i][col] == Piece.EMPTY) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {

        if (findNextAvailableSpot(col) == -1) {
            return false;
        }
        return true;
    }

    @Override
    public boolean existLegalMove() {
        for (int col = 0; col < Num_Of_Col; ++col) {//All col are check
            if (this.isLegalMove(col)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        this.pieces[this.findNextAvailableSpot(col)][col] = move;
    }

    @Override
    public void updateMove(int col, int row, Piece move) {

        this.pieces[row][col] = move;
    }

    @Override
    public Winner findWinner() {
        int count;

        for (int col = 0; col < Num_Of_Col; col++) {

            int rowLp = this.findNextAvailableSpot(col) == -1 ? Num_Of_Row : findNextAvailableSpot(col);
            System.out.println(findNextAvailableSpot(col));
            count = 0;
            for (int row = 1; row < rowLp; row++) {
                if (this.pieces[row][col] == this.pieces[row - 1][col]) {
                    count++;
                    if (count == 3) {
                        return new Winner(this.pieces[row][col], col, row - 3, col, row);
                    }
                } else {
                    count = 0;

                }
            }
        }

        for (int row = 0; row < Num_Of_Row; ++row) {
            int count2 = 1;

            for (int col = 1; col < Num_Of_Col; ++col) {
                if (this.pieces[row][col] == this.pieces[row][col - 1]) {
                    count2++;
                    if (count2 == 4) {
                        return new Winner(this.pieces[row][col], col - 3, row, col, row);
                    }
                } else {
                    count2 = 1;


                }
            }
        }

        return new Winner(Piece.EMPTY);
    }

}

