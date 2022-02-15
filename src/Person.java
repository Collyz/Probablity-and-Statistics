import java.util.Random;
public class Person extends BirthdayProgram{
    int birthdayDay;
    int birthdayMonth;
    int[][] array;
    int success;

    public Person(int numPeople, int runs){
        super(numPeople, runs);
        Random rand = new Random();
        this.birthdayDay = 0;
        this.birthdayMonth = 0;
        this.success = 0;

        array = new int[2][numPeople];
        for(int i = 0; i < runs; i++){
            for(int j = 0; j < array[0].length; j++){
                birthdayMonth = rand.nextInt(365) + 1;
                birthdayDay = rand.nextInt(30) + 1;
                array[0][j] = birthdayMonth;
            }
            for(int k = 1; k < array[0].length; k++){
                if(array[0][k] == array[0][k - 1]){
                        plusCount();
                }
            }
            System.out.println(getCount());
            if(getCount() <= 1){
                success++;
            }
            clearCount();
        }
        System.out.println(success);
    }
    public int getBirthdayDay(){
        return birthdayDay;
    }
    public int getBirthdayMonth(){
        return birthdayMonth;
    }
}
