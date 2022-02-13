public class MeanMedianModeStandDev {

    private int[] array;

    public MeanMedianModeStandDev(int[] numbers){
        array = numbers;
    }

    public double getMean(){
        double mean = 0;
        for (int j : array) {
            mean = mean + j;
        }
        return mean/array.length;
    }

    public double getMedian(){
        int median;
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i + 1; j < array.length; j++){

                if(array[j] < array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        if(array.length%2 == 1){
            median = array[(array.length/2)];
        }
        else
            median = (array[array.length/2] + array[(array.length/2) - 1]) / 2;
        return median;
    }

    public double getMode(){
        int count1;
        int count2 = 0;
        int popular1;
        int popular2 = 0;

        for(int i = 0; i < array.length; i++) {
            popular1 = array[i];
            count1 = 1;

            for(int j = i + 1;j < array.length; j++){
                if(popular1 == array[j]) count1++;
            }
            if (count1 > count2) {
                popular2 = popular1;
                count2 = count1;
            } else if (count1 == count2) {
                popular2 = Math.min(popular1, popular2);
            }
        }
        return popular2;
    }

    public double STD(){
        double mean = 0;
        if(array.length == 1)return array[0];
        if(array.length == 0)return 0;
        for (int k : array) {
            mean = mean + k;
        }

        mean = mean/array.length;
        double sumOfTempValues = 0;

        for (int j : array) {
            double tempValues = Math.pow(j - mean, 2);
            sumOfTempValues = sumOfTempValues + tempValues;
        }

        return  Math.sqrt(sumOfTempValues/(array.length - 1));
    }

    public void print(){
        for (int j : array) {
            System.out.println(j);
        }
    }
}
