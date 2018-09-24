public class Main {
    public static void main(String[] args) {
        Reader r = new Reader();
        int[][] arr = r.LoadPuzzle("s01a.txt");
        Board bd = new Board(arr);
        bd.filler();
        while (!bd.isSolved()) {
            bd.alg1();
            bd.alg2();
//            bd.printArr();
            System.out.println();
        }
        System.out.println("solved");
        bd.printArr();

    }
}