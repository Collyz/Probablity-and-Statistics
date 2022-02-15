public class MeanMedianModeStandDev {

    private int[] array1;

    public MeanMedianModeStandDev(){
        this.array1 = new int[]{4, 2, 5};
        getMean();
        getMedian();
        getMode();
        getSTD();
    }

    public double getMean(){
        double mean = 0;
        for(int i = 0; i < array1.length; i++){
            mean = mean + array1[i];
        }
        System.out.println("Mean: " + mean/array1.length);
        return mean/array1.length;
    }

    public double getMedian(){
        double median = 0;

        for(int i = 0; i < array1.length - 1; i++){

            int min_index;
            for(int j = i + 1; j < array1.length; j++){

                if(array1[j] < array1[i]){
                    min_index = j;
                    int temp = array1[min_index];
                    array1[min_index] = array1[i];
                    array1[i] = temp;
                }
            }
        }
        if(array1.length%2 == 1){
            median = array1[(array1.length/2)];
        }
        else
            median = (array1[array1.length/2] + array1[(array1.length/2) - 1]) / 2;
        System.out.println("Median: " + median);
        return median;
    }

    public double getMode(){
        int count1 = 0;
        int count2 = 0;
        int frequentOne = 0;
        int frequentTwo = 0;

        for(int i = 0; i < array1.length; i++) {
            frequentOne = array1[i];
            count1 = 1;

            for(int j = i + 1;j < array1.length; j++){
                if(frequentOne == array1[j]) count1++;
            }
            if (count1 > count2) {
                frequentTwo = frequentOne;
                count2 = count1;
            } else if (count1 == count2) {
                frequentTwo = Math.min(frequentOne, frequentTwo);
            }
        }
        System.out.println("Mode: " + frequentTwo);
        return frequentTwo;
    }

    public double getSTD(){
        if(array1.length == 1)return 1;
        if(array1.length == 0)return 0;

        double mean = getMean();
        double sumOfTempValues = 0;

        for(int i = 0; i < array1.length; i++){
            double tempValues = Math.pow(array1[i] - mean, 2);
            sumOfTempValues = sumOfTempValues + tempValues;
        }
        double standDev = Math.sqrt(sumOfTempValues/(array1.length));
        double variance = sumOfTempValues/(array1.length - 1);
        System.out.println("Variance: " + variance);
        System.out.println("Standard Deviation: " + standDev);
        return standDev;
    }
}
