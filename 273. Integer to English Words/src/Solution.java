import java.util.*;

/**
 * Created by sahilpujari on 10/20/16.
 */
class Solution {
    private String numberToWords(int num) {
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(0, "Zero");
        myMap.put(1, "One");
        myMap.put(2, "Two");
        myMap.put(3, "Three");
        myMap.put(4, "Four");
        myMap.put(5, "Five");
        myMap.put(6, "Six");
        myMap.put(7, "Seven");
        myMap.put(8, "Eight");
        myMap.put(9, "Nine");
        myMap.put(10, "Ten");
        myMap.put(11, "Eleven");
        myMap.put(12, "Twelve");
        myMap.put(13, "Thirteen");
        myMap.put(14, "Fourteen");
        myMap.put(15, "Fifteen");
        myMap.put(16, "Sixteen");
        myMap.put(17, "Seventeen");
        myMap.put(18, "Eighteen");
        myMap.put(19, "Nineteen");
        myMap.put(20, "Twenty");
        myMap.put(30, "Thirty");
        myMap.put(40, "Forty");
        myMap.put(50, "Fifty");
        myMap.put(60, "Sixty");
        myMap.put(70, "Seventy");
        myMap.put(80, "Eighty");
        myMap.put(90, "Ninety");
        myMap.put(100, "Hundred");
        myMap.put(1000, "Thousand");
        myMap.put(1000000, "Million");

        return recHelper(num, myMap);
    }



    private String recHelper(int num, Map<Integer, String> dict) {
        if(num == 0)
            return "Zero";

        Stack<Integer> myStack = new Stack<>();
        while(num != 0) {
            myStack.push(num % 10);
            num /= 10;
        }

        List<Integer> myList = new ArrayList<>();
        int curr = 0, mul;
        while(!myStack.isEmpty()) {
            //TOOD : Check for 1,4,
            mul = (int)Math.pow(10, myStack.size() -1);
            if(myStack.size() % 3 == 1 || myStack.size() == 1) {
                int temp = myStack.pop();
                curr += temp * mul;
                myList.add(curr/mul);
                curr = 0;
            } else {
                int temp = myStack.pop();
                curr += temp * mul;
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < myList.size(); i++) {
            sb.append(solve(myList.get(i), (myList.size() - i - 1), dict));
        }
        return sb.substring(0, sb.length() - 1);
    }

    private String solve(int a, int place, Map<Integer, String> dict) {
        StringBuilder sb = new StringBuilder();
        if(a == 0) return "";
        if(a < 21) {
            sb.append(dict.get(a)).append(" ");
        } else {
            Stack<Integer> myStack = new Stack<>();
            while(a != 0) {
                myStack.push(a % 10);
                a /= 10;
            }

            if(myStack.size() == 3) {
                int mul = (int)Math.pow(10, myStack.size() -1);
                int curr = myStack.pop();
                sb.append(dict.get(curr)).append(" ").append(dict.get(mul)).append(" ");
            }
            int rest = 0;
            int mul = (int)Math.pow(10, myStack.size() -1);
            while(!myStack.isEmpty()) {
                rest += myStack.pop() * mul;
                mul = (int)Math.pow(10, myStack.size() -1);
            }
            if(rest != 0) {
                System.out.println("Rest is " + rest);
                if(dict.containsKey(rest)) {
                    sb.append(dict.get(rest)).append(" ");
                } else {
                    sb.append(dict.get(rest - (rest % 10))).append(" ");
                    sb.append(dict.get(rest % 10)).append(" ");
                }
            }
        }


        if(place == 1) {
            sb.append("Thousand ");
        } else if(place == 2) {
            sb.append("Million ");
        } else if(place == 3) {
            sb.append("Billion ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(103203));
        System.out.println(10110100 >> 2 >>> 3);
    }
}