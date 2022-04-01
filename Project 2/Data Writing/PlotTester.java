public class PlotTester {
    public static void main(String args[]){

        //Creates the initial data for y = x^2
        Plotter plot = new Plotter("x", "y", 50);
        plot.output();
        //Salts the data from y = x^2
        GraphSalter salter = new GraphSalter();
        salter.saltData("x", "y", 50);
        //Smooths the salted data
        GraphSmoother smoother = new GraphSmoother();
        smoother.smoothData("x", "y", 5);
    }
}
