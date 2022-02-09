package P4;

import com.sun.jdi.Value;

import java.security.Key;

public class CustomHashMap<K,V> {

    //setting a capacity for the custom hashmap
    //since the default capacity for hashMap is 16,therefore we set
    //the capacity of our custom hashMap to 16

    private final EntryModel<K,V>[] table;

    private final int capacity=16;
    public CustomHashMap(){
        table=new EntryModel[capacity];
    }


    //custom put method implementation

    //the put method accepts one null key and multiple null elements as values.
    public void put(K key, V value){
        int index = index(key);
        EntryModel newEntry = new EntryModel(key, value, null);
        if(table[index] == null){
            table[index] = newEntry;
        }else {
            EntryModel<K, V> previousNode = null;
            EntryModel<K, V> currentNode = table[index];
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if(previousNode != null)
                previousNode.setNext(newEntry);
        }
    }




    //custom get method
    public V get(K key){
        V value = null;
        int index = index(key);
        EntryModel<K, V> entryModel = table[index];
        while (entryModel != null){
            if(entryModel.getKey().equals(key)) {
                value = entryModel.getValue();
                break;
            }
            entryModel = entryModel.getNext();
        }
        return value;
    }




    //custom remove method
    public void remove(K key){
        int index = index(key);
        EntryModel previous = null;
        EntryModel entryModel = table[index];
        while (entryModel != null){
            if(entryModel.getKey().equals(key)){
                if(previous == null){
                    entryModel = entryModel.getNext();
                    table[index] = entryModel;
                    return;
                }else {
                    previous.setNext(entryModel.getNext());
                    return;
                }
            }
            previous = entryModel;
            entryModel = entryModel.getNext();
        }
    }


    //custom contains method
    public boolean contains(V value){
        boolean flag=false;
        for (int i=0;i<capacity;i++){
            if (table[i]!=null){
                EntryModel<K,V> currentNode=table[i];
                if (get(currentNode.getKey()).equals(value)){
                    flag=true;
                }
            }
        }
        return flag;
    }


    //display all
    public void display(){
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                EntryModel<K, V> currentNode = table[i];
                while (currentNode != null){
                    System.out.println(String.format("Key is %s and value is %s", currentNode.getKey(), currentNode.getValue()));
                    currentNode = currentNode.getNext();
                }
            }
        }
    }



    //isEmpty
    public boolean isEmpty(){
        boolean flag=true;

        for (int i=0;i<capacity;i++){
            if (table[i]!=null){
                flag= false;
            }
        }
        return flag;
    }



    //custom replace method
    public void replace(K key,V newValue){
        V value = null;
        int index = index(key);
        EntryModel<K, V> entryModel = table[index];
        while (entryModel != null){
            if(entryModel.getKey().equals(key)) {
                 put(key,newValue);
                break;
            }
            entryModel = entryModel.getNext();
        }

    }



    private int index(K key){
        if(key == null){
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }

}
