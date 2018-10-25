package nl.hva.ict.ds.util;

import java.util.ArrayList;
import nl.hva.ict.ds.Player;

import java.util.List;

public class QuadraticProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {
    private int size;
    private int maximumSize;
    
    // For the keys and values
    private String[] keys;
    private Player[] values;
    
    public QuadraticProbingMultiValueSymbolTable(int arraySize) {
        keys = new String[arraySize];
        values = new Player[arraySize];
        
        size = 0;
        maximumSize = arraySize;
    }

    @Override
    public void put(String key, Player value) {
        int keyHashed = hash(key);
        int index = keyHashed;
        int hash = 1;
        
        while(index != keyHashed){
            // no collision
            if(keys[index] == null){
                keys[index] = key;
                values[index] = value;
                size++;
            }
            else if(keys[index].equals(key)){
                values[index] = value;
            }
            else{
                index = (index + hash * hash++) % maximumSize;
            }
        }
    }

    @Override
    public List<Player> get(String key) {
        int index = hash(key);
        int factor = 1;
        ArrayList<Player> players = new ArrayList<>();
        
        while(keys[index] != null){
            if(keys[index].equals(key)){
                players.add(values[index]);
            }
            index = ( index + factor * factor++) % maximumSize;
        }
        return players;
    }
    
    private int hash(String key){
        return key.hashCode() % maximumSize;
    }
}
