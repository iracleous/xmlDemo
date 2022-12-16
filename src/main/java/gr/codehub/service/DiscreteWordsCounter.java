package gr.codehub.service;

import java.util.HashSet;

public class DiscreteWordsCounter {
    private static String words = "The UN and agency’s Statistical Yearbook 2022 also noted than the cattle emit around 50 times " +
            "more carbon dioxide than chickens, more growing rice emits five times and more carbon into the atmosphere, than wheat and coarse grains.";

    public static void main(String[] args) {
        System.out.println("countWords= "+countWords(words));
        System.out.println("countDistinctWords= "+countDistinctWords(words));
    }


    public static int countWords(String paragraph){
        String []words = paragraph.split(" ");
        return words.length;
    }

    public static int countDistinctWords(String paragraph){
        String []words = paragraph.split(" ");
        HashSet<String> set = new HashSet<>();
        for(String s : words) set.add(s);
        return set.size();
    }
}
