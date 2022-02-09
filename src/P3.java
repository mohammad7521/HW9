
//write a java program which takes an arrayList as an input
//and then omits two adjacent numbers where the left number is bigger
//than the right number

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class P3 {


    public static ArrayList<Integer> remove(ArrayList<Integer> arrayList){
        ArrayList<Integer> newAL=new ArrayList<>();

        if (arrayList.size()%2!=0) {
            arrayList.remove(arrayList.size()-1);
        }

            for (int i = 0; i < arrayList.size(); i += 2) {
                if (arrayList.get(i) < arrayList.get(i + 1)) {
                    newAL.add(arrayList.get(i));
                    newAL.add(arrayList.get(i + 1));
                }
            }
        return newAL;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();

        arrayList.add(23);
        arrayList.add(2);
        arrayList.add(34);
        arrayList.add(12);
        arrayList.add(23);
        arrayList.add(22);
        arrayList.add(12);
        arrayList.add(24);
        arrayList.add(23);
        arrayList.add(24);
        arrayList.add(24);
        arrayList.add(2);
        arrayList.add(22);

        System.out.println(arrayList);
        System.out.println();
        System.out.println(remove(arrayList));


    }
}
