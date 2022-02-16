import java.util.Random;
public class BirthdayProgram extends Persons{
    int birthdayDay;
    int birthdayMonth;
    int[][] birthday;
    Random rand;
    double success;

    public BirthdayProgram(int numPeople, int runs){
        super(numPeople, runs);
        this.birthdayDay = 0;
        this.birthdayMonth = 0;
        rand = new Random();
        this.success = 0;
        birthday = new int[2][getPeople()];
    }

    public double birthdaySolve(){
        for(int i = 0; i < getRuns(); i++){
            for(int j = 0; j < birthday[0].length; j++){
                birthdayMonth = rand.nextInt(12) + 1;
                birthdayDay = rand.nextInt(30) + 1;
                birthday[0][j] = birthdayMonth;
                birthday[1][j] = birthdayDay;
            }

            for(int k = 0; k < birthday[0].length; k++){
                for(int l = k + 1; l < birthday[0].length; l++) {
                    if ((birthday[0][k] == birthday[0][l]) && (birthday[1][k] == birthday[1][l])) {
                        plusCount();
                        if(getCount() <= 1){
                            success++;
                        }
                    }
                }
            }
            clearCount();
        }
        success = (success/getRuns()) * 100;
        System.out.println("Odds of two people sharing the same birthday in a group of " + getPeople() + " is "
                + success + "%");
        success = 0;
        return success;
    }
    public int getBirthdayDay(){
        return birthdayDay;
    }
    public int getBirthdayMonth(){
        return birthdayMonth;
    }
}
