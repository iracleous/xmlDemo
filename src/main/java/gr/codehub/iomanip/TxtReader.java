package gr.codehub.iomanip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TxtReader {

    public static void main(String[] args) {
//        try {
//            textReader("xml_files/sample-lorem-ipsum-text-file.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    //    String paragraph = " Cras fermentum odio eu feugiat pretium nibh ipsum. Natoque penatibus et magnis dis. Morbi tristique senectus et netus et malesuada fames. Nunc vel risus commodo viverra maecenas accumsan. Fames ac turpis egestas maecenas pharetra convallis posuere morbi. Morbi tristique senectus et netus et malesuada fames ac. Suscipit tellus mauris a diam maecenas sed enim ut. Sed vulputate mi sit amet mauris commodo quis imperdiet massa. Vitae turpis massa sed elementum tempus egestas sed sed risus. Duis ut diam quam nulla porttitor. At risus viverra adipiscing at in. Sed sed risus pretium quam vulputate dignissim suspendisse in. Nec feugiat nisl pretium fusce id velit ut tortor. Massa tempor nec feugiat nisl pretium fusce id velit ut.";

        String paragraph = " dfdf. hmhk. dfdf,hmhk    dfdf";
      //  splitToSentences(paragraph);
        statistics(paragraph);

    }

    public static void textReader(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileReader = new Scanner(file);
        int counter=0;
        while (fileReader.hasNext()){
            String line = fileReader.nextLine();
            if(line.equals("")) continue;
            counter ++;
            System.out.println(counter + "   ---- "+line);}
    }

    public static void splitToSentences(String paragraph){
        if (paragraph == null) return;
        String[] lines = paragraph.split("\\.");
        for (String line:lines){
            System.out.println("-"+line+"-");
            System.out.println("-"+line.trim()+"-");
        }
    }



    public static void statistics(String paragraph){
        String words[] = paragraph.split("[\\W\\.\\,]");
        List<String> wordList = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for (String word : words){
            if (word.equals("")) continue;
            wordList.add(word);
            wordSet.add(word);
        }
        System.out.println(wordList.size());
        System.out.println(words.length);
        System.out.println(wordSet.size());
    }
}
