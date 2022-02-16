public class TestWriter {
    public static void main(String[] args){

        WriteData test = new WriteData("ID", "Favorite Number", 1000, 2);
        test.output();
        Persons test2 = new BirthdayProgram(23, 10000);
        ((BirthdayProgram) test2).birthdaySolve();
        MonteCarloSimulation test3 = new MonteCarloSimulation(10000);
        test3.gameShow();
    }
}
