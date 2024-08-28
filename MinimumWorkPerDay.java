import java.util.Arrays;

public class MinimumWorkPerDay {

    public static int minWork(int[] tasks, int d) {
        Arrays.sort(tasks);
        if (tasks.length <= d) {
            return tasks[tasks.length - 1];
        }

        int totalDays = d;
        int maxWork = tasks[tasks.length - 1];

        for (int i = tasks.length - 2; i >= 0; i--) {
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
        int d1 = 10;
        System.out.println("Minimum work per day for tasks1: " + minWork(tasks1, d1));

        int[] tasks2 = {30, 20, 22, 4, 21};
        int d2 = 6;
        System.out.println("Minimum work per day for tasks2: " + minWork(tasks2, d2));
    }
}
