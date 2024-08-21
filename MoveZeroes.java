import java.util.Scanner;

public class MoveZeroes {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        int n = sc.nextInt();
        System.out.println("Enter the array elements:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Original array:");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        
        move(arr);
        
        System.out.println("\nModified array:");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        sc.close();
    }

    public static void move(int[] arr) {
        int nonZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nonZero++] = arr[i];
            }
        }
        while (nonZero < arr.length) {
            arr[nonZero++] = 0;
        }
}

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] != 0) {
                temp[k++] = arr[i++];
            } else {
                i++;
            }

            if (arr[j] != 0) {
                temp[k++] = arr[j++];
            } else {
                j++;
            }
        }
        while (i <= mid) {
            if (arr[i] != 0) {
                temp[k++] = arr[i];
            }
            i++;
        }

        while (j <= high) {
            if (arr[j] != 0) {
                temp[k++] = arr[j];
            }
            j++;
        }

        while (k < temp.length) {
            temp[k++] = 0;
        }

        for (i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}
