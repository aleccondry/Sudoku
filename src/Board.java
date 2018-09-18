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

    public boolean isSolved(){ //Returns true if game is won
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j].getVal() == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void filler(){ //Fills options list
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
                        }
                    }
                    if(cells[i][k].getVal() != 0) {
                        if (cells[i][j].getOptions().contains(cells[i][k].getVal())) {
                            cells[i][j].remove(cells[i][k].getVal());
                        }
                    }
                }
                if((i+1)%3==0) {//i=2,5,8
                    if((j+1)%3==0) {//j=2,5,8
                        cells[i][j].remove(cells[i-1][j].getVal());
                        cells[i][j].remove(cells[i-2][j].getVal());
                        cells[i][j].remove(cells[i][j-1].getVal());
                        cells[i][j].remove(cells[i-1][j-1].getVal());
                        cells[i][j].remove(cells[i-2][j-1].getVal());
                        cells[i][j].remove(cells[i][j-2].getVal());
                        cells[i][j].remove(cells[i-1][j-2].getVal());
                        cells[i][j].remove(cells[i-2][j-2].getVal());

                    }
                    else if((j+1)%3==1) {//j=0,3,6
                        cells[i][j].remove(cells[i][j+1].getVal());
                        cells[i][j].remove(cells[i][j+2].getVal());
                        cells[i][j].remove(cells[i-1][j].getVal());
                        cells[i][j].remove(cells[i-1][j+1].getVal());
                        cells[i][j].remove(cells[i-1][j+2].getVal());
                        cells[i][j].remove(cells[i-2][j].getVal());
                        cells[i][j].remove(cells[i-2][j+1].getVal());
                        cells[i][j].remove(cells[i-2][j+2].getVal());

                    }
                    else if((j+1)%3==2) {//j=1, 4, 7
                        cells[i][j].remove(cells[i][j-1].getVal());
                        cells[i][j].remove(cells[i][j+1].getVal());
                        cells[i][j].remove(cells[i-1][j].getVal());
                        cells[i][j].remove(cells[i-1][j-1].getVal());
                        cells[i][j].remove(cells[i-1][j+1].getVal());
                        cells[i][j].remove(cells[i-2][j].getVal());
                        cells[i][j].remove(cells[i-2][j-1].getVal());
                        cells[i][j].remove(cells[i-2][j+1].getVal());

                    }

                }
                else if((i+1)%3==1) {//i=0,3,6
                    if((j+1)%3==0) {//j=2,5,8
                        cells[i][j].remove(cells[i][j-1].getVal());
                        cells[i][j].remove(cells[i][j-2].getVal());
                        cells[i][j].remove(cells[i+1][j].getVal());
                        cells[i][j].remove(cells[i+1][j-1].getVal());
                        cells[i][j].remove(cells[i+1][j-2].getVal());
                        cells[i][j].remove(cells[i+2][j].getVal());
                        cells[i][j].remove(cells[i+2][j-1].getVal());
                        cells[i][j].remove(cells[i+2][j-2].getVal());

                    }
                    else if((j+1)%3==1) {//j=0,3,6
                        cells[i][j].remove(cells[i+1][j].getVal());
                        cells[i][j].remove(cells[i+2][j].getVal());
                        cells[i][j].remove(cells[i][j+1].getVal());
                        cells[i][j].remove(cells[i+1][j+1].getVal());
                        cells[i][j].remove(cells[i+2][j+1].getVal());
                        cells[i][j].remove(cells[i][j+2].getVal());
                        cells[i][j].remove(cells[i+1][j+2].getVal());
                        cells[i][j].remove(cells[i+2][j+2].getVal());

                    }
                    else if((j+1)%3==2) {//j=1, 4, 7
                        cells[i][j].remove(cells[i][j-1].getVal());
                        cells[i][j].remove(cells[i][j+1].getVal());
                        cells[i][j].remove(cells[i+1][j].getVal());
                        cells[i][j].remove(cells[i+1][j-1].getVal());
                        cells[i][j].remove(cells[i+1][j+1].getVal());
                        cells[i][j].remove(cells[i+2][j].getVal());
                        cells[i][j].remove(cells[i+2][j-1].getVal());
                        cells[i][j].remove(cells[i+2][j+1].getVal());

                    }

                }
                else if((i+1)%3==2) {//i=1, 4, 7
                    if((j+1)%3==0) {//j=2,5,8
                        cells[i][j].remove(cells[i][j-1].getVal());
                        cells[i][j].remove(cells[i][j-2].getVal());
                        cells[i][j].remove(cells[i-1][j].getVal());
                        cells[i][j].remove(cells[i-1][j-1].getVal());
                        cells[i][j].remove(cells[i-1][j-2].getVal());
                        cells[i][j].remove(cells[i+1][j].getVal());
                        cells[i][j].remove(cells[i+1][j-1].getVal());
                        cells[i][j].remove(cells[i+1][j-2].getVal());

                    }
                    else if((j+1)%3==1) {//j=0,3,6
                        cells[i][j].remove(cells[i][j+1].getVal());
                        cells[i][j].remove(cells[i][j+2].getVal());
                        cells[i][j].remove(cells[i-1][j].getVal());
                        cells[i][j].remove(cells[i-1][j+1].getVal());
                        cells[i][j].remove(cells[i-1][j+2].getVal());
                        cells[i][j].remove(cells[i+1][j].getVal());
                        cells[i][j].remove(cells[i+1][j+1].getVal());
                        cells[i][j].remove(cells[i+1][j+2].getVal());


                    }
                    else if((j+1)%3==2) {//j=1, 4, 7
                        cells[i][j].remove(cells[i][j-1].getVal());
                        cells[i][j].remove(cells[i][j+1].getVal());
                        cells[i][j].remove(cells[i-1][j].getVal());
                        cells[i][j].remove(cells[i-1][j-1].getVal());
                        cells[i][j].remove(cells[i-1][j+1].getVal());
                        cells[i][j].remove(cells[i+1][j].getVal());
                        cells[i][j].remove(cells[i+1][j-1].getVal());
                        cells[i][j].remove(cells[i+1][j+1].getVal());

                    }
                }


            }
        }
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j].enter();
            }
        }
//        for (int i = 0; i < cells.length; i++) {
//            for (int j = 0; j < cells[0].length; j++) {
//                cells[i][j].printOptions();
//            }
//        }
    }

    public void alg2(){

    }

    public void isValid(){

    }

    public void printArr(){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                System.out.print(cells[i][j].getVal() + " ");
            }
            System.out.println();
        }
    }
}

