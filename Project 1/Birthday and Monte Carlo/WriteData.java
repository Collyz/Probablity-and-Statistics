import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class WriteData {
    private String titleColumnOne;
    private String titleColumnTwo;
    private int rows;
    private int columns;
    private int[][] id;
    private FileWriter fw;
    private BufferedWriter br;

    public WriteData(String columnOne, String columnTwo, int row, int columns){
        this.titleColumnOne = columnOne;
        this.titleColumnTwo = columnTwo;
        this.rows = row;
        this.columns = columns;
        Random rand = new Random();
        this.id = new int[rows][columns];

        try{
            this.fw = new FileWriter("ExampleOutput.csv");
            this.br = new BufferedWriter(fw);
        }catch(Exception e){
            System.out.println("ERROR OCCURED: " + e.toString());
        }
        for(int i = 0; i < row; i++){
            id[i][0] = i + 1;
            for(int j = 1; j < columns; j++){
                id[i][j] = rand.nextInt(1000);
            }
        }
    }

    public void output(){
        try {
            br.write(titleColumnOne);
            br.write(",");
            br.write(titleColumnTwo);
            br.newLine();
            for (int i = 0; i < rows; i++) {
                br.write(String.valueOf(id[i][0]));
                br.write(",");
                br.write(String.valueOf(id[i][1]));
                br.newLine();
            }
            br.close();
        }catch (Exception e){
            System.out.println("Write out error (or close error): " + e.toString());
        }
    }

}