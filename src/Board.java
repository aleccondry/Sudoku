public class Board {

    private Cell[][] cells;

    public Board(int[][] numgrid){
        for (int i = 0; i < numgrid.length; i++) {
            for (int j = 0; j < numgrid[0].length; j++) {
                cells[i][j] = new Cell(i, j, numgrid[i][j]);
            }
        }
    }

    public void filler(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j].getVal() == 0){
                    cells[i][j].fill();
                }

            }
        }
    }


}