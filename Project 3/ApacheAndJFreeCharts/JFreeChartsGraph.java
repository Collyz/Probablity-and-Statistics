import org.jfree.chart.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xml.CategoryDatasetHandler;
import org.jfree.data.xy.DefaultXYDataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class JFreeChartsGraph <T extends Comparable<T>>{
    private File readSalt;      //The salted file to read
    private File readSmooth;    //The smoothed file to read
    private Scanner scanSalt;   //To read from the salted file
    private Scanner scanSmooth; //To read from the smoothed file

    /**
     * Empty class constructor that initializes files and scanners.
     */
    public JFreeChartsGraph(){
        try {
            readSalt = new File("SalterData.csv");
            readSmooth = new File("SmoothData.csv");

            scanSalt = new Scanner(readSalt);
            scanSmooth = new Scanner(readSmooth);
        }catch(FileNotFoundException e){
            System.out.println("File Not Found: " + e.toString());
        }

    }

    /**
     * Reads the files and temporarily stores the x and y values.
     * The x and y values are then added to a DefaultCategoryDataset object.
     * This stores the values to be added to a jpeg output.
     * A ChartFactory object is created with a title, x and y axis labels and
     * dataset. The .jpeg output is then created
     */
    public void graph(){
        ArrayList <Double> xValuesSalt = new ArrayList<>();   //Stores the x values to be added to the chart
        ArrayList <Double> yValuesSalt = new ArrayList<>();   //Stores the y values to be added to the chart

        ArrayList <Double> xValuesSmooth = new ArrayList<>();   //Stores the x values to be added to the chart
        ArrayList <Double> yValuesSmooth = new ArrayList<>();   //Stores the y values to be added to the chart
        scanSalt.nextLine();
        while(scanSalt.hasNext() && scanSmooth.hasNext()) {
            //For Salted Graph
            xValuesSalt.add(scanSalt.nextDouble());               //Storing the x values
            scanSalt.next();                                      //Skips comman
            yValuesSalt.add(scanSalt.nextDouble());               //Storing the y values
            //For Smoothed Graph
            xValuesSmooth.add(scanSmooth.nextDouble());               //Storing the x values
            scanSmooth.next();                                      //Skips comman
            yValuesSmooth.add(scanSmooth.nextDouble());               //Storing the y values
        }

        //The object that stores all the data for Salt Graph
        DefaultCategoryDataset datasetSalt = new DefaultCategoryDataset();
        //The object that stores all the data for Smooth Graph
        DefaultCategoryDataset datasetSmooth = new DefaultCategoryDataset();
        for (int i = 0; i < xValuesSalt.size(); i++) {
            //Adding the data to the dataset object for Salted Graph
            datasetSalt.addValue(yValuesSalt.get(i), "x^2", xValuesSalt.get(i).toString());
            //Adding the data to the dataset object for Smoothed Graph
            datasetSmooth.addValue(yValuesSmooth.get(i), "x^2", xValuesSmooth.get(i).toString());
        }
        //Creation of the salted chart
        JFreeChart chartSalt = ChartFactory.createLineChart("Salt Graph", "x Values"
                , "y Values", datasetSalt);
        //Creatino of the smoothed chart
        JFreeChart chartSmooth = ChartFactory.createLineChart("Smooth Graph", "x Values"
                , "y Values", datasetSmooth);

        try{
            //Outputing the salt chart as a .jpeg
            ChartUtils.saveChartAsJPEG(new File("C:\\Users\\Safin Mowla\\IdeaProjects\\ProjectThree\\SaltGraph.jpeg" ),
                    chartSalt,1900, 800);
            //Outputing the smooth chart as a .jpeg
            ChartUtils.saveChartAsJPEG(new File("C:\\Users\\Safin Mowla\\IdeaProjects\\ProjectThree\\SmoothGraph.jpeg" ),
                    chartSmooth,1900, 800);
        }catch(Exception e){
            System.out.println("Error");
        }

    }

    /**
     * Empty compareTo method since the data was already in order
     *
     * @return Gives zero
     */
    public int compareTo(){
        return 0;
    }

    /**
     * Required for the dataset to work
     *
     * @return The compareTo method
     */
    public Comparable plzwork(){
        return this.compareTo();
    }
}
