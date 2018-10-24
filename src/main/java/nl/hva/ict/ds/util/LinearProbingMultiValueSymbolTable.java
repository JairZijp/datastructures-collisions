package nl.hva.ict.ds.util;

import java.util.ArrayList;
import java.util.Arrays;
import nl.hva.ict.ds.Player;

import java.util.List;

public class LinearProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {
    
    private int maxArraySize, currentArraySize;
    
    private String[] keys;
    //private List<Player> values = new ArrayList<Player>(100);
    private List<Player> values = Arrays.asList(new Player[7]);
    
    public LinearProbingMultiValueSymbolTable(int arraySize) {
        this.currentArraySize = 0;
        maxArraySize = arraySize;
        keys = new String[maxArraySize];
        
    }

    @Override
    public void put(String key, Player value) {
               
        int hash = hash(key);
          
//        System.out.println("hash: " + hash);
//        System.out.println("key: " + key);
//        System.out.println("value: " + value);
//        System.out.println("---------------");

        // double table size if 50% full
        //if (currentArraySize >= maxArraySize/2) resize(2*maxArraySize);

        int i;
        for (i = hash; keys[i] != null; i = (i + 1) % maxArraySize) {
            if (keys[i].equals(key)) { values.set(i, value); return; }
        }
        keys[i] = key;
        values.set(i, value);
        currentArraySize++;
       
        System.out.println(values);
    }
    
    @Override
    public List<Player> get(String key) {
        
        System.out.println("key" + key);
    
        List<Player> list = Arrays.asList(new Player[maxArraySize]);
        int i = hash(key);
        while (keys[i] != null)
        {
            if (keys[i].equals(key))
                list.set(i, values.get(i));
            i = (i + 1) % maxArraySize;
        }            
        return list;
        
    }
    
    private int hash(String key) {
        return key.hashCode() % maxArraySize; 
    }
    
    private int size() {
        return currentArraySize;
    }

}
