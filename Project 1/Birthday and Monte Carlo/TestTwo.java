public class TestTwo {
    public static void main(String[] args){

        WriteData test = new WriteData("ID", "Favorite Number", 1000, 1000);
        test.output();
        Person test2 = new Person(23, 10000);
        test2.reset();
        MonteCarloSimulation test3 = new MonteCarloSimulation(1000000);
        test3.gameShow();
    }
}
