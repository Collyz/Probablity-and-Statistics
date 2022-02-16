import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class SetOperations {
    private ArrayList<Integer> setOne = new ArrayList<Integer>();
    private ArrayList<Integer> setTwo = new ArrayList<Integer>();

    public SetOperations(int size, int bound){
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            setOne.add(rand.nextInt(bound) + 1);
            setTwo.add(rand.nextInt(bound) + 1);
        }
    }

    public SetOperations(ArrayList set1, ArrayList set2){
        this.setOne = set1;
        this.setTwo = set2;
    }

    public void runAll(){
        System.out.println("Set 1 : " + setOne);
        System.out.println("Set 2 : " + setTwo);
        System.out.println("Union of the two sets: " + setUnion());
        System.out.println("Intersect of the two sets:" + setIntersect());
        System.out.println("Complement of Set 1 " + setComplement() + "\n");
    }

    public ArrayList setUnion(){
        ArrayList<Integer> union = new ArrayList<>();
        union.addAll(setOne);
        union.addAll(setTwo);
        for(int i = 0; i < union.size(); i++){
            for(int j = i + 1; j < union.size(); j++){
                if(union.get(i) == union.get(j)){
                    union.remove(j);
                }
            }
        }
        return union;
    }

    public ArrayList setIntersect(){
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        for(int i = 0; i < setOne.size(); i++){
            for(int j = 0; j < setTwo.size(); j++){
                if(setOne.get(i) == setTwo.get(j)){
                    intersect.add(setOne.get(i));
                }
            }
        }
        return intersect;
    }

    public ArrayList setComplement(){
        ArrayList<Integer> complement = new ArrayList<Integer>();
        for(int i = 0; i < setOne.size(); i++){
            for(int j = 0; j < setTwo.size(); j++){
                if(setOne.get(i) == setTwo.get(j)){
                    setTwo.remove(j);
                }
            }
        }
        complement = setTwo;
        return complement;
    }

}
