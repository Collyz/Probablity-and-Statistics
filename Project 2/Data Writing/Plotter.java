import java.io.BufferedWriter;
import java.io.FileWriter;

public class Plotter {
    private String titleColumnOne;  //Stores a column title
    private String titleColumnTwo;  //Stores a column title
    private int rows;               //Stores the number of rows to create
    private int columns;            //Stores the number of columns to create
    private int[][] xAndY;          //Stores the x and y values of the function
    private FileWriter fw;          //Required to create a file
    private BufferedWriter br;      //Required to write to a file that is created

    /** The constructor of the class which accepts three parameters and initializes all private variables
     *
     * @param columnOne  The columnOne title to be accepted
     * @param columnTwo  The columnTwo title to be accepted
     * @param row        The number of rows to be accepted
     */
    public Plotter(String columnOne, String columnTwo, int row){
        this.titleColumnOne = columnOne;
        this.titleColumnTwo = columnTwo;
        this.rows = row;
        this.columns = 2;//For graphing a function only two rows are desired
        this.xAndY = new int[rows][columns];

        //Creation of the file "RegularData.csv"
        try{
            this.fw = new FileWriter("RegularData.csv");
            this.br = new BufferedWriter(fw);
        }catch(Exception e){
            System.out.println("ERROR OCCURRED: " + e.toString());
        }
        //Fills in the array with x values 1-50 and y values with x^2 for x = 1-50
        for(int i = 0; i < row; i++){
            xAndY[i][0] = i + 1; //iterations of x 1- 50
            for(int j = 1; j < columns; j++){
                xAndY[i][j] = (i + 1) * (i + 1); //x^2
            }
        }
    }

    //The method 'output' writes to the file "RegularData.csv" and then closes the BufferedWriter 'bw'
    public void output(){
        try {
            br.write(titleColumnOne); //Title of column one
            br.write(" , ");      //Separate by comma
            br.write(titleColumnTwo); //Title of column tne
            br.newLine();             //New line to start the x and y values
            for (int i = 0; i < rows; i++) {
                br.write(String.valueOf(xAndY[i][0]));   //x values
                br.write(" , ");                     //Separate by coma
                br.write(String.valueOf(xAndY[i][1]));   //y values
                br.newLine();                            //New line to start the next x and y values
            }
            br.close();  //Close the writer after the array has finished
        }catch (Exception e){
            System.out.println("Write out error (or close error): " + e.toString());
        }
    }

}