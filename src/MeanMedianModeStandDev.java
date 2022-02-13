public class MeanMedianModeStandDev {

    private int[] array;

    public MeanMedianModeStandDev(int[] numbers){
        array = numbers;
    }

    public double getMean(){
        double mean = 0;
        for(int i = 0; i < array.length; i++){
            mean = mean + array[i];
        }
        return mean/array.length;
    }

    public double getMedian(){
        double median = 0;

        for(int i = 0; i < array.length - 1; i++){

            int min_index = i;
            for(int j = i + 1; j < array.length; j++){

                if(array[j] < array[i]){
                    min_index = j;
                    int temp = array[min_index];
                    array[min_index] = array[i];
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
        int count1 = 0;
        int count2 = 0;
        int popular1 = 0;
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
        if(array.length == 1)return 1;
        if(array.length == 0)return 0;
        for(int i = 0; i < array.length; i++)mean = mean + array[i];

        mean = mean/array.length;
        double sumOfTempValues = 0;

        for(int i = 0; i < array.length; i++){
            double tempValues = Math.pow(array[i] - mean, 2);
            sumOfTempValues = sumOfTempValues + tempValues;
        }
        double results = Math.sqrt(sumOfTempValues/(array.length - 1));

        return results;
    }

    public void print(){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
