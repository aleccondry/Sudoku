import java.util.ArrayList;

public class Cell {
    private int row, col;
    private ArrayList<Integer> options;
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }

    private void fill(){
        for (int i = 1; i < 10; i++) {
            options.add(i);
        }
    }


}
