import java.util.Random;
public class Person extends BirthdayProgram {
    /*
    Private variables. birthdayDay represents the day of a birthday. birthdayMonth represents the month of a birthday
    The 2D array birthday stores the day and month of a birthday
    The random object rand is to create the random days of the month and month
    The success double stores the likelyhood of two people sharing a birthday as a percent
    */
    private int birthdayDay;
    private int birthdayMonth;
    private int[][] birthday;
    private Random rand;
    private double success;

    public Person(int numPeople, int runs){
        super(numPeople, runs);
        this.birthdayDay = 0;
        this.birthdayMonth = 0;
        rand = new Random();
        this.success = 0;
        birthday = new int[2][getPeople()];//Rows set to 2 because a person never has more than one day and month birthday
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
        return success;
    }
    public void reset(){
        System.out.print("Odds of two people sharing the same birthday in a group of " + getPeople() + " is ");
        System.out.printf("%.2f", birthdaySolve());
        System.out.println("%");
        success = 0;
    }
    public int getBirthdayDay(){
        return birthdayDay;
    }
    public int getBirthdayMonth(){
        return birthdayMonth;
    }
}
