import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteData {
    private FileWriter fw;
    private BufferedWriter br;

    public WriteData(){
        try{
            fw = new FileWriter("ExampleOutput.csv");
            br = new BufferedWriter(fw);
        }catch(Exception e){
            System.out.println("ERROR OCCURED: " + e.toString());
        }
    }

    public void outputSingleLine(String string1, int[][] array1){
        try {
            br.write(string1);
            br.newLine();
            for (int[] ints : array1) {
                br.write(String.valueOf(ints[0]));
                br.write(",");
                br.write(String.valueOf(ints[1]));
                br.newLine();
            }
            br.close();
        }catch (Exception e){
            System.out.println("Write out error (or close error): " + e.toString());
        }
    }

}
