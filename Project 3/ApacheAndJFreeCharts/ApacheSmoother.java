//Appropriate external library import
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
//Approriate java imports
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ApacheSmoother{

    //File readers
    private FileWriter fw;          //Creates the file to write to
    private BufferedWriter bw;      //Better performance writer
    //The file to be read
    private File read;
    //Temporary storage from salted data
    private ArrayList<Double> xValues;
    private ArrayList<Double> yValues;
    //Scans the file
    private Scanner scan;
    //The number of y values to be averaged at once
    private int bound;

    /**
     * Class constructor that accepts an integer to intialize bound.
     * Also initializes the filewriter,bufferedwriter, file, scanner,
     * storage contains.
     * Reads the salter csv and stores the x, y values.`
     */
    public ApacheSmoother(int bound){
        try{
            //Write to a new file
            fw = new FileWriter("SmoothData.csv");
            bw = new BufferedWriter(fw);
            //Reads from the file
            read = new File("SalterData.csv");
            scan = new Scanner(read);

            xValues = new ArrayList<>();        //Store x values
            yValues = new ArrayList<>();        //Store y values
            this.bound = bound;                 //The specificed bound

            scan.nextLine();                    //Skip the header line
            while(scan.hasNext()){
                xValues.add(scan.nextDouble()); //Adds the x value to the xValue ArrayList
                scan.next();                    //Skips comma
                yValues.add(scan.nextDouble()); //Adds the y value to the yValue ArrayList
            }
        }catch(IOException e){
            System.out.println("ERROR OCCURRED: " + e.toString());
        }

    }

    /**
     * Smooths the salted data. Performs this by created a
     * DescriptiveStatistics object with a window size set by the bound.
     * The window size determines how many numbers it can hold before it pushes
     * out the last number. This allows the object to act as a rolling avg calculator.
     * The method writes the new values onto a .csv file
     */
    public void smoothData(){
        this.bound = bound;
        try{
            //The object that stores a 'bound' amount of numbers
            DescriptiveStatistics rollAvg = new DescriptiveStatistics(bound);
            while(!xValues.isEmpty() && !yValues.isEmpty()) {
                rollAvg.addValue(yValues.remove(0));
                bw.write(String.valueOf(xValues.remove(0)));      //Writes x value to csv
                bw.write(" , ");                                    //Write comma to csv
                bw.write(String.valueOf(rollAvg.getMean()));            //Writes rolling avg to csv
                bw.newLine();                                           //Writes new line to csv
            }
            bw.close();
        }catch(Exception e){
            System.out.println("Write out error (or close error): " + e.toString());
        }
    }

}
