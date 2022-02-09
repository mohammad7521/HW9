package P4;

import java.util.concurrent.ScheduledExecutorService;

public class Main {

    public static void main(String[] args) {
        CustomHashMap<String,String> customHashMap=new CustomHashMap<>();

        customHashMap.display();
        System.out.println();
        System.out.println("putting new key value pairs:");
        customHashMap.put("mohammad","mohammad@gmail.com");
        customHashMap.put("ali","ali@gmail.com");
        System.out.println();
        customHashMap.display();
        System.out.println();
        System.out.println("checking if contains mohammad@gmail.com");
        System.out.println(customHashMap.contains("mohammad@gmail.com"));
        System.out.println();
        System.out.println("checking if the array is empty:");
        System.out.println(customHashMap.isEmpty());
        System.out.println();
        System.out.println("showing all elements");
        customHashMap.display();
        System.out.println();
        System.out.println("replacing mohammad@gmail.com with reza@gmail.com:");
        customHashMap.replace("mohammad","reza@gmail.com");
        customHashMap.display();

    }
}
