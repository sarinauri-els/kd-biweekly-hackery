package TexasHoldEm;

import java.util.*;
import java.util.stream.Collectors;

public class CardValueMapper {
    public static List<Integer> mapValues(List<String> values) {
        Map<String, Integer> valuesMap = new HashMap<>();

        valuesMap.put("A", 1);
        valuesMap.put("2", 2);
        valuesMap.put("3", 3);
        valuesMap.put("4", 4);
        valuesMap.put("5", 5);
        valuesMap.put("6", 6);
        valuesMap.put("7", 7);
        valuesMap.put("8", 8);
        valuesMap.put("9", 9);
        valuesMap.put("10", 10);
        valuesMap.put("J", 11);
        valuesMap.put("Q", 12);
        valuesMap.put("K", 13);

        return values.stream().map(valuesMap::get).collect(Collectors.toList());
    }
}
