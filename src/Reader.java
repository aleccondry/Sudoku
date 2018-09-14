import java.io.*;

public class Reader {

    public Reader(){

    }

    public int[][] LoadPuzzle(String file){
        String output;
        int[][] arr = new int[9][9];
        try{
            BufferedReader br = new BufferedReader(new FileReader("./src/Puzzles/" + file));
            try{
                output = br.readLine();
                while(output != null){
                    String[] val = output.split(" ");
                    for (int i = 0; i < val.length; i++) {
                        if (!val[i].equals("")) {
                            arr[i][0] = Integer.parseInt(val[i]);
                            System.out.print(arr[i][0] + " ");
                        }
                    }
                    System.out.println(" ");
                    output = br.readLine();

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
