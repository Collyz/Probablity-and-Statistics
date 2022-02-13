public class TestWriter {
    public static void main(String[] args){
        WriteData test = new WriteData();
        String title = "ID, Favorite Number";
        String favNumber = "Favorite Number: ";
        int[][] id = new int[1000][1000];

        for(int i = 0; i < 1000; i++){
            id[i][0] = (int)(Math.random() * (1000 - 1));
            id[i][1] = (int)(Math.random() * (1000 - 1));
        }

        test.outputSingleLine(title, id);
        System.out.println(id[1][0]);

    }
}
