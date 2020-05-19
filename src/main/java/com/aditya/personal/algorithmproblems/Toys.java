package com.aditya.personal.algorithmproblems;

import java.util.*;
import java.util.stream.Collectors;

public class Toys {

    public static ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes)
    {

        // lower case the toys and convert them to a set for faster lookups
        Collection<String> lowerCasedToys = toys.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        Map<String, Integer> toyCount = new HashMap<>();

        for (String quote : quotes) {

            String[] words = quote.split("\\s+");

            Set<String> alreadyUsed = new HashSet<>();

            for (String word: words) {

                word = word.toLowerCase();

                // just move forward in case the word is not a toy.
                if (!lowerCasedToys.contains(word))
                    continue;

                // since it's a multiple occurance of the same toy
                if (alreadyUsed.contains(word))
                    continue;

                toyCount.put(word, toyCount.getOrDefault(word, 0) + 1);
                alreadyUsed.add(word);

            }
        }

        // this will sort the list in ascending order of the toy count.
        ArrayList<String> toReturn = toyCount.keySet().stream()
                .sorted((w1, w2)-> {

                    // sort by counts
                    int comparisonResult = toyCount.get(w2).compareTo(toyCount.get(w1));


                    // if the count is not the same.
                    if (comparisonResult != 0)
                        return comparisonResult;

                    // return the alphabetical comparison result to sort.
                    return w1.compareTo(w2);
                })
                .limit(topToys)
                .collect(Collectors.toCollection(ArrayList::new));

        return toReturn;
    }

        public static void main (String[]args){

        List<String> p = Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell");
        List<String> q = Arrays.asList("anacell anacell", "betacellular", "");
            popularNToys(5, 5, p, 3, q);
        }

    }
