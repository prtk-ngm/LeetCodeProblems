import java.security.PublicKey;

public class HashTables {

  public static void main(String[] args) {
    HashTableImpl htImpl = new HashTableImpl(40);
    htImpl.put(1,11);
    htImpl.put(1,22);
    System.out.println(htImpl.get(1,11));
    System.out.println(htImpl.get(1,22));

    htImpl.remove(1,11);
    System.out.println(htImpl.get(1,11));
    System.out.println(htImpl.get(1,22));

  }

}

class HashTableImpl{
  private CustomHashTable hashTable = null;
  private float loadFactor = 0.75f;

  public HashTableImpl(int size){
    createHashTable(size);
  }

  public HashTableImpl(int size, float lf){
    createHashTable(size);
    this.loadFactor = lf;
  }

  public void createHashTable(int initialCapacity){
    this.hashTable = new CustomHashTable();
    hashTable.tableSize = initialCapacity;
    hashTable.count = 0;
    hashTable.buckets = new Bucket[hashTable.tableSize];

    for(int i=0 ; i< hashTable.tableSize ; i++){
      hashTable.buckets[i] = new Bucket();
      hashTable.buckets[i].next = null;
      hashTable.buckets[i].numberOfElements = 0;

    }
  }
  public Integer get(int key, int value){
    ListNode temp = hashTable.buckets[hash(key, hashTable.tableSize)].next;
    while(temp != null){
      if(temp.key == key && temp.value == value){
        return value;

      }
      temp = temp.next;
    }
    return null;

  }

  //Map specified hash key and value return previous associated value of key if exists.
  public Integer put(int key, int value){
    int index;
    ListNode temp = null;
    ListNode newNode = null;
    ListNode prev = null;
    index = hash(key,hashTable.tableSize);

    temp = hashTable.buckets[index].next;

    while(temp != null){
      prev=temp;
      temp = temp.next;
    }

    newNode = new ListNode();
    newNode.value = value;
    newNode.key = key;
    newNode.next = null;

    if(prev == null)
      hashTable.buckets[index].next = newNode;
    else
      prev.next = newNode;



    hashTable.buckets[index].numberOfElements++;
    hashTable.count++;

    if(hashTable.count > Math.round(hashTable.tableSize * this.loadFactor)){
      //rehash logic should go here.
    }

    if(prev == null)
      return null;
    else
      return prev.value;

  }

  //remove specified key and value.
  public void remove(int key, int value){
    int index;
    ListNode prev = null;
    ListNode temp = null;
    index = hash(key,hashTable.tableSize);

    for(temp = hashTable.buckets[index].next; temp != null ; prev = temp, temp = temp.next){
      if(temp.value == value){
        if(prev!= null){
          prev.next = temp.next;
        }
        hashTable.buckets[index].numberOfElements--;
        hashTable.count--;
      }
    }

  }



  int hash(int key, int size){

    return key%size;
  }

}

class ListNode{
  int key;
  int value;
  ListNode next;
}

class Bucket{
  int numberOfElements;
  ListNode next;
}

class CustomHashTable {
  int tableSize;
  int count;
  Bucket [] buckets;

}
