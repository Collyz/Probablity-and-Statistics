import java.util.ArrayList;
import java.util.Random;

public class SetOperations {
    private ArrayList<Integer> setOne = new ArrayList<Integer>(); //ArrayList of set one
    private ArrayList<Integer> setTwo = new ArrayList<Integer>(); //ArrayList of set two

    //If there are no ArrayLists to be used then this constructor will be used
    //Fills both sets with random numbers that bounded by a given number until a given size is achieved
    public SetOperations(int size, int bound){
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            setOne.add(rand.nextInt(bound) + 1);
            setTwo.add(rand.nextInt(bound) + 1);
        }
    }

    //If there are ArrayLists to be used then this constructor will be used
    public SetOperations(ArrayList set1, ArrayList set2){
        this.setOne = set1;
        this.setTwo = set2;
    }

    //Runs all of the methods below runAll and prints their return values
    public void runAll(){
        System.out.println("Set 1 : " + setOne);
        System.out.println("Set 2 : " + setTwo);
        System.out.println("Union of the two sets: " + setUnion());
        System.out.println("Intersect of the two sets:" + setIntersect());
        System.out.println("Complement of Set 1 " + setComplement() + "\n");
    }

    //Finds the union of two ArrayList and returns it
    public ArrayList setUnion(){
        ArrayList<Integer> union = new ArrayList<>();
        union.addAll(setOne);
        union.addAll(setTwo);
        //If there are repeated numbers they are removed
        for(int i = 0; i < union.size(); i++){
            for(int j = i + 1; j < union.size(); j++){
                if(union.get(i) == union.get(j)){
                    union.remove(j);
                }
            }
        }
        return union;
    }

    //Finds the intersect of two Arraylist and returns it
    public ArrayList setIntersect(){
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        for(int i = 0; i < setOne.size(); i++){
            for(int j = 0; j < setTwo.size(); j++){
                if(setOne.get(i) == setTwo.get(j)){
                    intersect.add(setOne.get(i));  //If the two ArrayList share a value it is added to intersect ArrayList
                }
            }
        }
        for(int k = 0; k < intersect.size(); k++){
            for(int l = k + 1; l < intersect.size(); l++){
                if(intersect.get(k) == intersect.get(l)){
                    intersect.remove(l);
                }
            }
        }
        return intersect;
    }

    //Finds the compliment of setOne and returns it
    public ArrayList setComplement(){
        ArrayList<Integer> complement = new ArrayList<Integer>();
        for(int i = 0; i < setOne.size(); i++){
            for(int j = 0; j < setTwo.size(); j++){
                if(setOne.get(i) == setTwo.get(j)){
                    setTwo.remove(j);  //If a number exists in setOne and setTwo it is removed from setTwo
                }
            }
        }
        complement = setTwo;
        return complement;
    }

}
