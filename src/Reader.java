import java.io.*;

public class Reader {

    public Reader(){

    }

    public int[][] LoadPuzzle(String file){
        String output;
        int[][] arr = new int[9][9];
        int counter = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader("./src/Puzzles/" + file));
            try{
                while(br.readLine() != null){
                    output = br.readLine();
                    String[] val = output.split(" ");
                    for (int i = 0; i < val.length; i++) {
                        System.out.println(val[i]);
                    }
                    for (int i = 0; i < val.length; i++) {
                        arr[i][counter] = Integer.parseInt(val[i]);
                    }
                    counter++;
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        return arr;
    }
}
