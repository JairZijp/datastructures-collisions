package nl.hva.ict.ds.util;

import java.util.ArrayList;
import java.util.Arrays;
import nl.hva.ict.ds.Player;

import java.util.List;

public class DoubleHashingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {
    
    private int maxArraySize, currentArraySize;
    
    private String[] keys;
    private List<Player> values;
    private int collisionCount = 0;
    
    public DoubleHashingMultiValueSymbolTable(int arraySize) {
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
        int stepSize = hash2(key);
                               
        while(values.get(hash) != null) {
           hash += stepSize;
           hash %= maxArraySize;
        }
        
        values.set(hash, value);
        currentArraySize++;
                  
    }

    @Override
    public List<Player> get(String key) {
        
       List<Player> result = new ArrayList<>();

        int hash = hash(key);
        int stepSize = hash2(key);
        
        if((values.get(hash).getFirstName() + values.get(hash).getLastName()).equals(key)) {
            result.add(values.get(hash));
        }
        
        int i = 1;
        int index;
        
        do {
            index = (hash + i * stepSize) % maxArraySize;
            
            if (index >= maxArraySize) break;
            
            if (values.get(index) != null && (values.get(index).getFirstName() + values.get(index).getLastName()).equals(key)) {
                result.add(values.get(index));
            }
            
            i++;
            
        } while (values.get(index) != null && index != hash);
      
        return result;
        
    }
    
    private int hash(String key) {       
        return Math.abs(key.hashCode() % maxArraySize); 
    }
    
    private int hash2(String key) {
        return Math.abs(6 - key.hashCode() % 6);
    }
    
    private int size() {
        return currentArraySize;
    }
    
}
