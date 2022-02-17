import java.util.Random;
public class Person extends BirthdayProgram {

    private int birthdayDay; //random number 1-30
    private int birthdayMonth; //random number 1-12
    private int[][] birthday; //holds random day and month
    private Random rand; //object to create random numbers
    private double success; //likelyhood of two people sharing a birthday as a percent

    //The parameters are the number of people in the sample and how many times to run the program.
    public Person(int numPeople, int runs){
        super(numPeople, runs);
        this.birthdayDay = 0;
        this.birthdayMonth = 0;
        rand = new Random();
        this.success = 0;
        birthday = new int[2][getPeople()];//Rows set to 2 because a person never has more than one day and month birthday
    }

    //The method assigns random birthdays to the sample of people and runs a certain amount of times
    public double birthdaySolve(){
        //Controls runs
        for(int i = 0; i < getRuns(); i++){
            //Sets random birthdays
            for(int j = 0; j < birthday[0].length; j++){
                birthdayMonth = getBirthdayMonth();
                birthdayDay = getBirthdayDay();
                birthday[0][j] = birthdayMonth;
                birthday[1][j] = birthdayDay;
            }
            //Compares random birthdays
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

    //Prints out the amount of success for the number of runs and resets success to zero
    public void reset(){
        System.out.print("Odds of two people sharing the same birthday in a group of " + getPeople() + " is ");
        System.out.printf("%.2f", birthdaySolve());
        System.out.println("%");
        success = 0;
    }
    //Returns a random birthday day 1-31
    public int getBirthdayDay(){
        this.birthdayDay = rand.nextInt(31) + 1;
        return birthdayDay;
    }
    //Returns a random birthday month 1-12
    public int getBirthdayMonth(){
        this.birthdayMonth = rand.nextInt(12) + 1;
        return birthdayMonth;
    }
}
