import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class GraphSmoother{
    private FileWriter fw;                     //Required to create a file
    private BufferedWriter bw;                 //Required to write to a file that is created
    private File file;                         //Required to locate a file
    private Scanner in;                        //Required to read from a file
    private ArrayList<Integer> xValues;        //Stores the x values
    private ArrayList<Integer> yValues;        //Stores the y values

    /** Class constructor that accepts no parameters and initializes all the private variables
     * Stores all the x values in the Arraylist xValues and all the y values in the ArrayList yValues
     */
    public GraphSmoother(){
        try {
            fw = new FileWriter("SmootherData.csv");     //File to create for the new salted data
            bw = new BufferedWriter(fw);                          //To write to the new file created
            file = new File("SalterData.csv");          //File to get data from
            in = new Scanner(file);                               //Required to read file with data
            xValues = new ArrayList<>();                          //Initialized to store x values
            yValues = new ArrayList<>();                          //Initialized to store y values

            //Skips the two column titles and the comma to get to the x and y values
            in.next();
            in.next();
            in.next();
            //As long as there are values in the .csv file then the while loop will run which will fill the x and y value ArrayLists
            while(in.hasNext()){
                xValues.add(in.nextInt()); //x value stored
                in.next();                 //skip comma
                yValues.add(in.nextInt()); //y value stored
            }
            in.close();                    //Close the file that the data was taken from

        }catch (Exception e){
            System.out.println("ERROR OCCURRED: " + e.toString());
        }
    }

    /** The method 'smoothData' accepts three paramaters
     * The method takes the average of a given number of y values and writes the average for those given y values
     * @param columnOne   Title of column one
     * @param columnTwo   Title of column two
     * @param bound       The number of y values to average at once
     */
    public void smoothData(String columnOne, String columnTwo, int bound){
        try {
            bw.write(columnOne);     //Column name
            bw.write(" , ");     //Separated by comma
            bw.write(columnTwo);     //Column name
            bw.newLine();            //New line to start the x and y values
            int tempX = 0;               //Temporarily stores the x value to be written
            double yAverage = 0;     //Temporarily stores the average of the y values
            while(!yValues.isEmpty()){
                for(int i = 0; i < bound; i++){
                    if(!yValues.isEmpty()) {
                        yAverage = yAverage + yValues.remove(0);  //Sum calculation
                    }
                }
                yAverage = yAverage/bound;  //Average calculation

                for(int j = 0; j < bound; j++) {
                    if(!xValues.isEmpty()) {
                        tempX = xValues.remove(0);
                    }
                    else{break;}
                    bw.write(String.valueOf(tempX));    //Writing the x value
                    bw.write(" , ");                //Separate with comma
                    bw.write(String.valueOf(yAverage)); //Writing the average y value of a given 'bound' y values
                    bw.newLine();                       //New line to print the next x and y values
                }
            }

            bw.close();   //Closes the file that was being written to
        }catch (Exception e){
            System.out.println("Write out error (or close error): " + e.toString());
        }
    }

}
