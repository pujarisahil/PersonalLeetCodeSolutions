/**
 * Created by sahilpujari on 10/31/16.
 */
/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * <br><br>
 * Minimum Length Subarray with Sum = k</b><br>
 * Given an array A having positive and negative integers and a number k,
 * find the minimum length sub array of A with sum = k.
 * <br><br>
 * Example: <br>
 * array = { 2, 3, 1, 2, 4, 3 }
 * <br>
 * k = 7
 * <br>
 * Output: [ 4 3 ]
 * <br><br>
 * <a href="https://www.youtube.com/watch?v=gHSoIwnERF0">Minimum Length Subarray with Sum k - Youtube Link</a>
 * @author Saurabh
 *
 */
public class MinimumLengthSubArraySum {

    public static void main(String[] args) {
        int[] array = {2,3,1,2,4,3};
        int k = 7;
        printMinSubArrayWithSum(array, k);
    }

    public static void printMinSubArrayWithSum(int[] array, int k) {

        int start = -1;     // Start of min subarray
        int end = -1;       // End of min subarray
        int min = Integer.MAX_VALUE;    // size of the smallest subarray with sum = k

        for(int i = 0; i < array.length; i++) {

            int currentSum = 0;
            for(int j = i; j < array.length && (j-i+1) < min; j++) {
                currentSum += array[j];
                if(currentSum == k) {
                    start = i;
                    end = j;
                    min = end - start + 1;
                    break;
                }
            }
        }

        if(start == -1 || end == -1)  {
            System.out.println("No subarray exists with sum = " + k);
            return ;
        }

        System.out.print("[ ");
        while(start <= end) {
            System.out.print(array[start] + " ");
            start++;;
        }
        System.out.println("]");
    }

}