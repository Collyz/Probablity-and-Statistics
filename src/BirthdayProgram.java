public class BirthdayProgram {
    private int people;
    private int runs;
    private int count;

    public BirthdayProgram(int numPeople, int runs){
        this.people = numPeople;
        this.runs = runs;
    }

    public void plusCount(){
        count++;
    }

    public void clearCount(){
        count = 0;
    }

    public int getPeople(){
        return people;
    }

    public int getRuns(){
        return runs;
    }

    public int getCount(){
        return count;
    }

}