import java.util.Random;
public class Person {
    int birthdayDay;
    int birthdayMonth;

    public Person(){
        Random rand = new Random();
        this.birthdayDay = rand.nextInt (31) + 1;
        this.birthdayMonth = rand.nextInt(12) + 1;
    }
}
