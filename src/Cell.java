import java.util.ArrayList;

public class Cell {    //takes in val 0
    private int row, col, val;
    private ArrayList<Integer> options;
    public Cell(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }

    public void fill(){
        for (int i = 1; i < 10; i++) {
            options.add(i);
        }
    }
    public void remove(int rem){//removing int rem from options
        for (int i = 0; i < options.size(); i++) {
            if (rem == options.get(i))
                options.remove(i);
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getVal() {
        return val;
    }

    public ArrayList<Integer> getOptions() {
        return options;
    }
}
