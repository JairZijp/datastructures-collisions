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
    private int collisionCount = 0;
    
    public LinearProbingMultiValueSymbolTable(int arraySize) {
        this.currentArraySize = 0;
        maxArraySize = arraySize;
        keys = new String[maxArraySize];
        values = Arrays.asList(new Player[maxArraySize]);
        
    }

    @Override
    public void put(String key, Player value) {
        
        if (currentArraySize >= maxArraySize) {
            System.out.println("List is full");
            return;
        } 

        int hash = hash(key);
        
        // If the index is available/null put the player in that index.
        // If not keep searching in the list until we find an empty spot
        if(values.get(hash) == null) {   
            keys[hash] = key;
            values.set(hash, value);            
        } else {          
            collisionCount++;
 
            int emptyIndex = hash;
            while(values.get(emptyIndex) != null){
                emptyIndex++;
            }

            keys[emptyIndex] = key;
            values.set(emptyIndex, value);            
        }
        
        currentArraySize++;       
        
    }
    
    @Override
    public List<Player> get(String key) {
       
        List<Player> list = new ArrayList<>();
               
        for (int i = hash(key); keys[i] != null; i = (i + 1) % maxArraySize) {
            
            System.out.println(keys[i]);
         
            if (keys[i].equals(key)) {
                System.out.println("Ja equal");
                list.add(values.get(i));
            }
            
        }

        System.out.println("Get list: " + list);
        
        return list;
        
    }
   
    private int hash(String key) {  
        return Math.abs(key.hashCode() % maxArraySize); 
    }
    
    private int size() {
        return currentArraySize;
    }

}
