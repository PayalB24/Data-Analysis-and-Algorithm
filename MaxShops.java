import java.util.Arrays;

public class MaxShops {
    public static int maximumShops(int[] opening, int[] closing, int n, int k) {
        int[] sortedOpening = new int[n];
        int[] sortedClosing = new int[n];

        for (int i = 0; i < n; i++) {
            sortedOpening[i] = opening[i];
            sortedClosing[i] = closing[i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedClosing[j] > sortedClosing[j + 1]) {
                    int tempClosing = sortedClosing[j];
                    sortedClosing[j] = sortedClosing[j + 1];
                    sortedClosing[j + 1] = tempClosing;

                    int tempOpening = sortedOpening[j];
                    sortedOpening[j] = sortedOpening[j + 1];
                    sortedOpening[j + 1] = tempOpening;
                }
            }
        }

        int count = 0;
        int[] currentClosing = new int[k];
        Arrays.fill(currentClosing, 0);

        for (int i = 0; i < n; i++) {
            boolean assigned = false;

            for (int j = 0; j < k; j++) {
                if (currentClosing[j] <= sortedOpening[i]) {
                    currentClosing[j] = sortedClosing[i];
                    count++;
                    assigned = true;
                    break;
                }
            }

            if (!assigned && count < k) {
                currentClosing[count] = sortedClosing[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] S = {1, 8, 3, 2, 6};
        int[] E = {5, 10, 6, 5, 9};
        int K = 2;
        int N = S.length;

        System.out.println("Maximum number of shops that can be visited: " + maximumShops(S, E, N, K));
    }
}
