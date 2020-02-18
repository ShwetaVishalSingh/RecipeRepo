package com.recipe.se.recipes.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindKeysWithCommonValuesMap {

    public static void main(String[] args) {
        Map<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("1", "shweta");
        stringHashMap.put("2", "vishal");
        stringHashMap.put("3", "vikas");
        stringHashMap.put("4", "shweta");
        stringHashMap.put("5", "shweta");
        stringHashMap.put("6", "vishal");

        List<String> keysvalues = new ArrayList<>();
        List<String> commonnamesvalues = new ArrayList<>();
        for (Entry<String, String> name : stringHashMap.entrySet()) {
            if(!commonnamesvalues.isEmpty() && commonnamesvalues.contains(name.getValue()))
            {
                keysvalues.add(name.getKey());
            }
            commonnamesvalues.add(name.getValue());
        }
        System.out.println(keysvalues);
    }
}

