import com.sun.source.tree.Tree;

import java.util.Random;
import java.util.TreeSet;
import java.util.stream.StreamSupport;


//write a java program which creates two treeSets and
//fill them with random characters from 1 to 10
//and show the treeSet
public class P2 {


    //method to randomize a treeSet
    public static void randomizeTreeSet(int n,TreeSet<Character> treeSet) {

        int rand;
        while (treeSet.size()<10) {
            Random random = new Random();
            rand = random.nextInt(26);
            treeSet.add((char) ('a' + rand));
        }
    }


    //get community of two treeSets
    public static TreeSet<Character> getCommunity(TreeSet<Character> ts1,TreeSet<Character> ts2) {

        TreeSet<Character> treeSet = new TreeSet<>();

        for (Character c : ts1) {
            treeSet.add(c);
        }

        for (Character c : ts2) {
            treeSet.add(c);
        }
        return treeSet;
    }


    //subscription of treeSets:
    public static TreeSet<Character> subscriptions (TreeSet<Character> ts1,TreeSet<Character> ts2){

        TreeSet<Character> treeSet=new TreeSet<>();
        treeSet.addAll(ts1);
        treeSet.retainAll(ts2);
        return treeSet;
    }



        public static void main (String[]args){

            TreeSet<Character> treeSet1 = new TreeSet<>();
            TreeSet<Character> treeSet2 = new TreeSet<>();

            //length of the treeSet.
            int n=10;
            randomizeTreeSet(n,treeSet1);
            randomizeTreeSet(n,treeSet2);

            System.out.println("1st randomized treeSet:");
            System.out.println(treeSet1);
            System.out.println();
            System.out.println("2nd randomized treeSet:");
            System.out.println(treeSet2);
            System.out.println();

            System.out.println("community of treeSets:");


            //community
            System.out.println(getCommunity(treeSet1, treeSet2));
            System.out.println();


            //subscription
            System.out.println("subscription of treeSets:");
            System.out.println(subscriptions(treeSet1,treeSet2));
            }


    }


