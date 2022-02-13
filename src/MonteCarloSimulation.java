import java.util.Random;
public class MonteCarloSimulation {

    private int[] array;
    private int[] contestantPick;
    private Random rand;
    private double counter1;
    private double counter2;
    private int rounds;

    public MonteCarloSimulation(){
        this.rand = new Random();
        this.contestantPick = new int[3];
        this.array = new int[3];
        this.rounds = 10000;
    }

    public void gameShow(){
        for(int l = 0; l < rounds; l++) {
            //Sets up the array to mimic the three curtains and random contestant pick
            int n = array.length;
            int next;
            for (int i = 0; i < n; i++) {
                do {
                    next = rand.nextInt(n) + 1;
                } while (alreadyUsed(array, i, next));
                array[i] = next;
            }
            for(int p = 0; p < n; p++){
                do{
                    next = rand.nextInt(n) + 1;
                } while (alreadyUsed(contestantPick, p, next));
                contestantPick[p] = next;
            }
            //Picks one of the curtains and doesn't change answer
            int answer = array[1];
            int pick = rand.nextInt(n) + 1;
            for (int j = 0; j < (n - 1); j++) {
                if (pick == answer) {
                    counter1++;
                    j++;
                }
            }

            //Picks one of the curtains, answer always changes
            int previousPick = -1;
            for (int k = 0; k < (n - 1); k++) {
                pick = rand.nextInt(n);
                if (contestantPick[pick] == answer && pick != previousPick) {
                    counter2++;
                    k++;
                }
                else{
                    previousPick = pick;
                }
            }
        }
    }

    private boolean alreadyUsed(int[] a, int size, int val){
        for(int i = 0; i < size; i++){
            if(a[i] == val){
                return true;
            }
        }
        return false;
    }

    public void results(){
        double percentSame = (counter1/rounds) * 100;
        double percentDiff = (counter2/rounds) * 100;
        System.out.printf("The contestant did not change their answer: %.2f\n", percentSame);
        System.out.printf("The contestant changed their answer: %.2f", percentDiff);

    }




}
