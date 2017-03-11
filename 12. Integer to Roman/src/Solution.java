/**
 * Created by sahilpujari on 3/10/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "I");
        myMap.put(2, "II");
        myMap.put(3, "III");
        myMap.put(4, "IV");
        myMap.put(5, "V");
        myMap.put(6, "VI");
        myMap.put(7, "VII");
        myMap.put(8, "VIII");
        myMap.put(9, "IX");
        myMap.put(10, "X");
        myMap.put(50, "L");
        myMap.put(100, "C");
        myMap.put(500, "D");
        myMap.put(1000, "M");
        myMap.put(900, "CM");
        myMap.put(400, "CD");
        myMap.put(90, "XC");
        myMap.put(40, "XL");
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num % 1000 != num) {
                sb.append(myMap.get(1000));
                num -= 1000;
            } else if (num % 900 != num) {
                sb.append(myMap.get(900));
                num -= 900;
            } else if (num % 500 != num) {
                sb.append(myMap.get(500));
                num -= 500;
            } else if (num % 400 != num) {
                sb.append(myMap.get(400));
                num -= 400;
            } else if (num % 100 != num) {
                sb.append(myMap.get(100));
                num -= 100;
            } else if (num % 90 != num) {
                sb.append(myMap.get(90));
                num -= 90;
            } else if (num % 50 != num) {
                sb.append(myMap.get(50));
                num -= 50;
            } else if (num % 40 != num) {
                sb.append(myMap.get(40));
                num -= 40;
            } else if (num % 10 != num) {
                sb.append(myMap.get(10));
                num -= 10;
            } else {
                sb.append(myMap.get(num));
                num = 0;
            }
        }

        return sb.toString();
    }
}