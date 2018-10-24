package nl.hva.ict.ds.util;

import nl.hva.ict.ds.Player;

import java.util.List;

public class LinearProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {
    
    private int maxArraySize;
    private int arraySize;
    
    public LinearProbingMultiValueSymbolTable(int arraySize) {
        this.maxArraySize = arraySize;
    }

    @Override
    public void put(String key, Player value) {
        
        int hash = hash(key);
        System.out.println("Hash: " + hash);
           
    }
    
    private int hash(String key) {
        return key.hashCode() % maxArraySize; 
    }
    
    private int size() {
        return arraySize;
    }

    @Override
    public List<Player> get(String key) {
        return null;
    }
}
