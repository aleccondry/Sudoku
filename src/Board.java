import java.util.ArrayList;

public class Board {

    private Cell[][] cells;
    private Set[] rows, cols, boxes;
    private ArrayList<Integer> options2;

    public Board(int[][] numgrid){

        ArrayList<Cell>[] boxSets = new ArrayList[9];
        cells = new Cell[9][9];
        rows = new Set[9];
        cols = new Set[9];
        boxes = new Set[9];

        for (int i = 0; i < 9; i++) {
            boxSets[i] = new ArrayList<Cell>();
        }

        for (int i = 0; i < numgrid.length; i++) {
            for (int j = 0; j < numgrid[0].length; j++) {
                Cell cell = new Cell(i, j, numgrid[i][j]);
                cells[i][j] = cell;
                int boxIdx = i/3*3 + j/3;
                boxSets[boxIdx].add(cell);
            }
        }

        for (int i = 0; i < 9; i++) { //fills sets with arrays of cells
            Cell[] box = new Cell[9];
            for (int j = 0; j < 9; j++) {
                box[j] = boxSets[i].get(j);
            }
            boxes[i] = new Set(box);
            rows[i] = new Set(cells[i]);
            Cell[] list = new Cell[9];
            for (int j = 0; j < 9; j++) {
                list[j] = cells[j][i];
            }
            cols[i] = new Set(list);
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
//        for (int i = 0; i < boxes.length; i++) {
//            Cell[] arr = boxes[i].getCells();
//            for (int j = 0; j < arr.length; j++) {
//                for (int k = 0; k < arr.length; k++) {
//                    if (arr[j].getVal() != 0){
//                        if (arr[j].getOptions().contains(arr[k].getVal())){
//                            arr[j].remove(arr[k].getVal());
//                        }
//                    }
//                }
//            }
//        }

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
        System.out.println(isValid());
    }

    public boolean isValid() {
        for (int i = 0; i < rows.length; i++) {
            Cell[] arr1 = rows[i].getCells();
            Cell[] arr2 = cols[i].getCells();
            Cell[] arr3 = boxes[i].getCells();
            for (int j = 0; j < arr1.length; j++) {
                for (int k = 0; k < arr1.length; k++) {
                    if (k != j) {
                        if (arr1[j].getVal() == arr1[k].getVal() && arr1[j].getVal() != 0) {
                            return false;
                        }
                        if (arr2[j].getVal() == arr2[k].getVal() && arr2[j].getVal() != 0) {
                            return false;
                        }
                        if (arr3[j].getVal() == arr3[k].getVal() && arr3[j].getVal() != 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public void printArr() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                System.out.print(cells[i][j].getVal() + " ");
            }
            System.out.println();
        }
    }
}

