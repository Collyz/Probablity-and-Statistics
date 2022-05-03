public class ExternalLibGraphTester {
    public static void main(String arg[]){

        ApacheSmoother smoother = new ApacheSmoother(4);
        smoother.smoothData();
        JFreeChartsGraph graph = new JFreeChartsGraph();
        graph.graph();
    }
}
