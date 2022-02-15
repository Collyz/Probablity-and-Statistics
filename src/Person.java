import java.util.Random;
public class Person extends BirthdayProgram{
    int birthdayDay;
    int birthdayMonth;
    int[][] birthday;
    double success;

    public Person(int numPeople, int runs){
        super(numPeople, runs);
        Random rand = new Random();
        this.birthdayDay = 0;
        this.birthdayMonth = 0;
        this.success = 0;

        birthday = new int[2][getPeople()];
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
                        System.out.println(getCount());
                        if(getCount() <= 1){
                            success++;
                        }
                    }
                }
            }
            clearCount();
        }
        success = success/numPeople;
        System.out.println("With " + getPeople() + " people, there was a success of: " +
                success + "where a percent above 0 means there was a match");
        success = 0;
    }
    public int getBirthdayDay(){
        return birthdayDay;
    }
    public int getBirthdayMonth(){
        return birthdayMonth;
    }
}
