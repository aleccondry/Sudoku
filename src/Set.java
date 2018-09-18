public class Set {

    private Cell[] cells;

    public Set(Cell[] cells){
        this.cells = cells;
    }

    public Cell[] getCells(){
        return cells;
    }

    public int[] getValsofCells(){
        int[] arr = new int[9];
        for (int i = 0; i < cells.length; i++) {
            arr[i] = cells[i].getVal();
        }
        return arr;
    }
}
