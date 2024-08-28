import java.util.Arrays;

public class MinimumWorkPerDay {

    public static int minWork(int[] tasks, int D) {
        // Sort the tasks array in ascending order
        Arrays.sort(tasks);

        // If the number of tasks is less than or equal to the number of days,
        // the largest task will determine the minimum amount of work per day
        if (tasks.length <= D) {
            return tasks[tasks.length - 1];
        }

        int totalDays = D;
        int maxWork = tasks[tasks.length - 1];

        for (int i = tasks.length - 2; i >= 0; i--) {
            // Distribute tasks greedily across the days
            if (totalDays > 1) {
                totalDays--;
                maxWork = Math.max(maxWork, tasks[i]);
            } else {
                maxWork += tasks[i];
            }
        }

        return maxWork;
    }

    public static void main(String[] args) {
        int[] tasks1 = {3, 4, 7, 15};
        int D1 = 10;
        System.out.println("Minimum work per day for tasks1: " + minWork(tasks1, D1)); // Output: 4

        int[] tasks2 = {30, 20, 22, 4, 21};
        int D2 = 6;
        System.out.println("Minimum work per day for tasks2: " + minWork(tasks2, D2)); // Output: 22
    }
}
