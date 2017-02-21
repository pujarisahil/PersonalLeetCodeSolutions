import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sahilpujari on 10/30/16.
 */
class WordNode {
    int count;
    String word;

    WordNode(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<WordNode> myList = new LinkedList<>();
        myList.add(new WordNode(beginWord, 1));
        wordList.add(endWord);

        while(!myList.isEmpty()) {
            WordNode temp = myList.remove();

            if(temp.word.equals(endWord))
                return temp.count;
            char[] myArr = temp.word.toCharArray();
            for(int i = 0; i < myArr.length; i++) {
                for(char j = 'a'; j <= 'z'; j++) {
                    char t = myArr[i];
                    if(myArr[i] != j)
                        myArr[i] = j;

                    if(wordList.contains(new String(myArr))) {
                        myList.add(new WordNode(new String(myArr), temp.count + 1));
                        wordList.remove(new String(myArr));
                    }

                    myArr[i] = t;
                }
            }
        }
        return 0;
    }
}