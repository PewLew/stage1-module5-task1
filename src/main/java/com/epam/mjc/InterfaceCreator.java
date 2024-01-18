package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase(){
        return x -> {
            for(var e : x){
                if(!Character.isUpperCase(e.charAt(0)))
                    return false;
            }

            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int counter = x.size() - 1;
            int check = x.size() - 1;
            for (int i = 0; i < x.size(); i++){
                if (x.get(i) % 2 == 0) {
                    counter += 1;
                    x.add(x.get(i));
                }
                if(i == check)
                    break;
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for(var e : values){
                String[] arr = e.split(" ");
                String firstWord = arr[0];
                String lastWord = arr[arr.length-1];
                char dotCheck = lastWord.charAt(lastWord.length()-1);
                if(Character.isUpperCase(firstWord.charAt(0)) && dotCheck=='.' && arr.length>3)
                    list.add(e);
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for(var e : x){
                map.put(e, e.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}
