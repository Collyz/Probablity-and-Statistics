import java.util.Arrays;
import java.util.Random;

public class MeanMedianModeStandDevVariance {

    private int[] arrayOne;

    public MeanMedianModeStandDevVariance(int size, int bound){
        Random rand = new Random();
        this.arrayOne = new int[size];
        for(int i = 0; i < arrayOne.length; i++){
            arrayOne[i] = rand.nextInt(10) + 1;
        }
    }

    public MeanMedianModeStandDevVariance(int[] array){
        this.arrayOne = array;
    }

    public void runAll(){
        System.out.println("The array numbers are: " + Arrays.toString(arrayOne));
        System.out.println("Mean: " + getMean());
        System.out.println("Median: " + getMedian());
        System.out.println("Mode: " + getMode());
        System.out.println("Variance: " + getVariance());
        System.out.println("Standard Deviation: " + getSTD() + "\n");
    }

    public double getMean(){
        double mean = 0;
        for(int i = 0; i < arrayOne.length; i++){
            mean = mean + arrayOne[i];
        }
        mean = mean/arrayOne.length;
        return mean;
    }

    public double getMedian(){
        double median = 0;

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
            median = arrayOne[(arrayOne.length/2)];
        }
        else
            median = (arrayOne[arrayOne.length/2] + arrayOne[(arrayOne.length/2) - 1]) / 2;
        return median;
    }

    public double getMode(){
        int count1 = 0;
        int count2 = 0;
        int frequentOne = 0;
        int frequentTwo = 0;

        for(int i = 0; i < arrayOne.length; i++) {
            frequentOne = arrayOne[i];
            count1 = 1;

            for(int j = i + 1;j < arrayOne.length; j++){
                if(frequentOne == arrayOne[j]) count1++;
            }
            if (count1 > count2) {
                frequentTwo = frequentOne;
                count2 = count1;
            } else if (count1 == count2) {
                frequentTwo = Math.min(frequentOne, frequentTwo);
            }
        }
        return frequentTwo;
    }

    public double getVariance(){
        if(arrayOne.length == 1)return 1;
        if(arrayOne.length == 0)return 0;

        double mean = getMean();
        double sumOfTempValues = 0;

        for(int i = 0; i < arrayOne.length; i++){
            double tempValues = Math.pow(arrayOne[i] - mean, 2);
            sumOfTempValues = sumOfTempValues + tempValues;
        }

        double variance = sumOfTempValues/(arrayOne.length);
        return variance;
    }

    public double getSTD(){
        if(arrayOne.length == 1)return 1;
        if(arrayOne.length == 0)return 0;

        double mean = getMean();
        double sumOfTempValues = 0;

        for(int i = 0; i < arrayOne.length; i++){
            double tempValues = Math.pow(arrayOne[i] - mean, 2);
            sumOfTempValues = sumOfTempValues + tempValues;
        }
        double standDev = Math.sqrt(sumOfTempValues/(arrayOne.length));
        return standDev;
    }

}
