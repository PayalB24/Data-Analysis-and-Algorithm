import java.util.*;

public class DistinctSubsets {

    public static List<List<Integer>> findSubsets(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> subsets = new HashSet<>();
        int n = arr.length;
        int totalSubsets = (1 << n); 
        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { 
                    subset.add(arr[i]);
                }
            }
            subsets.add(subset);
        }
        return new ArrayList<>(subsets);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2};
        int[] arr2 = {1, 2};

        System.out.println("Subsets for {1, 2, 2}: " + findSubsets(arr1));
        System.out.println("Subsets for {1, 2}: " + findSubsets(arr2));
    }
}
