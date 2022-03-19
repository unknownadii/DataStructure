package HashMapAndHashSet.HashMapImplemented;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplemented<K, V> {

    private class HMNode {
        K key;
        V value;

        HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private LinkedList<HMNode> buckets[];

    //Constructor
    public HashMapImplemented() {
        initbuckets(4);
        size = 0;
    }

    private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key) {
        int code = key.hashCode();
        int bucketIndex = Math.abs(code) % buckets.length;
        return bucketIndex;
    }

    private int dataIndex(K key, int bucketIndex) {
        int dataIndex = 0;
        for (HMNode node : buckets[bucketIndex]) {
            if (node.key.equals(key)) {
                return dataIndex;
            }
            dataIndex++;
        }
        // if we don't get the key in this bucketIndex then return -1
        return -1;
    }

    //Rehashing
    private void rehash() throws Exception {
        LinkedList<HMNode>[] oldLinkedListArray = buckets;
        initbuckets(2 * oldLinkedListArray.length);
        size = 0;
        for (int i = 0; i < oldLinkedListArray.length; i++) {
            for (HMNode node : oldLinkedListArray[i]) {
                put(node.key, node.value);
            }
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Put Data In HashMap
    public void put(K key, V value) throws Exception {
        int bucketIndex = hashFunction(key);
        int dataIndexInBucket = dataIndex(key, bucketIndex);
        if (dataIndexInBucket == -1) {
            // If key is not present then insert
            HMNode temp = new HMNode(key, value);
            buckets[bucketIndex].addLast(temp);
            size++;
        } else {
            // If key is present then update
            HMNode returnDataNode = buckets[bucketIndex].get(dataIndexInBucket);
            returnDataNode.value = value;
        }
        // checking the size of the HashMap
        double lambda = size * 1.0/* converted in to double*/ / buckets.length;
        if (lambda > 2.0) {
            rehash();
        }
    }

    // Contains Key
    public boolean containsKey(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndexInBucket = dataIndex(key, bucketIndex);
        if (dataIndexInBucket == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Remove
    public V removeNode(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndexInBucket = dataIndex(key, bucketIndex);
        if (dataIndexInBucket == -1) {
            return null;
        } else {
            return buckets[bucketIndex].remove(dataIndexInBucket).value;
        }
    }

    // Key Set
    public ArrayList<K> keySet() {
        ArrayList<K> keySetList = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            for (HMNode node : buckets[i]) {
                keySetList.add(node.key);
            }
        }
        return keySetList;
    }

    //size

    public int size() {
        return size;
    }

    //Display
    public void display() throws Exception {
        for (int i = 0; i < buckets.length; i++) {
            for (HMNode node : buckets[i]) {
                System.out.print(node.key + "->" + node.value + " ");
            }
            System.out.println(".");
        }
    }

    //Get the value of key
    public V get(K key) throws Exception {
        int bucketIndex = hashFunction(key);
        int dataIndexInBucket = dataIndex(key, bucketIndex);
        if (dataIndexInBucket == -1) {
            return null;
        } else {
            return buckets[bucketIndex].get(dataIndexInBucket).value;
        }
    }
}































