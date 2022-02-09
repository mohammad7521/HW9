package P4;

public class EntryModel<K,V> {

    //implementing our entry model for the custom hashMap

    //a hashMap contains 16 buckets of entries as objects

    //each hashMap object contains a key,a value and a reference to the next object
    //in the index

    //key
    private K key;

    //value
    private V value;

    //reference to the next object
    private EntryModel<K,V> next;


    //constructor
    public EntryModel(K key, V value, EntryModel<K, V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    //getters and setters
    public K getKey(){
        return  key;
    }

    public void setKey(K key){
        this.key=key;
    }

    public V getValue(){
        return this.value;
    }

    public void setValue(V value){
        this.value=value;
    }

    public EntryModel getNext(){
        return this.next;
    }

    public void setNext(EntryModel<K,V> next){
        this.next=next;
    }
}
