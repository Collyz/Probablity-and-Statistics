public class TestWriter {
    public static void main(String[] args){

        WriteData test = new WriteData("ID", "Favorite Number", 1000, 2);
        test.output();
        BirthdayProgram test2 = new Person(23, 10000);
        ((Person) test2).reset();
        MonteCarloSimulation test3 = new MonteCarloSimulation(10000);
        test3.gameShow();
    }
}
