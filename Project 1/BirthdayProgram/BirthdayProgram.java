public class BirthdayProgram {
    private int people; //Stores the number of people in the sample
    private int runs;  //Stores the number of runs
    private int count;  //Stores the successive matches between runs, needed to calculate success over all of total runs

    public BirthdayProgram(int numPeople, int runs){
        this.people = numPeople;
        this.runs = runs;
    }
    //Increments count by one
    public void plusCount(){
        count++;
    }

    //Sets count to zero if it were any other number
    public void clearCount(){
        count = 0;
    }

    //Returns the amount of people in the sample
    public int getPeople(){
        return people;
    }

    //Returns the amount of runs
    public int getRuns(){
        return runs;
    }

    //Returns the count
    public int getCount(){
        return count;
    }

}