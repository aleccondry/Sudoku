public class Board {

    private Cell[][] cells;

    public Board(int[][] numgrid){
        for (int i = 0; i < numgrid.length; i++) {
            for (int j = 0; j < numgrid[0].length; j++) {
                cells[i][j] = new Cell(i, j, numgrid[i][j]);
            }
        }
    }




}