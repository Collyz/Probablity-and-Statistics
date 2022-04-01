import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.util.Scanner;

public class GraphSalter {
    private FileWriter fw;                     //Required to create a file
    private BufferedWriter bw;                 //Required to write to a file that is created
    private Random rand;                       //Required to randomly salt the y values
    private File file;                         //Required to locate a file
    private Scanner in;                        //Required to read from a file
    private ArrayList<Integer> xValues;        //Stores the x values
    private ArrayList<Integer> yValues;        //Stores the y values

    /** Class constructor that accepts no parameters and initializes all cthe private variables
     * Stores all the x values in the Arraylist xValues and all the y values in the ArrayList yValues
     */
    public GraphSalter(){
        try {
            fw = new FileWriter("SalterData.csv");    //File to create for the new salted data
            bw = new BufferedWriter(fw);                       //To write to the new file created
            rand = new Random();                               //Initialized to salt the data
            file = new File("RegularData.csv");      //The file to draw the data from
            in = new Scanner(file);                            //Initialized to read the data from the file
            xValues = new ArrayList<>();                       //Initialized x storage
            yValues = new ArrayList<>();                       //Initialized y storage

            //Skips the first three values which are the two column titles and a comma
            in.next();
            in.next();
            in.next();
            //As long as there are values in the .csv file then the while loop will run which will fill the x and y value ArrayLists
            while(in.hasNext()){
                xValues.add(in.nextInt()); //x value stored
                in.next();                 //skip the comma
                yValues.add(in.nextInt()); //y value stored
            }
            in.close();                    //Close the file that the data was taken from

        }catch (Exception e){
            System.out.println("ERROR OCCURRED: " + e.toString());
        }
    }

    /** The method 'saltData' accepts three parameters
     * Writes to the initialized file with the salted y values
     * @param columnOne  Header of the x values column
     * @param columnTwo  Header of the y values column
     * @param bound      The largest the random number can be 0 to 'bound'
     */
    public void saltData(String columnOne, String columnTwo, int bound){
        try {
            bw.write(columnOne);         //Column name
            bw.write(" , ");         //Separated by comma
            bw.write(columnTwo);         //Column name
            bw.newLine();                //New line to start the x and y values
            int randBound = bound;       //Stores the bound
            for (int i = 0; i < yValues.size(); i++) {
                //This integer will either be 0 or 1 each time the loop runs which allows
                // for the data to be either randomly added to subtracted from
                int plusOrMinus = rand.nextInt(2);
                //Adds to y value and writes x and y separated by comma to the file
                if (plusOrMinus == 0) {
                    int temp = xValues.get(i);
                    bw.write(String.valueOf(temp));
                    bw.write(" , ");
                    int tempSum = yValues.get(i) + rand.nextInt(randBound + 1);
                    bw.write(String.valueOf(tempSum));
                    bw.newLine();
                }
                //Subtracts from y value and writes x and y separated by comma to the file
                if (plusOrMinus == 1) {
                    int temp = xValues.get(i);
                    bw.write(String.valueOf(temp));
                    bw.write(" , ");
                    int tempSum = yValues.get(i) - rand.nextInt(randBound + 1);
                    bw.write(String.valueOf(tempSum));
                    bw.newLine();
                }
            }
            bw.close();   //Closes the file that was written to
        }catch (Exception e){
            System.out.println("Write out error (or close error): " + e.toString());
        }
    }

}
