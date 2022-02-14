import java.util.ArrayList;
import java.util.Arrays;

public class SetOperations {
    private ArrayList<Integer> setOne = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private ArrayList<Integer> setTwo = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 9));

    public SetOperations(){
        System.out.println("Set 1 : " + setOne);
        System.out.println("Set 2 : " + setTwo);
    }

    public void setUnion(){
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
        System.out.println("Union of the two sets: " + union);
    }

    public void setIntersect(){
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        for(int i = 0; i < setOne.size(); i++){
            for(int j = 0; j < setTwo.size(); j++){
                if(setOne.get(i) == setTwo.get(j)){
                    intersect.add(setOne.get(i));
                }
            }
        }
        System.out.println("Intersect of the two sets:" + intersect);
    }

    public void setComplement(){
        ArrayList<Integer> complement = new ArrayList<Integer>();
        for(int i = 0; i < setOne.size(); i++){
            for(int j = 0; j < setTwo.size(); j++){
                if(setOne.get(i) == setTwo.get(j)){
                    setTwo.remove(j);
                }
            }
        }
        System.out.println("Complement of  " + setTwo);
    }


}
