import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public void aggregate(List<String> inputs, String period) {
        String[] tokensTemp = period.split(",");
        int startYear, endYear;
        int startMonth, endMonth;

        startYear = Integer.parseInt(tokensTemp[0].split("-")[0].trim());
        startMonth = Integer.parseInt(tokensTemp[0].split("-")[1].trim());

        endYear = Integer.parseInt(tokensTemp[1].split("-")[0].trim());
        endMonth = Integer.parseInt(tokensTemp[1].split("-")[1].trim());

        Map<String, Map<String, Integer>> myMap = new LinkedHashMap<>();
        for(String str : inputs) {
            String[] tokens = str.split(",");
            String date = tokens[0].substring(0, 7);
            int month = Integer.parseInt(date.split("-")[1]);
            int year = Integer.parseInt(date.split("-")[0]);

            if(!isInPeriod(startYear, startMonth, endYear, endMonth, month, year))
                continue;

            String key = tokens[1];
            Integer value = Integer.parseInt(tokens[2].trim());

            if(myMap.containsKey(date)) {
                Map<String, Integer> temp = myMap.get(date);
                if(temp.containsKey(key)) {
                    Integer current = temp.get(key);
                    temp.put(key, current + value);
                    myMap.put(date, temp);
                } else {
                    temp.put(key, value);
                    myMap.put(date, temp);
                }
            } else {
                Map<String, Integer> temp = new LinkedHashMap<>();
                temp.put(key, value);
                myMap.put(date, temp);
            }
        }

        SortedSet<String> keys = new TreeSet<String>(myMap.keySet());
        LinkedList<String> list = new LinkedList<>(keys);
        Iterator<String> itr = list.descendingIterator();
        while(itr.hasNext()) {
            String dat = itr.next();
            System.out.print(dat);
            Map<String, Integer> tempMap = myMap.get(dat);
            SortedSet<String> keysTwo = new TreeSet<String>(tempMap.keySet());
            for(String tempMapKey : keysTwo) {
                System.out.print("," + tempMapKey + ", " + tempMap.get(tempMapKey));
            }
            System.out.println();
        }
    }

    public boolean isInPeriod(int startYear, int startMonth, int endYear, int endMonth, int givenMonth, int givenYear) {
        if(givenYear >= startYear && givenYear <= endYear) {
            if(givenYear == startYear) {
                if(givenMonth >= startMonth)
                    return true;
            } else if(givenYear == endYear) {
                if(givenMonth < endMonth)
                    return true;
            } else
                return true;
        }
        return false;
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Solution solution = new Solution();
        Scanner scan = new Scanner(System.in);
        String period = scan.nextLine();
        scan.nextLine();
        List<String> inputs = new ArrayList<>();
        while(scan.hasNextLine()) {
            inputs.add(scan.nextLine());
        }

        solution.aggregate(inputs, period);
    }
}