import java.util.ArrayList;
import java.util.Arrays;

public class SetOperationsB {
    private ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9));

    public SetOperationsB(){
        System.out.println("ArrayList 1 : " + list1);
        System.out.println("ArrayList 2 : " + list2);
    }

    public void SetUnionB(){
        ArrayList<Integer> union = new ArrayList<>();
        union.addAll(list1);
        union.addAll(list2);
        for(int i = 0; i < union.size(); i++){
            for(int j = i + 1; j < union.size(); j++){
                if(union.get(i) == union.get(j)){
                    union.remove(j);
                }
            }
        }
        System.out.println(union);
    }

    public void SetIntersectB(){

    }

    public void SetComplement(){

    }


}
