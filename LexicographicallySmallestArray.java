import java.util.*;

public class LexicographicallySmallestArray {
    public static int[] lexicographicallySmallestArray(int[] arr, int n, int K) {
        int remainingSwaps = K;

        for (int i = 0; i < n - 1 && remainingSwaps > 0; i++) {
            int minIndex = i;
            for (int j = i + 1; j < Math.min(i + remainingSwaps + 1, n); j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            while (minIndex > i && remainingSwaps > 0) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[minIndex - 1];
                arr[minIndex - 1] = temp;

                minIndex--;
                remainingSwaps--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {7, 6, 9, 2, 1};
        int K = 3;

        int[] result = lexicographicallySmallestArray(arr, arr.length, K);

        System.out.println("Lexicographically smallest array: " + Arrays.toString(result));
    }
}
