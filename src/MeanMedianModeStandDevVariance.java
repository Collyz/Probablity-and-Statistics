import java.util.Arrays;
import java.util.Random;

public class MeanMedianModeStandDevVariance {

    private int[] arrayOne; //holds the random number values
    Random rand;//object to create random number values

    //If there is not an existing array to be used then this constructor is used
    public MeanMedianModeStandDevVariance(int size, int bound){
        this.arrayOne = new int[size];
        rand = new Random();
        for(int i = 0; i < arrayOne.length; i++){
            arrayOne[i] = rand.nextInt(10) + 1;
        }
    }

    //If there is an existing array to be used then this constructor is used
    public MeanMedianModeStandDevVariance(int[] array){
        this.arrayOne = array;
        rand = new Random();
    }

    //Runs all of the methods in below runAll() and prints their results
    public void runAll(){
        System.out.println("The array numbers are: " + Arrays.toString(arrayOne));
        System.out.println("Mean: " + getMean());
        System.out.println("Median: " + getMedian());
        System.out.println("Mode: " + getMode());
        System.out.println("Variance: " + getVariance());
        System.out.println("Standard Deviation: " + getSTD() + "\n");
    }

    //Returns the average of the array
    public double getMean(){
        double mean = 0;
        //Sum of the array
        for(int i = 0; i < arrayOne.length; i++){
            mean = mean + arrayOne[i];
        }
        mean = mean/arrayOne.length; //Average of the sum
        return mean;
    }

    //Finds the middle number or median of an array and returns it
    public double getMedian(){
        double median = 0;
        //Sorts the array from least to greatest
        for(int i = 0; i < arrayOne.length - 1; i++){
            int min_index;
            for(int j = i + 1; j < arrayOne.length; j++){
                if(arrayOne[j] < arrayOne[i]){
                    min_index = j;
                    int temp = arrayOne[min_index];
                    arrayOne[min_index] = arrayOne[i];
                    arrayOne[i] = temp;
                }
            }
        }
        if(arrayOne.length%2 == 1){
            median = arrayOne[(arrayOne.length/2)];  //If the array has an odd number of elements this is the median
        }
        else
            median = (arrayOne[arrayOne.length/2] + arrayOne[(arrayOne.length/2) - 1]) / 2; //If the array has even an number of elements this is the median
        return median;
    }

    //Finds the number that appears the most or the mode.
    //If there isn't one then the smallest number is returned
    public double getMode(){
        int count1;
        int count2 = 0;
        int frequentOne;
        int frequentTwo = 0;

        for(int i = 0; i < arrayOne.length; i++) {
            frequentOne = arrayOne[i];
            count1 = 1;
            //Checks each number in the array to see if it appears more than once
            for(int j = i + 1;j < arrayOne.length; j++){
                if(frequentOne == arrayOne[j]) count1++;
            }
            if (count1 > count2) {
                frequentTwo = frequentOne;
                count2 = count1;
            } else if (count1 == count2) {
                frequentTwo = Math.min(frequentOne, frequentTwo);  //If two numbers appear an equal amount of times the smaller is returned
            }
        }
        return frequentTwo;
    }

    //Returns the variance for the array
    public double getVariance(){
        if(arrayOne.length == 1)return 1;
        if(arrayOne.length == 0)return 0;

        double mean = getMean();  //Average of the array
        double sumOfTempValues = 0;
        //The average is subtracted from each value of the array and then squared, each square is summed
        for(int i = 0; i < arrayOne.length; i++){
            double tempValues = Math.pow(arrayOne[i] - mean, 2);
            sumOfTempValues = sumOfTempValues + tempValues;
        }

        double variance = sumOfTempValues/(arrayOne.length);
        return variance;
    }

    //Returns the standard deviation of the array
    public double getSTD(){
        double standDev = Math.sqrt(getVariance());   //Standard deviation is the square root of variance
        return standDev;
    }

}
