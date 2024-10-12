import java.util.*;

public class LargestNumber {

    // Custom comparator to sort the numbers
    private static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            // Compare x+y and y+x
            String xy = x + y;
            String yx = y + x;
            return yx.compareTo(xy); // yx > xy means y should come before x
        }
    }

    public static String largestNumber(int[] nums) {
        // Convert the integers to strings
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }

        // Sort the array using the custom comparator
        Arrays.sort(numStrings, new CustomComparator());

        // If the largest number is '0', return '0'
        if (numStrings[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted numbers
        StringBuilder result = new StringBuilder();
        for (String num : numStrings) {
            result.append(num);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of elements

        int n = scanner.nextInt();

        // Input: the integers
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Compute the largest concatenated number
        String largestNumber = largestNumber(nums);

        // Output the result
        System.out.println(largestNumber);

        scanner.close();
    }
}

