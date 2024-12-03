public class AllSubsets {
    public static void printAllSubsets(int[] array) {
        int n = array.length;
        int totalSubsets = (1 << n); 
        for (int mask = 0; mask < totalSubsets; mask++) {
            System.out.print("{ ");
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println("Subsets of the given array:");
        printAllSubsets(array);
    }
}
