public class Main {
    public static void main(String[] args) {
        Reader r = new Reader();
        Board bd = new Board(r.LoadPuzzle("s01a.txt"));
        bd.filler();

    }
}