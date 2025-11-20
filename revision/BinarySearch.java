package revision;

public class BinarySearch {
    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if(sortedArray[mid] == target)
                return mid;
            else if (sortedArray[mid] < target) {
                left = mid +1;
            }
            else
                right = mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 45, 56, 67};
        int target = 23;

        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Found " + target + " at index " + result);
        } else {
            System.out.println(target + " not found in the array");
        }
    }
}
