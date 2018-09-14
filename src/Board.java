public class Board {

    private Cell[][] cells;

    public Board(int[][] numgrid){

        cells = new Cell[9][9];
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

    public void alg1(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {  //access all cells

                for (int k = 0; k < cells.length; k++) { //run through rows
                    if(cells[k][j].getVal() != 0) {
                            if (cells[i][j].getOptions().contains(cells[k][j].getVal())){
                                cells[i][j].remove(cells[k][j].getVal());
                                cells[i][j].printOptions();
                        }
                    }
                }
            }

        }


    }

}

