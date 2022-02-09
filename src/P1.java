import java.lang.reflect.Array;
import java.util.*;

public class P1 {

    //a hashSet to store all the permutations of a string inside it
    //in order to avoid duplication
    public static Set<String> hashSet = new HashSet<>();

    //a hashmap to store the permutation as value and assigning them to a key which is
    //the string itself
    public static HashMap<String, Set<String>> hashmap=new HashMap<>();


    // Recursive function to add all permutation of a string to a hashSet and then assigning it
    //to a hashMap
    public static void permute(String string, String addedAnswer) {


        if (string.length() == 0) {

            hashSet.add(addedAnswer);
            return;
        }

        for (int i = 0; i < string.length(); i++) {

            char ch = string.charAt(i);

            String restOfString = string.substring(0, i)
                    + string.substring(i + 1);

            // recursive call
            permute(restOfString, addedAnswer + ch);

        }

    }



    public static void showPermutations(ArrayList<String> arrayList){

        if (arrayList.size()>1){
            permute(arrayList.get(0),"");
            hashmap.put(arrayList.get(0),hashSet);
            if(hashmap.get(arrayList.get(0)).contains(arrayList.get(1))){
                System.out.println("Pass");
            }else System.out.println("Fail");
        }

        else {
            String s=arrayList.get(0);
            permute(s, "");
            hashmap.put(s, hashSet);
            System.out.println(hashmap);
        }

    }



    public static void main(String[] args)
    {

        hashmap.clear();


        Scanner scanner=new Scanner(System.in);

        System.out.println("please enter two words:");

        while (true) {
            String words = scanner.nextLine();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(List.of(words.split(" ")));
            if (arrayList.size() > 2) {
                System.out.println("please enter only two words!");
            }
            else {
                showPermutations(arrayList);
            }
        }

    }
}