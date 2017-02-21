import java.util.*;

public class CatchInsider {
    Map<Integer, Double> priceMap = new HashMap<>();
    SortedMap<Integer, SortedSet<Transaction>> transactionMap = new TreeMap<>();

    public Set catchInsiders(String[] input) {
        initialData(input);
        Set result = new HashSet<>();
        for (Integer key : transactionMap.keySet()) {
            SortedSet<Transaction> currentSet = transactionMap.get(key);
            for (Transaction tr : currentSet) {
                double curValue = tr.amount * priceMap.get(key);
                for (int i = 1; i <= 3; i++) {
                    if (priceMap.get(key + i) != null) {
                        double delta = tr.amount * priceMap.get(key + i) - curValue;
                        if ((tr.buy && delta >= 5000000) || (!tr.buy && delta <= -5000000)) {
                            result.add(tr.name);
                        }
                    }
                }
            }
        } return result;
    }

    private void initialData(String[] input) {
        for(String st : input){
            String[] stArr = st.split("\\|");
            System.out.println(Arrays.toString(stArr));
            if(stArr.length == 2) {
                priceMap.put(Integer.parseInt(stArr[0]),Double.parseDouble(stArr[1]));
            } else {
                Transaction trans = new Transaction(Integer.parseInt(stArr[0]),stArr[2].equals("BUY"), stArr[1],Integer.parseInt(stArr[3]));
                int key = Integer.parseInt(stArr[0]);
                if(!transactionMap.containsKey(key)){
                    transactionMap.put(key, new TreeSet());
                }
                transactionMap.get(key).add(trans);
            }
        }
    }

    public static void main(String[] args) {
        String[] data = new String[]{"1|700", "2|10000","3|50","4|700", "5|10","6|50000","1|Bob|BUY|30000", "1|Alan|BUY|20000" ,"2|tob|BUY|30000", "3|Ann|BUY|20000","5|Bb|BUY|30000", "4|Aggn|BUY|20000"};
        CatchInsider cs = new CatchInsider();
        System.out.println(cs.catchInsiders(data));
    }
}


class Transaction implements Comparable<Transaction> {
    int day;
    boolean buy;
    String name;
    int amount;
    public Transaction(int day, boolean buy, String name, int amount) {
        this.day = day;
        this.buy = buy;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public int compareTo(Transaction t2) {
        if(this.day == t2.day){
            return this.name.compareTo(t2.name);
        } else {
            return this.day - t2.day;
        }
    }
}