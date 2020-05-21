package com.github.mathan26.concepts.java8;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "Love", "you", "too"));

        //java 7
        for (String str : list) {
            if (str.length() > 3) {
                System.out.println(str);//Love
            }
        }

        // Use forEach () combined with anonymous inner class to iterate
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.length() > 3)
                    System.out.println(s);//Love
            }
        });

        //Lamda
        list.forEach(s -> {
                    if (s.length() > 3)
                        System.out.println(s);//Love
                }
        );

        //Requirements: Suppose there is a list of strings, and you need to delete all the strings with a length greater than 3.
        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().length()>3){
                iterator.remove();
            }
        }
        System.out.println(list);//[I, you, too]
        list = new ArrayList<>(Arrays.asList("I", "Love", "you", "too"));

        //annonymous class
        list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()>3;
            }
        });
        System.out.println(list);//[I, you, too]

        list = new ArrayList<>(Arrays.asList("I", "Love", "you", "too"));
        //Lamda
        list.removeIf(s->s.length()>3);
        System.out.println(list);//[I, you, too]

//        Requirement: Suppose there is a list of strings,
//        all elements with a length greater than 3 are converted to uppercase, and the remaining elements remain unchanged.
        list = new ArrayList<>(Arrays.asList("I", "Love", "you", "too"));


        /*replaceAll()*/
        //Java 7

        for(int i=0;i<list.size();i++){
            String str=list.get(i);
            if((str.length()>3)){
                list.set(i,str.toUpperCase());
            }
        }
        System.out.println(list); //[I, LOVE, you, too]

        //annonymous
        list = new ArrayList<>(Arrays.asList("I", "Love", "you", "too"));
        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if(s.length()>3){
                    return s.toUpperCase();
                }
                return s;
            }
        });
        System.out.println(list);

        //lamda
        list = new ArrayList<>(Arrays.asList("I", "Love", "you", "too"));
        list.replaceAll(s -> {
            if(s.length()>3){
                return s.toUpperCase();
            }else{
                return s;
            }
        });

        System.out.println(list);

        /*sort()*/

//        Requirements: Suppose there is a list of strings,
//        and the elements are sorted in ascending order according to the length of the string.
        list = new ArrayList<>(Arrays.asList("I", "Love", "you", "too"));
        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
                return str1.length()-str2.length();
            }
        });
        System.out.println(list); //[I, you, too, Love]

        list = new ArrayList<>(Arrays.asList("I", "Love", "you", "too"));

//        lamda
        list.sort((str1,str2)->str1.length()-str2.length());
        System.out.println(list); //[I, you, too, Love]

//        Requirements: Suppose there is a number to the Map corresponding to English words,
//        please output all the mapping relationships in the Map.
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");

        //java 7
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
        }

        //anonymous
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println("key :"+integer+" value: "+s);
            }
        });

        //Lamda
        map.forEach((key,value)-> System.out.println("key :"+key+" value: "+value));
       /* key :1 value: one
        key :2 value: two
        key :3 value: three*/

//        Demand; Suppose there is a number to the Map corresponding to English words,
//        output 4 corresponding to English words, if there is no output NoValue

        //java 7
        if(map.containsKey("4"))
            System.out.println(map.get(4));
        else
            System.out.println("No value");

        //Lamda
        System.out.println(map.getOrDefault("4","No Value"));//No Value

        //Requirements: Assuming there is a number to the Map corresponding to English words,
        // please convert all the words in the original mapping relationship to uppercase.

//        java 7
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(map);//{1=ONE, 2=TWO, 3=THREE}

        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        //anonymous
        map.replaceAll(new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer key, String value) {
                return value.toUpperCase();
            }
        });
        System.out.println(map);

        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        //lamda
        map.replaceAll((k,v)->v.toUpperCase());
        System.out.println(map);

        //merge method

        map.merge(10,"newvalue",(v1,v2)->v1+"oldvalue");
        System.out.println(map);//{1=ONE, 2=TWO, 3=THREE, 10=newvalue}
        map.merge(1,"newvalue",(v1,v2)->v1+"oldvalue");//{1=ONEoldvalue, 2=TWO, 3=THREE, 10=newvalue}
        System.out.println(map);

    }
}

