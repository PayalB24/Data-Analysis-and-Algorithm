import java.util.Scanner;

public class TrailingZeroes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number n: ");
        int n = sc.nextInt();

        int low = 0;
        int high = 5 * n;
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (counttrailing(mid) >= n) {
                result = mid;
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }

        System.out.println("The smallest number whose factorial coontains atleast "+n+" trailing zeroes is: "+result);

        sc.close();
    }

    public static int counttrailing(int mid){
        int count = 0;
        for(int i =5; mid/i>0;i*=5){
            count+=mid/i;
        }
        return count;
    }

}
