package lk.ijse.dep.service;

public interface Board {
     int Num_Of_Row=5;
     int Num_Of_Col=6;

     BoardUI getBordUI();
     int findNextAvailableSpot(int col);
     boolean isLegalMove(int col);
     boolean existLegalMove();
     void updateMove(int col, Piece move);
     void updateMove(int col, int row, Piece move);
     Winner findWinner();

}
