import java.util.ArrayList;

public class Cell {
    private int row, col, val;
    private ArrayList<Integer> options;
    public Cell(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }

    private void fill(){
        for (int i = 1; i < 10; i++) {
            options.add(i);
        }
    }


}
