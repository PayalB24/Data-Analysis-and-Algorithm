import java.util.Scanner;

/**
 * lastzero
 */
public class lastzero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        int n = sc.nextInt();
        System.out.println("Enter the array elements:");
        int []arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Original array");
        for(int ele : arr){
            System.out.println(ele+" ");
        }
        movezero(arr,n);

        System.out.println("Modified array ");
        for(int ele : arr){
            System.out.println(ele +" ");
        }
        sc.close();
    }

    public static void movezero(int arr[], int n){
        int nonzero = 0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[nonzero++] = arr[i];
            }
        }

        while(nonzero < n){
            arr[nonzero++] = 0;
        }
    }
}