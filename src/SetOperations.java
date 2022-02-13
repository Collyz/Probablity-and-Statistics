import java.util.Scanner;
public class SetOperations {

    public SetOperations(int[] array1, int[] array2){
    }

    public void SetUnion(int[] array1, int [] array2){
        int totalLength = array1.length + array2.length;
        int[] union = new int[totalLength];

        for(int i = 0; i < array1.length; i ++){
            union[i] = array1[i];
        }
        for(int i = 0; i < array2.length; i++){
            union[i + array1.length] = array2[i];
        }
        for(int i = 0; i < union.length; i ++) {
            System.out.print(union[i] + " ");
        }
    }

    public void SetIntersect(int[] array1, int[] array2){
        int count = 0;
        int totalLength = array1.length + array2.length;
        int [] holder = new int[totalLength];

        //If they have equal sizes
        if(array1.length == array2.length){
            for(int i = 0; i < array1.length; i++){
                if(array1[i] == array2[i]){
                    count++;
                }
            }
        }
        //If they have unequal sizes
        if (array1.length > array2.length) {
            for(int i = 0; i < array2.length; i++){
                for(int j = 0; j < array1.length; j++){
                    if(array2[i] == array1[j]){
                        count++;
                        holder[i] = array2[i];
                    }
                }
            }
        }
        else if(array1.length < array2.length){
            for(int i = 0; i < array1.length; i++){
                for(int j = 0; j < array2.length; j++){
                    if(array1[i] == array1[j]){
                        count++;
                    }
                }
            }
        }

        int[] intersect = new int[count];
        for(int i = 0; i < holder.length; i++){
            if(holder[i] != 0){
                intersect[i] = holder[i];
            }
        }
        System.out.print("The intersection of the two arrays is: ");
        for(int i = 0; i < intersect.length; i++){
            System.out.println(intersect[i] + " ");
        }
        System.out.println();
    }

    public void SetComplement(int[] array1, int [] array2){
        int arrayHolder = Math.max(array1.length, array2.length);
        int count = 0;
        int[] holder = new int[arrayHolder];
        Scanner in = new Scanner(System.in);
        System.out.print("One array? (Y / N): ");
        char input = in.next().charAt(0);

        if(input == 'Y'){
            System.out.println("The complement of the set is (-infinity, infinity)");
            System.out.print("Excluding: ");
            for(int i = 0; i < array1.length; i++){
                System.out.print(array1[i] + " ");
            }
        }
        if(input == 'N'){

            if(array1.length > array2.length){

                for(int i = 0; i < array1.length; i++){

                    for(int j = 0; j < array2.length;j++){

                        if (array1[i] != array2[j]) {
                            holder[i] = array1[i];
                        }
                    }
                }
            }
            for(int i = 0; i < holder.length; i++){
                System.out.print(holder[i]);
            }
        }

    }
}
