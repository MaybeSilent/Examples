package demos;

import java.util.TreeMap;

public class Solution {
    public static void main(String[] args){
        TreeMap<Integer,Integer> maps = new TreeMap<>();
        maps.put(1,3);
        maps.put(2,4);
        maps.put(3,2);
        for(int i : maps.keySet()) {
            System.out.println(maps.get(i));
        }
    }
}
