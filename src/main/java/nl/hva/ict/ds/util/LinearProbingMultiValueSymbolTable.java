package nl.hva.ict.ds.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import nl.hva.ict.ds.Player;

import java.util.List;

public class LinearProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {
    
    private int maxArraySize, currentArraySize;
    
    private String[] keys;
    //private List<Player> values = new ArrayList<Player>(100);
    private List<Player> values;
    
    public LinearProbingMultiValueSymbolTable(int arraySize) {
        this.currentArraySize = 0;
        maxArraySize = arraySize;
        keys = new String[maxArraySize];
        values = Arrays.asList(new Player[maxArraySize]);
        
    }

    @Override
    public void put(String key, Player value) {
   
          int tmp = hash(key);
        System.out.println("HASH: " + tmp);
//        System.out.println("hash: " + hash);
        System.out.println("Firstname: " + key);
  //      System.out.println("value: " + value);
       
        int i = tmp;
        do
        {
            if (keys[i] == null)
            {
                keys[i] = key;
                values.set(i, value); 
                currentArraySize++;
                return;
            }
            if (keys[i].equals(key)) 
            { 
                // TODO: handle if the same hash
                System.out.println("Ja dezelfde!");
                values.set(i, value); 
                return; 
            }            
            i = (i + 1) % maxArraySize;            
        } while (i != tmp);       
       
    }
    
    @Override
    public List<Player> get(String key) {
        
        System.out.println(values);
        
        System.out.println("key: " + key);
       
        List<Player> list = new ArrayList<>();
               
        for (int i = hash(key); keys[i] != null; i = (i + 1) % maxArraySize) 
            if (keys[i].equals(key))
                list.add(values.get(i));
        
        System.out.println(list);
        
        
        return list;
        
    }
    
    private int hash(String key) {
        return key.hashCode() % maxArraySize; 
    }
    
    private int size() {
        return currentArraySize;
    }

}
